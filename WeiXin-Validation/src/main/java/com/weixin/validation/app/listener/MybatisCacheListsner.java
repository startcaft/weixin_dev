package com.weixin.validation.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class MybatisCacheListsner implements CacheEventListener {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisCacheListsner.class);
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/*监听 cahche put 事件*/
	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		if (logger.isInfoEnabled()) {
			logger.info("cache name:" + cache.getName() + "--- element key:" + element.getObjectKey());
		}
	}

	@Override
	public void notifyElementPut(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementRemoved(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementUpdated(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyRemoveAll(Ehcache arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Object clone() throws CloneNotSupportedException {
	      throw new CloneNotSupportedException();
	}
}
