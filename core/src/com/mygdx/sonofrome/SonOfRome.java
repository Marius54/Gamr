package com.mygdx.sonofrome;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.sonofrome.Screens.PlayScreen;

public class SonOfRome extends Game {
	public SpriteBatch batch;
	public static SonOfRome instance;

	private SonOfRome(){
	}

	public static SonOfRome getInstance(){
	    if(instance == null){
	        instance = new SonOfRome();
        }
        return instance;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(PlayScreen.getInstance());
	}

	@Override
	public void render () {
		super.render();
	}
}
