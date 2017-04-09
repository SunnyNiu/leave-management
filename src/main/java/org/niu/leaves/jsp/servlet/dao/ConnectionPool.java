package org.niu.leaves.jsp.servlet.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.SQLException;
import java.sql.Connection;


/**
 * Created by Sunny on 4/02/2017.
 */
public class ConnectionPool {

    private static ComboPooledDataSource ds;

    public static Connection getConnection() throws SQLException {
        if (ds == null) {
            try{
                Class.forName("oracle.jdbc.OracleDriver");
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }

            ds = new ComboPooledDataSource();
            ds.setJdbcUrl("jdbc:oracle:thin:@192.168.99.100:49161:xe");
            //ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUser("system");
            ds.setPassword("oracle");
            ds.setAcquireIncrement(1);
            ds.setMaxIdleTime(30000);
            ds.setMaxPoolSize(10);
            ds.setAutoCommitOnClose(true);
        }
        return ds.getConnection();
    }
}
