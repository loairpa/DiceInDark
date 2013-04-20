/*    Dice in the dark. D & D Android app for the blind and seeing impaired,
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

import com.example.framework.gl.Texture;
import com.example.framework.gl.TextureRegion;
import com.example.framework.impl.GLGame;


public class Assets {

		public static Texture background;
	    public static TextureRegion backgroundRegion;
	    
	    public static void load(GLGame game) {
	        background = new Texture(game, "background.png");
	        backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);
	        
	       
	    }       

	    public static void reload() {
	        background.reload();

	    }

}
