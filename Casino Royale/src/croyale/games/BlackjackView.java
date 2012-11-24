package croyale.games;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import croyale.Blackjackgui;
import croyale.Casinogui;
import croyale.GameSession;
//import croyale.ImagePanel;
import croyale.gameutil.Blackjack;
import croyale.gameutil.Play;

public class BlackjackView {
	BlackjackView(JFrame frame){
	//	drawWelcomeScreen();
		createAndShowGUI();
	}
	
	public BlackjackView() {
		// TODO Auto-generated constructor stub
	}

	protected JPanel contentPane;

	JFrame blackjackFrame;
	
	protected static JFrame registerWindow;
	
	public JMenuBar createMenuBar(){
		
		// Declare all used menu parts
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		// Create Menu Bar
		menuBar = new JMenuBar();
		
		// Build 'File' Menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);
		
		// Create and add items to 'File' Menu
		
		// 'Exit' item
		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		menu.add(menuItem);
		
		// Build 'Help' Menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);
		
		// 'About...' item
		menuItem = new JMenuItem("About...", KeyEvent.VK_A);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(contentPane,
						"Created by Team Royale\n\u00a9 2012", 
						"About XYZ Casino",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu.add(menuItem);
		
		return menuBar;
	}

	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	public Container drawWelcomeScreen(Container pane){

		// Initialize containers
		JLayeredPane contentPane = new JLayeredPane();
		
		// Set background image as panel
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/BlackjackTable.png").getImage());
		backgroundPane.setOpaque(false);

		
		//JPanel formContainer = new JPanel();
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		pane.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			if (shouldFill) {
				//natural height, maximum width
				c.fill = GridBagConstraints.HORIZONTAL;
			}
			JButton hitButton = new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
			if (shouldWeightX) {
				c.weightx = 5.5;
			}
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			
			JButton standButton= new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 0;
			pane.add(standButton, c);


	/*	formContainer.setLayout(new BoxLayout(formContainer,BoxLayout.Y_AXIS));
		formContainer.setOpaque(false);
		formContainer.setBounds(300, 200, 400, 160);

		contentPane.add(formContainer,1);
		contentPane.add(backgroundPane,2);   
	*/	
		contentPane.add(pane,1);
		contentPane.add(backgroundPane,2);
		//JButton hitButton = new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));

		hitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				;//Blackjack currentBlackjack = new Blackjack();// TODO Auto-generated method stub
			}
		});
		//hitButton.setBounds(150,150, 50, 50);
		//formContainer.add(hitButton);
		//formContainer.add(Box.createVerticalStrut(20));
		return contentPane;
		//return pane;
	}
	
	public static void createAndShowGUI(){
		
		// Creates main program window
		JFrame window = new JFrame("Blackjack");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and set Menu in Frame
		BlackjackView myGUI = new BlackjackView();
		window.setJMenuBar(myGUI.createMenuBar());

		// Initialize main screen
		window.setContentPane(myGUI.drawWelcomeScreen(window.getContentPane()));
        
		// Display main program window
		int windowWidth = 800;
		int windowHeight = 600;
		window.setBounds(50, 100, windowWidth, windowHeight);
		window.setResizable(false);
		window.setVisible(true);
		
		
	}
	

	public Play getUserInput() {
		// TODO Auto-generated method stub
		return null;
	}
	private class ImagePanel extends JLabel {

		  private Image img;
		  {setOpaque(false);} 

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		    super.paintComponent(g);
		  }

		}
}
	
