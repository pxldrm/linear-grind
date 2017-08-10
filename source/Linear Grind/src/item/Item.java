//************************************************************
/**
*	Item 		Defines attributes for Items.
*	
*	@author		pxldrm
*	@since		7/11/2017
* 	@update 	8/8/2017
*/
//************************************************************
package item;
import data.Global;
import game.Type;
public class Item extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Type 	itemType;
	private int 	damageValue;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Item(int id, String name, int cost, int[] effectType, int damageType, int[] attributeList, int[] elementList, int itemType, int damageValue, String description){
		super(id, name, cost, effectType, damageType, attributeList, elementList, description);
		this.itemType 		= Global.itemTypes[itemType];
		this.damageValue 	= damageValue;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Type 	itemType(){
		return itemType;
	}
	public int 		damageValue(){
		return damageValue;
	}
//************************************************************
/**
*	Output as String
*/
//************************************************************
	public String 	toString(){
		String a = "";
		String b = "";
		String c = "";
		for (int i = 0; i < effectType.length; i++){
			if (effectType[i] != null)
				a += effectType[i].name() 		+ display.Base.space(10 - effectType[i].name().length());
		}
		for (int i = 0; i < attributeList.length; i++){
			b += attributeList[i] 				+ display.Base.space(5 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			c += elementList[i] 				+ display.Base.space(4 - String.valueOf(elementList[i]).length());
		}
		return 	id 					+ display.Base.space(3 - String.valueOf(id).length()) +
				name 				+ display.Base.space(20 - name.length()) +
				cost 				+ display.Base.space(10 - String.valueOf(cost).length()) +
				a 					+ display.Base.space(20 - a.length()) +
				damageType.name() 	+ display.Base.space(10 - damageType.name().length()) +
				b 					+ display.Base.space(45 - b.length()) +
				c 					+ display.Base.space(50 - c.length()) +
				itemType.name() 	+ display.Base.space(15 - itemType.name().length()) +
				damageValue 		+ display.Base.space(5 - String.valueOf(damageValue).length()) +
				description;
	}
}
