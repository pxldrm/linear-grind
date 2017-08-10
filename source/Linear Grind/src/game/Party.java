//************************************************************
/**
*	Party 		Defines party attributes.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	8/4/2017
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
	private static int 		WEAPON_INV_SIZE = 10;
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
	public static void 		removeItem(int item){
		items[item] = null;
		//sort items
		itemCount = 0;
		item.Base[] temp = new item.Base[items.length];
		for (int i = 0; i < items.length; i++){
			if (items[i] != null){
				temp[itemCount] = items[i];
				itemCount += 1;
			}
		}
		for (int i = 0; i < itemCount; i++)
			items[i] = (Item)temp[i];
		for (int i = itemCount; i < items.length; i++)
			items[i] = null;
	}
	public static void 		removeWeapon(int item){
		weapons[item] = null;
		//sort weapons
		weaponCount = 0;
		item.Base[] temp = new item.Base[weapons.length];
		for (int i = 0; i < weapons.length; i++){
			if (weapons[i] != null){
				temp[weaponCount] = weapons[i];
				weaponCount += 1;
			}
		}
		for (int i = 0; i < weaponCount; i++)
			weapons[i] = (Weapon)temp[i];
		for (int i = weaponCount; i < weapons.length; i++)
			weapons[i] = null;
	}
	public static void 		removeArmor(int item){
		armors[item] = null;
		//sort armors
		armorCount = 0;
		item.Base[] temp = new item.Base[armors.length];
		for (int i = 0; i < armors.length; i++){
			if (armors[i] != null){
				temp[armorCount] = armors[i];
				armorCount += 1;
			}
		}
		for (int i = 0; i < armorCount; i++)
			armors[i] = (Armor)temp[i];
		for (int i = armorCount; i < armors.length; i++)
			armors[i] = null;
	}
	public static void 		addGold(int g){
		gold += g;
	}
}
