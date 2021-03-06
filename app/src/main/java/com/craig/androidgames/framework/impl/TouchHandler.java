package com.craig.androidgames.framework.impl;
/**
 * Created by craig on 11/30/2015.
 */
import java.util.List;

import android.view.View.OnTouchListener;

import com.craig.androidgames.framework.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
    public List<TouchEvent> getTouchEvents();
}
