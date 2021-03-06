//************************************************************
/**
*	Global 		Defines the internal database that is referenced in-game.
*	
*	@author		pxldrm
*	@since		7/13/2017
* 	@update 	7/30/2017
*/
//************************************************************
package data;
import battler.*;
import calc.Behavior;
import game.Role;
import game.Type;
import item.*;
import scene.*;
public class Global {
//Data
	public static Behavior[] 	behaviors;
	public static Role[] 		roles;
	//Types
	public static Type[] 		accessoryTypes;
	public static Type[] 		armorTypes;
	public static Type[] 		attributeTypes;
	public static Type[] 		bodyTypes;
	public static Type[] 		damageTypes;
	public static Type[] 		effectTypes;
	public static Type[] 		elementTypes;
	public static Type[] 		enemyTypes;
	public static Type[] 		equipmentTypes;
	public static Type[] 		helmetTypes;
	public static Type[] 		itemTypes;
	public static Type[] 		mapTypes;
	public static Type[] 		shieldTypes;
	public static Type[] 		shopTypes;
	public static Type[] 		skillTypes;
	public static Type[] 		weaponTypes;
	//Items
	public static Armor[] 		armors;
	public static Item[] 		items;
	public static Skill[] 		skills;
	public static Weapon[] 		weapons;
	//Battlers
	public static Actor[] 		actors;
	public static Enemy[] 		enemies;
	//Scenes
	public static Shop[] 		shops;
	public static Map[] 		maps;
}
