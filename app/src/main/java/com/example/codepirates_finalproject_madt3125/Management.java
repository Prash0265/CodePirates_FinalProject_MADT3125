package com.example.codepirates_finalproject_madt3125;

import java.util.ArrayList;

public class Management {
    private static final Management managementInstance = new Management();
    private final ArrayList<Employee> employeesData;

    private Management() {
        employeesData = new ArrayList<>();
    }

    public static Management getInstance() {
        return managementInstance;
    }

    public ArrayList<String> getEmployeeNames() {
        ArrayList<String> employeeNames = new ArrayList<>();
        employeesData.forEach(employee -> employeeNames.add(employee.getName()));
        return employeeNames;
    }

    public void addEmployee(Employee employee) {
        employeesData.add(employee);
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i < employeesData.size(); i++) {
            if (employeesData.get(i).getName().equalsIgnoreCase(name)) return employeesData.get(i);
        }
        return null;
    }
}
