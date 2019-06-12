package com.iniesta.services;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Number_activity extends AppCompatActivity {
    Button b1;
    EditText t1;
    Button login;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_number_activity);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t1=findViewById(R.id.number);
        login=findViewById(R.id.login);
        b1=findViewById(R.id.skip);
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s1=t1.getText().toString();
                if(s1.length()==10) {
                    login.setVisibility(View.VISIBLE);
                    Toast.makeText(Number_activity.this, "hello" + s1, Toast.LENGTH_SHORT).show();
                }
                else {
                    login.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s1.length()==10)
                    Toast.makeText(Number_activity.this, "hello"+s1, Toast.LENGTH_SHORT).show();


            }
        });



    }

   public   void skip(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void login(View view)
    {
        Toast.makeText(this, "number :"+s1, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
