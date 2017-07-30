//************************************************************
/**
*	Base 		Superclass for all battler classes.
*	
*	@author		pxldrm
*	@since		7/14/2017
* 	@update 	
*/
//************************************************************
package battler;
import data.Global;
import item.Skill;
public class Base {
//************************************************************
/**
*	Variables
*/
//************************************************************
	protected int 		id;
	protected String 	name;
	protected int[] 	attributeList;
	protected int[] 	elementList;
	protected Skill[] 	skillList;
	protected int 		lv;
	protected int 		exp;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Base(int id, String name, int[] attributeList, int[] elementList, int[] skillList, int lv, int exp){
		this.id 			= id;
		this.name 			= name;
		this.attributeList 	= attributeList;
		this.elementList 	= elementList;
		this.skillList 		= new Skill[skillList.length];
		for (int i = 0; i < skillList.length; i++){
			if (skillList[i] != -1)
				this.skillList[i] 	= Global.skills[skillList[i]];
		}
		this.lv 			= lv;
		this.exp 			= exp;
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
	public int[] 		attributeList(){
		return attributeList;
	}
	public int 			hp(){
		return attributeList[0];
	}
	public int 			mp(){
		return attributeList[1];
	}
	public int 			mhp(){
		return attributeList[2];
	}
	public int 			mmp(){
		return attributeList[3];
	}
	public int 			atk(){
		return attributeList[4];
	}
	public int 			def(){
		return attributeList[5];
	}
	public int 			mat(){
		return attributeList[6];
	}
	public int 			mdf(){
		return attributeList[7];
	}
	public int 			agi(){
		return attributeList[8];
	}
	public int 			luk(){
		return attributeList[9];
	}
	public int[] 		elementList(){
		return elementList;
	}
	public Skill[] 		skillList(){
		return skillList;
	}
	public int 			lv(){
		return lv;
	}
	public int 			exp(){
		return exp;
	}
//************************************************************
/**
*	Mutators
*/
//************************************************************
	public void addHp(int hp){
		attributeList[0] += hp;
	}
}
