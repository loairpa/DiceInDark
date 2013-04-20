package com.example.framework.impl;

import java.util.List;

import android.gesture.GestureOverlayView.OnGestureListener;
import android.view.MotionEvent;
import com.example.framework.Input.GestureEvent;
public interface GestureHandler extends OnGestureListener {

    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
	public List<GestureEvent> getGestureEvents();
}
