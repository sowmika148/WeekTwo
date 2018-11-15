package com.example.stammana.weektwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<String> states;
    private String selectedState = "";
    private String selectedGender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadStates();
        Spinner statesSpinner = (Spinner) findViewById(R.id.states);
        statesSpinner.setOnItemSelectedListener(this);
    }

    private void loadStates() {
        states = Arrays.asList("AP", "Telangana", "TN", "Kerala", "Karnataka");
        Spinner statesSpinner = (Spinner) findViewById(R.id.states);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,states);
        statesSpinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedState = states.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void submit(View view) {
        EditText name = (EditText)findViewById(R.id.userName);
        EditText password = (EditText)findViewById(R.id.password);
        EditText address = (EditText)findViewById(R.id.address);
        EditText age = (EditText)findViewById(R.id.age);
        EditText date = (EditText)findViewById(R.id.date);
        EditText month = (EditText)findViewById(R.id.month);
        EditText year = (EditText)findViewById(R.id.year);
        String personName = name.getText().toString();
        String personPassword = password.getText().toString();
        String personAddress = address.getText().toString();
        String personGender = selectedGender;
        String personAge = age.getText().toString();
        String personDOB = date.getText().toString() + "/" + month.getText().toString() + "/" + year.getText().toString();
        String state = selectedState;
        ((TextView) findViewById(R.id.personUserName)).setText(personName);
        ((TextView) findViewById(R.id.personPassword)).setText(personPassword);
        ((TextView) findViewById(R.id.personAddress)).setText(personAddress);
        ((TextView) findViewById(R.id.personGender)).setText(personGender);
        ((TextView) findViewById(R.id.personAge)).setText(personAge);
        ((TextView) findViewById(R.id.personDOB)).setText(personDOB);
        ((TextView) findViewById(R.id.personState)).setText(state);
    }

    public void gender(View view) {
        RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
        int selectedId = gender.getCheckedRadioButtonId();
        RadioButton genderButton = (RadioButton) findViewById(selectedId);
        selectedGender = genderButton.getText().toString();
    }
}
