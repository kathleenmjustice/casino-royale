package croyale;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Blackjackgui {
	Blackjackgui(JFrame frame){
		drawWelcomeScreen();
		createAndShowGUI();
	}
	
	public Blackjackgui() {
		// TODO Auto-generated constructor stub
	}

	protected JPanel contentPane;
	
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

	public Container drawWelcomeScreen(){
	
		// Initialize containers
		JLayeredPane contentPane = new JLayeredPane();
		
		// Set background image as panel
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/blackjack table.jpg").getImage());
		backgroundPane.setOpaque(false);
		
		// Initialize login form
		JPanel formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer,BoxLayout.Y_AXIS));
		formContainer.setOpaque(false);
		formContainer.setBounds(300, 200, 400, 160);

		// Label for UserID
		JPanel userIDLabel = new JPanel();
		userIDLabel.setLayout(new BoxLayout(userIDLabel, BoxLayout.X_AXIS));
		userIDLabel.setPreferredSize(new Dimension(100,20));
		JLabel userIDLabelText = new JLabel("Username:");
		userIDLabel.add(userIDLabelText);
		userIDLabel.add(Box.createHorizontalStrut(3));
						
		contentPane.add(formContainer,1);
		contentPane.add(backgroundPane,2);   
		
		
		return contentPane;
	}
	
	public static void createAndShowGUI(){
		
		// Creates main program window
		JFrame window = new JFrame("Blackjack");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and set Menu in Frame
		Blackjackgui myGUI = new Blackjackgui();
		window.setJMenuBar(myGUI.createMenuBar());
		
		// Initialize main screen
		window.setContentPane(myGUI.drawWelcomeScreen());
		
		// Display main program window
		int windowWidth = 800;
		int windowHeight = 600;
		window.setBounds(50, 100, windowWidth, windowHeight);
		window.setResizable(false);
		window.setVisible(true);
	}
		
}

class ImagePanel extends JLabel {

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
