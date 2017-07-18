//************************************************************
/**
*	DBConnector Handles all database definitions.
*	
*	@author		pxldrm
*	@since		7/13/2017
* 	@update 	7/16/2017
*/
//************************************************************
package data;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnector {
//************************************************************
/**
*	Variables
*/
//************************************************************
	//file path
	private static final String dbConn 			= "jdbc:sqlite:";
	private static final String dbPath 			= "database/";
	private static final String dbExt 			= ".sqlite";
	//database definitions
	protected static final String dbData 		= dbConn + dbPath + "data" + dbExt;
	protected static final String dbTypes 		= dbConn + dbPath + "types" + dbExt;
	protected static final String dbItems 		= dbConn + dbPath + "items" + dbExt;
	protected static final String dbBattlers 	= dbConn + dbPath + "battlers" + dbExt;
	protected static final String dbScenes 		= dbConn + dbPath + "scenes" + dbExt;
	//Data table definitions
	protected static final String[] tableData 		= {
													"behaviors",
													"roles"};
	//Type table definitions
	protected static final String[] tableTypes 		= {
													"armorTypes",
													"attributeTypes",
													"damageTypes",
													"effectTypes",
													"elementTypes",
													"enemyTypes",
													"itemTypes",
													"mapTypes",
													"shopTypes",
													"skillTypes",
													"weaponTypes",};
	//Item table definitions
	protected static final String[] tableItems 		= {
													"armors",
													"items",
													"skills",
													"weapons"};
	//Battler table definitions
	protected static final String[] tableBattlers 	= {
													"actors",
													"enemies"};
	//Scene table definitions
	protected static final String[] tableScenes 	= {
													"shops",
													"maps"};
	//connections
	protected static Connection conn = null;
//************************************************************
/**
*	Method for connecting database
*/
//************************************************************
	protected static Connection dbConnector(String db) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(db);
			return conn;
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			try {
				if(conn != null)
				conn.close();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
	}
//************************************************************
/**
*	Method for converting string array to int array
*/
//************************************************************
	protected static int[] convert(String[] array){
		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++){
			if (array[i].compareTo("null") == 0)
				array[i] = "-1";
			temp[i] = Integer.parseInt(array[i]);
		}
		return temp;
	}
}
