//************************************************************
/**
*	Type 		Defines attributes for Types.
*	
*	@author		pxldrm
*	@since		7/13/2017
* 	@update 	7/17/2017
*/
//************************************************************
package data;
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
		return 	id 			+ Global.spaces(3 - String.valueOf(id).length()) +
				name;
	}
}
