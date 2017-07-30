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
import calc.Behavior;
import data.Global;
import game.Type;
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
			a += attributeList[i] 				+ display.Base.space(6 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 				+ display.Base.space(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillList.length; i++){
			if (skillList[i] != null)
				c += skillList[i].name() 		+ display.Base.space(15 - skillList[i].name().length());
		}
		for (int i = 0; i < armorList.length; i++){
			if (armorList[i] != null)
				d += armorList[i].name() 		+ display.Base.space(10 - armorList[i].name().length());
		}
		for (int i = 0; i < itemList.length; i++){
			if (itemList[i] != null)
				e += itemList[i].name() 		+ display.Base.space(10 - itemList[i].name().length());
		}
		for (int i = 0; i < weaponList.length; i++){
			if (weaponList[i] != null)
				f += weaponList[i].name() 		+ display.Base.space(10 - weaponList[i].name().length());
		}
		for (int i = 0; i < behavior.length; i++){
			if (behavior[i] != null)
				g += behavior[i].id() 			+ display.Base.space(2 - String.valueOf(behavior[i].id()).length());
		}
		return 	id 					+ display.Base.space(3 - String.valueOf(id).length()) +
				name 				+ display.Base.space(25 - name.length()) +
				a 					+ display.Base.space(20 - a.length()) +
				b 					+ display.Base.space(50 - b.length()) +
				c 					+ display.Base.space(75 - c.length()) +
				lv 					+ display.Base.space(3 - String.valueOf(lv).length()) +
				exp 				+ display.Base.space(6 - String.valueOf(exp).length()) +
				enemyType.name() 	+ display.Base.space(10 - enemyType.name().length()) +
				gold 				+ display.Base.space(6 - String.valueOf(gold).length()) +
				d 					+ display.Base.space(30 - d.length()) +
				e 					+ display.Base.space(20 - e.length()) +
				f 					+ display.Base.space(30 - f.length()) +
				g;
	}
}
