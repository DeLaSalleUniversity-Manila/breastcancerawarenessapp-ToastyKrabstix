package com.example.christian.bca;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

public class SplashActivity extends Activity {
    private void jump() {
//it is safe to use this code even if you
//do not intend to allow users to skip the splash
        if(isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //try{
        setContentView(R.layout.content_splash);
        VideoView videoHolder = (VideoView)findViewById(R.id.myvideo);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.splash);
        videoHolder.setVideoURI(video);
        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                jump();
            }

        });
        videoHolder.start();
    }



}
