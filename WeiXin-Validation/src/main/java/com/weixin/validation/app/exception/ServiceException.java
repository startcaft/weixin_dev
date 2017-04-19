package com.weixin.validation.app.exception;

/**
 * 自定义Service层异常
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String exMsg) {
		super(exMsg);
	}
}
