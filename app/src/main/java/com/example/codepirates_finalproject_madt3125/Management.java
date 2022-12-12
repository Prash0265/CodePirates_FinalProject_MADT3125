package com.example.codepirates_finalproject_madt3125;

import java.util.ArrayList;

enum EmployeeType {
    Manager("Manager"),
    Programmer("Programmer"),
    Tester("Tester");


    private final String label;

    EmployeeType(String label) {
        this.label = label;
    }

//    public String getLabel() {
//        return label;
//    }
}

public class Management {
    private static final Management databaseInstance = new Management();
    private final ArrayList<Employee> employeesData;

    private Management() {
        employeesData = new ArrayList<>();
    }

    public static Management getInstance() {
        return databaseInstance;
    }

    public ArrayList<String> getEmployeeNames() {
        ArrayList<String> employeeNames = new ArrayList<>();
        employeesData.forEach(employee -> employeeNames.add(employee.getName()));
        return employeeNames;
    }

    public void addEmployee(Employee employee) {
        employeesData.add(employee);
    }

    public Employee getEmployee(int position) {
        return employeesData.get(position);
    }
}
