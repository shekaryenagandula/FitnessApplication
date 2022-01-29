package com.example.gymapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class Fragment3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment3_layout,container,false);

        LinearLayout bmicalc=v.findViewById(R.id.bmicalc);
        LinearLayout fatcalc=v.findViewById(R.id.bodyfatcalc);

        bmicalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext().getApplicationContext(), CalcBMI.class);
                startActivity(i);
            }
        });
        fatcalc.setOnClickListener((View view) ->{
            Intent i=new Intent(view.getContext().getApplicationContext(), CalcBodyfat.class);
            startActivity(i);
        });
        return v;
    }
}
