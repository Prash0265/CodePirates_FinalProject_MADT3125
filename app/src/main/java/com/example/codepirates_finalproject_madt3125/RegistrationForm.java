package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityRegistrationFormBinding;

import java.text.NumberFormat;

public class RegistrationForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityRegistrationFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationFormBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.spnrEmployeeType.setOnItemSelectedListener(this);

        binding.btnRegister.setOnClickListener(view -> onSubmit());

        binding.vehicleType.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.car:
                    binding.editTextCarType.setVisibility(View.VISIBLE);
                    binding.textView4.setVisibility(View.VISIBLE);
                    binding.sideCarType.setVisibility(View.GONE);
                    binding.textView5.setVisibility(View.GONE);
                    break;
                case R.id.motorcycle:
                    binding.editTextCarType.setVisibility(View.GONE);
                    binding.textView4.setVisibility(View.GONE);
                    binding.sideCarType.setVisibility(View.VISIBLE);
                    binding.textView5.setVisibility(View.VISIBLE);
                    break;

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = binding.spnrEmployeeType.getSelectedItem().toString();
        switch (item) {
            case "Manager":
                binding.empProperties.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setText("Total Number Of Clients:");
                break;
            case "Tester":
                binding.empProperties.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setText("Total Number Of Bugs:");
                break;
            case "Programmer":
                binding.empProperties.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setText("Total Number Of Projects:");
                break;
            default:
                binding.empProperties.setVisibility(View.GONE);
                binding.txtvwEmpSelection.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void onSubmit() {
        String empFirstName = binding.firstName.getText().toString();
        String empLastName = binding.lastName.getText().toString();
        String empDate = binding.birthYear.getText().toString();
        String empMonthlySal = binding.monthlySalary.getText().toString();
        String empOccupationRate = binding.occupationRate.getText().toString();
        String empId = binding.employeeID.getText().toString();
        String empType = binding.spnrEmployeeType.getSelectedItem().toString();
        String empProperties = binding.empProperties.getText().toString();

        String vehicleType = "";
        if (binding.vehicleType.getCheckedRadioButtonId() == R.id.car) {
            vehicleType = "Car";
        } else if (binding.vehicleType.getCheckedRadioButtonId() == R.id.motorcycle) {
            vehicleType = "Motorcycle";
        }
        String carType = binding.editTextCarType.toString();
        String sideCar = "";
        if (binding.sideCarType.getCheckedRadioButtonId() == R.id.yes) {
            vehicleType = "Yes";
        } else if (binding.sideCarType.getCheckedRadioButtonId() == R.id.no) {
            vehicleType = "No";
        }
        String vehicleModel = binding.vehicleModel.getText().toString();
        String vehiclePlate = binding.plateNumber.getText().toString();
        String vehicleColor = binding.vehicleColor.getSelectedItem().toString();

        String msg = "";
        if (empFirstName.isEmpty()) msg = "Please Enter Your First Name";
        else if (empLastName.isEmpty()) msg = "Please Enter Your Last Name";
        else if (empDate.isEmpty()) msg = "Please Enter Your Date Of Birth";
        else if (!isNumeric(empDate)) msg = "Please Enter Valid Date Of Birth";
        else if (empMonthlySal.isEmpty()) msg = "Please Enter Your Monthly Salary";
        else if (!isNumeric(empMonthlySal)) msg = "Please Enter Valid Monthly Salary";
        else if (empOccupationRate.isEmpty()) msg = "Please Enter Your Occupation Rate";
        else if (!isNumeric(empOccupationRate)) msg = "Please Enter Valid Occupation Rate";
        else if (empType.isEmpty()) msg = "Please Select a Employee Type";
        else if (empProperties.isEmpty()) msg = "Please Enter The Number";
        else if (!isNumeric(empProperties)) msg = "Please Enter Valid Number";
        else if (empId.isEmpty()) msg = "Please Enter Your Employee ID";
        else if (vehicleType.isEmpty()) msg = "Please Select a Vehicle Type";
        else if (vehicleType.equals("Car") && carType.isEmpty())
            msg = "Please Enter a Valid Car Type ";
        else if (vehicleType.equals("Motorcycle") && sideCar.isEmpty())
            msg = "Please Select a Valid Side Car Type ";
        else if (vehicleModel.isEmpty()) msg = "Please Enter Vehicle Model ";
        else if (vehiclePlate.isEmpty()) msg = "Please Enter Vehicle Plate Number";
        else if (vehicleColor.isEmpty()) msg = "Please Select Vehicle Color";

        if (msg.length() > 0) Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}