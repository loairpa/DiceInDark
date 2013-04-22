/*    Dice in the dark. D & D app for the blind and seeing impaired,
*    Copyright (C) <2013r>  <Lovisa Irpa Helgadottir>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.plovergames.framework.impl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.speech.tts.TextToSpeech;
import android.util.Log;


import com.plovergames.framework.Audio;
import com.plovergames.framework.Sound;

public class AndroidAudio implements Audio, TextToSpeech.OnInitListener {
    AssetManager assets;
    SoundPool soundPool;
    TextToSpeech textToSpeech;
    
    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
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