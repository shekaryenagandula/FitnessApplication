package com.example.gymapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutMembership extends AppCompatActivity {

    private TextView dietplan1,dietplan2,dietplan3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

         dietplan1=findViewById(R.id.dietplan1);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //      dietplan2=findViewById(R.id.dietplan2);
  //      dietplan3=findViewById(R.id.dietplan3);

        dietplan1.setOnClickListener((View v)->{
            Intent i=new Intent(this,PaymentActivity.class);
            startActivity(i);
        });
/*        dietplan2.setOnClickListener((View v)->{
            Intent i=new Intent(this,PaymentActivity.class);
            i.putExtra("diet2", (CharSequence) dietplan2);
            startActivity(i);
        });
        dietplan3.setOnClickListener((View v)->{
            Intent i=new Intent(this,PaymentActivity.class);
            i.putExtra("diet3", (CharSequence) dietplan3);
            startActivity(i);
        }); */
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