package com.example.framework.impl;

import com.example.framework.Game;
import com.example.framework.Screen;

public abstract class GLScreen extends Screen {
	protected final GLGraphics glGraphics;
	protected final GLGame glGame;
	
	public GLScreen(Game game){
		super(game);
		glGame = (GLGame)game;
		glGraphics = glGame.getGLGraphics();
	}

}
