package com.example.codepirates_finalproject_madt3125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.codepirates_finalproject_madt3125.databinding.ActivityRegistrationFormBinding;

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
                binding.txtvwEmpSelection.setText("#Clients");
                break;
            case "Tester":
                binding.empProperties.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setText("#Bugs");
                break;
            case "Programmer":
                binding.empProperties.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setVisibility(View.VISIBLE);
                binding.txtvwEmpSelection.setText("#Projects");
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

    private void onSubmit() {

    }
}