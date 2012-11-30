package croyale.games;

import java.awt.Color;
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

public class BlackjackView{

	//private static Play currentPlay; // User's response, "Hit" or "Stand".
	private JPanel m_enterBetL = new JPanel();
	private JTextField m_betTf = new JTextField(5);
	private JButton m_betBtn = new JButton("Bet");
	private JPanel m_enterPlayL = new JPanel();
	private JTextField m_currentPlayTf = new JTextField(10);
	private JButton m_playBtn = new JButton("Play");
	private JPanel m_balanceL = new JPanel();
	private JTextField m_balanceTf = new JTextField(20);
	private JTextArea m_outputTa = new JTextArea(40, 40);
	private JLabel backgroundPane;
	private JPanel contentPane;

	BlackjackView(JPanel gamePane){
	 contentPane = gamePane;
	 drawGameScreen();
	}

	public void drawGameScreen(){

		// Initialize containers
		contentPane.removeAll();
		contentPane.setBackground(new Color(0,176,80));
		JLayeredPane mainPane = new JLayeredPane();
		
		// Set background image as panel
		//JLabel backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/BlackjackTable.png").getImage());
		backgroundPane = new ImagePanel(new ImageIcon("src/croyale/resources/blackjack.jpg").getImage());
		backgroundPane.setOpaque(false);

		//Layout the components.
		JPanel formContainer = new JPanel();
		formContainer.setLayout(new BoxLayout(formContainer,BoxLayout.Y_AXIS));
		formContainer.setOpaque(false);
		//formContainer.setBounds(300, 200, 400, 260);
		//JButton m_hitBtn = new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
		//JButton standButton= new JButton(new ImageIcon("src/croyale/resources/HIT poker chip.png"));
		//m_hitBtn.setPreferredSize(new Dimension(20,20));
		
		m_enterBetL.setLocation(10, 100);
		m_enterBetL.setLayout(new BoxLayout(m_enterBetL, BoxLayout.X_AXIS));
		//m_enterBetL.setPreferredSize(new Dimension(100,5));
		JLabel m_enterBetLText = new JLabel("Enter amount of Bet:");
		m_enterBetL.add(m_enterBetLText);
		m_enterBetL.setMaximumSize(m_enterBetL.getPreferredSize());
		formContainer.add(this.m_enterBetL);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));
		m_betTf.setMaximumSize(m_betTf.getPreferredSize());
		formContainer.add(this.m_betTf);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));

		
		formContainer.add(this.m_betBtn);
		m_enterPlayL.setLayout(new BoxLayout(m_enterPlayL, BoxLayout.X_AXIS));
		m_enterPlayL.setPreferredSize(new Dimension(100,20));
		JLabel m_enterPlayLText = new JLabel("Enter play (Hit or Stand)");
		m_enterPlayL.add(m_enterPlayLText);
		formContainer.add(this.m_enterPlayL);
		formContainer.add(Box.createRigidArea(new Dimension(5,0)));
		m_currentPlayTf.setMaximumSize(m_currentPlayTf.getPreferredSize());
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
		m_balanceTf.setMaximumSize(m_balanceTf.getPreferredSize());
		formContainer.add(this.m_balanceTf);
		
		formContainer.add(this.m_outputTa);
		
		
		mainPane.setPreferredSize(new Dimension(800,1000));
		//mainPane.add(formContainer,1);
		mainPane.add(backgroundPane,2);
		contentPane.add(mainPane);
		backgroundPane.setBounds(50,0,600,800);
		formContainer.setBounds(50,100,600,800);
		contentPane.setBounds(0,0,600,800);
		contentPane.revalidate();
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
	/*public Play getCurrentPlay(){
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
    }*/
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
	
