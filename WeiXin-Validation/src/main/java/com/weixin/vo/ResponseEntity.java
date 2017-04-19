package com.weixin.vo;

/**
 * 响应实体
 */
public class ResponseEntity {
	
	private Integer errCode = 9999;	//正常响应为0，其余都是有错误
	private String errMsg;			//错误提示信息
	private Object respData;		//响应数据
	
	public Integer getErrCode() {
		return errCode;
	}
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getRespData() {
		return respData;
	}
	public void setRespData(Object respData) {
		this.respData = respData;
	}
}
