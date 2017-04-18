package com.weixin.gitcommand.dao;

import java.util.List;
import java.util.Map;

import com.weixin.gitcommand.model.CommandUsage;

public interface CommandUsageMapper {
	
	int deleteByPrimaryKey(Integer id);

	int insert(CommandUsage record);

	CommandUsage selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CommandUsage record);
	
	/*根据id查询，关联查询tb_command*/
	CommandUsage selectByPrimaryKeyWithCommand(Integer id);
	
	/*根据指定属性查询集合*/
	List<CommandUsage> selectList(Map<String, Object> map);
}