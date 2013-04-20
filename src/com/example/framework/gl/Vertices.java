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
package com.example.framework.gl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.example.framework.impl.GLGraphics;

public class Vertices {
    final GLGraphics glGraphics;
    final boolean hasColor;
    final boolean hasTexCoords;
    final int vertexSize;
    final IntBuffer vertices;
    final int[] tmpBuffer;
    final ShortBuffer indices;
    
    public Vertices(GLGraphics glGraphics, int maxVertices, int maxIndices, boolean hasColor, boolean hasTexCoords) {
        this.glGraphics = glGraphics;
        this.hasColor = hasColor;
        this.hasTexCoords = hasTexCoords;
        this.vertexSize = (2 + (hasColor?4:0) + (hasTexCoords?2:0)) * 4;
        this.tmpBuffer = new int[maxVertices * vertexSize / 4];
        
        ByteBuffer buffer = ByteBuffer.allocateDirect(maxVertices * vertexSize);
        buffer.order(ByteOrder.nativeOrder());
        vertices = buffer.asIntBuffer();
        
        if(maxIndices > 0) {
            buffer = ByteBuffer.allocateDirect(maxIndices * Short.SIZE / 8);
            buffer.order(ByteOrder.nativeOrder());
            indices = buffer.asShortBuffer();
        } else {
            indices = null;
        }            
    }
    
    public void setVertices(float[] vertices, int offset, int length) {
        this.vertices.clear();
        int len = offset + length;
        for(int i=offset, j=0; i < len; i++, j++) 
            tmpBuffer[j] = Float.floatToRawIntBits(vertices[i]);
        this.vertices.put(tmpBuffer, 0, length);
        this.vertices.flip();
    }
    
    public void setIndices(short[] indices, int offset, int length) {
        this.indices.clear();
        this.indices.put(indices, offset, length);
        this.indices.flip();
    }
    
	public void bind() {
	    GL10 gl = glGraphics.getGL();
	    
	    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	    vertices.position(0);
	    gl.glVertexPointer(2, GL10.GL_FLOAT, vertexSize, vertices);
	    
	    if(hasColor) {
	        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
	        vertices.position(2);
	        gl.glColorPointer(4, GL10.GL_FLOAT, vertexSize, vertices);
	    }
	    
	    if(hasTexCoords) {
	        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	        vertices.position(hasColor?6:2);
	        gl.glTexCoordPointer(2, GL10.GL_FLOAT, vertexSize, vertices);
	    }
	}
	
	public void draw(int primitiveType, int offset, int numVertices) {        
	    GL10 gl = glGraphics.getGL();
	    
	    if(indices!=null) {
	        indices.position(offset);
	        gl.glDrawElements(primitiveType, numVertices, GL10.GL_UNSIGNED_SHORT, indices);
	    } else {
	        gl.glDrawArrays(primitiveType, offset, numVertices);
	    }        
	}
	
	public void unbind() {
	    GL10 gl = glGraphics.getGL();
	    if(hasTexCoords)
	        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	
	    if(hasColor)
	        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}