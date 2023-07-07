package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

    Texture imgBackGround;
    Texture img;

    public static float SCR_WIDTH;
    public static float SCR_HEIGHT;

    Mosquito[] mosquito;

    Texture[] imges;

    OrthographicCamera camera;

    Vector3 touch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("swamp.jpg");
        camera = new OrthographicCamera();
        touch = new Vector3();

        SCR_WIDTH = Gdx.graphics.getWidth();
        SCR_HEIGHT = Gdx.graphics.getHeight();

        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        mosquito = new Mosquito[15];
        for (int i = 0; i < 15; i++) {
            mosquito[i] = new Mosquito();
        }
        imges = new Texture[]{
                new Texture("mosq0.png"),
                new Texture("mosq1.png"),
                new Texture("mosq2.png"),
                new Texture("mosq3.png"),
                new Texture("mosq4.png"),
                new Texture("mosq5.png"),
                new Texture("mosq6.png"),
                new Texture("mosq7.png"),
                new Texture("mosq8.png"),
                new Texture("mosq9.png"),
                new Texture("mosq10.png"),
        };
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        for (int i = 0; i < mosquito.length; i++) {
            batch.draw(
                    imges[mosquito[i].phase],
                    mosquito[i].x,
                    mosquito[i].y,
                    mosquito[i].width,
                    mosquito[i].height,
                    0,
                    0,
                    500,
                    500,
                    mosquito[i].isFlip(),
                    false);
            mosquito[i].move();
        }
        batch.end();

        if (Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            for (int i = mosquito.length - 1; i >= 0; i--) {
                if (mosquito[i].isAlive && mosquito[i].hit(touch.x, touch.y)) {
                    mosquito[i].hit(touch.x, touch.y);
                }
            }

        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        for (int i = 0; i < imges.length; i++) {
            imges[i].dispose();
        }
    }
}
