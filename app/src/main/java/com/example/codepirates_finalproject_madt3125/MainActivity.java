package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> employees;

    private void registerDefaultEmployee() {
        Vehicle v1 = new Car(
                "VX16",
                "Yellow",
                "Sedan",
                "Car"
        );

        Employee e1 = new Manager(
                "Andrew",
                1997,
                10,
                12,
                v1
        );

        Vehicle v2 = new Motorcycle(
                "DHS8",
                "Red",
                "Sports",
                true
        );

        Employee e2 = new Manager(
                "Joseph",
                1988,
                12,
                20,
                v2
        );

        Management.getInstance().addEmployee(e1);
        Management.getInstance().addEmployee(e2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerDefaultEmployee();

        employees = Management.getInstance().getEmployeeNames();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, employees);
        binding.empList.setAdapter(adapter);
        binding.empList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, EmployeeDetail.class);
            intent.putExtra("empName", parent.getAdapter().getItem(position).toString());
            startActivity(intent);
        });

        binding.button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegistrationForm.class);
            startActivity(intent);
        });

        binding.searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               filterData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              filterData(newText);
                return false;
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Clearing employee array
        employees.clear();
        // Adding all employee data from singleton to class array
        employees.addAll(Management.getInstance().getEmployeeNames());
        // Notify adapter to invoke update
        adapter.notifyDataSetChanged();
    }

    private void filterData(String text){
        ArrayList<String> employeeNames = Management.getInstance().getEmployeeNames();
        if (text.isEmpty()) {
            employees.clear();
            // Adding all employee data from singleton to class array
            employees.addAll(employeeNames);
            // Notify adapter to invoke update
            adapter.notifyDataSetChanged();
        }
        else {
            ArrayList<String> filteredNames = new ArrayList<>();
            employeeNames.forEach(employee -> {
                if (employee.contains(text)) filteredNames.add(employee);
            });
            employees.clear();
            // Adding all employee data from singleton to class array
            employees.addAll(filteredNames);
            // Notify adapter to invoke update
            adapter.notifyDataSetChanged();
        }
    }
}