package graphic;

import java.awt.Dimension;

public class ScreenController {

	private Game game;
	private GameScreen gameScreen;
	private MainMenuScreen mainMenuScreen;

	public ScreenController()
	{
	}

	public create()
	{
		gameScreen = new GameScreen();
		mainMenuScreen = new MainMenuScreen();
		mainMenuScreen.setVisible(true);
	}

	public resize(int width, int height)
	{
		if(gameScreen.isVisible() == true)
			gameScreen.setPreferredSize(new Dimension(width, height));
		else if(mainMenuScreen.isVisible() == true)
			mainMenuScreen.setPreferredSize(new Dimension(width, height));
	}

	public dispose()
	{
		if(gameScreen.isVisible() == true)
			gameScreen.dispose();
		else if(mainMenuScreen.isVisible() == true)
			mainMenuScreen.dispose();
	}

}
