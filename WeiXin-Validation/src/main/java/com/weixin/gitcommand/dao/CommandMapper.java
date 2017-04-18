package com.weixin.gitcommand.dao;

import com.weixin.gitcommand.model.Command;

public interface CommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Command record);

    int insertSelective(Command record);

    Command selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Command record);

    int updateByPrimaryKeyWithBLOBs(Command record);

    int updateByPrimaryKey(Command record);
}