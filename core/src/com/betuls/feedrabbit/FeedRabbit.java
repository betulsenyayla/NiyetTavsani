
package com.betuls.feedrabbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.Random;

public class FeedRabbit extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture rabbit;
	Texture curuk;
	Texture curuk2;
	Texture curuk3;
	Texture kagit;
	Texture normalHavuc;
	float rabbitX = 0;
	float rabbitY = 0;
	int gameState = 0;
	float velocity = 0;
	float gravity = 0.5f;
	float curukVelocity = 3;
	Random random;
	int score;
	int scoredHavuc;
	BitmapFont font;
	BitmapFont font2;
	int durdur = 0;
	String falMetni = new String();


	Circle rabbitCircle;

	ShapeRenderer shapeRenderer;

	int numberOfCuruk = 3;
	float [] curukX = new float[numberOfCuruk];
	float [] curukOffset = new float[numberOfCuruk];
	float [] curukOffset2 = new float[numberOfCuruk];
	float []curukOffset3 = new float[numberOfCuruk];
	float distance = 0;

	Circle [] curukCircles;
	Circle [] curukCircles2;
	Circle [] curukCircles3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		rabbit = new Texture("rabbit.png");
		curuk = new Texture("curukHavuc.png");
		curuk2 = new Texture("curukHavuc.png");
		curuk3 = new Texture("curukHavuc.png");
		kagit = new Texture("kagit.png");
		normalHavuc = new Texture("normalHavuc.png");


		distance = Gdx.graphics.getWidth() / 2;
		random = new Random();

		rabbitX = Gdx.graphics.getWidth()/20;
		rabbitY = Gdx.graphics.getHeight()/8;

		shapeRenderer = new ShapeRenderer();

		rabbitCircle = new Circle();
		curukCircles = new Circle[numberOfCuruk];
		curukCircles2 = new Circle[numberOfCuruk];
		curukCircles3 = new Circle[numberOfCuruk];

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4);

		font2 = new BitmapFont();
		font2.setColor(Color.BLACK);
		font2.getData().setScale(5);

		for(int i=0; i<numberOfCuruk; i++)
		{
			curukOffset[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
			curukOffset2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
			curukOffset3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

			curukX[i] = Gdx.graphics.getWidth() - curuk.getWidth()/2 + i*distance;

			curukCircles[i] = new Circle();
			curukCircles2[i] = new Circle();
			curukCircles3[i] = new Circle();

		}

	}

	@Override
	public void render () {

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if(gameState == 1)
		{
			if(curukX[scoredHavuc] < Gdx.graphics.getWidth()/20)
			{
				score++;

				if(scoredHavuc < numberOfCuruk-1)
				{
					scoredHavuc++;
				}else{
					scoredHavuc = 0;
				}

			}

			if (Gdx.input.justTouched()) {
				velocity = -13;
			}

			for(int i=0; i<numberOfCuruk; i++)
			{
				if(curukX[i] < 0){
					curukX[i] = curukX[i] + numberOfCuruk * distance;

					curukOffset[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					curukOffset2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					curukOffset3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
				}
				else{
					curukX[i] = curukX[i] - curukVelocity;
				}

				batch.draw(curuk, curukX[i], Gdx.graphics.getHeight()/2 + curukOffset[i], Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4 );
				batch.draw(curuk2, curukX[i], Gdx.graphics.getHeight()/2 + curukOffset2[i], Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4 );
				batch.draw(curuk3, curukX[i], Gdx.graphics.getHeight()/2 + curukOffset3[i], Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4 );

				curukCircles[i] = new Circle(curukX[i]+ Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/2 + curukOffset[i] + Gdx.graphics.getHeight()/8, Gdx.graphics.getWidth()/12 );
				curukCircles2[i] = new Circle(curukX[i]+ Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/2 + curukOffset2[i] + Gdx.graphics.getHeight()/8, Gdx.graphics.getWidth()/12 );
				curukCircles3[i] = new Circle(curukX[i]+ Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/2 + curukOffset3[i] + Gdx.graphics.getHeight()/8, Gdx.graphics.getWidth()/12 );

			}


			if(rabbitY >0 || velocity<0)
			{
				velocity= velocity + gravity;
				rabbitY = rabbitY - velocity;
			}

		} else if(gameState == 0){
			if (Gdx.input.justTouched()) {
				gameState = 1;
			}

		}
		else if(gameState == 2)
		{
			if (Gdx.input.justTouched()) {
				gameState = 1;

				rabbitY = Gdx.graphics.getHeight()/8;

				for(int i=0; i<numberOfCuruk; i++)
				{
					curukOffset[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					curukOffset2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					curukOffset3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

					curukX[i] = Gdx.graphics.getWidth() - curuk.getWidth()/2 + i*distance;

					curukCircles[i] = new Circle();
					curukCircles2[i] = new Circle();
					curukCircles3[i] = new Circle();

				}

				velocity = 0;
				scoredHavuc = 0;
				score = 0;
			}
		}

		batch.draw(rabbit, rabbitX , rabbitY , Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/4  );
		font.draw(batch, String.valueOf(score), 100, 200);
		batch.end();
		rabbitCircle.set(rabbitX + Gdx.graphics.getWidth()/12 , rabbitY + Gdx.graphics.getHeight()/8 , Gdx.graphics.getWidth()/12);

		fallar fal = new fallar();

		for(int i=0; i<numberOfCuruk; i++)
		{

			if(Intersector.overlaps(rabbitCircle, curukCircles[i]) || Intersector.overlaps(rabbitCircle, curukCircles2[i]) || Intersector.overlaps(rabbitCircle, curukCircles3[i]))
			{
				if(score>=3){
					gameState = 2;

					if(durdur == 0) {
						falMetni = fal.falCek();
						durdur ++;
					}

					batch.begin();

					batch.draw(kagit, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
					font2.draw(batch, falMetni, Gdx.graphics.getWidth()/4, 700);

					batch.end();

				}else{
					gameState = 2;
				}

			}
		}
	}
	@Override
	public void dispose ()
	{

	}
}
