package com.shit.demo.postgresql.service;

import java.sql.Connection;

public interface PostgresqlService {
    public Connection getPgConnection();
}
