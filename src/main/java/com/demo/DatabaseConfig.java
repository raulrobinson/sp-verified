package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); // Cambia por tu URL de conexión
        dataSource.setUsername("tu_usuario"); // Cambia por tu nombre de usuario
        dataSource.setPassword("tu_contraseña"); // Cambia por tu contraseña
        return dataSource;
    }
}

