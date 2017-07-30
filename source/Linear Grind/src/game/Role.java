//************************************************************
/**
*	Role 		Defines attributes for actor roles.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	7/17/2017
*/
//************************************************************
package game;

import display.Base;

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
			a += attributeList[i] 	+ Base.space(3 - String.valueOf(attributeList[i]).length());
		}
		for (int i = 0; i < elementList.length; i++){
			b += elementList[i] 	+ Base.space(4 - String.valueOf(elementList[i]).length());
		}
		for (int i = 0; i < skillLearned.length; i++){
			c += skillLearned[i] 	+ Base.space(3 - String.valueOf(skillLearned[i]).length());
		}
		for (int i = 0; i < lvLearned.length; i++){
			d += lvLearned[i] 		+ Base.space(3 - String.valueOf(lvLearned[i]).length());
		}
		return 	id 					+ Base.space(3 - String.valueOf(id).length()) +
				name 				+ Base.space(20 - name.length()) +
				a 					+ Base.space(30 - a.length()) +
				b 					+ Base.space(50 - b.length()) +
				c 					+ Base.space(50 - b.length()) +
				d;
	}
}
