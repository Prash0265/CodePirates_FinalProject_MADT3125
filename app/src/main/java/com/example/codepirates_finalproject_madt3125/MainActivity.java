package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        employees = Management.getInstance().getEmployeeNames();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, employees);
        binding.empList.setAdapter(adapter);

        binding.empList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, EmployeeDetail.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });

        binding.button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegistrationForm.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Clearing employee array
        employees.clear();
        // Adding all employee data from singelton to class array
        employees.addAll(Management.getInstance().getEmployeeNames());
        // Notify adapter to invoke update
        adapter.notifyDataSetChanged();
    }
}