package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Mosquito {
    float x, y;
    float xSpeed, ySpeed;
    float width, height;
    Texture img;

    public Mosquito(float x, float y, float width, float height, Texture img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;

        xSpeed = 20;
        ySpeed = 20;
    }

    void checkDirections(float SCR_WIDTH, float SCR_HEIGHT) {
        if (x < 0 || x > SCR_WIDTH - width) xSpeed = -xSpeed;
        if (y < 0 || y > SCR_HEIGHT - height) ySpeed = -ySpeed;
    }

    void move() {
        x += xSpeed;
        y += ySpeed;
    }
}
