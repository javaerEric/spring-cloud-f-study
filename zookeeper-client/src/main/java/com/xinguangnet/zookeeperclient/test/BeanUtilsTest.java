package com.xinguangnet.zookeeperclient.test;

import com.xinguangnet.zookeeperclient.dto.UserDTO;
import com.xinguangnet.zookeeperclient.entity.User;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author: duozl
 * @Date: 2018/3/30 16:52
 */
public class BeanUtilsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtilsTest.class);

    public static void main(String[] args) {
        User user = new User("1", "小明", "男", "123456", "1.0");
        LOGGER.info(user.toString());

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        LOGGER.info(userDTO.toString());

        userDTO.setId(user.getUserId());
        LOGGER.info(userDTO.toString());
    }
}
