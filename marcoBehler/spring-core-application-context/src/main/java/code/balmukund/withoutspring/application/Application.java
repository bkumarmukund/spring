package code.balmukund.withoutspring.application;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum Application {
    INSTANCE;

    private DataSource dataSource;

    public DataSource dataSource() {
        if (dataSource == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("pa55bird");
            dataSource.setURL("jdbc:mysql://localhost:3306/testFirst");
            this.dataSource = dataSource;
        }
        return dataSource;
    }


}
