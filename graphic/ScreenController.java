package graphic;

import java.awt.Dimension;

public class ScreenController {

	private Game game;
	private GameScreen gameScreen;
	private MainMenuScreen mainMenuScreen;

	public ScreenController()
	{
		gameScreen = new GameScreen();
		mainMenuScreen = new MainMenuScreen(this);
		mainMenuScreen.setVisible(true);

        mainMenuScreen.getPlayButton().addActionListener(new MenuButtonListener());

	}

	public create(Integer playerNumber)
	{
		game = new Game(playerNumber);
        game.StartGame();
		gameScreen.MapRender(game);
		gameScreen.setVisible(true);
		mainMenuScreen.dispose();

        gameScreen.getAttackButton().addActionListener(new ButtonListener());
        gameScreen.getMoveButton().addActionListener(new ButtonListener());
        gameScreen.getCraftButton().addActionListener(new ButtonListener());
        gameScreen.getScanButton().addActionListener(new ButtonListener());
        gameScreen.getPickUpButton().addActionListener(new ButtonListener());
        gameScreen.getDropButton().addActionListener(new ButtonListener());
        gameScreen.getUseVirusButton().addActionListener(new ButtonListener());
        gameScreen.getStealButton().addActionListener(new ButtonListener());
  
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

	public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            
            switch (choice) {

                case "Attack":
                    AttackFrame attackFrame = new AttackFrame();
                    attackFrame.setVisible(true);
                    attackFrame.getOkButton().addActionListener(new OkButtonListener());
                    attackFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

                case "Move":
                    //todo
                    //virologist.Move(field);
                    break;
                case "Craft":
                    CraftFrame craftFrame = new CraftFrame();
                    craftFrame.setVisible(true);
                    craftFrame.getOkButton().addActionListener(new OkButtonListener());
                    craftFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

                case "Scan":
                    //todo
                    //virologist.ScanCode();
                    break;

                case "Pickup":
                    PickUpFrame pickupFrame = new PickUpFrame();
                    pickupFrame.setVisible(true);
                    pickupFrame.getOkButton().addActionListener(new OkButtonListener());
                    pickupFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

                case "Drop":
                    DropFrame dropFrame = new DropFrame();
                    dropFrame.setVisible(true);
                    dropFrame.getOkButton().addActionListener(new OkButtonListener());
                    dropFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

                case "Use Virus":
                    UserVirusFrame usevirusFrame = new UseVirusFrame();
                    usevirusFrame.setVisible(true);
                    usevirusFrame.getOkButton().addActionListener(new OkButtonListener());
                    uservirusFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

                case "Steal":
                    StealFrame stealFrame = new StealFrame();
                    stealFrame.setVisible(true);
                    stealFrame.getOkButton().addActionListener(new OkButtonListener());
                    stealFrame.getCancelButton().addActionListener(new CancelButtonListener());
                    break;

            }
        }
    }

    public class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();

            switch (choice) {

                case "AttackOk":
                    //todo
                    //virologist.Attack(virus, targetVirologist);
                    break;

                case "CraftOk":
                    //todo
                    //virologist.CraftVirus(recipe);
                    break;

                case "PickUpOk":
                    //todo
                    //virologist.AddMaterial(material);
                    //virologist.AddEquipment(equipment);
                    break;

                case "DropOk":
                    //todo
                    //virologist.RemoveEquipment(equipment);
                    break;

                case "UseVirusOk":
                    //todo
                    //virologist.UseVirusOnSelf(virus);
                    break;

                case "StealOk":
                    //todo
                    //virologist.StealEquipment(targetVirologist, equipment);
                    //virologist.StealMaterial(targetVirologist, material)
                    break;
            }
        }
    }

    public class MenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Play")) {
                create(mainMenuScreen.getPlayerNumber());
            }
            else if(choice.equals("Help")) {
                
            }
        }
    }

}
