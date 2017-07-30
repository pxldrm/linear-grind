//************************************************************
/**
*	Type 		Defines attributes for Types.
*	
*	@author		pxldrm
*	@since		7/13/2017
* 	@update 	7/17/2017
*/
//************************************************************
package game;

import display.Base;

public class Type {
//************************************************************
/**
*	Variables
*/
//************************************************************
	private final int 		id;
	private final String 	name;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 					Type(int id, String name){
		this.id 	= id;
		this.name 	= name;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 				id(){
		return id;
	}
	public String 			name(){
		return name;
	}
//************************************************************
/**
*	Output as String
*/
//************************************************************
	public String 			toString(){
		return 	id 			+ Base.space(3 - String.valueOf(id).length()) +
				name;
	}
}
