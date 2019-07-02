package com.iniesta.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private Spinner selectservice1, servicecategory;
    private Button btn_proceed;
    private String name,email,phone,tolocation,fromlocation,service,servicescategory,date;
    private EditText mName,mEmail,mphone,mtolocation,mfromlocation,mdate;
    private String[] serviceslist = { "Select Service", "HouseHold Shifting", "Wheelers", "Office Shifting"};
    private String[] servicecategorieslist = { "Slect Service Categories", "Hello", "Hi", "It's", "Aman", "Here"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().hide();

        btn_proceed = findViewById(R.id.proceed_btn);
        mName = findViewById(R.id.clientname);
        mEmail = findViewById(R.id.clientemail);
        mphone = findViewById(R.id.clientphone);
        mdate = findViewById(R.id.servicedate);
        mtolocation = findViewById(R.id.clienttoLocation);
        mfromlocation = findViewById(R.id.clienttoLocation);
        selectservice1 = findViewById(R.id.selectservice);
        servicecategory = findViewById(R.id.categories);

        ArrayAdapter serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,serviceslist);
        serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectservice1.setAdapter(serviceAdapter);

        ArrayAdapter cateserviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,servicecategorieslist);
        cateserviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicecategory.setAdapter(cateserviceAdapter);

        selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                service = serviceslist[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        servicecategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                servicescategory = servicecategorieslist[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                email = mEmail.getText().toString();
                phone = mphone.getText().toString();
                tolocation = mtolocation.getText().toString();
                fromlocation = mfromlocation.getText().toString();
                date = mdate.getText().toString();

                Toast.makeText(FormActivity.this, name+" "+email+" "+phone+" "+tolocation+" "+fromlocation+" "+date+" "+service+" "+servicescategory, Toast.LENGTH_LONG).show();

            }
        });



    }
}
