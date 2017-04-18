package com.weixin.gitcommand.model;

public class Command {
	
    private Integer id;
    private String commandName;
    private byte[] commandDesc;

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

    public byte[] getCommandDesc() {
        return commandDesc;
    }

    public void setCommandDesc(byte[] commandDesc) {
        this.commandDesc = commandDesc;
    }
}