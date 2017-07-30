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
import game.Type;
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
	private Type 	weightType;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Armor(int id, String name, int cost, int[] effectType, int[] attributeList, int[] elementList, int armorType, int weightType){
		super(id, name, cost, effectType, attributeList, elementList);
		this.armorType 		= Global.armorTypes[armorType];
		if (armorType == 0)
			this.weightType 	= Global.shieldTypes[weightType];
		if (armorType == 1)
			this.weightType 	= Global.helmetTypes[weightType];
		if (armorType == 2)
			this.weightType 	= Global.bodyTypes[weightType];
		if (armorType == 3)
			this.weightType 	= Global.accessoryTypes[weightType];;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Type 	armorType(){
		return armorType;
	}
	public Type 	weightType(){
		return weightType;
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
				b 					+ display.Base.space(45 - b.length()) +
				c 					+ display.Base.space(50 - c.length()) +
				armorType.name() 	+ display.Base.space(15 - armorType.name().length()) +
				weightType.name();
	}
}
