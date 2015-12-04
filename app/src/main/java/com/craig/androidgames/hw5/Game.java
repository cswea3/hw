package com.craig.androidgames.hw5;

import com.craig.androidgames.framework.Screen;
import com.craig.androidgames.framework.impl.AndroidGame;

public class Game extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
} 
