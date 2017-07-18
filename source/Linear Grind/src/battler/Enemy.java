//************************************************************
/**
*	Enemy 		Defines attributes for Enemies.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package battler;
import data.Behavior;
import data.Global;
import data.Type;
import item.*;
public class Enemy extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Type 		enemyType;
	private int 		gold;
	private Armor[] 	armorList;
	private Item[] 		itemList;
	private Weapon[] 	weaponList;
	private Behavior[] 	behavior;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Enemy(int id, String name, int[] attributeList, int[] elementList, int[] skillList, int lv, int exp, int enemyType, int gold, int[] armorList, int[] itemList, int[] weaponList, int[] behavior){
		super(id, name, attributeList, elementList, skillList, lv, exp);
		this.enemyType 		= Global.enemyTypes[enemyType];
		this.gold 			= gold;
		this.armorList 		= new Armor[armorList.length];
		for (int i = 0; i < armorList.length; i++){
			if (armorList[i] != -1)
				this.armorList[i] 	= Global.armors[armorList[i]];
		}
		this.itemList 		= new Item[itemList.length];
		for (int i = 0; i < itemList.length; i++){
			if (itemList[i] != -1)
				this.itemList[i] 	= Global.items[itemList[i]];
		}
		this.weaponList 		= new Weapon[weaponList.length];
		for (int i = 0; i < weaponList.length; i++){
			if (weaponList[i] != -1)
				this.weaponList[i] 	= Global.weapons[weaponList[i]];
		}
		this.behavior 		= new Behavior[behavior.length];
		for (int i = 0; i < behavior.length; i++){
			this.behavior[i] 	= Global.behaviors[behavior[i]];
		}
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Type 		enemyType(){
		return enemyType;
	}
	public int 			gold(){
		return gold;
	}
	public Armor[] 		armorList(){
		return armorList;
	}
	public Item[] 		itemList(){
		return itemList;
	}
	public Weapon[] 	weaponList(){
		return weaponList;
	}
	public Behavior[] 	behavior(){
		return behavior;
	}
//************************************************************
/**
*	Output as String
*/
//************************************************************
	public String 		toString(){
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		String e = "";
		String f = "";
		String g = "";
		for (int i = 0; i < attributeList.length; i++){
			a += attributeList[i] 				+ Global.spaces(6 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 				+ Global.spaces(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillList.length; i++){
			if (skillList[i] != null)
				c += skillList[i].name() 		+ Global.spaces(15 - skillList[i].name().length());
		}
		for (int i = 0; i < armorList.length; i++){
			if (armorList[i] != null)
				d += armorList[i].name() 		+ Global.spaces(10 - armorList[i].name().length());
		}
		for (int i = 0; i < itemList.length; i++){
			if (itemList[i] != null)
				e += itemList[i].name() 		+ Global.spaces(10 - itemList[i].name().length());
		}
		for (int i = 0; i < weaponList.length; i++){
			if (weaponList[i] != null)
				f += weaponList[i].name() 		+ Global.spaces(10 - weaponList[i].name().length());
		}
		for (int i = 0; i < behavior.length; i++){
			if (behavior[i] != null)
				g += behavior[i].id() 			+ Global.spaces(2 - String.valueOf(behavior[i].id()).length());
		}
		return 	id 					+ Global.spaces(3 - String.valueOf(id).length()) +
				name 				+ Global.spaces(25 - name.length()) +
				a 					+ Global.spaces(20 - a.length()) +
				b 					+ Global.spaces(50 - b.length()) +
				c 					+ Global.spaces(75 - c.length()) +
				lv 					+ Global.spaces(3 - String.valueOf(lv).length()) +
				exp 				+ Global.spaces(6 - String.valueOf(exp).length()) +
				enemyType.name() 	+ Global.spaces(10 - enemyType.name().length()) +
				gold 				+ Global.spaces(6 - String.valueOf(gold).length()) +
				d 					+ Global.spaces(30 - d.length()) +
				e 					+ Global.spaces(20 - e.length()) +
				f 					+ Global.spaces(30 - f.length()) +
				g;
	}
}
