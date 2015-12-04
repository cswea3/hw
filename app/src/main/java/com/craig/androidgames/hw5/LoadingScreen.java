package com.craig.androidgames.hw5;

import com.craig.androidgames.framework.*;

/**
 * Created by craig on 12/3/2015.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(com.craig.androidgames.framework.Game game) {
        super(game);
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("GrassLine.png", Graphics.PixmapFormat.RGB565);
        Assets.clearBackground = g.newPixmap("ClearBackground.png", Graphics.PixmapFormat.RGB565);
        Assets.character = g.newPixmap("Character.png", Graphics.PixmapFormat.RGB565);
        Assets.playButton = g.newPixmap("Play.png", Graphics.PixmapFormat.RGB565);
        Assets.helpButton = g.newPixmap("Help.png", Graphics.PixmapFormat.RGB565);
        Assets.leftButton = g.newPixmap("Left.png", Graphics.PixmapFormat.RGB565);
        Assets.rightButton = g.newPixmap("Right.png", Graphics.PixmapFormat.RGB565);

       // Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    public void present(float deltaTime) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
