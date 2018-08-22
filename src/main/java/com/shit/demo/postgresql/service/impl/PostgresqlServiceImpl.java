package com.shit.demo.postgresql.service.impl;

import com.shit.demo.postgresql.service.PostgresqlService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service("postgresqlService")
public class PostgresqlServiceImpl implements PostgresqlService {
    public Connection getPgConnection(){
//        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shit","shit","ring");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
