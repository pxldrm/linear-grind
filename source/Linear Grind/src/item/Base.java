//************************************************************
/**
*	Base 		Superclass for all item classes.
*	
*	@author		pxldrm
*	@since		7/11/2017
* 	@update 	7/24/2017
*/
//************************************************************
package item;
import data.Global;
import game.Type;
public class Base {
//************************************************************
/**
*	Variables
*/
//************************************************************
	protected int 		id;
	protected String 	name;
	protected int 		cost;
	protected Type[] 	effectType;
	protected int[] 	attributeList;
	protected int[] 	elementList;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Base(int id, String name, int cost, int[] effectType, int[] attributeList, int[] elementList){
		this.id 			= id;
		this.name 			= name;
		this.cost 			= cost;
		this.effectType 	= new Type[effectType.length];
		for (int i = 0; i < effectType.length; i++){
			this.effectType[i] 	= Global.effectTypes[effectType[i]];
		}
		this.attributeList 	= attributeList;
		this.elementList 	= elementList;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 			id(){
		return id;
	}
	public String 		name (){
		return name;
	}
	public int 			cost(){
		return cost;
	}
	public Type[] 		effectType(){
		return effectType;
	}
	public int[] 		attributeList(){
		return attributeList;
	}
	public int[] 		elementList(){
		return elementList;
	}
//************************************************************
/**
*	Booleans
*/
//************************************************************
	public boolean 		isArmor()
	{
		if (this.getClass().equals(Armor.class))
			return true;
		else
			return false;
	}
	public boolean 		isItem()
	{
		if (this.getClass().equals(Item.class))
			return true;
		else
			return false;
	}
	public boolean 		isSkill()
	{
		if (this.getClass().equals(Skill.class))
			return true;
		else
			return false;
	}
	public boolean 		isWeapon()
	{
		if (this.getClass().equals(Weapon.class))
			return true;
		else
			return false;
	}
}
