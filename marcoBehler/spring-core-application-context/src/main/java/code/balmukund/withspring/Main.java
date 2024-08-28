package code.balmukund.withspring;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import code.balmukund.withoutspring.dao.UserDao;
import code.balmukund.withspring.config.MyApplicationContextConfiguration;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);
        
        // ((AbstractApplicationContext) ctx).refresh();
        // UserDao userDao = ctx.getBean(UserDao.class);

        String msg = ctx.getBean("helloBean", String.class);

        System.out.println(msg);

        int nanoInt = ctx.getBean("magicInteger", Integer.class);

        System.out.println(nanoInt);

        UserDao userDao = ctx.getBean("userDao", UserDao.class);
        // System.out.println(userDao);

        System.out.println(userDao.findById(1));

        DataSource dataSource = ctx.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);
    }   
}
