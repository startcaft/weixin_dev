package com.weixin.gitcommand.model;

public class Command {
	
    private Integer id;
    private String commandName;
    private String commandDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName == null ? null : commandName.trim();
    }

    public String getCommandDesc() {
        return commandDesc;
    }

    public void setCommandDesc(String commandDesc) {
        this.commandDesc = commandDesc;
    }
}