package com.andrea.yoyoplayer.player;
import android.media.MediaPlayer;
import android.util.Log;

public class YoYoPlayer extends MediaPlayer {
    final static String TAG = "YoYoPlayer";
    public void initYoYoPlayerListener(){
        this.setOnPreparedListener(onPreparedListener);
        this.setOnErrorListener(onErrorListener);
    }
    MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mp) {
            Log.i(TAG,"onPrepared");
            start();
        }
    };

    MediaPlayer.OnErrorListener onErrorListener = new MediaPlayer.OnErrorListener(){
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            Log.e(TAG,"error:"+",what:"+what+",extra:"+extra);
            stop();
            release();
            return false;
        }
    };
}
