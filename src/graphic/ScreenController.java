package src.graphic;

import src.MainMenuScreen;

import java.awt.Dimension;

public class ScreenController {

	private GameScreen gameScreen;
	private MainMenuScreen mainMenuScreen;

	public ScreenController()
	{

	}

	public void create()
	{
		gameScreen = new GameScreen();
		mainMenuScreen = new MainMenuScreen();
		mainMenuScreen.setVisible(true);
	}

	public void resize(int width, int height)
	{
		if(gameScreen.isVisible() == true)
			gameScreen.setPreferredSize(new Dimension(width, height));
		else if(mainMenuScreen.isVisible() == true)
			mainMenuScreen.setPreferredSize(new Dimension(width, height));
	}

	public void dispose()
	{
		if(gameScreen.isVisible() == true)
			gameScreen.dispose();
		else if(mainMenuScreen.isVisible() == true)
			mainMenuScreen.dispose();
	}

}
