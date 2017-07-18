//************************************************************
/**
*	RunGame 	Main driver for application.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package main;
import java.sql.SQLException;
import battler.*;
import data.Condition;
import data.DBImport;
import data.Global;
public class RunGame{
	private static void 	debugger(){
	    System.out.println(		"\n\n*****************************************\n\n"
				    		+ 	"*              DEBUGGER                 *\n\n"
				    		+ 	"*****************************************");
	    Actor actor = Global.actors[0];
	    Enemy enemy = Global.enemies[0];
	    System.out.println(Condition.check(enemy.behavior()[0].condition()[0], actor, enemy));
	}
	private static void 	dataDump(){
	    System.out.println(		"\n\n*****************************************\n\n"
				    		+ 	"*              DATA DUMP                *\n\n"
				    		+ 	"*****************************************");
	    //data
    	System.out.println("===================================BEHAVIORS");
	    for(int i = 0; i < Global.behaviors.length; i++){
	    	System.out.println(Global.behaviors[i].toString());
	    }
    	System.out.println("===================================ROLES");
	    for(int i = 0; i < Global.roles.length; i++){
	    	System.out.println(Global.roles[i].toString());
	    }
	    //types
    	System.out.println("===================================ARMOR TYPES");
	    for(int i = 0; i < Global.armorTypes.length; i++){
	    	System.out.println(Global.armorTypes[i].toString());
	    }
    	System.out.println("===================================ATTRIBUTE TYPES");
	    for(int i = 0; i < Global.attributeTypes.length; i++){
	    	System.out.println(Global.attributeTypes[i].toString());
	    }
    	System.out.println("===================================DAMAGE TYPES");
	    for(int i = 0; i < Global.damageTypes.length; i++){
	    	System.out.println(Global.damageTypes[i].toString());
	    }
    	System.out.println("===================================EFFECT TYPES");
	    for(int i = 0; i < Global.effectTypes.length; i++){
	    	System.out.println(Global.effectTypes[i].toString());
	    }
    	System.out.println("===================================ELEMENT TYPES");
	    for(int i = 0; i < Global.elementTypes.length; i++){
	    	System.out.println(Global.elementTypes[i].toString());
	    }
    	System.out.println("===================================ENEMY TYPES");
	    for(int i = 0; i < Global.enemyTypes.length; i++){
	    	System.out.println(Global.enemyTypes[i].toString());
	    }
    	System.out.println("===================================ITEM TYPES");
	    for(int i = 0; i < Global.itemTypes.length; i++){
	    	System.out.println(Global.itemTypes[i].toString());
	    }
    	System.out.println("===================================MAP TYPES");
	    for(int i = 0; i < Global.mapTypes.length; i++){
	    	System.out.println(Global.mapTypes[i].toString());
	    }
    	System.out.println("===================================SHOP TYPES");
	    for(int i = 0; i < Global.shopTypes.length; i++){
	    	System.out.println(Global.shopTypes[i].toString());
	    }
    	System.out.println("===================================SKILL TYPES");
	    for(int i = 0; i < Global.skillTypes.length; i++){
	    	System.out.println(Global.skillTypes[i].toString());
	    }
    	System.out.println("===================================WEAPON TYPES");
	    for(int i = 0; i < Global.weaponTypes.length; i++){
	    	System.out.println(Global.weaponTypes[i].toString());
	    }
	    //items
    	System.out.println("===================================ARMORS");
	    for(int i = 0; i < Global.armors.length; i++){
	    	System.out.println(Global.armors[i].toString());
	    }
    	System.out.println("===================================ITEMS");
	    for(int i = 0; i < Global.items.length; i++){
	    	System.out.println(Global.items[i].toString());
	    }
    	System.out.println("===================================SKILLS");
	    for(int i = 0; i < Global.skills.length; i++){
	    	System.out.println(Global.skills[i].toString());
	    }
    	System.out.println("===================================WEAPONS");
	    for(int i = 0; i < Global.weapons.length; i++){
	    	System.out.println(Global.weapons[i].toString());
	    }
		//battlers
    	System.out.println("===================================ACTORS");
	    for(int i = 0; i < Global.actors.length; i++){
	    	System.out.println(Global.actors[i].toString());
	    }
    	System.out.println("===================================ENEMIES");
	    for(int i = 0; i < Global.enemies.length; i++){
	    	System.out.println(Global.enemies[i].toString());
	    }
	    //scenes
    	System.out.println("===================================MAPS");
	    for(int i = 0; i < Global.maps.length; i++){
	    	System.out.println(Global.maps[i].toString());
	    }
    	System.out.println("===================================SHOPS");
	    for(int i = 0; i < Global.shops.length; i++){
	    	System.out.println(Global.shops[i].toString());
	    }
	}
	public static void 		main(String[] args){
//************************************************************
/**
*	Build Database
*/
//************************************************************
	    try {
	    	DBImport.importDatabase();
	    }
	    catch (SQLException e ) {
			System.err.println(e.getMessage());
	    }
//************************************************************
/**
*	Testing
*/
//************************************************************
	    dataDump();
	    debugger();
	}
}
