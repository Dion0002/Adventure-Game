package adventure;


import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;


import javax.swing.JOptionPane;

/**
 * Story class contains all the action of the game
 */
public class Story {
	
	Game game;
	WGame wg;
	GameForm gf;
	Player player = new Player();
	Pouch pouch = new Pouch();
	Enemy villain = new Enemy();
	Random rand = new Random();
	
	
	

    /** The delay used for display messages. */
    public static final int MAXIMUM_GOLD_DROP = 30;
    
    /** The coin / health penalty for running away,  */
    public static final int PENALTY_FOR_RUNNING = 5;
    
    /** The random number generator of this game. */
    public static final Random RANDOM = new Random();



    
    int armourDropChance = 10;
    int healthPotionDropChance = 50;
    int swordDropChance = 5;

	 protected boolean running = true;
	 protected boolean ranAway = false;
	   
	int itemIndex;
	
	
	int sword = 100;
	int armour = 50;
	int potion = 10;
	
	
	public  Story(Game g,WGame welgame,GameForm gamfor) {
		
		game = g;
		wg = welgame;
		gf = gamfor;

	}
	
	public void defaultSetp() {
		wg.hpnumberLabel.setText(String.valueOf(player.health));
		wg.psLabel.setText(String.valueOf(player.potionsRemaining));
		wg.clabel.setText(String.valueOf(player.getPouch().coins));
		wg.ekLabel.setText(String.valueOf(player.enemiesKilled));
	}

		

	public void selectOpsion(String nextChoise) {
		
		
		
		switch(nextChoise) {
		case "attack": attack();break;
		
		case "usepotion": usepotion();break;
		case "run": run();break;
		case  "exit": exit();break;
		case "buysword": buysword(); break;
		case "buyarmor": buyarmor();break;
		case  "buypotion": buypotion();break;
		
		
		
		}
	        }
	       
	

	public void gameStory() {
		wg.mainTextArea.setText("A " + villain.name() + " appeared" + " HP : "+ villain.health() + "\n What do you want to do?");
		game.nextchoise1 ="attack";
		game.nextchoise2 ="usepotion";
		game.nextchoise3 ="run";
		game.nextchoise4 ="exit";
		game.nextchoise5 ="buysword";
		game.nextchoise6 ="buyarmor";
		game.nextchoise7 ="buypotion";

			
	}
	
	public void attack() {
		
		
	
		if(villain.health() > 0) {
             
		 int playerAttack = player.attack();
         int enemyAttack = villain.attack();

         wg.actionTextArea.setText("You took " + enemyAttack + " damage.\nYou took " + enemyAttack + " damage.");
         

         villain.takeDamage(playerAttack);
         player.takeDamage(enemyAttack);
         gameStory();
         defaultSetp();
		 
         if (player.health() <= 0)
         {
			  Math.max(0,player.health());

			int res = JOptionPane.showConfirmDialog(null, "nUh oh! You have died!\n Do you wan't to play again ","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(res == JOptionPane.YES_OPTION) { 
			
			player.reset();
			villain.reset();
		    gameStory();
			defaultSetp();
			wg.actionTextArea.setText("");
			
			}
			if(res == JOptionPane.NO_OPTION) {
   			 exit();
			}
		}

         }
	    if(villain.health()<=0)
	    {
	    	enemydead();
	    }
             
        
         if (player.hasSword())
         {
             System.out.println("\n# adv.Sword type: " + player.getSword().name() + " | hitpoints: " + player.getSword().hitpoints() + "  #");
      
          
         } // end of if (player.hasSword())
         

         // adv.Armour
         if (player.hasArmour())
         {
             System.out.println("\n# adv.Armour type: " + player.getArmour().name() + " | adv.Armour hitpoints: " + player.getArmour().hitpoints() + "  #");
             player.armour.useArmour();
         } // end of if (player.hasArmour())
   	
			
         
         
         
         	game.nextchoise1 ="attack";
			game.nextchoise2 ="usepotion";
			game.nextchoise3 ="run";
			game.nextchoise4 ="exit";
			game.nextchoise5 ="buysword";
			game.nextchoise6 ="buyarmor";
			game.nextchoise7 ="buypotion"; 
	 
	}
	public void enemydead() {
 if(villain.health() <= 0) {
        
        	 
        	 Pouch pouch = player.getPouch();
        	 player.increaseEnemiesKilled();
        	 pouch.addCoins(RANDOM.nextInt(MAXIMUM_GOLD_DROP));
        	 
        	 String[] sword = {"wood", "metal", "gold"};
        	 String[] armor= {"leather","iron","gold"};
        	
        	 

             if (RANDOM.nextInt(100) < swordDropChance)
             {
                 if (player.hasSword())
                 {
                     System.out.println("\nThe " + villain.name() + " dropped a sword, but you already have one.");
                    
                 } // end of if (player.hasSword())
                 else
                 {
                	 
                     player.addSword(sword[rand.nextInt(3)]);
                     System.out.println("\nThe " + villain.name() + " dropped a " + player.getSword().name() + ".\nYour attack damage has now increased by " + player.getSword().damageIncrease() + ".");
                	
                	 } // end of if (player.hasSword())
                          
             } // end of if (RANDOM.nextInt(100) < swordDropChance)
        	 
             else if (RANDOM.nextInt(100) < armourDropChance)
             {
                 if (player.hasArmour())
                 {
                     System.out.println("\nThe " + villain.name() + " dropped some armour, but you already have some.");
                 
                 } // end of if (player.hasArmour())
                 else
                 {
                     player.addArmour(armor[rand.nextInt(3)]);
                     System.out.println("\nThe " + villain.name() + " dropped " + player.getArmour().name() + ".\nYour damage taken has now decreased by " + player.getArmour().damageBlocked() + ".");
                 } // end of if (player.hasArmour())
                 
             } // end of else if (RANDOM.nextInt(100) < armourDropChance)
        	 
        	 
             
             
             else if (RANDOM.nextInt(100) < healthPotionDropChance)
             {
                 player.addPotions(1);
                 System.out.println("\nThe " + villain.name() + " dropped a health potion.");
                 
             } // end of else if (RANDOM.nextInt(100) < healthPotionDropChance)  

        	 
	
	        	  
	        	  villain.reset();
	  		      gameStory();
	        		defaultSetp();
	   			
	   			  	
	   			 
	        	
	          
	      
			}
         
		
		
	}

	public void usepotion() {
		 if (player.health() > player.FULL_HEALTH - player.POTION_HEALING) 
         {

			 JOptionPane.showMessageDialog(null, "You are healthy, and do not need a potion.","Game Over",JOptionPane.PLAIN_MESSAGE);
            return;
            
         } // end of if (player.health() > player.FULL_HEALTH - player.POTION_HEALING)
         
         player.usePotion();
         defaultSetp();
     	game.nextchoise1 ="attack";
		game.nextchoise2 ="usepotion";
		game.nextchoise3 ="run";
		game.nextchoise4 ="exit";
		game.nextchoise5 ="buysword";
		game.nextchoise6 ="buyarmor";
		game.nextchoise7 ="buypotion";
		
	}
	public void run	() {
		Pouch pouch = player.getPouch();
		

	    if (player.getPouch().getCoins() > PENALTY_FOR_RUNNING)
        {

			 JOptionPane.showMessageDialog(null, + PENALTY_FOR_RUNNING + " coins were stolen by the  "+villain.name()+" ","Game Over",JOptionPane.PLAIN_MESSAGE);
		         
            pouch.removeCoins(PENALTY_FOR_RUNNING);
            player.getPouch();
            
            villain.reset();
            gameStory();
			defaultSetp();
         
        }// end of if (player.getPouch().getCoins() > PENALTY_FOR_RUNNING)
        /* adv.Player does not have enough coins. Take away health instead of coins. */
        else
        {
        	

			 JOptionPane.showMessageDialog(null," The enemy did " + PENALTY_FOR_RUNNING + " damage before you managed to escape" ,"Game Over",JOptionPane.PLAIN_MESSAGE);
		   
            player.takeDamage(PENALTY_FOR_RUNNING);
            if(player.health()<=0) {

    			int resp = JOptionPane.showConfirmDialog(null, "nUh oh! You have died!\n Do you wan't to play again ","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    			if(resp == JOptionPane.YES_OPTION) { 
    			
    			player.reset();
    			villain.reset();
    			
    			defaultSetp();
            	
            }
    			if(resp == JOptionPane.NO_OPTION) {
    			 exit();
    			
            }
    			
        } 
            
            
            villain.reset();  
       
            gameStory();

        defaultSetp();
        
        
    	game.nextchoise1 ="attack";
		game.nextchoise2 ="usepotion";
		game.nextchoise3 ="run";
		game.nextchoise4 ="exit";
		game.nextchoise5 ="buysword";
		game.nextchoise6 ="buyarmor";
		game.nextchoise7 ="buypotion";
	}
	}
	
   public void exit() {
	  
	   String playername = JOptionPane.showInputDialog("Enter your name : ");
	   player.name=playername;
	   
       try {
		FileWriter writer = new FileWriter("C:\\Users\\berbe\\eclipse-workspace\\Adventure Quests\\src\\adventure\\leaderboards",true);

		writer.write(player.getData());
		writer.write(System.getProperty("line.separator"));
		writer.close();
       } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
	
	
	   System.exit(0);
		
	}
   
   
   
   
   


   
   public void buysword() {
	   


	   if (player.getPouch().getCoins() < 100)
       {
			 JOptionPane.showMessageDialog(null,"You cannot afford this item Please purchase an afforable item." ,"Store",JOptionPane.PLAIN_MESSAGE);
				

         
           

           /* Return so that the item is not purchased later. */
           return;
       } // end of if (player.getPouch().getCoins() > PRICE[itemIndex])
	   player.addSword("wood");
	   /* Pay for the item that was bought */
       player.getPouch().removeCoins(sword);
       
       /* Display the item purchased and price. */
       player.getPouch();
       
		 JOptionPane.showMessageDialog(null,"You purchased: sword   for " + sword + " coins " ,"Store",JOptionPane.PLAIN_MESSAGE);

       
       defaultSetp();
       
   	game.nextchoise1 ="attack";
	game.nextchoise2 ="usepotion";
	game.nextchoise3 ="run";
	game.nextchoise4 ="exit";
	game.nextchoise5 ="buysword";
	game.nextchoise6 ="buyarmor";
	game.nextchoise7 ="buypotion";

   
	   
   }
   
	
 public void buyarmor() {
	
	 if (player.getPouch().getCoins() < 50)
     {
		 JOptionPane.showMessageDialog(null,"You cannot afford this item Please purchase an afforable item." ,"Game Over",JOptionPane.PLAIN_MESSAGE);
       
         

      
         
         /* Return so that the item is not purchased later. */
         return;
     } // end of if (player.getPouch().getCoins() > PRICE[itemIndex])
	 
	 player.addArmour("leather");
	 player.getPouch().removeCoins(armour);
      
      /* Display the item purchased and price. */
	   player.getPouch();
	   
	   JOptionPane.showMessageDialog(null,"You purchased: armour  for " + armour + " coins " ,"Store",JOptionPane.PLAIN_MESSAGE);
     
      defaultSetp();
      
  	game.nextchoise1 ="attack";
	game.nextchoise2 ="usepotion";
	game.nextchoise3 ="run";
	game.nextchoise4 ="exit";
	game.nextchoise5 ="buysword";
	game.nextchoise6 ="buyarmor";
	game.nextchoise7 ="buypotion";
	 }

 
 public void buypotion() {
	 
	 if (player.getPouch().getCoins() < potion)
     {
		 JOptionPane.showMessageDialog(null,"You cannot afford this item" ,"Game Over",JOptionPane.PLAIN_MESSAGE);
       
         

      
         
         /* Return so that the item is not purchased later. */
         return;
     } // end of if (player.getPouch().getCoins() > PRICE[itemIndex])
	 player.addPotions(1);
	  /* Pay for the item that was bought */
     player.getPouch().removeCoins(potion);
     
     /* Display the item purchased and price. */
     player.getPouch();
     JOptionPane.showMessageDialog(null,"You purchased: potion for " + potion + " coins " ,"Store",JOptionPane.PLAIN_MESSAGE);
   
	   
     
     defaultSetp();
     
 	game.nextchoise1 ="attack";
	game.nextchoise2 ="usepotion";
	game.nextchoise3 ="run";
	game.nextchoise4 ="exit";
	game.nextchoise5 ="buysword";
	game.nextchoise6 ="buyarmor";
	game.nextchoise7 ="buypotion";
     
 }
 
 
 
 
	
	
	
}
