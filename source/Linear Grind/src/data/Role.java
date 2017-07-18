//************************************************************
/**
*	Role 		Defines attributes for actor roles.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package data;
public class Role {
//************************************************************
/**
*	Variables
*/
//************************************************************
	private int 	id;
	private String 	name;
	private int[] 	attributeList;
	private int[] 	elementList;
	private int[] 	skillLearned;
	private int[] 	lvLearned;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Role(int id, String name, int[] attributeList, int[] elementList, int[] skillLearned, int[] lvLearned){
		this.id 			= id;
		this.name 			= name;
		this.attributeList 	= attributeList;
		this.elementList 	= elementList;
		this.skillLearned 	= skillLearned;
		this.lvLearned 		= lvLearned;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 		id(){
		return id;
	}
	public String 	name (){
		return name;
	}
	public int[] 	attributeList(){
		return attributeList;
	}
	public int[] 	elementList(){
		return elementList;
	}
	public int[] 	skillLearned(){
		return skillLearned;
	}
	public int[] 	lvLearned(){
		return lvLearned;
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
		String d = "";
		for (int i = 0; i < attributeList.length; i++){
			a += attributeList[i] 	+ Global.spaces(3 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 	+ Global.spaces(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillLearned.length; i++){
			c += skillLearned[i] 	+ Global.spaces(3 - String.valueOf(skillLearned[i]).length());
		}
		for (int i = 0; i < lvLearned.length; i++){
			d += lvLearned[i] 		+ Global.spaces(3 - String.valueOf(lvLearned[i]).length());
		}
		return 	id 					+ Global.spaces(3 - String.valueOf(id).length()) +
				name 				+ Global.spaces(20 - name.length()) +
				a 					+ Global.spaces(30 - a.length()) +
				b 					+ Global.spaces(50 - b.length()) +
				c 					+ Global.spaces(50 - b.length()) +
				d;
	}
}
