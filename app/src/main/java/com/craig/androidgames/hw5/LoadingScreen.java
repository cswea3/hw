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
        Assets.player = g.newPixmap("Character.png", Graphics.PixmapFormat.RGB565);
        Assets.enemy = g.newPixmap("EnemyBug.png", Graphics.PixmapFormat.RGB565);
        Assets.score[0] = g.newPixmap("0.png", Graphics.PixmapFormat.RGB565);
        Assets.score[1] = g.newPixmap("1.png", Graphics.PixmapFormat.RGB565);
        Assets.score[2] = g.newPixmap("2.png", Graphics.PixmapFormat.RGB565);
        Assets.score[3] = g.newPixmap("3.png", Graphics.PixmapFormat.RGB565);
        Assets.score[4] = g.newPixmap("4.png", Graphics.PixmapFormat.RGB565);
        Assets.score[5] = g.newPixmap("5.png", Graphics.PixmapFormat.RGB565);
        Assets.score[6] = g.newPixmap("6.png", Graphics.PixmapFormat.RGB565);
        Assets.score[7] = g.newPixmap("7.png", Graphics.PixmapFormat.RGB565);
        Assets.score[8] = g.newPixmap("8.png", Graphics.PixmapFormat.RGB565);
        Assets.score[9] = g.newPixmap("9.png", Graphics.PixmapFormat.RGB565);
        Assets.score[10] = g.newPixmap("10.png", Graphics.PixmapFormat.RGB565);
        Assets.sc = g.newPixmap("sc.png", Graphics.PixmapFormat.RGB565);
        Assets.wonLabel = g.newPixmap("win.png", Graphics.PixmapFormat.RGB565);
        Assets.lostLabel = g.newPixmap("lose.png", Graphics.PixmapFormat.RGB565);
        Assets.level = g.newPixmap("level.png", Graphics.PixmapFormat.RGB565);
        Assets.music = game.getAudio().newSound("musBG.mp3");


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
