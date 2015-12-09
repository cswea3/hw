package com.craig.androidgames.hw5;

import java.util.List;

import android.graphics.Color;
import java.util.Random;


import com.craig.androidgames.framework.Game;
import com.craig.androidgames.framework.Graphics;
import com.craig.androidgames.framework.Input.TouchEvent;
import com.craig.androidgames.framework.Pixmap;
import com.craig.androidgames.framework.Screen;

/**
 * Created by craig on 12/3/2015.
 */
public class GameScreen extends Screen {
    int score = 0;
    int level = 1;
    boolean gameOver = false;
    boolean win = false;
    boolean scorePause = false;
    private float screenSpeed = 0.5f;
    private float timeSinceLastFrame = 0.0f;
    private int playerSpeed = 5;
    Character player;
    Character enemy;

    public GameScreen(com.craig.androidgames.framework.Game game) {
        super(game);
        player = new Character(Assets.player, game.getGraphics().getWidth() / 2, 10);
        player.setX((game.getGraphics().getWidth() / 2) - (player.get().getWidth() / 2));
        spawnEnemy( game);
        Assets.music.play(1);

    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        // Settings.load(game.getFileIO());

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                //Log.v("TAG", "In touch up");
                if(inBounds(event, 0, 420, 194, 85)) { // needs to insert the width and height of the button
                    // move character left
                    if(player.getX() > playerSpeed)
                        player.setX(player.getX() - playerSpeed);
                }
                if(inBounds(event, 245, 420, 194, 85)) { // needs to insert the width and height of the button
                    if(player.getX() <  g.getWidth() - (playerSpeed * 7))
                        player.setX(player.getX() + playerSpeed);
                }
                if(gameOver){
                    if((win && level == 4) || !win){
                        if(inBounds(event,(g.getWidth() / 2) - (Assets.playButton.getWidth() / 2 ), g.getHeight() / 2, Assets.playButton.getWidth(), Assets.playButton.getHeight())) {
                            reset();
                        }
                    } else if(win) {
                        if(inBounds(event,(g.getWidth() / 2) - (Assets.playButton.getWidth() / 2 ), g.getHeight() / 2, Assets.playButton.getWidth(), Assets.playButton.getHeight())){
                            win = false;
                            score = 0;
                            scorePause = false;
                            gameOver = false;

                        }
                    }
                }
            }
        }





    }

    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        timeSinceLastFrame += deltaTime;
        //if(timeSinceLastFrame > screenSpeed) {
        if(!gameOver) {
            //Resets the background every frame to prevent bleed through
            g.drawPixmap(Assets.clearBackground, 0 , 0);

            //Drawing the grass layer
            for(int x = 0; x < 500; x = x + 26) {
                g.drawPixmap(Assets.background, 0, x);
            }

            //adding the movement buttons
            g.drawPixmap(Assets.leftButton, 0, 420);
            g.drawPixmap(Assets.rightButton, 245, 420);
            g.drawPixmap(player.get(), player.getX(),player.getY());
            enemy.setY(enemy.getY() - 3 * level);
            g.drawPixmap(enemy.get(), enemy.getX(), enemy.getY());
            g.drawPixmap(Assets.score[score], 200, 350);
            g.drawPixmap(Assets.sc, 0, 370);
            if(inBounds(player, enemy)&& !scorePause) {
                if (score == 0){
                    gameOver = true;

                win = false;
                }else {
                    score--;
                    scorePause = true;
                }
            }
            if(score == 10){
                gameOver = true;
                win = true;
                level++;
            }
            if(outBounds(player, enemy)) {
                if(!scorePause) {
                    if (score <= 9) {
                        score++;
                        spawnEnemy(game);
                    }

                }else {
                    spawnEnemy(game);
                }
            }
            g.drawPixmap(Assets.score[score], 200, 350);

            timeSinceLastFrame = 0;
        }

        if(gameOver){
            if(win && level == 4){
                g.drawPixmap(Assets.wonLabel, (g.getWidth() / 2) - (Assets.wonLabel.getWidth() / 2), g.getHeight() / 2 - Assets.wonLabel.getHeight());
                g.drawPixmap(Assets.playButton, ((g.getWidth() / 2) - (Assets.playButton.getWidth() / 2)), (g.getHeight() / 2));
            } else if(win) {
                g.drawPixmap(Assets.level, 0, g.getHeight() / 2 - Assets.level.getHeight());
                g.drawPixmap(Assets.score[level], 0 + Assets.level.getWidth(), g.getHeight() / 2 - Assets.level.getHeight());
                g.drawPixmap(Assets.playButton, ((g.getWidth() / 2) - (Assets.playButton.getWidth() / 2)), (g.getHeight() / 2));
            } else {
                g.drawPixmap(Assets.playButton, ((g.getWidth() / 2) - (Assets.playButton.getWidth() / 2)), (g.getHeight() / 2));
                g.drawPixmap(Assets.lostLabel,(g.getWidth() / 2) - (Assets.lostLabel.getWidth() / 2), g.getHeight() / 2 - Assets.lostLabel.getHeight() );
            }
        }
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        return(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1);
    }

    private boolean inBounds(Character p, Character e) {
        return(p.getX() > e.getX() && p.getX() < e.getX() + e.getWidth() - 1 &&
                p.getY() > e.getY() && p.getY() < e.getY() + e.getHeight() - 1);
    }
    private boolean outBounds(Character p, Character e) {
        return(p.getY() > e.getY() + e.getHeight());
    }


    void spawnEnemy(Game game){
        Random gen = new Random();
        int rand = gen.nextInt(9);
        int x = rand * (game.getGraphics().getWidth() / 10);
        enemy = new Character(Assets.enemy, x, game.getGraphics().getHeight());
        scorePause = false;

    }
    void reset() {
        spawnEnemy(game);
        gameOver = false;
        win = false;
        score = 0;
        scorePause = false;

        level = 1;
    }
}


