package com.itcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")

public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    //右压栈
    public void setList(){
       redisTemplate.boundListOps("namelist").leftPush("孙悟空");
       redisTemplate.boundListOps("namelist").leftPush("猪八戒");
       redisTemplate.boundListOps("namelist").leftPush("沙师弟");
    }

    @Test
    public void getlist(){
        List namelist = redisTemplate.boundListOps("namelist").range(0, 10);
        System.out.println(namelist);

    }

    //查询集合中的某个元素
    @Test
    public void searchByindex(){
        String namelist = (String) redisTemplate.boundListOps("namelist").index(1);
        System.out.println(namelist);
    }

    //移除集合中某个元素的值
    @Test
    public void removeTest(){
        redisTemplate.boundListOps("namelist").remove(1,"猪八戒");

    }

    //删除元素中的值
    @Test
    public void deleteValue(){
        redisTemplate.delete("namelist");
    }
}
