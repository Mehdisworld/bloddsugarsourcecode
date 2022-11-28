package com.androtoolz.bloodsugardiary;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
    public static Context ctx;
    MediaPlayer sound = MediaPlayer.create(ctx, this.sound_id);
    int sound_id;

    public Music(int i, Context context) {
        this.sound_id = i;
        ctx = context;
        this.sound.setAudioStreamType(3);
        this.sound.setLooping(true);
    }

    public void rel() {
        try {
            this.sound.release();
        } catch (Exception unused) {
        }
    }

    public void playNote() {
        try {
            this.sound.seekTo(0);
        } catch (Exception unused) {
        }
        this.sound.start();
    }

    public void stopPlaying() {
        try {
            if (this.sound.isPlaying()) {
                this.sound.pause();
            }
        } catch (Exception unused) {
        }
    }
}
