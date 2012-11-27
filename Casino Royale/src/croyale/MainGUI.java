package croyale;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import croyale.games.BlackjackMVC;

public class MainGUI {
	protected static JFrame window;
	protected static MainGUI myGUI;
	protected JPanel contentPane;
	protected JTextField userIDinput, userPWinput;
	protected JTextField r_userIDinput, r_userPWinput;
	protected JTextField nameinput, emailinput, phoneinput, addressinput, balanceinput;
	
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
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/mainBackground.png").getImage());
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
		
		// UserID Text Field Input area
		userIDinput = new JTextField(20);
		userIDinput.setText("JohnDoe@gmail.com");
		userIDLabel.add(userIDinput);
		formContainer.add(userIDLabel);
		formContainer.add(Box.createVerticalStrut(20));
		
		// Label for User Password
		JPanel userPWLabel = new JPanel();
		userPWLabel.setLayout(new BoxLayout(userPWLabel, BoxLayout.X_AXIS));
		userPWLabel.setPreferredSize(new Dimension(100,20));
		JLabel userPWLabelText = new JLabel("Password:");
		userPWLabel.add(userPWLabelText);
		userPWLabel.add(Box.createHorizontalStrut(3));
		
		// UserPW Text Field Input area
		userPWinput = new JTextField(20);
		userPWinput.setText("pass1234");
		userPWLabel.add(userPWinput);
		formContainer.add(userPWLabel);
		formContainer.add(Box.createVerticalStrut(20));
		
		// Add Login button
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GameSession.login(userIDinput.getText(),userPWinput.getText());
				MainGUI.drawMainScreen();
				//Casinogui window = new Casinogui();
				//window.frame.setVisible(true);
			}
		});
		loginButton.setPreferredSize(new Dimension(150,25));
		formContainer.add(loginButton);
		formContainer.add(Box.createVerticalStrut(20));
		
		// Add Register button
		JButton registerButton = new JButton("Register...");
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createRegisterWindow();
			}
		});
		registerButton.setPreferredSize(new Dimension(150,25));
		formContainer.add(registerButton);
		
		contentPane.add(formContainer,1);
		contentPane.add(backgroundPane,2);   
		
		
		return contentPane;
	}
	
	public static void createAndShowGUI(){
		
		// Creates main program window
		window = new JFrame("Casino Royale");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and set Menu in Frame
		myGUI = new MainGUI();
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
	
	public static void drawMainScreen(){
		// Initialize containers
		JLayeredPane contentPane = new JLayeredPane();
		
		// Set background image as panel
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/mainBackground.png").getImage());
		backgroundPane.setOpaque(false);
		
		// Initialize main layout
		JPanel gameContainer = new JPanel();
		gameContainer.setLayout(new BorderLayout());
		gameContainer.setOpaque(false);
		gameContainer.setBounds(0, 200, 1000, 600);
		
		String[] games = {"Blackjack"};
		JComboBox<String> gamesComboBox = new JComboBox<String>(games);
		gamesComboBox.setSelectedItem(null);
		gamesComboBox.setMaximumSize(gamesComboBox.getPreferredSize());
		
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.X_AXIS));
		leftPane.setOpaque(false);
		
		leftPane.add(Box.createHorizontalStrut(50));
		leftPane.add(gamesComboBox);

		gameContainer.add(leftPane,BorderLayout.LINE_START);
		gamesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();        
				String gameName = (String)cb.getSelectedItem();
				if (gameName == "Blackjack")
					try {
						
						BlackjackMVC blackjackWindow = new BlackjackMVC();
						//blackjackWindow.blackjackFrame.setVisible(true);
					} catch (Exception ee) {
						System.out.println("Could not create Casino gui");
						ee.printStackTrace();
					}
			}
		 });
		
		
		contentPane.add(gameContainer,1);
		contentPane.add(backgroundPane,2); 
		
		// Initialize main screen
		window.setContentPane(contentPane);
		int windowWidth = 1100;
		int windowHeight = 800;

		window.setBounds(50, 100, windowWidth, windowHeight);
		window.setVisible(true);
	}
	
	public Container drawRegisterScreen(){
		Container registrationPane = new JPanel();
		registrationPane.setBackground(new Color(0,176,80));
		
		JPanel registerForm = new JPanel();
		registerForm.setLayout(new BoxLayout(registerForm,BoxLayout.Y_AXIS));
		registerForm.setOpaque(false);
		registerForm.setBounds(50, 200, 400, 400);
		
		registerForm.add(Box.createVerticalStrut(50));
		
		// Label for Name
		JPanel nameLabel = new JPanel();
		nameLabel.setLayout(new BoxLayout(nameLabel, BoxLayout.X_AXIS));
		nameLabel.setPreferredSize(new Dimension(100,20));
		JLabel nameLabelText = new JLabel("Name:");
		nameLabel.add(nameLabelText);
		nameLabel.add(Box.createHorizontalStrut(3));
		
		// Name Text Field Input area
		nameinput = new JTextField(20);
		nameinput.setText("John Doe");
		nameLabel.add(nameinput);
		registerForm.add(nameLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for email
		JPanel emailLabel = new JPanel();
		emailLabel.setLayout(new BoxLayout(emailLabel, BoxLayout.X_AXIS));
		emailLabel.setPreferredSize(new Dimension(100,20));
		JLabel emailLabelText = new JLabel("Email:");
		emailLabel.add(emailLabelText);
		emailLabel.add(Box.createHorizontalStrut(3));
		
		// Email Text Field Input area
		emailinput = new JTextField(20);
		emailinput.setText("JohnDoe@gmail.com");
		emailLabel.add(emailinput);
		registerForm.add(emailLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for Phone
		JPanel phoneLabel = new JPanel();
		phoneLabel.setLayout(new BoxLayout(phoneLabel, BoxLayout.X_AXIS));
		phoneLabel.setPreferredSize(new Dimension(100,20));
		JLabel phoneLabelText = new JLabel("Phone Number:");
		phoneLabel.add(phoneLabelText);
		phoneLabel.add(Box.createHorizontalStrut(3));
		
		// Phone Text Field Input area
		phoneinput = new JTextField(20);
		phoneinput.setText("(216) 123-4567");
		phoneLabel.add(phoneinput);
		registerForm.add(phoneLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for Address
		JPanel addressLabel = new JPanel();
		addressLabel.setLayout(new BoxLayout(addressLabel, BoxLayout.X_AXIS));
		addressLabel.setPreferredSize(new Dimension(100,20));
		JLabel addressLabelText = new JLabel("Address:");
		addressLabel.add(addressLabelText);
		addressLabel.add(Box.createHorizontalStrut(3));
		
		// Address Text Field Input area
		addressinput = new JTextField(20);
		addressinput.setText("6542 Main Street");
		addressLabel.add(addressinput);
		registerForm.add(addressLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for Balance
		JPanel balanceLabel = new JPanel();
		balanceLabel.setLayout(new BoxLayout(balanceLabel, BoxLayout.X_AXIS));
		balanceLabel.setPreferredSize(new Dimension(100,20));
		JLabel balanceLabelText = new JLabel("Balance:");
		balanceLabel.add(balanceLabelText);
		balanceLabel.add(Box.createHorizontalStrut(3));
		
		// Balance Text Field Input area
		balanceinput = new JTextField(20);
		balanceinput.setText("50000");
		balanceLabel.add(balanceinput);
		registerForm.add(balanceLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for UserID
		JPanel userIDLabel = new JPanel();
		userIDLabel.setLayout(new BoxLayout(userIDLabel, BoxLayout.X_AXIS));
		userIDLabel.setPreferredSize(new Dimension(100,20));
		JLabel userIDLabelText = new JLabel("Username:");
		userIDLabel.add(userIDLabelText);
		userIDLabel.add(Box.createHorizontalStrut(3));
		
		// UserID Text Field Input area
		r_userIDinput = new JTextField(20);
		r_userIDinput.setText("JohnDoe@gmail.com");
		userIDLabel.add(r_userIDinput);
		registerForm.add(userIDLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for User Password
		JPanel userPWLabel = new JPanel();
		userPWLabel.setLayout(new BoxLayout(userPWLabel, BoxLayout.X_AXIS));
		userPWLabel.setPreferredSize(new Dimension(100,20));
		JLabel userPWLabelText = new JLabel("Password:");
		userPWLabel.add(userPWLabelText);
		userPWLabel.add(Box.createHorizontalStrut(3));
		
		// UserPW Text Field Input area
		r_userPWinput = new JTextField(20);
		r_userPWinput.setText("pass1234");
		userPWLabel.add(r_userPWinput);
		registerForm.add(userPWLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Add OK button
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Database.createAccount(nameinput.getText(),r_userIDinput.getText(),r_userPWinput.getText());
				Database.updateAddress(r_userIDinput.getText(), addressinput.getText());
				Database.updateBalance(r_userIDinput.getText(), Integer.parseInt(balanceinput.getText()));
				Database.updateEmail(r_userIDinput.getText(), emailinput.getText());
				Database.updatePhone(r_userIDinput.getText(), phoneinput.getText());
				registerWindow.dispose();
			}
		});
		okButton.setPreferredSize(new Dimension(150,25));
		registerForm.add(okButton);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Add Cancel button
		JButton registerButton = new JButton("Cancel");
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				registerWindow.dispose();
			}
		});
		registerButton.setPreferredSize(new Dimension(150,25));
		registerForm.add(registerButton);
		
		registrationPane.add(registerForm);
		return registrationPane;
	}
	
	public static void createRegisterWindow(){
		// Creates main program window
				registerWindow = new JFrame("Register");
				
				// Initialize main screen
				MainGUI registration = new MainGUI();
				registerWindow.setContentPane(registration.drawRegisterScreen());
				
				// Display main program window
				int windowWidth = 600;
				int windowHeight = 500;
				registerWindow.setBounds(150, 200, windowWidth, windowHeight);
				registerWindow.setVisible(true);
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
