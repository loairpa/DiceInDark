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
package com.plovergames.diceindark;

import java.util.ArrayList;
import java.util.List;



import com.plovergames.framework.Sound;
import com.plovergames.framework.gl.Animation;
import com.plovergames.framework.gl.Texture;
import com.plovergames.framework.gl.TextureRegion;
import com.plovergames.framework.impl.GLGame;





public class Assets {

		public static Texture mainMenuScreen;
	    public static TextureRegion mainMenuScreenRegion;
	    
	    public static Texture items;
	    
	    
	    public static List<TextureRegion> D4;
	    public static List<TextureRegion> D6;
	    public static List<TextureRegion> D8;
	    public static List<TextureRegion> D10;
	    public static List<TextureRegion> D12;
	    public static List<TextureRegion> D20;
	    public static List<TextureRegion> D100;
	    public static Animation D4_anim;
	    public static Animation D6_anim;
	    public static Animation D8_anim;
	    public static Animation D10_anim;
	    public static Animation D12_anim;
	    public static Animation D20_anim;
	    public static Animation D100_anim;
	    public static Sound shakeDie;
	    public static Sound rollDie;
	    
	    public static void load(GLGame game) {
	    	D4= new ArrayList<TextureRegion>();
	    	D6= new ArrayList<TextureRegion>();
	    	D8= new ArrayList<TextureRegion>();
	    	D10=new ArrayList<TextureRegion>();
	    	D12= new ArrayList<TextureRegion>();
	    	D20= new ArrayList<TextureRegion>();
	    	D100 = new ArrayList<TextureRegion>();
	    	mainMenuScreen = new Texture(game, "background.png");
	    	mainMenuScreenRegion = new TextureRegion(mainMenuScreen, 0, 0, 320, 480);
	        
	    items = new Texture(game,"atlas.png");
	    
	    D4.add(new TextureRegion(items, 480, 0, 160, 220));
	    D4.add(new TextureRegion(items, 320, 0, 160, 220));
	    D4.add(new TextureRegion(items, 160, 0, 160, 220));
	    D4.add(new TextureRegion(items, 0, 0, 160, 220));
	    
	    D4_anim= new Animation(0.3f, D4.get(0),D4.get(1), D4.get(2),D4.get(3));
	    

	    D6.add(new TextureRegion(items, 645+800, 0, 160, 220));
	    D6.add(new TextureRegion(items,645+640,0,160,220));
	    D6.add(new TextureRegion(items, 645+480, 0, 160, 220));
	    D6.add(new TextureRegion(items, 645+320, 0, 160, 220));
	    D6.add(new TextureRegion(items, 645+160, 0, 160, 220));
	    D6.add(new TextureRegion(items,645,0,160,220));
	    
	    D6_anim= new Animation(0.3f, D6.get(0),D6.get(1), D6.get(2),D6.get(3), D6.get(4),D6.get(5));
	    

	    D8.add(new TextureRegion(items, 1120, 220, 160, 220));
	    D8.add(new TextureRegion(items,960,220,160,220));
	    D8.add(new TextureRegion(items, 800, 220, 160, 220));
	    D8.add(new TextureRegion(items,640,220,160,220));
	    D8.add(new TextureRegion(items, 480, 220, 160, 220));
	    D8.add(new TextureRegion(items, 320, 220, 160, 220));
	    D8.add(new TextureRegion(items, 160, 220, 160, 220));
	    D8.add(new TextureRegion(items,0,220,160,220));
	    
	    D8_anim= new Animation(0.3f, D8.get(0),D8.get(1), D8.get(2),D8.get(3), D8.get(4),D8.get(5),D8.get(6),D8.get(7));
	    

	    D10.add(new TextureRegion(items,0,480+240,160,220));
	    D10.add(new TextureRegion(items, 160, 480+240, 160, 220));
	    D10.add(new TextureRegion(items, 320, 480+240, 160, 220));
	    D10.add(new TextureRegion(items, 480, 480+240, 160, 220));	
	    D10.add(new TextureRegion(items,640,480+240,160,220));
	    D10.add(new TextureRegion(items, 800, 480+240, 160, 220));
	    D10.add(new TextureRegion(items,960,480+240,160,220));
	    D10.add(new TextureRegion(items, 1120, 480+240, 160, 220));
	    D10.add(new TextureRegion(items,1280,480+240,160,220));
	    D10.add(new TextureRegion(items, 1440, 480+240, 160, 220));
	    D10_anim= new Animation(0.3f, D10.get(0),D10.get(1), D10.get(2),D10.get(3), D10.get(4),D10.get(5),D10.get(6),D10.get(7),D10.get(8),D10.get(9));
	    
	    D12.add(new TextureRegion(items, 1440, 480, 160, 220));
	    D12.add(new TextureRegion(items,1280,480,160,220));
	    D12.add(new TextureRegion(items, 1120, 480, 160, 220));
	    D12.add(new TextureRegion(items,960,480,160,220));
	    D12.add(new TextureRegion(items, 800, 480, 160, 220));
	    D12.add(new TextureRegion(items,640,480,160,220));
	    D12.add(new TextureRegion(items, 480, 480, 160, 220));
	    D12.add(new TextureRegion(items, 320, 480, 160, 220));
	    D12.add(new TextureRegion(items, 160, 480, 160, 220));
	    D12.add(new TextureRegion(items,0,480,160,220));
	    D12.add(new TextureRegion(items, 1440, 220, 160, 220));
	    D12.add(new TextureRegion(items,1280,220,160,220));
	    
	    D12_anim= new Animation(0.3f, D12.get(0),D12.get(1), D12.get(2),D12.get(3), D12.get(4),D12.get(5),D12.get(6),D12.get(7),D12.get(8),D12.get(9),D12.get(10),D12.get(11));
	    
	    D20.add(new TextureRegion(items, 1440+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items,1280+5,480+920+50+10,160,220));
	    D20.add(new TextureRegion(items, 1120+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items,960+5,480+920+50+10,160,220));
	    D20.add(new TextureRegion(items, 800+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items,640+5,480+920+50+10,160,220));
	    D20.add(new TextureRegion(items, 480+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items, 320+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items, 160+5, 480+920+50+10, 160, 220));
	    D20.add(new TextureRegion(items,0+5,480+920+50+510,160,220));
	    D20.add(new TextureRegion(items, 1440, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items,1280,480+700+40,160,220));
	    D20.add(new TextureRegion(items, 1120, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items,960,480+700+40,160,220));
	    D20.add(new TextureRegion(items, 800, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items,640,480+700+40,160,220));
	    D20.add(new TextureRegion(items, 480, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items, 320, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items, 160, 480+700+40, 160, 220));
	    D20.add(new TextureRegion(items,0,480+700+40,160,220));
	    D20_anim= new Animation(0.3f, D20.get(0),D20.get(1), D20.get(2),D20.get(3), D20.get(4),D20.get(5),D20.get(6),D20.get(7),D20.get(8),D20.get(9),D20.get(10),D20.get(11), D20.get(12),D20.get(13), D20.get(14),D20.get(15),D20.get(16),D20.get(17),D20.get(18),D20.get(19));
	    
	    
	    D100.add(new TextureRegion(items,0,960,160,220));
	    D100.add(new TextureRegion(items, 160, 960, 160, 220));
	    D100.add(new TextureRegion(items, 320, 960, 160, 220));
	    D100.add(new TextureRegion(items, 480, 960, 160, 220));	
	    D100.add(new TextureRegion(items,640,960,160,220));
	    D100.add(new TextureRegion(items, 800, 960, 160, 220));
	    D100.add(new TextureRegion(items,960,960,160,220));
	    D100.add(new TextureRegion(items, 1120, 960, 160, 220));
	    D100.add(new TextureRegion(items,1280,960,160,220));
	    D100.add(new TextureRegion(items, 1440, 960, 160, 220));
	    D100_anim= new Animation(0.3f, D100.get(0),D100.get(1), D100.get(2),D100.get(3), D100.get(4),D100.get(5),D100.get(6),D100.get(7),D100.get(8),D100.get(9));
	    
	    
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
