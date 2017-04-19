package com.weixin.gitcommand.model;

public class CommandUsage implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String title;
    private String content;
    private Integer commandId;
    private Boolean istop;
    private String desc;
    private Integer sort;
    
    private Command command;

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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        this.desc = desc == null ? null : desc.trim();
    }

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}