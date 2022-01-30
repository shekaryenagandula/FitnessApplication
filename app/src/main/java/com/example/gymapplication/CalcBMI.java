package com.example.gymapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class CalcBMI extends AppCompatActivity {

    private EditText heighttxt,weighttxt;
    private  TextView outputscore,bmitype;
    private Button calculatebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_bmi);
        CalculatListener();

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    private void CalculatListener() {

        heighttxt=(EditText) findViewById(R.id.heighttxt);
        weighttxt=(EditText) findViewById(R.id.weighttxt);
        outputscore=(TextView) findViewById(R.id.outputscore);
        bmitype=(TextView) findViewById(R.id.bmitype);
        calculatebtn=(Button) findViewById(R.id.calculatebtn);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String heightvalue = heighttxt.getText().toString();
            float height = Float.valueOf(heightvalue);
            String weightvalue = weighttxt.getText().toString();
            float weight = Float.valueOf(weightvalue);

                if(TextUtils.isEmpty(heightvalue)  || TextUtils.isEmpty(weightvalue)){
                    Toast.makeText(getApplicationContext(), "Not valid inputs", Toast.LENGTH_LONG).show();

                }else{
                    float out = (weight/((height/100)*(height/100)));
                    String display="Your BMI is "+out;
                    outputscore.setText(display);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    if (out < 18.5) {
                        bmitype.setText("Category: Underweight");
                    } else if (out >= 18.5 && out < 25.0) {
                        bmitype.setText("Category: Healthy");
                    }
                    else if(out >= 25.0 && out < 29.9){
                        bmitype.setText("Category: Healthy");
                    }else {
                        bmitype.setText("Category: Obese");
                    }
                }



            }

        });

    }

}