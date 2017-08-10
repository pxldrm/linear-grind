//************************************************************
/**
*	Base 		Defines the window to display all game content.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	8/8/2017
*/
//************************************************************
package window;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
public class Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private JFrame frame;
	//screen dimensions
	private static final GraphicsDevice GD 		= GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private static final int SCREEN_WIDTH 		= Base.GD.getDisplayMode().getWidth();
	private static final int SCREEN_HEIGHT 		= Base.GD.getDisplayMode().getHeight();
	//frame dimensions
//	private static final int FRAME_WIDTH 		= 680;
//	private static final int FRAME_HEIGHT 		= FRAME_WIDTH / 2;
	private static final int FRAME_WIDTH 		= Base.SCREEN_WIDTH / 2;
	private static final int FRAME_HEIGHT 		= Base.SCREEN_HEIGHT / 2;
	private static final int X_POS 				= (Base.SCREEN_WIDTH - Base.FRAME_WIDTH) / 2;
	private static final int Y_POS 				= (Base.SCREEN_HEIGHT - Base.FRAME_HEIGHT) / 2;
	private static final int BORDER_WIDTH 		= FRAME_WIDTH / 40;
	private static final int BORDER_HEIGHT 		= FRAME_HEIGHT / 40;
	private static final int HOR_SECTIONS 		= 6;
	private static final int VER_SECTIONS 		= 10;
	private final static int SECTION_BORDER 	= FRAME_WIDTH / 192;
	private final static int PADDING 			= FRAME_WIDTH / 96;
	//card panels
	public static JPanel 		cards;
	public static final String 	TITLE_CARD 		= "title";
	public static final String 	MENU_CARD 		= "menu";
	public static final String 	GAMEOVER_CARD 	= "gameOver";
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public Base(){
		//build frame
		frame = new JFrame(display.Vocab.title);
		frame.setBounds(X_POS, Y_POS, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//add jpanel cards
        cards = new JPanel(new CardLayout());
        cards.add(new Menu(), MENU_CARD);
        cards.add(new Title(), TITLE_CARD);
        cards.add(new GameOver(), GAMEOVER_CARD);
        frame.getContentPane().add(cards, BorderLayout.CENTER);
		frame.setVisible(true);
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	//dimensions
	public static int 			width(){
		return FRAME_WIDTH;
	}
	public static int 			height(){
		return FRAME_HEIGHT;
	}
	public static int 			x_pos(){
		return X_POS;
	}
	public static int 			y_pos(){
		return Y_POS;
	}
	public static int 			borderWidth(){
		return BORDER_WIDTH;
	}
	public static int 			borderHeight(){
		return BORDER_HEIGHT;
	}
	public static int 			horizontalSections(){
		return HOR_SECTIONS;
	}
	public static int 			verticalSections(){
		return VER_SECTIONS;
	}
	public static int 			sectionBorder(){
		return SECTION_BORDER;
	}
	//card panels
	public static JPanel 		cards(){
		return cards;
	}
	public static String 		title(){
		return TITLE_CARD;
	}
	public static String 		menu(){
		return MENU_CARD;
	}
	public static String 		gameOver(){
		return GAMEOVER_CARD;
	}
	public Object 				wipe(){
		return null;
	}
//************************************************************
/**
*	Common objects
*/
//************************************************************
	public static JButton 		menuButton(String s, int x, int y, int w, int h){
		JButton b = new JButton(s);
		b.setFocusable(false);
		b.setFont(display.Base.menuFont());
		b.setForeground(Color.white);
		b.setBackground(Color.black);
		b.setBounds(x, y, w, h);
		return b;
	}
	public static JLabel 		menuLabel(String s, int hA, int vA, int x, int y, int w, int h){
		JLabel l = new JLabel(s);
		l.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white),BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING)));
		l.setHorizontalAlignment(hA);
		l.setVerticalAlignment(vA);
		l.setFont(display.Base.menuFont());
		l.setForeground(Color.white);
		l.setBounds(x, y, w, h);
		return l;
	}
	public static JComboBox<Object> 		menuComboBox(DefaultComboBoxModel<Object> m, int x, int y, int w, int h){
		JComboBox<Object> c = new JComboBox<Object>();
		c.setFocusable(false);
		c.setMaximumRowCount(5);
		c.setModel(m);
		c.setFont(display.Base.menuFont());
		c.setForeground(Color.white);
		c.setBackground(Color.black);
		c.setBounds(x, y, w, h);
		return c;
	}
}
