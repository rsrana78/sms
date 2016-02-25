package com.ayp.sms.shiroSecurity;
/**
 * 
 * @author rana
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public final class MysqlDatabaseConnectionLoader {

    private static final String PROPERTIES_FILE = "/application.properties";

    private static final Logger log = Logger.getLogger(MysqlDatabaseConnectionLoader.class);
    private static final String URL = "jdbc.url";
    private static final String USER = "jdbc.username";
    private static final String PASS = "jdbc.password";

    private static DataSource dataSource;

    public static Connection getConnection() {
        try {
            if (dataSource == null) {
                loadDataSource();
            }

            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            loadDataSource();
        }

        return dataSource;
    }

    private static void loadDataSource() {
        Properties properties;
        InputStream fis = null;
        try {
            properties = new Properties();
            fis = MysqlDatabaseConnectionLoader.class.getResourceAsStream(PROPERTIES_FILE);
            properties.load(fis);

            String jdbcUrl = properties.getProperty(URL);
            String username = properties.getProperty(USER);
            String password = properties.getProperty(PASS);

            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(jdbcUrl);
            mysqlDataSource.setUser(username);
            mysqlDataSource.setPassword(password);

            dataSource = mysqlDataSource;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    log.error("Unable to close stream.", ex);
                }
            }
        }
    }
}
