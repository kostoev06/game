package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

	Texture imgBackGround;
	Texture img;

    public static float SCR_WIDTH = 1280;
    public static float SCR_HEIGHT = 720;

	Mosquito mosquito;


    @Override
    public void create() {
        batch = new SpriteBatch();
		imgBackGround = new Texture("swamp.jpg");
		img = new Texture("mosq.jpg");
        SCR_WIDTH = Gdx.graphics.getWidth();
        SCR_HEIGHT = Gdx.graphics.getHeight();
        mosquito = new Mosquito();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();
        batch.draw(mosquito.img, mosquito.x, mosquito.y, mosquito.width, mosquito.height);

        mosquito.checkDirections(SCR_WIDTH, SCR_HEIGHT);

        mosquito.move();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
