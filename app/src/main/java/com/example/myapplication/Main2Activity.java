package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name1=(TextView) findViewById(R.id.textView4);
        ImageView vv =(ImageView) findViewById(R.id.imageView2);
        TextView f=(TextView) findViewById(R.id.textView7);

        Bundle bundle = getIntent().getExtras();
        String name =bundle.getString("name");
        String he = bundle.getString("height");
        String wi = bundle.getString("weight");



        double BMI=Double.parseDouble(wi)/(Double.parseDouble(he)/100.0*Double.parseDouble(he)/100.0);
        DecimalFormat fu =new DecimalFormat("#.##");
        String msg;
        if(BMI>=24)
        {
            msg="體重過重";
            vv.setImageResource(R.drawable.bb);
        }
        else if(BMI<18.5)
        {
            msg="體重過輕";
            vv.setImageResource(R.drawable.aa);
        }
        else
        {
            msg="體重適中";
            vv.setImageResource(R.drawable.cc);
        }
        name1.setText(name+"的身高為"+he+"\n體重為"+wi);
        f.setText("BMI為:"+fu.format(BMI));
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
