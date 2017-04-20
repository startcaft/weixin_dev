package com.weixin.vo;

public class CommandUsageVo {
	
	private Integer id;
    private String title;
    private String content;
    private Integer commandId;
    private Boolean istop;
    private String desc;
    private Integer sort;
    
    private String commandName;
    private String commandDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCommandId() {
		return commandId;
	}

	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}

	public Boolean getIstop() {
		return istop;
	}

	public void setIstop(Boolean istop) {
		this.istop = istop;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCommandDesc() {
		return commandDesc;
	}

	public void setCommandDesc(String commandDesc) {
		this.commandDesc = commandDesc;
	}
	
}
