package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("SovietFlag.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 0);
		/*//long start = System.nanoTime();
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			public void run() {
				ScreenUtils.clear(1, 0, 0, 1);
			}
		}, 5000);
		*/

		/*try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			System.out.println("got interrupted!");
		}
		ScreenUtils.clear(1, 1, 0, 1);
		*/
		batch.begin();
		for (int i = 0; i <= 1600; i = i + 200) {

			batch.draw(img, i, 0);


		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
