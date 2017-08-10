//************************************************************
/**
*	Actor 		Defines attributes for Actors.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	8/7/2017
*/
//************************************************************
package battler;
import data.Global;
import game.Role;
public class Actor extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Role 		role;
	private item.Base[] equipmentList;
	private int 		skillCount = 0;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Actor(int id, String name, int[] attributeList, int[] elementList, int[] skillList, int lv, int exp, int role, int[] equipmentList){
		super(id, name, attributeList, elementList, skillList, lv, exp);
		this.role 		= Global.roles[role];
		for (int i = 0; i < this.role.skillLearned().length; i++){
			if (this.role.skillLearned()[i] != -1 && this.role.lvLearned()[i] != -1 && this.lv >= this.role.lvLearned()[i]){
				this.skillList[i] 		= Global.skills[this.role.skillLearned()[i]];
				skillCount ++;
			}
		}
		this.equipmentList 		= new item.Base[equipmentList.length];
		for (int i = 0; i < this.equipmentList.length; i++){
			if (equipmentList[i] != -1)
				this.equipmentList[i] 	= Global.weapons[equipmentList[i]];
		}
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public Role 		roleType(){
		return role;
	}
	public item.Base[] 	equipmentList(){
		return equipmentList;
	}
	public int 			skillCount(){
		return skillCount;
	}
	public int 			next(){
		return (int) Math.pow(lv * 10, lv);
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
		for (int i = 0; i < attributeList.length; i++){
			a += attributeList[i] 				+ display.Base.space(4 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 				+ display.Base.space(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillList.length; i++){
			if (skillList[i] != null)
				c += skillList[i].name() 		+ display.Base.space(10 - skillList[i].name().length());
		}
		for (int i = 0; i < equipmentList.length; i++){
			if (equipmentList[i] != null)
				d += equipmentList[i].name() 	+ display.Base.space(10 - equipmentList[i].name().length());
		}
		return 	id 			+ display.Base.space(3 - String.valueOf(id).length()) +
				name 		+ display.Base.space(10 - name.length()) +
				a 			+ display.Base.space(20 - a.length()) +
				b 			+ display.Base.space(50 - b.length()) +
				c 			+ display.Base.space(60 - c.length()) +
				lv 			+ display.Base.space(3 - String.valueOf(lv).length()) +
				exp 		+ display.Base.space(6 - String.valueOf(exp).length()) +
				role.name() + display.Base.space(10 - role.name().length()) +
				d;
	}
}
