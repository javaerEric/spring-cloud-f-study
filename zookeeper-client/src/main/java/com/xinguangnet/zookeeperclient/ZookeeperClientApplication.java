package com.xinguangnet.zookeeperclient;

import com.xinguangnet.zookeeperclient.dto.UserDTO;
import com.xinguangnet.zookeeperclient.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperClientApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperClientApplication.class);

	@Autowired
	private Validator validator;

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("4", "小明", "男", "123456", "1.0");
		LOGGER.info(user.toString());

		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		LOGGER.info(userDTO.toString());

		Set<ConstraintViolation<UserDTO>> validate = validator.validate(userDTO);
		LOGGER.info(validate.toString());

		userDTO.setId(user.getUserId());
		LOGGER.info(userDTO.toString());

		validate = validator.validate(userDTO);
		LOGGER.info(validate.toString());
	}
}
