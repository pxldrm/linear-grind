//************************************************************
/**
*	Behavior 	Defines attributes for enemy behavior.
*	
*	@author		pxldrm
*	@since		7/15/2017
* 	@update 	7/17/2017
*/
//************************************************************
package calc;

import display.Base;

public class Behavior {
//************************************************************
/**
*	Variables
*/
//************************************************************
	private int 	id;
	private int[] 	probability;
	private int[] 	turnCount;
	private int[] 	condition;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 			Behavior(int id, int[] probability, int[] turnCount, int[] condition){
		this.id 			= id;
		this.probability 	= probability;
		this.turnCount 		= turnCount;
		this.condition 		= condition;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 		id(){
		return id;
	}
	public int[] 	probability(){
		return probability;
	}
	public int[] 	turnCount(){
		return turnCount;
	}
	public int[] 	condition(){
		return condition;
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
		for (int i = 0; i < probability.length; i++){
			a += probability[i] 	+ Base.space(4 - String.valueOf(probability[i]).length());
		}
		for (int i = 0; i < turnCount.length; i++){
			b += turnCount[i] 		+ Base.space(3 - String.valueOf(turnCount[i]).length());
		}
		for (int i = 0; i < condition.length; i++){
			c += condition[i] 		+ Base.space(3 - String.valueOf(condition[i]).length());
		}
		return 	id 					+ Base.space(5 - String.valueOf(id).length()) +
				a 					+ Base.space(30 - a.length()) +
				b 					+ Base.space(20 - b.length()) +
				c;
	}
}
