//************************************************************
/**
*	Weapon 		Defines attributes for Weapons.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	8/8/2017
*/
//************************************************************
package item;
import data.Global;
import game.Type;
public class Weapon extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Type 	weaponType;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Weapon(int id, String name, int cost, int[] effectType, int damageType, int[] attributeList, int[] elementList, int weaponType, String description){
		super(id, name, cost, effectType, damageType, attributeList, elementList, description);
		this.weaponType 	= Global.weaponTypes[weaponType];
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Type 	weaponType(){
		return weaponType;
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
				weaponType.name() 	+ display.Base.space(15 - weaponType.name().length()) +
				description;
	}
}
