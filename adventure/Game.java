package adventure;

;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	WGame wg = new WGame();
	GameForm gf = new GameForm(wg);
	Story story = new Story(this, wg , gf);
	
	
	String nextchoise1,nextchoise2,nextchoise3,nextchoise4,nextchoise5,nextchoise6,nextchoise7;


    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Game();

     
     
	}

	public Game() {
		wg.createWGame(cHandler);
		story.defaultSetp();
		story.gameStory();
		gf.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			
			String yourChoice = event.getActionCommand();
			switch(yourChoice) {
			case "play": gf.showGameScreen(); break;
			
			
			case "ATTACK":story.selectOpsion(nextchoise1); break;
			case "USE_POTION": story.selectOpsion(nextchoise2); break;
			case "RUN": story.selectOpsion(nextchoise3);break;
			case "EXIT":story.selectOpsion(nextchoise4); break;
			case "buysword": story.selectOpsion(nextchoise5);break;
			case "buyarmor":story.selectOpsion(nextchoise6); break;
			case "buypotion": story.selectOpsion(nextchoise7);break;
			
			
			
			}
		}
		
	}
	
	
	

  

}
	
	

