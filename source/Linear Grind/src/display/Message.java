//************************************************************
/**
*	Message 	Handles messages shown in game.
*	
*	@author		pxldrm
*	@since		7/19/2017
* 	@update 	8/8/2017
*/
//************************************************************
package display;
import javax.swing.JOptionPane;
public class Message {
//************************************************************
/**
*	Variables
*/
//************************************************************
	
//************************************************************
/**
*	Show message in pop-up box
*/
//************************************************************
	public static void showMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
//************************************************************
/**
*	Game Messages
*/
//************************************************************
	public static String confirm = "Are you sure?";
	public static String charSelect = "Choose character.";
//************************************************************
/**
*	Common HTML tags
*/
//************************************************************
	public static String open 	= "<html><body>";
	public static String close 	= "</html></body>";
	public static String brk 	= "<br>";
}
