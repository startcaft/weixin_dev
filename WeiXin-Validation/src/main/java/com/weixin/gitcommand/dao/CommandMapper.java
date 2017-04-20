package com.weixin.gitcommand.dao;

import com.weixin.gitcommand.model.Command;

public interface CommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Command record);

    Command selectByPrimaryKey(Integer id);
}