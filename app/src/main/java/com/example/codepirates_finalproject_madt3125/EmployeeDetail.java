package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityEmployeeDetailBinding;

import org.w3c.dom.Text;

public class EmployeeDetail extends AppCompatActivity {
    Employee employee;

    ActivityEmployeeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        int position = getIntent().getIntExtra("position", -1);

        if (position == -1) {
            finish();
            return;
        }
        employee = Management.getInstance().getEmployee(position);

        System.out.println(employee);
        binding.employeeDetails.setText(employee.toString());
    }
}