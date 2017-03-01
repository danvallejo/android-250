package com.cstructor.androidinterfaces;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SoundPoolActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {

    private int id1;
    private static SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);

        // maxStreams, streamType, 0 currently has no effect
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // priority is 1 and has no effect
        id1 = soundPool.load(this, R.raw.working_week, 1);

        soundPool.setOnLoadCompleteListener(this);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        /**
         * @param soundID a soundID returned by the load() function
         * @param leftVolume left volume value (range = 0.0 to 1.0)
         * @param rightVolume right volume value (range = 0.0 to 1.0)
         * @param priority stream priority (0 = lowest priority)
         * @param loop loop mode (0 = no loop, -1 = loop forever)
         * @param rate playback rate (1.0 = normal playback, range 0.5 to 2.0)
         */
        soundPool.play(sampleId, 1, 1, 0, -1, 1);
    }

    @Override
    protected void onStop() {
        super.onStop();

        soundPool.stop(id1);
    }
}

