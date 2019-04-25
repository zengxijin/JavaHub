package org.jackzeng.flink;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * @author xijin.zeng created on 2018/12/29
 */
public class MD5Test {
        public static void main(String[] args) {

            String text = "18930997592";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] md5Bytes = messageDigest.digest(text.getBytes(Charset.forName("UTF-8")));
                StringBuilder hex = new StringBuilder();
                for (byte b : md5Bytes) {
                    hex.append(String.format("%02x", b));
                }

                //String s = Hex.encodeHex(digestBytes);//Base64.getEncoder().encodeToString(md5Bytes);
                System.out.println(hex.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


}
