package com.xinguangnet.esjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: duozl
 * @Date: 2018/3/28 14:04
 */
@Component
public class JobTest implements SimpleJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobTest.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("JobName:" + shardingContext.getJobName());
        LOGGER.info("JobParameter:" + shardingContext.getJobParameter());
        LOGGER.info("ShardingItem:" + shardingContext.getShardingItem());
        LOGGER.info("ShardingParameter:" + shardingContext.getShardingParameter());
        LOGGER.info("ShardingTotalCount:" + shardingContext.getShardingTotalCount());
        LOGGER.info("TaskId:" + shardingContext.getTaskId());
        LOGGER.info("---------------------------------------");
    }
}
