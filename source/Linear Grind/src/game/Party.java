//************************************************************
/**
*	Party 		Defines party attributes.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/24/2017
*/
//************************************************************
package game;
import battler.Actor;
import item.*;
public class Party {
//************************************************************
/**
*	Variables
*/
//************************************************************
	//game constants
	private static int 		PARTY_SIZE 		= 4;
	private static int 		ARMOR_INV_SIZE 	= 10;
	private static int 		ITEM_INV_SIZE 	= 10;
	private static int 		WEAPON_INV_SIZE = 4;
	//counters
	private static int 		memberCount 	= 0;
	private static int 		armorCount 		= 0;
	private static int 		itemCount 		= 0;
	private static int 		weaponCount 	= 0;
	//party attributes
	private static Actor[] 	members 		= new Actor[PARTY_SIZE];
	private static Armor[] 	armors 			= new Armor[ARMOR_INV_SIZE];
	private static Item[] 	items 			= new Item[ITEM_INV_SIZE];
	private static Weapon[] weapons 		= new Weapon[WEAPON_INV_SIZE];
	private static int 		gold 			= 0;
//************************************************************
/**
*	Accessors
*/
//************************************************************
	//counters
	public static int 		memberCount(){
		return memberCount;
	}
	public static int 		armorCount(){
		return armorCount;
	}
	public static int 		itemCount(){
		return itemCount;
	}
	public static int 		weaponCount(){
		return weaponCount;
	}
	//party attributes
	public static Actor[] 	members(){
		return members;
	}
	public static Armor[] 	armors(){
		return armors;
	}
	public static Item[] 	items(){
		return items;
	}
	public static Weapon[] 	weapons(){
		return weapons;
	}
	public static int 		gold(){
		return gold;
	}
//************************************************************
/**
*	Booleans
*/
//************************************************************
	public static boolean 	isFull(item.Base[] inv){
		if (inv.equals(armors)){
			if (armorCount == inv.length)
				return true;
			else
				return false;
		}
		if (inv.equals(items)){
			if (itemCount == inv.length)
				return true;
			else
				return false;
		}
		if (inv.equals(weapons)){
			if (weaponCount == inv.length)
				return true;
			else
				return false;
		}
		return true;
	}
//************************************************************
/**
*	Mutators
*/
//************************************************************
	public static void 		addMember(Actor actor){
		for(int i = 0; i < PARTY_SIZE; i++){
			if(members[i] == null){
				members[i] = actor;
				memberCount += 1;
				break;
			}
		}
	}
	public static void 		addItem(item.Base item){
		if (item.isArmor()){
			for(int i = 0; i < ARMOR_INV_SIZE; i++){
				if(armors[i] == null){
					armors[i] = (Armor)item;
					armorCount += 1;
					break;
				}
			}
		}
		if (item.isItem()){
			for(int i = 0; i < ITEM_INV_SIZE; i++){
				if(items[i] == null){
					items[i] = (Item)item;
					itemCount += 1;
					break;
				}
			}
		}
		if (item.isWeapon()){
			for(int i = 0; i < WEAPON_INV_SIZE; i++){
				if(weapons[i] == null){
					weapons[i] = (Weapon)item;
					weaponCount += 1;
					break;
				}
			}
		}
	}
	public static void 		addGold(int g){
		gold += g;
	}
}
