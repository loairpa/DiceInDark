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
package com.plovergames.framework;

import com.plovergames.framework.math.Vector2;
import com.plovergames.framework.math.Rectangle;
public class GameObject {
	
	public final Vector2 position;
	public final Rectangle bounds;
	
	public GameObject(float x, float y, float width, float height){
		this.position = new Vector2(x,y);
		this.bounds = new Rectangle(x-width/2,y-height/2,width,height);
	}

}
