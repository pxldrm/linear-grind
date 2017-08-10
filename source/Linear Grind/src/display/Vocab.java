//************************************************************
/**
*	Vocab 		Defines vocabulary used in game.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	8/8/2017
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
	public static final String[] attributeList 		= {	hp,
														mp,
														mhp,
														mmp,
														atk,
														def,
														mat,
														mdf,
														agi,
														luk,
														lv,
														exp,
														gold};
	public static final String[] elementList 		= {	Global.elementTypes[0].name(),
														Global.elementTypes[1].name(),
														Global.elementTypes[2].name(),
														Global.elementTypes[3].name(),
														Global.elementTypes[4].name(),
														Global.elementTypes[5].name(),
														Global.elementTypes[6].name(),
														Global.elementTypes[7].name(),
														Global.elementTypes[8].name(),
														Global.elementTypes[9].name(),
														Global.elementTypes[10].name(),};
	public static final String next 		= "next";
	//menu vocab
	public static final String use 			= "use";
	public static final String equip 		= "equip";
	public static final String discard 		= "discard";
	public static final String items 		= "items";
	public static final String weapons 		= "weapons";
	public static final String armors 		= "armor";
	public static final String skills 		= "skills";
	public static final String equipment 	= "equipment";
	public static final String empty 		= "empty";
	public static final String back 		= "back";
	public static final String exit 		= "exit";
	public static final String weapon 		= Global.equipmentTypes[0].name();
	public static final String shield 		= Global.equipmentTypes[1].name();
	public static final String helmet 		= Global.equipmentTypes[2].name();
	public static final String armor 		= Global.equipmentTypes[3].name();
	public static final String accessory1 	= Global.equipmentTypes[4].name();
	public static final String accessory2 	= Global.equipmentTypes[4].name();
	public static final String[] equipmentList 		= {	weapon,
														shield,
														helmet,
														armor,
														accessory1,
														accessory2};
	//main menu
	public static final String[] MAIN_NAV_NAMES 	= {	"status",
														"skills",
														"inventory",
														"options",
														exit};
	public static final String[] INV_NAV_NAMES 		= {	items,
														weapons,
														armors,
														back};
}
