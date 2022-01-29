package com.example.gymapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment1 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment1_layout,container,false);


        ImageButton abs_exe=rootview.findViewById(R.id.imageButton1);
        ImageButton biceps_exe=rootview.findViewById(R.id.imageButton2);
        ImageButton chest_exe=rootview.findViewById(R.id.imageButton3);
        ImageButton tricep_exe=rootview.findViewById(R.id.imageButton4);
        ImageButton back_exe=rootview.findViewById(R.id.imageButton5);
        ImageButton cardio_exe=rootview.findViewById(R.id.imageButton6);
        ImageButton forearm_exe=rootview.findViewById(R.id.imageButton7);
        ImageButton leg_exe=rootview.findViewById(R.id.imageButton8);
        ImageButton calf_exe=rootview.findViewById(R.id.imageButton9);
        ImageButton shoulder_exe=rootview.findViewById(R.id.imageButton10);

        abs_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        biceps_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        chest_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        tricep_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        back_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        cardio_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        forearm_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        leg_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        calf_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });
        shoulder_exe.setOnClickListener((View v) -> {
            //Temporary storing other screen to intent
            Intent intent=new Intent(v.getContext(),AbsExer.class);
            startActivity(intent);
        });

        return rootview;
    }

}
