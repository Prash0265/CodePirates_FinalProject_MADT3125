package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityEmployeeDetailBinding;

public class EmployeeDetail extends AppCompatActivity {

    ActivityEmployeeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}