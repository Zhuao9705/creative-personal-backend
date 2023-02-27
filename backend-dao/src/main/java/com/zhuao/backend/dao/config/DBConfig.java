package com.zhuao.backend.dao.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.zhuao.backend.dao.mapper")
public class DBConfig {

    /**
     * 配置数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "dbDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource masterDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置sqlsessionfactory
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = "dbSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mybatis/mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置事物管理器
     *
     * @return
     */
    @Primary
    @Bean(name = "dbTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("dbDataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
