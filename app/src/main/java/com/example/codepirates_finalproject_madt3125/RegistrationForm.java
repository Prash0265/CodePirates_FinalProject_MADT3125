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
    TextView empSelection, employeeProperties,sideCar, carType;
    RadioGroup radioGroup, sidecarRdGroup;
    EditText editText_empProperties, editText_carType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        employeeTypeSpinner = findViewById(R.id.spnr_employeeType);
        employeeTypeSpinner.setOnItemSelectedListener(this);
        sideCar = findViewById(R.id.textView5);
        radioGroup = findViewById(R.id.vehicleType);
        sidecarRdGroup = findViewById(R.id.sideCarType);
        carType = findViewById(R.id.textView4);
        editText_carType = findViewById(R.id.editTextCarType);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.car:
                    //  carType.setVisibility(View.VISIBLE);
                    carType.setVisibility(View.VISIBLE);
                    editText_carType.setVisibility(View.VISIBLE);
                    sidecarRdGroup.setVisibility(View.GONE);
                    sideCar.setVisibility(View.GONE);
                    // group.setOrientation(LinearLayout.HORIZONTAL);
                    break;
                case R.id.motorcycle:
                    //  carType.setVisibility(View.GONE);
                    carType.setVisibility(View.GONE);
                    editText_carType.setVisibility(View.GONE);
                    sidecarRdGroup.setVisibility(View.VISIBLE);
                    sideCar.setVisibility(View.VISIBLE);
                    //group.setOrientation(LinearLayout.VERTICAL);
                    break;

            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = employeeTypeSpinner.getSelectedItem().toString();
        switch (item) {
            case "Manager":
                employeeProperties = findViewById(R.id.txtvw_empSelection);
                editText_empProperties  = findViewById(R.id.empProperties);
                employeeProperties.setVisibility(View.VISIBLE);
                editText_empProperties.setVisibility(View.VISIBLE);
                empSelection = findViewById(R.id.txtvw_empSelection);
                empSelection.setText("#Clients");
                break;
            case "Tester":
                employeeProperties = findViewById(R.id.txtvw_empSelection);
                editText_empProperties  = findViewById(R.id.empProperties);
                employeeProperties.setVisibility(View.VISIBLE);
                editText_empProperties.setVisibility(View.VISIBLE);
                empSelection.setText("#Bugs");
                break;
            case "Programmer":
                employeeProperties = findViewById(R.id.txtvw_empSelection);
                editText_empProperties  = findViewById(R.id.empProperties);
                employeeProperties.setVisibility(View.VISIBLE);
                editText_empProperties.setVisibility(View.VISIBLE);
                empSelection.setText("#Projects");
                break;
            default:
                employeeProperties = findViewById(R.id.txtvw_empSelection);
                editText_empProperties  = findViewById(R.id.empProperties);
                employeeProperties.setVisibility(View.GONE);
                editText_empProperties.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}