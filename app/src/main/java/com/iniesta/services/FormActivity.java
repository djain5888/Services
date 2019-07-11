package com.iniesta.services;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class FormActivity extends AppCompatActivity {

    private Spinner selectservice1, servicecategory,genderSpinner;
    private Button btn_proceed;
    private String name,email,phone,tolocation,fromlocation,service,servicescategory,date;
    private EditText mName,mEmail,mphone,mtolocation,mfromlocation,mdate;
    DatePickerDialog picker;
    TextView heading,heading2;
    private String[] servicesList = { "Select Service", "HouseHold Shifting", "Wheelers", "Office Shifting"};
    private String[] serviceCategoriesList = { "Select Service Categories", "1BHK - 2000", "2BHK - 2500", "3BHK", "4BHK", "5BHK"};
    String[] genderList = new String[]{"You are","Male","Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().hide();
        Intent intent = getIntent();
        String valueString = intent.getStringExtra("value");
        Log.i("You Clicked: ",valueString);

        heading = findViewById(R.id.heading_form);
        heading2 = findViewById(R.id.heading22);
        btn_proceed = findViewById(R.id.proceed_btn);
        mName = findViewById(R.id.clientname);
        mEmail = findViewById(R.id.clientemail);
        mphone = findViewById(R.id.clientphone);
        mdate = findViewById(R.id.servicedate);
        genderSpinner = findViewById(R.id.genderSpinner);
        mtolocation = findViewById(R.id.clienttoLocation);
        mfromlocation = findViewById(R.id.clientfromlocation);
        selectservice1 = findViewById(R.id.selectservice);
        servicecategory = findViewById(R.id.categories);

        ArrayAdapter serviceAdapter;
        ArrayAdapter genderAdapter;

        mdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar cldr = java.util.Calendar.getInstance();
                int day = cldr.get(java.util.Calendar.DAY_OF_MONTH);
                int month = cldr.get(java.util.Calendar.MONTH);
                int year = cldr.get(java.util.Calendar.YEAR);
                // date picker dialog
                Date today=new Date();
                long minDate = cldr.getTime().getTime();
                Calendar c = java.util.Calendar.getInstance();
                c.setTime(today);
                c.add( java.util.Calendar.MONTH, +3 ) ;// Subtract 6 months
                long maxDate = c.getTime().getTime() ;//

                picker = new DatePickerDialog(FormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                mdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(minDate);
                picker.getDatePicker().setMaxDate(maxDate);
                picker.show();
            }
        });

        switch (valueString){
            case "beauty&spa":
                service = "beauty&spa";
                servicesList = new String[]{"Select Service","Service 1"};
                heading.setText("Life is not perfect, But your beauty can be...");
                heading2.setText("Find yourself & be that..");

                genderSpinner.setVisibility(View.VISIBLE);
                genderAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, genderList);
                genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                genderSpinner.setAdapter(genderAdapter);

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"please select a option"};
                        setList();
                    }
                });
                break;
            case "health&Fitness":
                service = "health&Fitness";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "packers&movers":
                service = "packers&movers";
                servicesList = new String[]{ "Select Service", "HouseHold Shifting", "Wheelers", "Office Shifting"};
                heading.setText("We always do our best to shift your goods in Professional Manner.");
                heading2.setText("Tell us Where are you Shifting");
                mfromlocation.setVisibility(View.VISIBLE);
                mtolocation.setHint("To Location");
                mdate.setHint("Shifting Date (dd/mm/yy)");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"please select a option"};
                        setList();
                    }
                });
                break;
            case "restaurants":
                service = "restaurants";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "acRepair":
                service = "acRepair";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "dietician":
                service = "acRepair";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "doctor":
                service = "acRepair";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "tutor":
                service = "acRepair";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "taxes":
                service = "acRepair";
                servicesList = new String[]{"Split AC","Window AC"};
                heading.setText("It's good Idea to get regular air conditioner tune ups..");
                heading2.setText("What's wrong with your air conditioner");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"Please select an option"};
                        setList();
                    }
                });
                break;
            case "salon":
                service = "salon";
                servicesList = new String[]{"Select Service","Service 1"};
                heading.setText("Life is not perfect, But your beauty can be...");
                heading2.setText("Find yourself & be that..");

                genderSpinner.setVisibility(View.VISIBLE);
                genderAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, genderList);
                genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                genderSpinner.setAdapter(genderAdapter);

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"please select a option"};
                        setList();
                    }
                });
                break;
            case "carpenter":
                service = "carpenter";
                servicesList = new String[]{"Select an item","drill &hang","lock","furniture assembly","door","fitting","drawer","new furniture making","other service"};
                heading.setText("Our Carpenter does Woodwork in Professional Manner.");
                heading2.setText("Why do you need carpenter");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"please select a option"};
                        setList();
                    }
                });
                break;
            case "homeAppliances":
                service = "homeAppliances";
                servicesList = new String[]{"select an item","split ac","window ac","furniture assembly","door","fitting","drawer","new furniture making","other service"};
                heading.setText("Home Appliances");
                heading2.setText("Tell us what you want");

                serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, servicesList);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectservice1.setAdapter(serviceAdapter);

                selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                        else if(i==1)
                        {
                            Log.i("go","1"+i);
                            serviceCategoriesList = new String[]{"service1","service2","service3"};
                            setList();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                        serviceCategoriesList = new String[]{"please select a option"};
                        setList();
                    }
                });
                break;
        }

        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                email = mEmail.getText().toString();
                phone = mphone.getText().toString();
                tolocation = mtolocation.getText().toString();
                fromlocation = mfromlocation.getText().toString();
                date = mdate.getText().toString();
                Intent i=new Intent(FormActivity.this,CheckOutActivity.class);
                startActivity(i);
                Toast.makeText(FormActivity.this, name+" "+email+" "+phone+" "+tolocation+" "+fromlocation+" "+date+" "+service+" "+servicescategory, Toast.LENGTH_LONG).show();

            }
        });

    }
    void setList()
    {
        ArrayAdapter cateserviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, serviceCategoriesList);
        cateserviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicecategory.setAdapter(cateserviceAdapter);
        servicecategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                servicescategory = serviceCategoriesList[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
