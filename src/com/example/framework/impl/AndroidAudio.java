package com.example.framework.impl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.speech.tts.TextToSpeech;
import android.util.Log;


import com.example.framework.Audio;
import com.example.framework.Sound;

public class AndroidAudio implements Audio, TextToSpeech.OnInitListener {
    AssetManager assets;
    SoundPool soundPool;
    TextToSpeech textToSpeech;
    
    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        this.textToSpeech = new TextToSpeech(activity, this);
    }

    
    public Sound newSound(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }


	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		if (arg0 == TextToSpeech.SUCCESS) {

//			int result = textToSpeech.setLanguage(Locale.ENGLISH);
//			if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
//				Log.e("TTS", "Language is not supported");
		} else 
			Log.e("TTS", "Initilization Failed");
		
	}


	@Override
	public void speakOut(String text) {
		// TODO Auto-generated method stub
		textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}

}