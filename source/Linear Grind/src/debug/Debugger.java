//************************************************************
/**
*	Debugger 	Defines methods used for testing.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	8/10/2017
*/
//************************************************************
package debug;
import battler.Actor;
import data.Global;
import game.Party;
public class Debugger{
//************************************************************
/**
*	Variables
*/
//************************************************************

//************************************************************
/**
*	Debugging methods
*/
//************************************************************
	public static void 	test(){
//		window.output.setText(Message.open 	+ "<br><br>*****************************************<br><br>"
//	    									+ "*" + htmlSpace(20) + " DEBUGGER " + htmlSpace(21) + " *<br><br>"
//	    									+ 	"*****************************************" + Message.close);

//	    Actor actor = Global.actors[0];
//	    Enemy enemy = Global.enemies[0];
//	    System.out.println(Condition.check(enemy.behavior()[0].condition()[0], actor, enemy));
	}
	public static void 	dataDump(){
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
    	System.out.println("===================================ACCESSORY TYPES");
	    for(int i = 0; i < Global.accessoryTypes.length; i++){
	    	System.out.println(Global.accessoryTypes[i].toString());
	    }
    	System.out.println("===================================ARMOR TYPES");
	    for(int i = 0; i < Global.armorTypes.length; i++){
	    	System.out.println(Global.armorTypes[i].toString());
	    }
    	System.out.println("===================================ATTRIBUTE TYPES");
	    for(int i = 0; i < Global.attributeTypes.length; i++){
	    	System.out.println(Global.attributeTypes[i].toString());
	    }
    	System.out.println("===================================BODY TYPES");
	    for(int i = 0; i < Global.bodyTypes.length; i++){
	    	System.out.println(Global.bodyTypes[i].toString());
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
    	System.out.println("===================================EQUIPMENT TYPES");
	    for(int i = 0; i < Global.equipmentTypes.length; i++){
	    	System.out.println(Global.equipmentTypes[i].toString());
	    }
    	System.out.println("===================================HELMET TYPES");
	    for(int i = 0; i < Global.helmetTypes.length; i++){
	    	System.out.println(Global.helmetTypes[i].toString());
	    }
    	System.out.println("===================================ITEM TYPES");
	    for(int i = 0; i < Global.itemTypes.length; i++){
	    	System.out.println(Global.itemTypes[i].toString());
	    }
    	System.out.println("===================================MAP TYPES");
	    for(int i = 0; i < Global.mapTypes.length; i++){
	    	System.out.println(Global.mapTypes[i].toString());
	    }
    	System.out.println("===================================SHIELD TYPES");
	    for(int i = 0; i < Global.shieldTypes.length; i++){
	    	System.out.println(Global.shieldTypes[i].toString());
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
	public static void 	initGame(){
		//party members
		Party.addMember(Global.actors[0]);
		Party.addMember(Global.actors[1]);
		Party.addMember(Global.actors[2]);
		Party.addMember(Global.actors[3]);
		//equipment		
		Party.members()[0].equipmentList()[0] = Global.weapons[3];
		Party.members()[0].equipmentList()[1] = Global.armors[2];
		Party.members()[0].equipmentList()[2] = Global.armors[11];
		Party.members()[0].equipmentList()[3] = Global.armors[20];
		
		Party.members()[1].equipmentList()[0] = Global.weapons[6];
		Party.members()[1].equipmentList()[1] = Global.armors[5];
		Party.members()[1].equipmentList()[2] = Global.armors[14];
		Party.members()[1].equipmentList()[3] = Global.armors[23];

		
		Party.members()[2].equipmentList()[0] = Global.weapons[0];
		Party.members()[2].equipmentList()[1] = Global.armors[0];
		Party.members()[2].equipmentList()[2] = Global.armors[9];
		Party.members()[2].equipmentList()[3] = Global.armors[18];
		
		Party.members()[3].equipmentList()[0] = Global.weapons[13];
		Party.members()[3].equipmentList()[2] = Global.armors[9];
		Party.members()[3].equipmentList()[3] = Global.armors[18];
		//inventory
		Party.addItem(Global.armors[0]);
		Party.addItem(Global.armors[5]);
		Party.addItem(Global.armors[10]);
		Party.addItem(Global.armors[15]);
		Party.addItem(Global.armors[15]);

		Party.addItem(Global.items[0]);
		Party.addItem(Global.items[1]);
		Party.addItem(Global.items[2]);
		Party.addItem(Global.items[3]);
		Party.addItem(Global.items[4]);
		Party.addItem(Global.items[0]);
		Party.addItem(Global.items[1]);
		Party.addItem(Global.items[2]);
		Party.addItem(Global.items[3]);
		Party.addItem(Global.items[4]);
		
		Party.addItem(Global.weapons[0]);
		Party.addItem(Global.weapons[4]);
		Party.addItem(Global.weapons[8]);
		Party.addItem(Global.weapons[12]);
		Party.addItem(Global.weapons[12]);
		
		Party.addGold(100);
		//testing
		for (Actor a: Party.members())
			a.modHp(-(a.mhp()) + 1);
		
	}
}
