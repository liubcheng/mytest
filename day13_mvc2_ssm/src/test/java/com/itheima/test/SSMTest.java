package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SSMTest {
    @Test
    public void testSpring(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-service.xml");
        AccountService accountService =  app.getBean(AccountService.class);
        accountService.queryAll();
    }
    @Test
    public void testMubaties() throws IOException {
        //加载全局配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.queryAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        session.close();
        is.close();
    }
    @Test
    public void testSpringAndMybaties(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        AccountDao accountDao = app.getBean(AccountDao.class);
        List<Account> accounts = accountDao.queryAll();
        for (Account account : accounts) {
            System.out.println(account);

        }

    }
}
