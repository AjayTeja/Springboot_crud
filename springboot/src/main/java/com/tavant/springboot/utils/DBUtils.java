package com.tavant.springboot.utils;

 

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class DBUtils {
    
    @Autowired
    Environment environment;
    
    public DataSource getDataSource() {
        try {
        
        BasicDataSource dataSource = new BasicDataSource();
        System.out.println("env class name"+environment.getClass().getName());
    //    MysqlDataSource dataSource = new MysqlDataSource();
        
    //    Properties properties = fileUtils.getProperties();
        dataSource.setUrl(environment.getProperty("db.url"));
        //dataSource.setPortNumber(Integer.parseInt(properties.getProperty("db.port")));
    //    dataSource.setDatabaseName(properties.getProperty("db.name"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
        }
        catch(Exception e) {
    }
//        try {
//            dataSource.setSslMode("DISABLED");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //dataSource.setUrl(url);
        return null;
    }

 

    public void closeConnection(Connection connection) {

 

        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 

    public Connection getConnection() {
        // we need to load the driver
        // DriverManager to get the connection object
        // r we following the datasource approach?
        Connection connection = null;
        try {
             connection = this.getDataSource().getConnection();
             return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
}