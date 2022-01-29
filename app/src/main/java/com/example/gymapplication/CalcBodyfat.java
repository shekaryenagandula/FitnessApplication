package com.example.gymapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalcBodyfat extends AppCompatActivity {
    private EditText waistinput,neckinput,ageinput,heightinput,weightinput;
    private Button calcBtn;
    private TextView calcout;
    private RadioGroup radioSexGroup;
    private RadioButton radiosexbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_bodyfat);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        CalculatListener();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void CalculatListener() {
        ageinput=(EditText) findViewById(R.id.ageinput);
        weightinput=(EditText) findViewById(R.id.weightinput);
        heightinput=(EditText) findViewById(R.id.heightinput);
        neckinput=(EditText) findViewById(R.id.neckinput);
        waistinput=(EditText) findViewById(R.id.waistinput);
        calcBtn=(Button) findViewById(R.id.calcBtn);
        radioSexGroup=(RadioGroup) findViewById(R.id.radiogroup);
        calcout= (TextView) findViewById(R.id.calcout);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedoption=radioSexGroup.getCheckedRadioButtonId();
                int age=Integer.valueOf(ageinput.getText().toString());
                int weight=Integer.valueOf(weightinput.getText().toString());
                int height=Integer.valueOf(heightinput.getText().toString());
                int neck=Integer.valueOf(neckinput.getText().toString());
                int waist=Integer.valueOf(waistinput.getText().toString());

                radiosexbutton=(RadioButton) findViewById(selectedoption);
//                Toast.makeText(getApplicationContext(), radiosexbutton.getText(), Toast.LENGTH_SHORT).show();


                if(TextUtils.isEmpty(ageinput.getText().toString()) || TextUtils.isEmpty(weightinput.getText().toString())|| TextUtils.isEmpty(heightinput.getText().toString())  || TextUtils.isEmpty(neckinput.getText().toString()) || TextUtils.isEmpty(waistinput.getText().toString()) ){
                    Toast.makeText(getApplicationContext(), "Not valid inputs", Toast.LENGTH_LONG).show();
                }
                else{
                    double valueongender = 0;
                    if(radiosexbutton.getText() == "Male"){
                        valueongender= 16.2;
                    }else{
                        valueongender= 5.4;
                    }
//                    double BMI=  ;
                    double out= (1.20 * (weight/((height*height/(100*100)))) + 0.23 * age  - valueongender);
                    calcout.setText(String.valueOf(out)+"%");

//                    Toast.makeText(this, out, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}