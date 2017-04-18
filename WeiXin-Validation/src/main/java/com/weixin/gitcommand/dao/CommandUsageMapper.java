package com.weixin.gitcommand.dao;

import com.weixin.gitcommand.model.CommandUsage;

public interface CommandUsageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommandUsage record);

    int insertSelective(CommandUsage record);

    CommandUsage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommandUsage record);

    int updateByPrimaryKeyWithBLOBs(CommandUsage record);

    int updateByPrimaryKey(CommandUsage record);
}