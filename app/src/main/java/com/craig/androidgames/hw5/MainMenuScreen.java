package com.craig.androidgames.hw5;

/**
 * Created by craig on 12/3/2015.
 */

import android.util.Log;

import java.util.List;

import com.craig.androidgames.framework.Game;
import com.craig.androidgames.framework.Graphics;
import com.craig.androidgames.framework.Input.TouchEvent;
import com.craig.androidgames.framework.Screen;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                Log.v("TAG", "In touch up");
                if(inBounds(event, 60,75, 194, 85)) {
                    game.setScreen(new GameScreen(game));
                }
            }
        }

    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();




        for(int x = 0; x < 500; x = x + 26) {
            g.drawPixmap(Assets.background, 0, x);
        }

        g.drawPixmap(Assets.playButton, 60, 75);
        g.drawPixmap(Assets.helpButton, 60, 150);
        g.drawPixmap(Assets.leftButton, 0, 420);
        g.drawPixmap(Assets.rightButton, 245, 420);



    }

    public void pause() {

        //Settings.save(game.getFileIO());
    }

    public void resume() {

    }

    public void dispose() {

    }
}

