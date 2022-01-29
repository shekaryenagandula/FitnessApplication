package com.example.gymapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;


public class AbsPlank extends AppCompatActivity {

    String videoURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plank_abs);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Uri uri= Uri.parse("");
        VideoView videoView=findViewById(R.id.videoView);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.plank;
        Uri uri=Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.seekTo(1);
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