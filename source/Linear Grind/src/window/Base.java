//************************************************************
/**
*	Base 		Defines the window to display all game content.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	7/28/2017
*/
//************************************************************
package window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	private static final int FRAME_WIDTH 		= Base.SCREEN_WIDTH / 2;
	private static final int FRAME_HEIGHT 		= Base.SCREEN_HEIGHT / 2;
	private static final int X_POS 				= (Base.SCREEN_WIDTH - Base.FRAME_WIDTH) / 2;
	private static final int Y_POS 				= (Base.SCREEN_HEIGHT - Base.FRAME_HEIGHT) / 2;
	private static final int BORDER_WIDTH 		= FRAME_WIDTH / 40;
	private static final int BORDER_HEIGHT 		= FRAME_HEIGHT / 40;
	//card panels
	public static JPanel 		cards;
	public static final String 	TITLE_CARD 		= "title";
	public static final String 	MENU_CARD 		= "menu";
	public static final String 	GAMEOVER_CARD 	= "gameOver";
	//section separator dimension
	private final static int 		BORDER 			= 5;
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
	public static int 			border(){
		return BORDER;
	}
	public Object 				wipe(){
		return null;
	}
}





//JLabel lblSelectItem = new JLabel("Items: ");
//lblSelectItem.setBounds(280, 195, 120, 14);
//
//itemList = new String[Party.itemCount];
//
//for (int i = 0; i < Party.itemCount; i++){
//	if (Party.items()[i] != null)
//		itemList[i] = Party.items()[i].name();
//}
//
//	
//JComboBox<Object> itemSelect = new JComboBox<Object>(itemList);
//itemSelect.setBounds(420, 192, 160, 20);
//
//
//
//
//
//add(itemSelect);
//add(lblSelectItem);
