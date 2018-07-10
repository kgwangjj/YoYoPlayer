package com.andrea.yoyoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.andrea.yoyoplayer.player.YoYoPlayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    final static String TAG = "YoYoPlayer";
    String testVideoPath = "/sdcard/Movies/videoviewdemo.mp4";
    private YoYoPlayer yoYoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        Log.i(TAG,"onCreate");

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG,"surfaceCreated");
        yoYoPlayer = new YoYoPlayer();
        try {
            yoYoPlayer.setDataSource(testVideoPath);
            yoYoPlayer.setDisplay(holder);
            yoYoPlayer.initYoYoPlayerListener();
            yoYoPlayer.prepareAsync();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG,"surfaceChanged:"+holder);
        Log.i(TAG,"width="+String.valueOf(width)+",height="+String.valueOf(height));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG,"surfaceDestroyed");
        if(yoYoPlayer!=null){
            yoYoPlayer.stop();
            yoYoPlayer.release();
        }
    }
}
