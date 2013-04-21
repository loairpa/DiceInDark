/*    Dice in the dark. D & D Android app for the blind and seeing impaired,
*    Copyright (C) 2013 Lovisa Irpa Helgadottir
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

import java.util.ArrayList;
import java.util.List;

import com.example.framework.Sound;
import com.example.framework.gl.Animation;
import com.example.framework.gl.Texture;
import com.example.framework.gl.TextureRegion;
import com.example.framework.impl.GLGame;



public class Assets {

		public static Texture mainMenuScreen;
	    public static TextureRegion mainMenuScreenRegion;
	    
	    public static Texture items;
	    
	    
	    public static List<TextureRegion> D4;
	    public static Animation D4_anim;
	    public static Sound shakeDie;
	    public static Sound rollDie;
	    
	    public static void load(GLGame game) {
	    	D4= new ArrayList<TextureRegion>();
	    	mainMenuScreen = new Texture(game, "background.png");
	    	mainMenuScreenRegion = new TextureRegion(mainMenuScreen, 0, 0, 320, 480);
	        
	    items = new Texture(game,"atlas.png");
	    
	    D4.add(new TextureRegion(items, 960, 0, 320, 480));
	    D4.add(new TextureRegion(items, 640, 0, 320, 480));
	    D4.add(new TextureRegion(items, 320, 0, 320, 480));
	    D4.add(new TextureRegion(items, 0, 0, 320, 480));
	    
	    D4_anim= new Animation(1f, D4.get(0),D4.get(1), D4.get(2),D4.get(3));
	    
	       rollDie=game.getAudio().newSound("ShakeAndRollDice-SoundBible.com-591494296.mp3");
	       shakeDie = game.getAudio().newSound("ShakeDice-SoundBible.com-1630587513.mp3");
	       
	    }       

	    public static void reload() {
	    	mainMenuScreen.reload();
	    	items.reload();

	    }
	    
	    public static void playSound(Sound sound) {
	            sound.play(1);
	    }

	    public static void playLoopSound(Sound sound) {
            sound.playloop(1);
    }
}
