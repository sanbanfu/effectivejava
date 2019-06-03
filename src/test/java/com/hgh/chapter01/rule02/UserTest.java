package com.hgh.chapter01.rule02;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest {
    Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void testBuilder() {
        User user = new User.Builder("huguanghui", "111111").age(23).tel(13266668888L).build();
        logger.info(user.toString());
    }

}