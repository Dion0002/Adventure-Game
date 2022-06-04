package adventure;

import javax.swing.JFrame;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


import adventure.Game.ChoiceHandler;

import javax.swing.JLabel;

public class WGame {
	
	JFrame window , leaderwind;
	JPanel titleNamePanel , startButtonPanel, mainTextPanel , choiceButtonPanel,playerPanel,storePanel,actionPanel,dropitemPanel,leaderpanel;
	JLabel titleNameLabel ,palyerStatus, HpLabel , hpnumberLabel, potionsleftLabel ,psLabel, coinsLabel,clabel , enemykillLabel, ekLabel,
	storeLabel,dropSwordLabel, dropswordHPLabel,droparmorLabel,droparmorHpLabel;
	JButton startButton ,attackbutton ,usepotionbutton,runbutton,extibutton,buysowrd,buyarmour,buypotion,leaderbordsbutton;
	JTextArea mainTextArea, actionTextArea;
	JTable leaderbordsTable;
	JScrollPane scrollPane;
	
	Font titleFont = new Font("Times New Roman",Font.PLAIN,60);
	Font normalFont = new Font("Times New Roman",Font.PLAIN,18);
	Font dropFont = new Font("Times New Roman",Font.PLAIN,14);
	
	Player player = new Player();
	
	

	
	public void createWGame(ChoiceHandler cHandler) {
	
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		

			   
			
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,500);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Welcome Adventurer");
		titleNameLabel.setForeground(Color.white);	
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		
		startButton= new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("play");
		startButtonPanel.add(startButton);
		

		window.add(titleNamePanel);
		window.add(startButtonPanel);	

		
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50,20,250,80);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is .......");
		mainTextArea.setBounds(50,50,250,80);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		
		actionPanel = new JPanel();
		actionPanel.setBounds(50,120,250,80);
		actionPanel.setBackground(Color.black);
		window.add(actionPanel);
		
		actionTextArea = new JTextArea("Demage");
		actionTextArea.setBounds(50,120,250,100);
		actionTextArea.setBackground(Color.black);
		actionTextArea.setForeground(Color.white);
		actionTextArea.setFont(normalFont);
		actionTextArea.setLineWrap(true);
		actionTextArea.setWrapStyleWord(true);
		actionTextArea.setEditable(false);
		actionPanel.add(actionTextArea);
		

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(31,300,250,250);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);
		
		attackbutton = new JButton("Attack");
		attackbutton.setBackground(Color.black);
		attackbutton.setForeground(Color.white);
		attackbutton.setFont(normalFont);
		attackbutton.setFocusPainted(false);
		attackbutton.addActionListener(cHandler);
		attackbutton.setActionCommand("ATTACK");
		choiceButtonPanel.add(attackbutton);
		
		usepotionbutton = new JButton("Use Potion");
		usepotionbutton.setBackground(Color.black);
		usepotionbutton.setForeground(Color.white);
		usepotionbutton.setFont(normalFont);
		usepotionbutton.setFocusPainted(false);
		usepotionbutton.addActionListener(cHandler);
		usepotionbutton.setActionCommand("USE_POTION");
		choiceButtonPanel.add(usepotionbutton);
		
		runbutton = new JButton("Run");
		runbutton.setBackground(Color.black);
		runbutton.setForeground(Color.white);
		runbutton.setFont(normalFont);
		runbutton.setFocusPainted(false);
		runbutton.addActionListener(cHandler);
		runbutton.setActionCommand("RUN");
		choiceButtonPanel.add(runbutton);
		
		extibutton = new JButton("Exit");
		extibutton.setBackground(Color.black);
		extibutton.setForeground(Color.white);
		extibutton.setFont(normalFont);
		extibutton.setFocusPainted(false);
		extibutton.addActionListener(cHandler);
		extibutton.setActionCommand("EXIT");
		choiceButtonPanel.add(extibutton);
		
		//player Status
		playerPanel = new JPanel();
		playerPanel.setBounds(450,0,350,270);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(4,2));
		window.add(playerPanel);
		
		
		HpLabel = new JLabel("Health:");
		HpLabel.setFont(normalFont);
		HpLabel.setForeground(Color.white);
		playerPanel.add(HpLabel);
		hpnumberLabel = new JLabel();
		hpnumberLabel.setForeground(Color.white);
		hpnumberLabel.setFont(normalFont);
		playerPanel.add(hpnumberLabel);
		
		potionsleftLabel = new JLabel("Potions Left:");
		potionsleftLabel.setFont(normalFont);
		potionsleftLabel.setForeground(Color.white);
		playerPanel.add(potionsleftLabel);
		psLabel = new JLabel();
		psLabel.setForeground(Color.white);
		psLabel.setFont(normalFont);
		playerPanel.add(psLabel);
		
		coinsLabel = new JLabel("Coins:");
		coinsLabel.setFont(normalFont);
		coinsLabel.setForeground(Color.white);
		playerPanel.add(coinsLabel);
		clabel = new JLabel();
		clabel.setForeground(Color.white);
		clabel.setFont(normalFont);
		playerPanel.add(clabel);
		
		enemykillLabel = new JLabel("Enemies killed:");
		enemykillLabel.setFont(normalFont);
		enemykillLabel.setForeground(Color.white);
		playerPanel.add(enemykillLabel);
		ekLabel= new JLabel();
		ekLabel.setForeground(Color.white);
		ekLabel.setFont(normalFont);
		playerPanel.add(ekLabel);
		
		
		
		
		//Store
		storePanel = new JPanel();
		storePanel.setBounds(420,270,300,280);
		storePanel.setBackground(Color.black);
		storePanel.setLayout(new GridLayout(3,1));
		window.add(storePanel);
		

		buysowrd = new JButton("Sword cost 100 coins");
		buysowrd.setBackground(Color.black);
		buysowrd.setForeground(Color.white);
		buysowrd.setFont(normalFont);
		buysowrd.setFocusPainted(false);
		buysowrd.addActionListener(cHandler);
		buysowrd.setActionCommand("buysword");
		storePanel.add(buysowrd);
		
		buyarmour = new JButton("Armour cost 50 coins");
		buyarmour.setBackground(Color.black);
		buyarmour.setForeground(Color.white);
		buyarmour.setFont(normalFont);
		buyarmour.setFocusPainted(false);
		buyarmour.addActionListener(cHandler);
		buyarmour.setActionCommand("buyarmor");
		storePanel.add(buyarmour);
		
		buypotion = new JButton("Potion cost 10 coins");
		buypotion.setBackground(Color.black);
		buypotion.setForeground(Color.white);
		buypotion.setFont(normalFont);
		buypotion.setFocusPainted(false);
		buypotion.addActionListener(cHandler);
		buypotion.setActionCommand("buypotion");
		storePanel.add(buypotion);
		

		
	
		
		window.setVisible(true);
		
		
	}

}
