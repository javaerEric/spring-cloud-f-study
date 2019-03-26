package com.xinguangnet.esjob.cofig;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.xinguangnet.esjob.job.JobTest;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: duozl
 * @Date: 2018/3/28 10:17
 */
@Configuration
public class JobConfig {

    @Autowired
    private ZookeeperProperties zookeeperProperties;

    @Autowired
    private ElasticJobDbProperties elasticJobDbProperties;

    @Autowired
    private ElasticJobProperties elasticJobProperties;

    @Autowired
    private JobTest jobTest;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(elasticJobDbProperties.getConnectString());
        dataSource.setUsername(elasticJobDbProperties.getUsername());
        dataSource.setPassword(elasticJobDbProperties.getPassword());

        dataSource.setInitialSize(10);
        dataSource.setMaxIdle(20);
        dataSource.setMinIdle(2);
        dataSource.setMaxWait(6000);

        return dataSource;
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter registryCenter() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(zookeeperProperties.getConnectString(), elasticJobProperties.getNamespace());
        zookeeperConfiguration.setDigest(elasticJobProperties.getDigest());
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }

    @Bean(initMethod = "init")
    public SpringJobScheduler testJob() {
        JobCoreConfiguration coreConfiguration = JobCoreConfiguration.newBuilder("jobTest", "0/30 * 9-17 * * ? ", 1).build();
        SimpleJobConfiguration jobConfiguration = new SimpleJobConfiguration(coreConfiguration, JobTest.class.getCanonicalName());
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(jobConfiguration).overwrite(true).build();

        JobEventRdbConfiguration jobEventRdbConfiguration = new JobEventRdbConfiguration(dataSource());
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(jobTest, registryCenter(), liteJobConfiguration, jobEventRdbConfiguration);

        return springJobScheduler;
    }
}
