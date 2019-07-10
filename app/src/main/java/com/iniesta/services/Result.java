package com.iniesta.services;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Result extends AppCompatActivity {

    TextView heading1,heading2,heading3,heading4,text1,text2,text3,text4;
    CardView howCard,attentionCard;
    ImageView i1;
    Button b1;
    String s;
    static Context context;
    private String dialog1Text;
    private String dialog2Text;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().hide();

        context = this;

        Intent res = getIntent();
        s = res.getStringExtra("value");
        Log.i("sss",s);
        b1 = findViewById(R.id.submit);
        i1 = findViewById(R.id.img);
        heading1 = findViewById(R.id.heading1);
        heading2 = findViewById(R.id.heading2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        howCard = findViewById(R.id.howCard);
        attentionCard = findViewById(R.id.attentionCard);
       // text2.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        text1.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        if(s.equals("carpenter"))
        {
            i1.setImageResource(R.drawable.carpenter);
            heading1.setText("CARPENTER");
            text1.setText(getString(R.string.carpenter_topic1));
            heading2.setText("Why Carpenter Serve on Door");
            text2.setText(getString(R.string.carpenter_topic2));
            dialog1Text = getString(R.string.carpenter_topic3);
            dialog2Text = getString(R.string.carpenter_topic4);

        }
        if(s.equals("beauty and spa"))
        {
            i1.setImageResource(R.drawable.beatyaspa);
            heading1.setText("Beauty & Spa");
            heading2.setText("Why Beauty & Spa from Serve on Door");
            text1.setText(getString(R.string.beauty_topic1));
            text2.setText(getString(R.string.beauty_topic2));
            dialog1Text = getString(R.string.beauty_topic3);
            dialog2Text = getString(R.string.beauty_topic4);
        }
        if(s.equals("salon"))
        {
            i1.setImageResource(R.drawable.beatyaspa);
            heading1.setText("Salon");
            heading2.setText("Why Salon from Serve on Door");
            text1.setText(getString(R.string.beauty_topic1));
            text2.setText(getString(R.string.beauty_topic2));
            dialog1Text = getString(R.string.beauty_topic3);
            dialog2Text = getString(R.string.beauty_topic4);
        }
        if(s.equals("Packers & Movers"))
        {
            i1.setImageResource(R.drawable.packers);
            heading1.setText("Packers & Movers");
            heading2.setText("Why Packer & Movers from Serve on Door");
            text1.setText(getString(R.string.packages_topic1));
            text2.setText(getString(R.string.packages_topic2));
            dialog1Text = getString(R.string.packages_topic3);
            dialog2Text = getString(R.string.packages_topic4);
        }
        if(s.equals("appliance"))
        {
            i1.setImageResource(R.drawable.ac);
            heading1.setText("AC Repair");
            heading2.setText("Why AC Repair from Serve on Door");
            text1.setText(getString(R.string.AC_topic1));
            text2.setText(getString(R.string.AC_topic2));
            dialog1Text = getString(R.string.AC_topic3);
            dialog2Text = getString(R.string.AC_topic4);
        }
        if(s.equals("healthAndFitness"))
        {
            i1.setImageResource(R.drawable.fitness);
            heading1.setText("Health and Fitness");
            heading2.setText("Why Health and Fitness from serve on door");
            text1.setText(getString(R.string.fitness_topic1));
            text2.setText(getString(R.string.fitness_topic2));
            dialog1Text = getString(R.string.fitness_topic3);
            dialog2Text = getString(R.string.fitness_topic4);
        }

        howCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.howitworks);
                dialog.setTitle("How It Works");

                TextView text = dialog.findViewById(R.id.dialog1t);
                System.out.println(dialog1Text);
                text.setText(dialog1Text);
                ImageView cross = dialog.findViewById(R.id.crossd1);
                cross.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        attentionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.conditions);
                dialog.setTitle("Attention");

                TextView text = dialog.findViewById(R.id.dialog2t);
                text.setText(dialog2Text);
                ImageView cross = dialog.findViewById(R.id.crossd2);
                cross.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
     public  void  submit(View view)
    {
        Log.i("bu","click");
        Intent i1=new Intent(this,FormActivity.class);
        i1.putExtra("value",s);
        startActivity(i1);

    }

}
