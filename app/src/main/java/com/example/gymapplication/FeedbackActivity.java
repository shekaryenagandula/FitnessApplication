package com.example.gymapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        EditText user_feedback =findViewById(R.id.user_feedback);
        EditText user_name=findViewById(R.id.user_name);
        Button submitfeedback=findViewById(R.id.submitfeedback);
        submitfeedback.setOnClickListener((View v) ->{
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("message/html");
            i.putExtra(Intent.EXTRA_EMAIL,new String[]{"fitnessapp.support@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT,"Feedback from Application");
            i.putExtra(Intent.EXTRA_TEXT,"Name:"+user_name.getText()+"\n Message:"+user_feedback.getText());
            try{
                startActivity(Intent.createChooser(i,"Please select Email "));
            }
            catch (android.content.ActivityNotFoundException ex)
            {
                Toast.makeText(this, "There ae no Email Clients on this device", Toast.LENGTH_LONG).show();
            }
        });
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


}