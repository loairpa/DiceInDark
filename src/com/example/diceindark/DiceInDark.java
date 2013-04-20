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
package com.example.diceindark;



import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;



import android.content.Intent;
import android.speech.tts.TextToSpeech;

import com.example.framework.Screen;
import com.example.framework.impl.GLGame;
import com.example.diceindark.Assets;
import com.example.diceindark.MainMenuScreen;
//import com.example.diceindark.Settings;

public class DiceInDark extends GLGame {

	boolean firstTimeCreate = true;
	@Override
	public Screen getStartScreen() {
		   /*Intent installIntent = new Intent();
           installIntent.setAction(
               TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
           startActivity(installIntent);*/
		// TODO Auto-generated method stub
		return new MainMenuScreen(this);
	}

	
	public void onSurfaceCreated(GL10 gl, EGLConfig config){
		super.onSurfaceCreated(gl, config);
		if(firstTimeCreate){
			Assets.load(this);
			firstTimeCreate = false;
		}
		else
			Assets.reload();
	}
	
	@Override
	public void onPause(){
		super.onPause();


	}
	
	
	
}

