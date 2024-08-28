package code.balmukund.withoutspring;

import code.balmukund.withoutspring.Entitty.User;
import code.balmukund.withoutspring.application.Application;
import code.balmukund.withoutspring.dao.UserDao;

public class Main {
    public static void main(String[] args) {
            UserDao userDao = new UserDao(
            Application.INSTANCE
            .dataSource()
        );

        User user = userDao.findById(1);

        System.out.println(user);    
    }

    
}
