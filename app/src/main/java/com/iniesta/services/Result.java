package com.iniesta.services;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Result extends AppCompatActivity {

    TextView heading1,heading2,heading3,heading4,text1,text2,text3,text4;
    ImageView i1;
    Button b1;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent res=getIntent();
        String s=res.getStringExtra("value");
        Log.i("sss",s);
        b1=findViewById(R.id.submit);
        heading1=findViewById(R.id.heading1);
        i1=findViewById(R.id.img);
        heading4=findViewById(R.id.heading4);
        heading2=findViewById(R.id.heading2);
        heading3=findViewById(R.id.heading3);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
      //  text3.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
       // text2.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        text1.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
       // text4.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        if(s.equals("carpenter"))
        {
            i1.setImageResource(R.drawable.carpenter);
            heading1.setText("CARPENTER");
           // String temp="@string/carpenter_topic1";
            text1.setText(getString(R.string.carpenter_topic1));
            heading2.setText("Why Carpenter Serve on Door");
            text2.setText(getString(R.string.carpenter_topic2));
            text3.setText(getString(R.string.carpenter_topic3));
            text4.setText(getString(R.string.carpenter_topic4));

        }
        if(s.equals("beauty and spa"))
        {
            i1.setImageResource(R.drawable.beatyaspa);
            heading1.setText("Beauty & Spa");
            heading2.setText("Why Beauty & Spa from Serve on Door");
            text1.setText(getString(R.string.beauty_topic1));
            text2.setText(getString(R.string.beauty_topic2));
            text3.setText(getString(R.string.beauty_topic3));
            text4.setText(getString(R.string.beauty_topic4));
        }
        if(s.equals("Packers & Movers"))
        {
            i1.setImageResource(R.drawable.packers);
            heading1.setText("Packers & Movers");
            heading2.setText("Why Packer & Movers from Serve on Door");
            text1.setText(getString(R.string.packages_topic1));
            text2.setText(getString(R.string.packages_topic2));
            text3.setText(getString(R.string.packages_topic3));
            text4.setText(getString(R.string.packages_topic4));
        }
        if(s.equals("appliance"))
        {
            i1.setImageResource(R.drawable.ac);
            heading1.setText("AC Repair");
            heading2.setText("Why AC Repair from Serve on Door");
            text1.setText(getString(R.string.AC_topic1));
            text2.setText(getString(R.string.AC_topic2));
            text3.setText(getString(R.string.AC_topic3));
            text4.setText(getString(R.string.AC_topic4));

        }
        if(s.equals("yoga"))
        {
            i1.setImageResource(R.drawable.heart);
            heading1.setText("yoga");
            heading2.setText("why fitness from serve on door");
            text1.setText(getString(R.string.yoga_topic1));
            text2.setText(getString(R.string.yoga_topic2));
            text3.setText(getString(R.string.yoga_topic3));
            text4.setText(getString(R.string.yoga_topic4));

        }

    }
     public  void  submit(View view)
    {
        Log.i("bu","clic");
    }
}
