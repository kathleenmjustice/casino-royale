package croyale;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.Box;

import croyale.games.BlackjackMVC;
import croyale.games.SlotMachineMVC;


public class LoginWindow extends JFrame implements ActionListener{
	private int UserID;
	private JButton OkButton;
	private JButton RegisterButton;
	private JButton RegistrationButton;
	//private JPanel contentPane;
	private JTextField UserIDBox;
	private JTextField PasswordBox;
	private JLabel UserIDLabel;
	private JLabel PasswordLabel;
	private JPanel formContaine;
	private JPanel formContainer;
	private JLayeredPane contentPane2;
	private Container registrationPane;
	private JPanel gameFrame;
	private static LoginWindow frame;
	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginWindow();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
					int windowWidth = 800;
					int windowHeight = 600;
					frame.setBounds(50, 100, windowWidth, windowHeight);
					frame.setResizable(false);
								
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginWindow() {
		setScreen();
	}
	private void setScreen(){
		//Container loginPane = new JPanel();
		
		JLayeredPane loginPane = new JLayeredPane();
		//loginPane.setBackground(new java.awt.Color(0,176,80));
		
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/mainBackground.png").getImage());
		backgroundPane.setOpaque(false);
		
		JPanel registerForm = new JPanel();
		registerForm.setLayout(new BoxLayout(registerForm,BoxLayout.Y_AXIS));
		registerForm.setOpaque(false);
		registerForm.setBounds(300, 200, 400, 200);
		registerForm.add(Box.createVerticalStrut(50));
		// Label for Name
		JPanel nameLabel = new JPanel();
		nameLabel.setLayout(new BoxLayout(nameLabel, BoxLayout.X_AXIS));
		nameLabel.setPreferredSize(new Dimension(100,20));
		JLabel nameLabelText = new JLabel("Name:");
		nameLabel.add(nameLabelText);
		nameLabel.add(Box.createHorizontalStrut(3));
		
		// Name Text Field Input area
		UserIDBox = new JTextField(20);
		UserIDBox.setText("");
		nameLabel.add(UserIDBox);
		registerForm.add(nameLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Label for User Password
		JPanel userPWLabel = new JPanel();
		userPWLabel.setLayout(new BoxLayout(userPWLabel, BoxLayout.X_AXIS));
		userPWLabel.setPreferredSize(new Dimension(100,20));
		JLabel userPWLabelText = new JLabel("Password:");
		userPWLabel.add(userPWLabelText);
		userPWLabel.add(Box.createHorizontalStrut(3));
				
		// UserPW Text Field Input area
		PasswordBox = new JTextField(20);
		PasswordBox.setText("");
		userPWLabel.add(PasswordBox);
		registerForm.add(userPWLabel);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Add Login button
		OkButton = new JButton("Ok");
		OkButton.addActionListener(this);
		OkButton.setPreferredSize(new Dimension(150,25));
		registerForm.add(OkButton);
		registerForm.add(Box.createVerticalStrut(20));
		
		// Add Register button
		RegisterButton = new JButton("Register...");
		RegisterButton.addActionListener(this);
		RegisterButton.setPreferredSize(new Dimension(150,25));
		registerForm.add(RegisterButton);
		//registerForm.add(Box.createVerticalStrut(20));
		loginPane.add(registerForm,1);
		loginPane.add(backgroundPane,2);
		
		this.add(loginPane);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == OkButton){
			System.out.println("here");
			//Database dbf = new Database();
			try{
				//System.out.println(dbf.connectDBase());
				//UserID = dbf.checkPlayer(UserIDBox.getText(), PasswordBox.getText());
				//if(UserID >0){
					//MenuWindow mw = new MenuWindow(UserID);
					//mw.setVisible(true);
					setGameScreen();
				//}else{
					//JOptionPane.showMessageDialog(null,"You are not Reigistred.","Error Message", JOptionPane.ERROR_MESSAGE);
					//UserID=0;
				//}
			}catch(Exception e1){
				System.out.println(e1.toString());
			}
			
		}
		else if(e.getSource() == RegistrationButton){
			RegistrationWindow rw = new RegistrationWindow(UserID);
			rw.setVisible(true);
			//this.dispose();
		}
		else{
			RegistrationWindow rw = new RegistrationWindow();
			rw.setVisible(true);
		}

	}
	private void setGameScreen(){
		JLayeredPane contentPane = new JLayeredPane();
		
		// Set background image as panel
		JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/mainBackground.png").getImage());
		backgroundPane.setOpaque(false);
		
		// Initialize main layout
		JPanel gameContainer = new JPanel();
		gameContainer.setLayout(new BorderLayout());
		gameContainer.setOpaque(false);
		gameContainer.setBounds(0, 200, 1000, 600);
		
		String[] games = {"Blackjack","Slot Machine"};
		JComboBox<String> gamesComboBox = new JComboBox<String>(games);
		gamesComboBox.setSelectedItem(null);
		gamesComboBox.setMaximumSize(gamesComboBox.getPreferredSize());
		
		JPanel gamesComboBoxPane = new JPanel();
		gamesComboBoxPane.setLayout(new BoxLayout(gamesComboBoxPane, BoxLayout.X_AXIS));
		gamesComboBoxPane.setOpaque(false);
		
		gamesComboBoxPane.add(Box.createHorizontalStrut(50));
		gamesComboBoxPane.add(gamesComboBox);
		gamesComboBoxPane.add(Box.createHorizontalStrut(75));
		gamesComboBoxPane.setMaximumSize(gamesComboBoxPane.getPreferredSize());

		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
		leftPane.setOpaque(false);
		
		leftPane.add(Box.createVerticalStrut(100));
		leftPane.add(gamesComboBoxPane);
		leftPane.add(Box.createVerticalStrut(50));

		// Create Player Info frame
		JPanel playerInfo = new JPanel();
		playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.Y_AXIS));
		JLabel playerInfoTitle = new JLabel("Player Account");
		playerInfo.setBackground(Color.RED);
		playerInfo.add(playerInfoTitle);
		RegistrationButton = new JButton("Registration");
		playerInfo.add(RegistrationButton);
		RegistrationButton.addActionListener(this);
		
		playerInfo.setMaximumSize(playerInfo.getPreferredSize());
		
		leftPane.add(playerInfo);
		leftPane.add(playerInfoTitle);
	
		
		gameFrame = new JPanel();
		gameContainer.add(leftPane,BorderLayout.LINE_START);
		gameContainer.add(gameFrame,BorderLayout.CENTER);
		
		
		
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
				if (gameName == "Slot Machine")
					try {
						
						SlotMachineMVC sm = new SlotMachineMVC(frame.gameFrame);
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
		frame.setContentPane(contentPane);
		int windowWidth = 1100;
		int windowHeight = 800;

		frame.setBounds(50, 100, windowWidth, windowHeight);
		frame.setVisible(true);
	}
}


class ImagePanel extends JLabel {

	  private java.awt.Image img;
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