package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText a;
    private EditText c;
    private EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FVD();
    }

    private void FVD() {
        a = findViewById(R.id.editText);
        c =findViewById(R.id.editText2);
        e =findViewById(R.id.editText3);
    }

    public void show(View view) {
        TextView b =findViewById(R.id.textView);
        b.setText("名字:"+ a.getText().toString());
        TextView d =findViewById(R.id.textView1);
        d.setText("身高為:"+c.getText().toString());

        double he= Double.parseDouble(c.getText().toString());
        double wi= Double.parseDouble(e.getText().toString());
        double BMI=wi/(he/100.0*he/100.0);
        DecimalFormat fu =new DecimalFormat("#.##");

        ImageView vv =(ImageView) findViewById(R.id.imageView3);
        TextView f =findViewById(R.id.textView3);
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
        f.setText("BMI為:"+fu.format(BMI));
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void nextpage(View view) {
        Bundle bundle =new Bundle();
        bundle.putString("height",c.getText().toString());
        bundle.putString("weight",e.getText().toString());
        bundle.putString("name",a.getText().toString());

        Intent intent=new  Intent(this,Main2Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
