package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;

@Component
public class StoredProcedureExecutor {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StoredProcedureExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeStoredProc() {
        String procedureCall = "{call tu_procedimiento(?, ?)}"; // Cambia por el nombre de tu procedimiento almacenado

        var inputParam1 = 0;
        var inputParam2 = 0;

        // Parámetros de entrada y salida
        Object[] parameters = {inputParam1, inputParam2}; // Cambia los valores por tus parámetros de entrada
        int[] parameterTypes = {Types.INTEGER, Types.VARCHAR}; // Cambia los tipos según los parámetros de entrada

        jdbcTemplate.update(procedureCall, parameters, parameterTypes);

        // También puedes obtener los valores de los parámetros de salida si existen
        Object outputValue1 = jdbcTemplate.queryForObject("SELECT ? FROM DUAL", Object.class, parameters[0]);
        Object outputValue2 = jdbcTemplate.queryForObject("SELECT ? FROM DUAL", Object.class, parameters[1]);

        // Realiza las operaciones necesarias con los valores de salida
    }
}

