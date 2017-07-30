//************************************************************
/**
*	Base 		Superclass for all display classes.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	7/27/2017
*/
//************************************************************
package display;

import java.awt.Font;

public class Base {
//************************************************************
/**
*	Variables
*/
//************************************************************
	//style dimensions
	private static final int 	FONT_SIZE 	= 18;
	private static final String FONT_STYLE 	= "Courier New";
	private static final Font 	MENU_FONT 	= new Font(FONT_STYLE, Font.PLAIN, menuFontSize());
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public static int 		menuFontSize(){
		if (window.Base.width() < 600)
			return FONT_SIZE - 10;
		else if (window.Base.width() < 700)
			return FONT_SIZE - 8;
		else if (window.Base.width() < 800)
			return FONT_SIZE - 6;
		else if (window.Base.width() < 900)
			return FONT_SIZE - 4;
		else if (window.Base.width() < 960)
			return FONT_SIZE - 2;
		else
			return FONT_SIZE;
	}
	public static Font 		menuFont(){
		return MENU_FONT;
	}
//************************************************************
/**
*	Display methods
*/
//************************************************************
	public static String 	space(int length){
		String spaces = "";
		for (int i = 0; i < length; i++)
			spaces += " ";
		return spaces;
	}
	public static String 	htmlSpace(int length){
		String spaces = "";
		for (int i = 0; i < length - 1; i++)
			spaces += "&nbsp";
		spaces += " ";
		return spaces;
	}
}
