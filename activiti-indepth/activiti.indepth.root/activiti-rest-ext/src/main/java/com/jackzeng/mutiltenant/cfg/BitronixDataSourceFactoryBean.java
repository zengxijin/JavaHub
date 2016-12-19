package com.jackzeng.mutiltenant.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import bitronix.tm.resource.common.ResourceBean;
import bitronix.tm.resource.jdbc.PoolingDataSource;
/**
 * @ClassName: BitronixDataSourceFactoryBean
 * @author:  Jack Zeng 
 * @CreateDate: [2016年12月13日 下午5:36:19]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年12月13日 下午5:36:19]   
 * @UpdateRemark: [TODO()]
 * @Description:  针对MySQL和activiti的DataSource生成PoolingDataSource，由Spring管理，
 *                当bean消亡的时候，PoolingDataSource也对应关闭
 * @version: [V1.0]
 */
public class BitronixDataSourceFactoryBean extends ResourceBean implements FactoryBean<PoolingDataSource>, DisposableBean {
	  private static final Logger LOG = LoggerFactory.getLogger(BitronixDataSourceFactoryBean.class);

	  private PoolingDataSource ds;
	  
	  public Class<?> getObjectType() {
	    return PoolingDataSource.class;
	  }
	  
	  public boolean isSingleton() {
	    return true;
	  }
	  
	  public PoolingDataSource getObject() throws Exception {
	    if (ds == null) {
	      ds = new PoolingDataSource();
	      ds.setClassName(getClassName());
	      ds.setUniqueName(getUniqueName() + "_" + System.currentTimeMillis());
	      ds.setAutomaticEnlistingEnabled(getAutomaticEnlistingEnabled());
	      ds.setUseTmJoin(getUseTmJoin());
	      ds.setMinPoolSize(getMinPoolSize());
	      ds.setMaxPoolSize(getMaxPoolSize());
	      ds.setMaxIdleTime(getMaxIdleTime());
	      ds.setAcquireIncrement(getAcquireIncrement());
	      ds.setAcquisitionTimeout(getAcquisitionTimeout());
	      ds.setAcquisitionInterval(getAcquisitionInterval());
	      ds.setDeferConnectionRelease(getDeferConnectionRelease());
	      ds.setAllowLocalTransactions(getAllowLocalTransactions());
	      ds.setShareTransactionConnections(getShareTransactionConnections());
	      ds.setDisabled(isDisabled());
	      ds.setIgnoreRecoveryFailures(getIgnoreRecoveryFailures());
	      ds.setDriverProperties(getDriverProperties());
	      
	      LOG.debug("Initializing PoolingDataSource with id " + ds.getUniqueName());
	      ds.init();
	    }
	    return ds;
	  }

	  public void destroy() throws Exception {
	    LOG.debug("Closing PoolingDataSource with id " + ds.getUniqueName());
	    ds.close();
	    ds = null;
	  }
	}

