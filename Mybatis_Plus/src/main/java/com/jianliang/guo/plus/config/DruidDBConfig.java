package com.jianliang.guo.plus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by jianliang.guo@mtime.com on
 *
 * @Description
 */
@Configuration
public class DruidDBConfig {

    private static Logger logger = Logger.getLogger(DruidDBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.dbcp2.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.dbcp2.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.dbcp2.max-total}")
    private int maxActive;

    @Value("${spring.datasource.dbcp2.max-wait-millis}")
    private int maxWait;

    @Value("${spring.datasource.dbcp2.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.dbcp2.min-evictable-idle-time-millis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.dbcp2.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.dbcp2.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.dbcp2.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.dbcp2.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.dbcp2.pool-prepared-statements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.dbcp2.max-open-prepared-statements}")
    private int maxPoolPreparedStatementPerConnectionSize;

//        @Value("${spring.datasource.filters}")
//        private String filters;

    @Value("{spring.datasource.tomcat.connection-properties}")
    private String connectionProperties;

    @Bean       //初始化实例Bean
    @Primary    //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//            try {
//                datasource.setFilters(filters);
//            } catch (SQLException e) {
//                logger.log(Level.ERROR, "druid configuration initialization filter : {0}", e);
//            }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }
}
