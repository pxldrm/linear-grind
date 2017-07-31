//************************************************************
/**
*	RunGame 	Main driver for application.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/30/2017
*/
//************************************************************
package main;
import java.awt.EventQueue;
import java.sql.SQLException;
import data.DBImport;
import debug.Debugger;
public class RunGame{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private static window.Base screen;
//************************************************************
/**
*	Build Database
*/
//************************************************************
	public static void 		loadDatabase(){
		try {
	    	DBImport.importDatabase();
	    }
	    catch (SQLException e ) {
			display.Message.showMessage("Failed to import database.");
	    }
	}
//************************************************************
/**
*	Create Window
*/
//************************************************************
	public static void 		createWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screen = new window.Base();
					screen.wipe();
				} catch (Exception e) {
					display.Message.showMessage("Failed to open window.");
				}
			}
		});
	}
//************************************************************
/**
*	Run Game
*/
//************************************************************
	public static void 		main(String[] args) {
		if (window.Base.width() < 500)
			display.Message.showMessage("Resolution too low.");
		else {
			//build database
			loadDatabase();
			Debugger.dataDump();
			//initialize game
			Debugger.initGame();
			//show window
			createWindow();
		}
	}
}
