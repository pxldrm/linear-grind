//************************************************************
/**
*	Actor 		Defines attributes for Actors.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package battler;
import data.Global;
import data.Role;
public class Actor extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private Role 		role;
	private item.Base[] equipmentList;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Actor(int id, String name, int[] attributeList, int[] elementList, int[] skillList, int lv, int exp, int role, int[] equipmentList){
		super(id, name, attributeList, elementList, skillList, lv, exp);
		this.role 		= Global.roles[role];
		for (int i = 0; i < this.role.skillLearned().length; i++){
			if (this.role.skillLearned()[i] != -1 && this.role.lvLearned()[i] != -1 && this.lv >= this.role.lvLearned()[i])
				this.skillList[i] 	= Global.skills[this.role.skillLearned()[i]];
		}
		this.equipmentList 		= new item.Base[equipmentList.length];
		if (equipmentList[0] != -1)
			this.equipmentList[0] 	= Global.weapons[equipmentList[0]];
		if (equipmentList[1] != -1)
			this.equipmentList[1] 	= Global.armors[equipmentList[1]];
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
			a += attributeList[i] 				+ Global.spaces(4 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 				+ Global.spaces(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillList.length; i++){
			if (skillList[i] != null)
				c += skillList[i].name() 		+ Global.spaces(10 - skillList[i].name().length());
		}
		for (int i = 0; i < equipmentList.length; i++){
			if (equipmentList[i] != null)
				d += equipmentList[i].name() 	+ Global.spaces(10 - equipmentList[i].name().length());
		}
		return 	id 			+ Global.spaces(3 - String.valueOf(id).length()) +
				name 		+ Global.spaces(10 - name.length()) +
				a 			+ Global.spaces(20 - a.length()) +
				b 			+ Global.spaces(50 - b.length()) +
				c 			+ Global.spaces(60 - c.length()) +
				lv 			+ Global.spaces(3 - String.valueOf(lv).length()) +
				exp 		+ Global.spaces(6 - String.valueOf(exp).length()) +
				role.name() + Global.spaces(10 - role.name().length()) +
				d;
	}
}
