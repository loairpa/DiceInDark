package com.example.diceindark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.example.framework.gl.Animation;
import com.example.framework.gl.Camera2D;
import com.example.framework.gl.SpriteBatcher;
import com.example.framework.gl.TextureRegion;
import com.example.framework.impl.GLGraphics;

public class DiceRender {
	
	static final float FRUSTUM_WIDTH = 10;
	static final float FRUSTUM_HEIGHT = 15;
	GLGraphics glGraphics;
	DiceScreen dice;
	Camera2D cam;
	SpriteBatcher batcher;
	List<List<TextureRegion>> diceTexture;
	List<Animation> diceAnimation;
	
	public DiceRender(GLGraphics glGraphics, SpriteBatcher batcher, DiceScreen dice){
		this.glGraphics= glGraphics;
		this.dice=dice;
		this.cam= new Camera2D(glGraphics, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.batcher=batcher;
		diceTexture = new ArrayList<List<TextureRegion>>();
		diceTexture.add(Assets.D4);
		diceTexture.add(Assets.D6);
		diceTexture.add(Assets.D8);
		diceTexture.add(Assets.D10);
		diceTexture.add(Assets.D12);

		diceAnimation = new ArrayList<Animation>();
		diceAnimation.add(Assets.D4_anim);
		diceAnimation.add(Assets.D6_anim);
		diceAnimation.add(Assets.D8_anim);
		diceAnimation.add(Assets.D10_anim);
		diceAnimation.add(Assets.D12_anim);
		
		
	}

	public void render(){
		cam.setViewportAndMatrices();
		
		renderDice();
	}
	


    public void renderDice() {

        GL10 gl = glGraphics.getGL();
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
        
        batcher.beginBatch(Assets.items);
        Die die = dice.dice.get(dice.currentDie);
        TextureRegion keyFrame;
        if(dice.currentDie<5){
 	   switch(dice.state){
        case DiceScreen.DICE_READY:
 		   if(die.hasResult)
 			   batcher.drawSprite(die.position.x+4, die.position.y+7, FRUSTUM_WIDTH, FRUSTUM_HEIGHT, diceTexture.get(dice.currentDie).get(die.result-1));
 		   else
 			   batcher.drawSprite(die.position.x+4, die.position.y+7,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT, diceTexture.get(dice.currentDie).get(0));
 		   break;
        case DiceScreen.DICE_SHAKING:
 			 keyFrame = diceAnimation.get(dice.currentDie).getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);		 
 			 batcher.drawSprite(die.position.x+4, die.position.y+FRUSTUM_HEIGHT*die.rand.nextFloat(),FRUSTUM_WIDTH,  FRUSTUM_HEIGHT,keyFrame);
 			 break;
 		 default:
 			 keyFrame = diceAnimation.get(dice.currentDie).getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);
 			 batcher.drawSprite(die.position.x+4, die.position.y+7,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT,keyFrame);
 			 break;
 			   
        }
        }else
        	batcher.drawSprite(die.position.x+4, die.position.y+7,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT, Assets.D4.get(0));
       /* switch(die.sides){
        case 4:
        	renderD4(die);
        	break;
        case 6:
        	renderD6(die);
        	break;
        default:
        	batcher.drawSprite(die.position.x+4, die.position.y+7,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT, Assets.D4.get(0));
        	break;
        	
        }*/
        
        batcher.endBatch();
        gl.glDisable(GL10.GL_BLEND);
    }


   
}
