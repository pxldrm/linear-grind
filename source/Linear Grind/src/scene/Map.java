//************************************************************
/**
*	Map 		Defines attributes for Maps.
*	
*	@author		pxldrm
*	@since		7/16/2017
* 	@update 	7/17/2017
*/
//************************************************************
package scene;
import battler.Enemy;
import data.Global;
import data.Type;
public class Map extends Base{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private int 		id;
	private String 		name;
	private Type 		mapType;
	private Enemy[] 	enemyList;
	private int[] 		probabilityList;
	private Shop[] 		shopList;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Map(int id, String name, int mapType, int[] enemyList, int[] probabilityList, int[] shopList){
		
		this.id 				= id;
		this.name 				= name;
		this.mapType 			= Global.mapTypes[mapType];
		this.enemyList 			= new Enemy[enemyList.length];
		for (int i = 0; i < enemyList.length; i++){
			if (enemyList[i] != -1)
				this.enemyList[i] 	= Global.enemies[enemyList[i]];
		}
		this.probabilityList 	= probabilityList;
		this.shopList 			= new Shop[shopList.length];
		for (int i = 0; i < shopList.length; i++){
			if (shopList[i] != -1)
				this.shopList[i] 	= Global.shops[shopList[i]];
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
	public Type 		mapType(){
		return mapType;
	}
	public Enemy[] 		enemyList(){
		return enemyList;
	}
	public int[] 		probabilityList(){
		return probabilityList;
	}
	public Shop[] 		shopList(){
		return shopList;
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
		for (int i = 0; i < enemyList.length; i++){
			if (enemyList[i] != null)
				a += enemyList[i].name() 		+ Global.spaces(25 - enemyList[i].name().length());
		}
		for (int i = 0; i < probabilityList.length; i++){
			b += probabilityList[i] 			+ Global.spaces(4 - String.valueOf(probabilityList[i]).length());
		}
		for (int i = 0; i < shopList.length; i++){
			if (shopList[i] != null)
				c += shopList[i].name() 		+ Global.spaces(15 - shopList[i].name().length());
		}
		return 	id 					+ Global.spaces(3 - String.valueOf(id).length()) +
				name 				+ Global.spaces(20 - name.length()) +
				mapType.name() 		+ Global.spaces(15 - mapType.name().length()) +
				a 					+ Global.spaces(50 - a.length()) +
				b 					+ Global.spaces(10 - b.length()) +
				c;
	}
}
