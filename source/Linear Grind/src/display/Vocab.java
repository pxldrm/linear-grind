//************************************************************
/**
*	Vocab 		Defines vocabulary used in game.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	7/30/2017
*/
//************************************************************
package display;

import data.Global;

public class Vocab {
//************************************************************
/**
*	Variables
*/
//************************************************************
	public static final String title 		= "Linear Grind";
	public static final String gameOver 	= "Game Over";
	//attributes
	public static final String hp 			= Global.attributeTypes[0].name();
	public static final String mp 			= Global.attributeTypes[1].name();
	public static final String mhp 			= Global.attributeTypes[2].name();
	public static final String mmp 			= Global.attributeTypes[3].name();
	public static final String atk 			= Global.attributeTypes[4].name();
	public static final String def 			= Global.attributeTypes[5].name();
	public static final String mat 			= Global.attributeTypes[6].name();
	public static final String mdf 			= Global.attributeTypes[7].name();
	public static final String agi 			= Global.attributeTypes[8].name();
	public static final String luk 			= Global.attributeTypes[9].name();
	public static final String lv 			= Global.attributeTypes[10].name();
	public static final String exp 			= Global.attributeTypes[11].name();
	public static final String gold 		= Global.attributeTypes[12].name();
	public static final String next 		= "next";
	//menu vocab
	public static final String equipment 	= "equipment";
	public static final String empty 		= "empty";
	public static final String weapon 		= Global.equipmentTypes[0].name();
	public static final String shield 		= Global.equipmentTypes[1].name();
	public static final String helmet 		= Global.equipmentTypes[2].name();
	public static final String armor 		= Global.equipmentTypes[3].name();
	public static final String accessory1 	= Global.equipmentTypes[4].name();
	public static final String accessory2 	= Global.equipmentTypes[4].name();
	public static final String[] equipmentList = {	weapon,
													shield,
													helmet,
													armor,
													accessory1,
													accessory2};
}
