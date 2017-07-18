//************************************************************
/**
*	Shop 		Defines attributes for Shops.
*	
*	@author		pxldrm
*	@since		7/16/2017
* 	@update 	7/17/2017
*/
//************************************************************
package scene;
import data.Global;
import data.Type;
import item.*;
public class Shop extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private int 		id;
	private String 		name;
	private Type 		shopType;
	private int 		priceRate;
	private item.Base[] itemList;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Shop(int id, String name, int shopType, int priceRate, int[] itemList){
		
		this.id 					= id;
		this.name 					= name;
		this.shopType 				= Global.shopTypes[shopType];
		this.priceRate 				= priceRate;
		switch(shopType){
		case 0:
			this.itemList 			= new Armor[itemList.length];
			for (int i = 0; i < itemList.length; i++){
				if (itemList[i] != -1)
					this.itemList[i] 	= Global.armors[itemList[i]];
			}
			break;
		case 1:
			this.itemList 			= new Item[itemList.length];
			for (int i = 0; i < itemList.length; i++){
				if (itemList[i] != -1)
					this.itemList[i] 	= Global.items[itemList[i]];
			}
			break;
		case 2:
			this.itemList 			= new Weapon[itemList.length];
			for (int i = 0; i < itemList.length; i++){
				if (itemList[i] != -1)
					this.itemList[i] 	= Global.weapons[itemList[i]];
			}
			break;
		case 3:
			this.itemList 			= new item.Base[itemList.length];
			break;
		}
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 			id(){
		return id;
	}
	public String 		name(){
		return name;
	}
	public Type 		shopType(){
		return shopType;
	}
	public int 			priceRate(){
		return priceRate;
	}
	public item.Base[] 	itemList(){
		return itemList;
	}
//************************************************************
/**
*	Output as String
*/
//************************************************************
	public String 		toString(){
		String a = "";
		for (int i = 0; i < itemList.length; i++){
			if (itemList[i] != null)
				a += itemList[i].name() 		+ Global.spaces(25 - itemList[i].name().length());
		}
		return 	id 					+ Global.spaces(3 - String.valueOf(id).length()) +
				name 				+ Global.spaces(20 - name.length()) +
				shopType.name() 	+ Global.spaces(15 - shopType.name().length()) +
				priceRate 			+ Global.spaces(5 - String.valueOf(priceRate).length()) +
				a;
	}
}
