package top.chuqin.utils.tools.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
    private final Logger logger = LoggerFactory.getLogger(Log4j2Test.class);


    @Test
    public void test() {
        while (true) {
            logger.info("hello");
        }
    }

    @Test
    public void test2() {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
