package com.bigjava18.springjdbc.test;

import com.bigjava18.springjdbc.bean.AccountService;
import com.bigjava18.springjdbc.bean.JavaConfig;
import com.bigjava18.springjdbc.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -06 -21 14 :37
 * @Description springjdbctemplate
 */
public class JdbcTest {

    JdbcTemplate jdbcTemplate;
    private AccountService accountService;

    /**
     * 获取配置信息
     */
    @Before
    public void before(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        //accountService = ctx.getBean(AccountService.class);
    }

    /**
     * 查询所有用户
     */
    @Test
    public void test1(){
        List<User> query = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        System.out.println("query = " + query);
    }

    /**
     * 添加用户信息
     */
    @Test
    public void test2() {
        jdbcTemplate.update("insert into user (username,password,age,address) values (?,?,?,?);", "cat", "1212", 12,"chain");
    }

    /**
     * 更新用户信息
     */
    @Test
    public void test3() {
        jdbcTemplate.update("update user set username = ? where id=?;", "lili", 1);
    }

    /**
     * 删除用户信息
     */
    @Test
    public void test4() {
        jdbcTemplate.update("delete from user where id=?", 2);
    }

}
