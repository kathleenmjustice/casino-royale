package croyale.games;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import util.ParseString;

//import croyale.ImagePanel;
import croyale.gameutil.Play;

@SuppressWarnings("serial")
public class BlackjackView extends JFrame{

	private static Play currentPlay; // User's response, "Hit" or "Stand".
	private JPanel m_enterBetL = new JPanel();
	private JTextField m_betTf = new JTextField(5);
	private JButton m_betBtn = new JButton("Bet");
	private JPanel m_enterPlayL = new JPanel();
	private JTextField m_currentPlayTf = new JTextField(10);
	private JButton m_playBtn = new JButton("Play");
	private JPanel m_balanceL = new JPanel();
	private JTextField m_balanceTf = new JTextField(20);
	private JTextArea m_outputTa = new JTextArea(40, 40);
	private JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/BlackjackTable.png").getImage());

	BlackjackView(JFrame frame){
		// Creates main program window
		this.setTitle("Blackjack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set Menu in Frame
		BlackjackView myGUI = new BlackjackView();
		this.setJMenuBar(myGUI.createMenuBar());

		// Initialize main screen
		this.setContentPane(myGUI.drawWelcomeScreen(this.getContentPane()));
		this.pack();
		
		// Display main program window
		int windowWidth = 800;
		int windowHeight = 600;
		this.setBounds(50, 100, windowWidth, windowHeight);
		this.setResizable(false);
	}
	BlackjackView(){
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

	public Container drawWelcomeScreen(Container pane){

		//Initialize components
		this.m_balanceTf.setEditable(false);
		this.m_outputTa.setEditable(false);
		
		// Initialize containers
		JLayeredPane contentPane = new JLayeredPane();
		
		// Set background image as panel
		//JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/BlackjackTable.png").getImage());
		backgroundPane.setOpaque(false);

		//Layout the components.
		JPanel formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer,BoxLayout.Y_AXIS));
		formContainer.setOpaque(false);
		formContainer.setBounds(300, 200, 400, 260);
		//JButton m_hitBtn = new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
		//JButton standButton= new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
		//m_hitBtn.setPreferredSize(new Dimension(20,20));
		
		m_enterBetL.setLocation(10, 100);
		m_enterBetL.setLayout(new BoxLayout(m_enterBetL, BoxLayout.X_AXIS));
		m_enterBetL.setPreferredSize(new Dimension(100,5));
		JLabel m_enterBetLText = new JLabel("Enter amount of Bet:");
		m_enterBetL.add(m_enterBetLText);
		formContainer.add(this.m_enterBetL);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));
		
		formContainer.add(this.m_betTf);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));

		
		formContainer.add(this.m_betBtn);
		m_enterPlayL.setLayout(new BoxLayout(m_enterPlayL, BoxLayout.X_AXIS));
		m_enterPlayL.setPreferredSize(new Dimension(100,20));
		JLabel m_enterPlayLText = new JLabel("Enter play (Hit or Stand)");
		m_enterPlayL.add(m_enterPlayLText);
		formContainer.add(this.m_enterPlayL);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));
		
		formContainer.add(this.m_currentPlayTf);
		formContainer.add(this.m_playBtn);
		
		m_balanceL.setLocation(10, 100);
		m_balanceL.setLayout(new BoxLayout(m_balanceL, BoxLayout.Y_AXIS));
		m_balanceL.setPreferredSize(new Dimension(100,20));
		JLabel m_balanceLText = new JLabel("balance:");
		m_balanceL.add(m_balanceLText);
		formContainer.add(this.m_balanceL);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));

		m_balanceTf.setLayout(new BoxLayout(m_balanceTf, BoxLayout.X_AXIS));
		formContainer.add(this.m_balanceTf);
		
		formContainer.add(this.m_outputTa);
		
		contentPane.add(formContainer,1);
		contentPane.add(backgroundPane,2);
		return contentPane;
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
	public Play getCurrentPlay(){
     	  ParseString parse = new ParseString();
  		  try {
  			try {
  				parse.parseString(this.m_currentPlayTf.getText());
  			} catch (NoSuchMethodException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} catch (SecurityException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} catch (IllegalArgumentException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} catch (InvocationTargetException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		} catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
            
    	return currentPlay;
    }
    public void setMoney(String newMoney){
    	System.out.println("newMoney: " + newMoney);
    	this.m_balanceTf.setText(newMoney);
    }
    public int getBet(){
    	return Integer.parseInt(this.m_betTf.getText());
    }
    public void addPlayListener(ActionListener pal){
    	this.m_playBtn.addActionListener(pal);
    }
    public void addBetListener(ActionListener bal){
    	this.m_betBtn.addActionListener(bal);
    }
}
	
