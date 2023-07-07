package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Mosquito {
    float x, y;
    float vx, vy;
    float width, height;
    int phase, nPhase = 10;

    boolean isAlive = true;

    public Mosquito() {
        width = height = MathUtils.random(100, 450);
        x = SCR_WIDTH / 2 - width / 2;
        y = SCR_HEIGHT / 2 - height / 2;

        vx = MathUtils.random(-7f, 7f);
        vy = MathUtils.random(-7f, 7f);

        phase = MathUtils.random(0, nPhase - 1);
    }

    void checkDirections() {
        if (x < 0 || x > SCR_WIDTH - width) vx = -vx;
        if (y < 0 || y > SCR_HEIGHT - height) vy = -vy;
    }

    void move() {
        x += vx;
        y += vy;
        if (isAlive) {
            checkDirections();
            if (++phase == nPhase) phase = 0;
        }
    }

    boolean hit(float tx, float ty) {
        if (x < tx && tx < x + width && y < ty && ty < y + height) {
            isAlive = false;
            phase = 10;
            vx = 0;
            vy = -8;
            return true;
        }
        return false;
    }

    boolean isFlip() {
        if (vx > 0) {
            return true;
        }
        return false;
    }
}
