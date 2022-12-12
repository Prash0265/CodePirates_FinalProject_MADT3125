package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityEmployeeDetailBinding;


public class EmployeeDetail extends AppCompatActivity {
    Employee employee;

    ActivityEmployeeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String name = getIntent().getStringExtra("empName");
        if (name.length() == 0) {
            finish();
            return;
        }

        employee = Management.getInstance().getEmployee(name);
        System.out.println(employee);
        binding.employeeDetails.setText(employee.toString());
    }
}