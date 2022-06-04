package adventure;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;


/**
 * The main character in this game.
 */
public class Player
{
	
    /* Class fields */

    /** Default number of potions of this player. */
    public static final int DEFAULT_NUMBER_OF_POTIONS = 3;


    /** Random number generator for this player. */
    public static Random RANDOM = new Random();

    /** The amount of HP one potion heals. */
    public static final int POTION_HEALING = 30;

    /** Maximum health of this player. */
    public static final int FULL_HEALTH = 100;

    /** The maximum attack damage of this player. */
    public static final int MAXIMUM_ATTACK_DAMAGE = 25;
    
    /** The default name given to a player. */
    public static final String NO_NAME = "";


    /* instance fields */
    protected Armour armour;
    protected int attackDamage;
    protected int enemiesKilled;
    protected boolean hasSword;
    protected boolean hasArmour;
    protected int health;
    protected Pouch pouch;
    protected String name;
    protected int potionsRemaining;
    protected Sword sword;

    /**
     * Constructs a new adv.Player.
     */
    public Player()
    {
    	name = NO_NAME;
        hasSword = false;
        hasArmour = false;
        health = FULL_HEALTH;
        potionsRemaining = DEFAULT_NUMBER_OF_POTIONS;
        enemiesKilled = 0;
        sword = new Sword("knife");
        armour = new Armour("clothes");
        pouch = new Pouch();
    } // end of constructor Player()

    /* Accessors */
    /**
     * Returns the name of this player.
     * 
     * @return the name of this player
     */
    public String getName()
    {
        return name;
    } // end of method setName(String name)

    /**
     * Returns the health of this player.
     * 
     * @return the health of this player
     */
    public int health()
    {
        return health;
    } // end of method health()

    /**
     * Returns the enemies killed of this player.
     * 
     * @return enemiesKilled
     */
    public int enemiesKilled()
    {
        return enemiesKilled;
    } // end of method enemiesKilled()

    /**
     * Returns the number of potions this player has.
     * 
     * @return the number of potions this player has
     */
    public int getPotions()
    {
        return potionsRemaining;
    } // end of method getPotions()

    /**
     * Returns the sword of this player.
     * 
     * @return the sword of this player
     */
    public Sword getSword()
    {
        return sword;
    } // end of method getSword()

    /**
     * Returns the armour of this player.
     * 
     * @return the armour of this player
     */
    public Armour getArmour()
    {
        return armour;
    } // end of method getSword()
    
    /**
     * Returns the pouch of this player.
     * 
     * @return the pouch of this player
     */
    public Pouch getPouch()
    {
        return pouch;
    } // end of method getPouch()

    /**
     * Returns whether this player has a sword.
     * 
     * @return <code>true</code> if this player has a sword, otherwise <code>false</code>
     */
    public boolean hasSword()
    {
        return hasSword;
    } // end of method hasSword()

    /**
     * Returns whether this player has armour.
     * 
     * @return <code>true</code> if this player has armour, otherwise <code>false</code>
     */
    public boolean hasArmour()
    {
        return hasArmour;
    } // end of method hasArmour()

    /* Mutators */
    /**
     * Sets the number of enemies killed by this player. Used for importing saved data.
     * 
     * @param enemiesKilled the number of enemies killed by this player
     */
    public void setEnemiesKilled(int enemiesKilled)
    {
        this.enemiesKilled = enemiesKilled;
    } // end of method setName(String name)    

    /**
     * Sets the number of health points of this player.
     * 
     * @param healthPoints the number of health points to give this player
     */
    public void setHealth(int healthPoints)
    {
        if (healthPoints > 0 && healthPoints <= FULL_HEALTH)
        {
            health = healthPoints;
        } // end of if (healthPoints > 0)
    } // end of method setHealthPoint(int healthPoints)

    /**
     * Sets the name of this player.
     * 
     * @param name the new name of this player
     */
    public void setName(String name)
    {
        this.name = name;
    } // end of method setName(String name)   

    /**
     * Sets the  of this player.
     * 
     * @param potions the set of nummber potion for the player
     */
    public void setNumberOfPotions(int potions)
    {
    
        if (potions >= 0)
        {
            potionsRemaining = potions;
        } // end of if (potions >= 0)
       
        	
        	
        
    } // end of method setName(String name)    


    /* Methods that affect the health of this player */
    /**
     * Returns damage dealt by this player, accounting for their sword.
     * 
     * @return the damage done by this player
     */
    public int attack()
    {
    	
        if (hasSword)
        {
            /*Player has a sword, use it to deal more damage. */
            sword.useSword();

            
          
            /* Check the hitpoint status of the sword. */
            if (sword.hitpoints() <= 0)
            {

                System.out.println("\nYour " + sword.name() + " broke.");
                hasSword = false;

                } // end of catch (InterruptedException exception)
                
            /* Increase the base attack damage by the sword's additional damage. */
            return RANDOM.nextInt(MAXIMUM_ATTACK_DAMAGE) + sword.damageIncrease();
        }

        /*Player does not have a sword, return the base attack damage. */
        return RANDOM.nextInt(MAXIMUM_ATTACK_DAMAGE);
    } // end of method attack()

    /**
     * Reduce the HP of this player by a specified amount.
     * 
     * @param damage the amount of damage to deal to this player
     */
    public void takeDamage(int damage)
    {
        if (hasArmour)
        {
            /* adv.Player has armour, use it to decrease the damage taken. */
            armour.useArmour();

            /* Protect against taking negative damage. */
            health = health - Math.max(damage - armour.damageBlocked(), 0);

            /* Check the hitpoint status of this armour. */
            if (armour.hitpoints() <= 0)
            {

                System.out.println("\nYour " + armour.name() + " broke.");

                

               
                /* The armour is broken, the player no longer has armour. */
                hasArmour = false;
            } // end of if (armour.hitpoints() <= 0)
        }
        else
        {
            /* Take regular damage if the player does not have armour. */
            health = health - damage;
        } // end of if (hasArmour)
    } // end of method damageDealt(int damage)

    /* Methods that affect the potions of this player. */
    /**
     * Uses a potion on this player.
     */
    public void usePotion()
    {
        /* Exit the function if there are no potions */
        if (potionsRemaining <= 0) {
        	 JOptionPane.showMessageDialog(null, "Don't have enught Potion to use","....",JOptionPane.PLAIN_MESSAGE);
        	 return;
        }	

        /* Use the potion to increase the player's health. */
        health = health + POTION_HEALING;

        /* Decrement the potions since one was just used. */
        potionsRemaining--;
    } // end of method usePotion()

    /**
     * Increases the amount of potions this player has by a specified amount.
     * 
     * @param potions the number of potions to add to this player
     */
    public void addPotions(int potions)
    {
        potionsRemaining = potionsRemaining + potions;
    } // end of method addPotions(int number)

    /**
     * Increases the kill count of this player.
     */
    public void increaseEnemiesKilled()
    {
        enemiesKilled++;
    } // end of increaseEnemiesKilled()

    /* Methods that affect the equipment of this player. */
    /**
     * Gives a sword to this player.
     */
    public void addSword(String type)
    {
        if (type == null) return;

        sword = new Sword(type);

        hasSword = true;
    } // end of method addSword()

    /**
     * Gives armour to this player.
     */
    public void addArmour(String type)
    {
        if (type == null) return;

        armour = new Armour(type);

        hasArmour = true;
    } // end of method addArmour()

    /**
     * Returns this player's data to be saved in text format.
     */
    public String getData()
    {
        return
        name + " " + enemiesKilled + " ";
      
    } // end of method getData()

    /**
     * Resets the state of this player.
     */
    public void reset()
    {
        health = FULL_HEALTH;
        potionsRemaining = DEFAULT_NUMBER_OF_POTIONS;
        enemiesKilled = 0;
        hasSword = false;
        hasArmour = false;
        pouch.coins=0;
        sword.damageIncrease=MAXIMUM_ATTACK_DAMAGE;
        
    } // end of method reset()
} // end of class Player