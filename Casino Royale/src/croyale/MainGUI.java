package croyale;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainGUI {
	protected JPanel contentPane;
	protected JLabel hintHelpBox, outLabel;
	protected JTextArea output;
	protected JTextField aField,bField;
	protected int a,b;
	
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
		
		JPanel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/mainBackground.png").getImage());
	
		JPanel foregroundPane = new JPanel(new BorderLayout());
		//foregroundPane.setBorder(new EmptyBorder(5,5,5,5));
		//foregroundPane.setOpaque(true);
		
				
		// Add all containers to upper level containers
		
		contentPane.add(backgroundPane,1);
		contentPane.add(foregroundPane,4);
		
		JLabel label = new JLabel();
		label.setBackground(Color.cyan);
		 label.setVerticalAlignment(JLabel.TOP);
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setOpaque(true);
	        label.setBackground(Color.cyan);
	        label.setForeground(Color.green);
	        label.setBorder(BorderFactory.createLineBorder(Color.black));
	        label.setBounds(100, 100, 140, 140);

		contentPane.add(label,3);
		
		label = new JLabel();
		 label.setVerticalAlignment(JLabel.TOP);
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setOpaque(true);
	        label.setBackground(Color.green);
	        label.setForeground(Color.green);
	        label.setBorder(BorderFactory.createLineBorder(Color.black));
	        label.setBounds(125, 125, 140, 140);
	        

			contentPane.add(label,5);
	        
		return contentPane;
	}
	
	public static void createAndShowGUI(){
		
		// Creates main program window
		JFrame window = new JFrame("Casino Royale");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and set Menu in Frame
		MainGUI myGUI = new MainGUI();
		window.setJMenuBar(myGUI.createMenuBar());
		
		// Initialize main screen
		window.setContentPane(myGUI.drawWelcomeScreen());
		
		// Display main program window
		int windowWidth = 800;
		int windowHeight = 600;
		window.setBounds(50, 100, windowWidth, windowHeight);
		window.setVisible(true);
	}

}

class ImagePanel extends JPanel {

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
