package com.skk.Seating_arrangement_system.exception;

public class EmployeeNotFoundException  extends RuntimeException  {
    public EmployeeNotFoundException(Long  id) {
        super("Could not find employee " + id);
    }

    public EmployeeNotFoundException(String mess) {
        super(mess );
    }


}
