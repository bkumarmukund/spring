package code.balmukund.withoutspring.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import code.balmukund.withoutspring.Entitty.User;
import code.balmukund.withoutspring.application.Application;

public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public User findById(Integer id) {
        try (Connection connection = dataSource
            .getConnection()
        ) {
            // execute required query
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User(1, "sam", 21);
    }
}
