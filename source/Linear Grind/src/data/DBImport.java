//************************************************************
/**
*	DBImport 	Imports SQLite Database into memory.
*	
*	@author		pxldrm
*	@since		7/13/2017
* 	@update 	7/30/2017
*/
//************************************************************
package data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import battler.*;
import calc.Behavior;
import display.Message;
import game.Role;
import game.Type;
import item.*;
import scene.Map;
import scene.Shop;
public class DBImport extends DBConnector{
//************************************************************
/**
*	Variables
*/
//************************************************************
	private static ArrayList<Object> temp = new ArrayList<Object>();
//************************************************************
/**
*	Main methods for importing External Database
*/
//************************************************************
	public static void 		importDatabase() throws SQLException{
		for (String s: tableData){
			connect(dbData, s);
		}
		for (String s: tableTypes){
			connect(dbTypes, s);
		}
		for (String s: tableItems){
			connect(dbItems, s);
		}
		for (String s: tableBattlers){
			connect(dbBattlers, s);
		}
		for (String s: tableScenes){
			connect(dbScenes, s);
		}
	}
	private static void 	connect(String db, String table) throws SQLException{
		conn = dbConnector(db);
		Statement stmt = null;
	    String query = "select * from " + table;
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	switch(db){
	        	case dbData:
	        		if (table.contentEquals(tableData[0]))
		        		createBehavior(rs);
	        		if (table.contentEquals(tableData[1]))
		        		createRole(rs);
	        		break;
	        		
	        	case dbTypes:
	        		createType(rs);
	        		break;
	        		
	        	case dbItems:
	    	        if (table.contentEquals(tableItems[0]))
		        		createArmor(rs);
	    	        if (table.contentEquals(tableItems[1]))
		        		createItem(rs);
	    	        if (table.contentEquals(tableItems[2]))
		        		createSkill(rs);
	    	        if (table.contentEquals(tableItems[3]))
		        		createWeapon(rs);
	    	        break;
	    	        
	        	case dbBattlers:	        		
	        		if (table.contentEquals(tableBattlers[0]))
		        		createActor(rs);
	        		if (table.contentEquals(tableBattlers[1]))
		        		createEnemy(rs);
	        		break;
	    	        
	        	case dbScenes:
	        		if (table.contentEquals(tableScenes[0]))
		        		createShop(rs);
	        		if (table.contentEquals(tableScenes[1]))
		        		createMap(rs);
	        		break;
	        	}
	        }
	        copyToArray(table);
	        temp.clear();
	    }
	    catch (SQLException e ) {
			Message.showMessage("Failed to fetch result set from " + table + ".");
	    }
	    finally {
	        if (stmt != null)
	        	stmt.close();
	    }
	}
//************************************************************
/**
*	Create ArrayList of Objects from Database
*/
//************************************************************
	//data
	private static void 	createBehavior(ResultSet rs) throws SQLException{
    	temp.add(new Behavior(
    			rs.getRow() - 1,
    			convert(rs.getString("probability").split(",")),
    			convert(rs.getString("turnCount").split(",")),
    			convert(rs.getString("condition").split(","))));
	}
	private static void 	createRole(ResultSet rs) throws SQLException{
		temp.add(new Role(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			new int[]{
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[]{
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			convert(rs.getString("skillLearned").split(",")),
    			convert(rs.getString("lvLearned").split(","))));
	}
	private static void 	createType(ResultSet rs) throws SQLException{
    	temp.add(new Type(
    			rs.getRow() - 1,
    			rs.getString("name")));
	}
	//items
	private static void 	createArmor(ResultSet rs) throws SQLException{
    	temp.add(new Armor(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("cost"),
    			new int[] {
    					rs.getInt("effectType")},
    			new int[] {
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[] {
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			rs.getInt("armorType"),
    			rs.getInt("weightType")));
	}
	private static void 	createItem(ResultSet rs) throws SQLException{
    	temp.add(new Item(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("cost"),
    			new int[] {
    					rs.getInt("effectType")},
    			new int[] {
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[] {
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			rs.getInt("itemType"),
    			rs.getInt("damageType"),
    			rs.getInt("damageValue")));
	}
	private static void 	createSkill(ResultSet rs) throws SQLException{
    	temp.add(new Skill(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("cost"),
    			new int[] {
    					rs.getInt("effectType")},
    			new int[] {
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[] {
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			rs.getInt("skillType"),
    			rs.getInt("damageType"),
    			rs.getInt("damageValue")));
	}
	private static void 	createWeapon(ResultSet rs) throws SQLException{
    	temp.add(new Weapon(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("cost"),
    			new int[] {
    					rs.getInt("effectType")},
    			new int[] {
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[] {
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			rs.getInt("weaponType"),
    			rs.getInt("damageType")));
	}
	//battlers
	private static void 	createActor(ResultSet rs) throws SQLException{
    	temp.add(new Actor(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			new int[]{
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[]{
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			convert(rs.getString("skillList").split(",")),
    			rs.getInt("lv"),
    			rs.getInt("exp"),
    			rs.getInt("role"),
    			convert(rs.getString("equipmentList").split(","))));
	}
	private static void 	createEnemy(ResultSet rs) throws SQLException{
    	temp.add(new Enemy(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			new int[]{
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("mhp"),
    					rs.getInt("mmp"),
    					rs.getInt("atk"),
    					rs.getInt("def"),
    					rs.getInt("mat"),
    					rs.getInt("mdf"),
    					rs.getInt("agi"),
    					rs.getInt("luk")},
    			new int[]{
    					rs.getInt("none"),
    					rs.getInt("bare"),
    					rs.getInt("slice"),
    					rs.getInt("stab"),
    					rs.getInt("blow"),
    					rs.getInt("fire"),
    					rs.getInt("water"),
    					rs.getInt("air"),
    					rs.getInt("earth"),
    					rs.getInt("light"),
    					rs.getInt("dark")},
    			convert(rs.getString("skillList").split(",")),
    			rs.getInt("lv"),
    			rs.getInt("exp"),
    			rs.getInt("enemyType"),
    			rs.getInt("gold"),
    			convert(rs.getString("armorList").split(",")),
    			convert(rs.getString("itemList").split(",")),
    			convert(rs.getString("weaponList").split(",")),
    			convert(rs.getString("behavior").split(","))));
	}
	//scenes
	private static void 	createShop(ResultSet rs) throws SQLException{
    	temp.add(new Shop(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("shopType"),
    			rs.getInt("priceRate"),
    			convert(rs.getString("itemList").split(","))));
	}
	private static void 	createMap(ResultSet rs) throws SQLException{
    	temp.add(new Map(
    			rs.getRow() - 1,
    			rs.getString("name"),
    			rs.getInt("mapType"),
    			convert(rs.getString("enemyList").split(",")),
    			convert(rs.getString("probabilityList").split(",")),
    			convert(rs.getString("shopList").split(","))));
	}
//************************************************************
/**
*	Transfer ArrayList to Internal Database
*/
//************************************************************
	//main copy operation
	private static void 	copyToArray(String table){
		//copy temp to data arrays
        if (table.contentEquals(tableData[0]))
    		behaviorArray();
        if (table.contentEquals(tableData[1]))
    		roleArray();
        //copy temp to type arrays
        if (table.contentEquals(tableTypes[0]))
        	Global.accessoryTypes 	= typeArray();
        if (table.contentEquals(tableTypes[1]))
        	Global.armorTypes 		= typeArray();
        if (table.contentEquals(tableTypes[2]))
        	Global.attributeTypes 	= typeArray();
        if (table.contentEquals(tableTypes[3]))
        	Global.bodyTypes 	= typeArray();
        if (table.contentEquals(tableTypes[4]))
        	Global.damageTypes 		= typeArray();
        if (table.contentEquals(tableTypes[5]))
        	Global.effectTypes 		= typeArray();
        if (table.contentEquals(tableTypes[6]))
        	Global.elementTypes 	= typeArray();
        if (table.contentEquals(tableTypes[7]))
        	Global.enemyTypes 		= typeArray();
        if (table.contentEquals(tableTypes[8]))
        	Global.equipmentTypes 	= typeArray();
        if (table.contentEquals(tableTypes[9]))
        	Global.helmetTypes 	= typeArray();
        if (table.contentEquals(tableTypes[10]))
        	Global.itemTypes 		= typeArray();
        if (table.contentEquals(tableTypes[11]))
        	Global.mapTypes 		= typeArray();
        if (table.contentEquals(tableTypes[12]))
        	Global.shieldTypes 	= typeArray();
        if (table.contentEquals(tableTypes[13]))
        	Global.shopTypes 		= typeArray();
        if (table.contentEquals(tableTypes[14]))
        	Global.skillTypes 		= typeArray();
        if (table.contentEquals(tableTypes[15]))
        	Global.weaponTypes 		= typeArray();
        //copy temp to item arrays
        if (table.contentEquals(tableItems[0]))
    		armorArray();
        if (table.contentEquals(tableItems[1]))
    		itemArray();
        if (table.contentEquals(tableItems[2]))
    		skillArray();
        if (table.contentEquals(tableItems[3]))
    		weaponArray();
        //copy temp to battler arrays
        if (table.contentEquals(tableBattlers[0]))
    		actorArray();
        if (table.contentEquals(tableBattlers[1]))
    		enemyArray();
        //copy temp to scene arrays
        if (table.contentEquals(tableScenes[0]))
    		shopArray();
        if (table.contentEquals(tableScenes[1]))
    		mapArray();
	}
	//data
	private static void 	behaviorArray(){
		Global.behaviors = new Behavior[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.behaviors[i] = (Behavior)temp.get(i);
        }
	}
	private static void 	roleArray(){
		Global.roles = new Role[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.roles[i] = (Role)temp.get(i);
        }
	}
	private static Type[] 	typeArray(){
		Type[] typeArray = new Type[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	typeArray[i] = (Type)temp.get(i);
        }
        return typeArray;
	}
	//items
	private static void 	armorArray(){
		Global.armors = new Armor[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.armors[i] = (Armor)temp.get(i);
        }
	}
	private static void 	itemArray(){
		Global.items = new Item[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.items[i] = (Item)temp.get(i);
        }
	}
	private static void 	skillArray(){
		Global.skills = new Skill[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.skills[i] = (Skill)temp.get(i);
        }
	}
	private static void 	weaponArray(){
		Global.weapons = new Weapon[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.weapons[i] = (Weapon)temp.get(i);
        }
	}
	//battlers
	private static void 	actorArray(){
		Global.actors = new Actor[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.actors[i] = (Actor)temp.get(i);
        }
	}
	private static void 	enemyArray(){
		Global.enemies = new Enemy[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.enemies[i] = (Enemy)temp.get(i);
        }
	}
	//scenes
	private static void 	shopArray(){
		Global.shops = new Shop[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.shops[i] = (Shop)temp.get(i);
        }
	}
	private static void 	mapArray(){
		Global.maps = new Map[temp.size()];
        for (int i = 0; i < temp.size(); i++){
        	Global.maps[i] = (Map)temp.get(i);
        }
	}
}
