package com.craig.androidgames.hw5;

import com.craig.androidgames.framework.*;

/**
 * Created by craig on 12/3/2015.
 */
public class GameScreen extends Screen {
    World world;

    public GameScreen(com.craig.androidgames.framework.Game game) {
        super(game);
        world = new World();
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        // Settings.load(game.getFileIO());

    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();


        g.drawPixmap(Assets.clearBackground, 0 , 0);

        for(int x = 0; x < 500; x = x + 26) {
            g.drawPixmap(Assets.background, 0, x);
        }
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}


