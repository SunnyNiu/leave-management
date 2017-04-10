package org.niu.leaves.jsp.servlet.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionPool {

    private static ComboPooledDataSource ds;

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("/config/config.properties");
        props.load(input);

        if (ds == null) {
            try {
                Class.forName(props.getProperty("ORACLE_DRIVER"));
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            ds = new ComboPooledDataSource();
            //ds.setJdbcUrl(props.getProperty("DOCKER_DATABASE"));
            ds.setJdbcUrl(props.getProperty("LOCAL_DATABASE"));
            ds.setUser(props.getProperty("DATABASE_USERNAME"));
            ds.setPassword(props.getProperty("DATABASE_PASSWORD"));
            ds.setAcquireIncrement(Integer.parseInt(props.getProperty("ACQUIRE_INCREMENT")));
            ds.setMaxIdleTime(Integer.parseInt(props.getProperty("MAX_IDLE_TILE_TIME")));
            ds.setMaxPoolSize(Integer.parseInt(props.getProperty("MAX_POOL_SIZE")));
            ds.setAutoCommitOnClose(Boolean.parseBoolean(props.getProperty("AUTO_COMMIT_ON_CLOSE")));
        }
        return ds.getConnection();
    }
}
