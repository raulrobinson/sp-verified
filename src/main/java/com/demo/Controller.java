package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final StoredProcedureExecutor storedProcedureExecutor;

    @Autowired
    public Controller(StoredProcedureExecutor storedProcedureExecutor) {
        this.storedProcedureExecutor = storedProcedureExecutor;
    }

    @GetMapping("/execute")
    public String executeStoredProc() {
        storedProcedureExecutor.executeStoredProc();
        return "Procedimiento almacenado ejecutado correctamente.";
    }
}

