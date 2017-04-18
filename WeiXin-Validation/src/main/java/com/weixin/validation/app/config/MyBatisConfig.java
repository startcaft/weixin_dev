package com.weixin.validation.app.config;


import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/*
 * sprigboot继承mybatis的入口
 * 1).创建SqlSessionFactory
 * 2).扫描 mapper 接口所在的包
 */
@Configuration
@MapperScan(basePackages="com.weixin.gitcommand.dao")
public class MyBatisConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(this.dataSource);
		
		bean.setTypeAliasesPackage("com.weixin.gitcommand.model");//扫描实体所在的包
		
		//扫描 mapperxml 映射文件所在的包
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
		bean.setMapperLocations(resolver.getResources("classpath:com/weixin/gitcommand/mapper/*.xml"));
		
		bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		
		return bean.getObject();
	}
	
	/**  
	* 配置事务管理器  
	*/  
	@Bean(name = "transactionManager")  
	@Primary  
	public DataSourceTransactionManager transactionManager() throws Exception {  
		return new DataSourceTransactionManager(this.dataSource);  
	}  

}
