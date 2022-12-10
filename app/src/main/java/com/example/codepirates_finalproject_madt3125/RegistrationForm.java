package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class RegistrationForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner employeeTypeSpinner;
    LinearLayout employeeProperties, sideCar, carType;
    TextView empSelection;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        employeeTypeSpinner = findViewById(R.id.spnr_employeeType);
        employeeTypeSpinner.setOnItemSelectedListener(this);
        sideCar = findViewById(R.id.sideCarRdGroup);
        radioGroup = findViewById(R.id.vehicleTypeRdGroup);
        carType = findViewById(R.id.carType);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.car:
                    carType.setVisibility(View.VISIBLE);
                    sideCar.setVisibility(View.GONE);
                    // group.setOrientation(LinearLayout.HORIZONTAL);
                    break;
                case R.id.motorcycle:
                    carType.setVisibility(View.GONE);
                    sideCar.setVisibility(View.VISIBLE);
                    //group.setOrientation(LinearLayout.VERTICAL);
                    break;

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = employeeTypeSpinner.getSelectedItem().toString();
        if (item.equals("Manager")) {
            employeeProperties = findViewById(R.id.linearEmpProperties);
            employeeProperties.setVisibility(View.VISIBLE);
            empSelection = findViewById(R.id.txtvw_empSelection);
            empSelection.setText("# Clients");
        } else if (item.equals("Tester")) {
            employeeProperties = findViewById(R.id.linearEmpProperties);
            employeeProperties.setVisibility(View.VISIBLE);
            empSelection = findViewById(R.id.txtvw_empSelection);
            empSelection.setText("# Bugs");
        } else if (item.equals("Programmer")) {
            employeeProperties = findViewById(R.id.linearEmpProperties);
            employeeProperties.setVisibility(View.VISIBLE);
            empSelection = findViewById(R.id.txtvw_empSelection);
            empSelection.setText("# Projects");
        } else {
            employeeProperties = findViewById(R.id.linearEmpProperties);
            employeeProperties.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}