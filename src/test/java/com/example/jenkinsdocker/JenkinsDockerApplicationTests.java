package com.example.jenkinsdocker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinsDockerApplicationTests {

    @Test
    void contextLoads() {
        int five = 2+3;
        assertEquals(5, five);
    }


    @Test
    void test2() {
        int five = 3+3;
        assertEquals(6, five);
    }

}
