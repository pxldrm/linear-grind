//************************************************************
/**
*	Armor 		Defines attributes for Armors.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package item;
import data.Global;
import data.Type;
//************************************************************
/**
*	Variables
*/
//************************************************************
public class Armor extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Type 	armorType;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Armor(int id, String name, int cost, int[] effectType, int[] attributeList, int[] elementList, int armorType){
		super(id, name, cost, effectType, attributeList, elementList);
		this.armorType 		= Global.armorTypes[armorType];
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Type 	armorType(){
		return armorType;
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
				a += effectType[i].name() 		+ Global.spaces(10 - effectType[i].name().length());
		}
		for (int i = 0; i < attributeList.length; i++){
			b += attributeList[i] 				+ Global.spaces(5 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			c += elementList[i] 				+ Global.spaces(4 - String.valueOf(elementList[i]).length());
		}
		return 	id 					+ Global.spaces(3 - String.valueOf(id).length()) +
				name 				+ Global.spaces(20 - name.length()) +
				cost 				+ Global.spaces(10 - String.valueOf(cost).length()) +
				a 					+ Global.spaces(20 - a.length()) +
				b 					+ Global.spaces(45 - b.length()) +
				c 					+ Global.spaces(50 - c.length()) +
				armorType.name();
	}
}
