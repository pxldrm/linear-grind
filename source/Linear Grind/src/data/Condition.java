//************************************************************
/**
*	Condition 	Defines attributes for enemy behavior conditions.
*	
*	@author		pxldrm
*	@since		7/16/2017
* 	@update 	
*/
//************************************************************
package data;
public class Condition {
//************************************************************
/**
*	Method for checking conditions
*/
//************************************************************
	public static boolean check(int cond, battler.Base a, battler.Base b){
		boolean result = false;
		switch(cond){
		case 0:
			result = a.lv() > b.lv() ? true : false;
			break;
		case 1:
			result = a.hp() > b.hp() ? true : false;
			break;
		case 2:
			result = b.mhp() / 2 >= b.hp() ? true : false;
			break;
		}
		return result;
	}
}
