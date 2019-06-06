package org.jackzeng;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Collections;

/**
 * @author xijin.zeng created on 2019/6/6
 */
public class RedisToolV2 {


    public static void bizLogic(Jedis jedis, String lockKey, String requestId, int expireTime) {

        // using case
        try (AutoCloseLock lock = new AutoCloseLock(jedis, lockKey, requestId, expireTime)) {
            Boolean isLockSuccess = lock.tryLock();
            if (isLockSuccess) {
              // do something
            }

            // AutoCloseLock will call close anyway
            // so you don't need to call releaseDistributedLock every time or in case you forget to do that
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static class AutoCloseLock implements AutoCloseable {

        private static final String LOCK_SUCCESS         = "OK";
        private static final String SET_IF_NOT_EXIST     = "NX";
        private static final String SET_WITH_EXPIRE_TIME = "PX";
        private static final Long RELEASE_SUCCESS = 1L;

        private boolean isLockSuccess    = false;
        private boolean isReleaseSuccess = false;

        private Jedis jedis;
        private String lockKey;
        private String requestId;
        private int expireTime;

        public AutoCloseLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
            this.jedis = jedis;
            this.lockKey = lockKey;
            this.requestId = requestId;
            this.expireTime = expireTime;
        }

        public boolean tryLock() {
            String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

            if (LOCK_SUCCESS.equals(result)) {
                isLockSuccess = true;
            }
            return isLockSuccess;
        }

        public void close() throws IOException {
            if (isLockSuccess) {
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

                if (RELEASE_SUCCESS.equals(result)) {
                    isReleaseSuccess = true;
                }
            }
        }
    }
}
