package com.iniesta.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FormActivity extends AppCompatActivity {

    private Spinner selectservice1, servicecategory;
    private Button btn_proceed;
    private String name,email,phone,tolocation,fromlocation,service,servicescategory,date;
    private EditText mName,mEmail,mphone,mtolocation,mfromlocation,mdate;
    TextView heading,heading2;

    private String[] serviceslist = { "Select Service", "HouseHold Shifting", "Wheelers", "Office Shifting"};
    private String[] servicecategorieslist = { "Slect Service Categories", "Hello", "Hi", "It's", "Aman", "Here"};
    private String[] servicecategorieslist2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().hide();
        Intent res=getIntent();
        String s=res.getStringExtra("value");//value of intent
        Log.i("you clicked",s);
        heading=findViewById(R.id.heading_form);
        heading2=findViewById(R.id.heading22);
        btn_proceed = findViewById(R.id.proceed_btn);
        mName = findViewById(R.id.clientname);
        mEmail = findViewById(R.id.clientemail);
        mphone = findViewById(R.id.clientphone);
        mdate = findViewById(R.id.servicedate);
        mtolocation = findViewById(R.id.clienttoLocation);
        mfromlocation = findViewById(R.id.clienttoLocation);
        selectservice1 = findViewById(R.id.selectservice);
        servicecategory = findViewById(R.id.categories);

        if(s.equals("salon"))
        {
            serviceslist= new String[]{"nothing here","21"};
            String[] insiderlist1={"here"};
            heading.setText("Life is not perfect, But your beauty can be...");
            heading2.setText("Find yourself & be that..");
            ArrayAdapter serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,serviceslist);
            serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            selectservice1.setAdapter(serviceAdapter);



            selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i==0)
                    {
                        Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"nothing here"};
                        setlist();
                    }
                    else if(i==1)
                    {   Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"nothing here","go for it"};
                        setlist();

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                    servicecategorieslist=new String[]{"please select a option"};
                    setlist();
                }
            });


        }
        else if(s.equals("carpenter"))
        {
            heading.setText("Our Carpenter does Woodwork in Professional Manner.");
            heading2.setText("Whats wrong with your woodwork");
            serviceslist= new String[]{"select an item","drill &hang","lock","furniture assembly","door","fitting","drawer","new furniture making","other service"};
            ArrayAdapter serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,serviceslist);
            serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            selectservice1.setAdapter(serviceAdapter);



            selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i==0)
                    {
                        Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"please select a valid item"};
                        setlist();
                    }
                    else if(i==1)
                    {   Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"backend","backend"};
                        setlist();

                    }
                    else {
                        servicecategorieslist=new String[]{"n/a","n/a","n/a","go for it"};
                        setlist();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                    servicecategorieslist=new String[]{"please select a option"};
                    setlist();
                }
            });





        }

        else if(s.equals("appliance"))
        {
            heading.setText("It's good Idea to get regular air conditioner tune ups..\n");
            heading2.setText("Whats wrong with your AC");
            serviceslist= new String[]{"select an item","split ac","window ac","furniture assembly","door","fitting","drawer","new furniture making","other service"};
            ArrayAdapter serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,serviceslist);
            serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            selectservice1.setAdapter(serviceAdapter);



            selectservice1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i==0)
                    {
                        Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"please select a valid item"};
                        setlist();
                    }
                    else if(i==1)
                    {   Log.i("go","1"+i);
                        servicecategorieslist=new String[]{"backend","backend"};
                        setlist();

                    }
                    else {
                        servicecategorieslist=new String[]{"n/a","n/a","n/a","go for it"};
                        setlist();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                    servicecategorieslist=new String[]{"please select a option"};
                    setlist();
                }
            });



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
    void setlist()
    {
        ArrayAdapter cateserviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,servicecategorieslist);
        cateserviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicecategory.setAdapter(cateserviceAdapter);
        servicecategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                servicescategory = servicecategorieslist[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
