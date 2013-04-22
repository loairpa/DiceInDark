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
		diceTexture.add(Assets.D20);

		diceAnimation = new ArrayList<Animation>();
		diceAnimation.add(Assets.D4_anim);
		diceAnimation.add(Assets.D6_anim);
		diceAnimation.add(Assets.D8_anim);
		diceAnimation.add(Assets.D10_anim);
		diceAnimation.add(Assets.D12_anim);
		diceAnimation.add(Assets.D20_anim);
		
		
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
        if(dice.currentDie<dice.dice.size()-1){
 	   switch(dice.state){
        case DiceScreen.DICE_READY:
 		   if(die.hasResult)
 			   batcher.drawSprite(die.position.x+4, die.position.y+6, FRUSTUM_WIDTH, FRUSTUM_HEIGHT, diceTexture.get(dice.currentDie).get(die.result-1));
 		   else
 			   batcher.drawSprite(die.position.x+4, die.position.y+6,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT, diceTexture.get(dice.currentDie).get(0));
 		   break;
        case DiceScreen.DICE_SHAKING:
 			 keyFrame = diceAnimation.get(dice.currentDie).getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);		 
 			 batcher.drawSprite(die.position.x+4, die.position.y+FRUSTUM_HEIGHT*die.rand.nextFloat(),FRUSTUM_WIDTH,  FRUSTUM_HEIGHT,keyFrame);
 			 break;
 		 default:
 			 keyFrame = diceAnimation.get(dice.currentDie).getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);
 			 batcher.drawSprite(die.position.x+4, die.position.y+6,FRUSTUM_WIDTH,  FRUSTUM_HEIGHT,keyFrame);
 			 break;
 			   
        }
        }else{
        	TextureRegion keyFrame2 ;
        	switch(dice.state){
            case DiceScreen.DICE_READY:
     		   if(die.hasResult && die.result<100){
     			   batcher.drawSprite(die.position.x+4, die.position.y+9, FRUSTUM_WIDTH/2, FRUSTUM_HEIGHT/2, 
     					   				Assets.D100.get((int)Math.floor(die.result/10)));
     			   if(die.result%10>0)
     			   batcher.drawSprite(die.position.x+4, die.position.y+3, FRUSTUM_WIDTH/2, FRUSTUM_HEIGHT/2, 
			   				Assets.D10.get((die.result)%10-1));
     			   else
        			   batcher.drawSprite(die.position.x+4, die.position.y+3, FRUSTUM_WIDTH/2, FRUSTUM_HEIGHT/2, 
   			   				Assets.D10.get(9));
     		   }
     		   else{
     			   batcher.drawSprite(die.position.x+4, die.position.y+9,FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2, Assets.D100.get(0));
     		   	   batcher.drawSprite(die.position.x+4, die.position.y+3,FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2, Assets.D10.get(0));
     		   }
     		   break;
            case DiceScreen.DICE_SHAKING:
            	keyFrame2 = Assets.D10_anim.getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING); 
     			 keyFrame = Assets.D100_anim.getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);		 
     			 batcher.drawSprite(die.position.x+4, die.position.y+FRUSTUM_HEIGHT*die.rand.nextFloat(),FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2,keyFrame);
     			batcher.drawSprite(die.position.x+4, die.position.y+FRUSTUM_HEIGHT*die.rand.nextFloat(),FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2,keyFrame2);
     			 break;
     		 default:
     			keyFrame2 = Assets.D10_anim.getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING); 
     			 keyFrame = Assets.D100_anim.getKeyFrames(die.rand.nextFloat(), Animation.ANIMATION_LOOPING);
     			 batcher.drawSprite(die.position.x+4, die.position.y+9,FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2,keyFrame);
      			batcher.drawSprite(die.position.x+4, die.position.y+3,FRUSTUM_WIDTH/2,  FRUSTUM_HEIGHT/2,keyFrame2);

     			 break;
        	}
        }


        
        batcher.endBatch();
        gl.glDisable(GL10.GL_BLEND);
    }


   
}
