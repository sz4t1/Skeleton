/**
 * NEM HISZEM HOGY ERRE AZ OSZTáLYRA SZüKSéG VAN
 */
import java.awt.Dimension;

public class ScreenController {

	private GameScreen gameScreen;
	private MainMenuScreen mainMenuScreen;

	public ScreenController()
	{

	}

	public void create()
	{
		gameScreen = new GameScreen( null);	//A PARAMéTEREK CSAK AZéRT, HOGY NE SRJON A FORDíTó
		mainMenuScreen = new MainMenuScreen(null);	//------||--------
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
