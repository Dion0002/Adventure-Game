package adventure;


public class GameForm {
	WGame wg;

public GameForm(WGame welcgame) {
	wg = welcgame;
	
}
	
public void showTitleScreen() {
  wg.titleNamePanel.setVisible(true);
  wg.startButtonPanel.setVisible(true);


  
  wg.mainTextPanel.setVisible(false);
  wg.actionPanel.setVisible(false);

  wg.choiceButtonPanel.setVisible(false);
  wg.playerPanel.setVisible(false);
  wg.storePanel.setVisible(false);
  
}

public void showGameScreen() {
	
	  wg.titleNamePanel.setVisible(false);
	  wg.startButtonPanel.setVisible(false);
	  

	 
	  wg.mainTextPanel.setVisible(true);
	  wg.actionPanel.setVisible(true);

	  wg.choiceButtonPanel.setVisible(true);
	  wg.playerPanel.setVisible(true);
	  wg.storePanel.setVisible(true);
}



}