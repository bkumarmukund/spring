package code.balmukund.withspring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

import code.balmukund.withoutspring.dao.UserDao;

@Configuration
public class MyApplicationContextConfiguration {
    
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/testFirst");
        dataSource.setUser("root");
        dataSource.setPassword("pa55bird");
        return dataSource;
    }

    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource());
    }

    @Bean
    public String helloBean() {
        return "hello bean executing!";
    }

    @Bean
    public int magicInteger() {
        return 12;
    }
}
