import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateDDLMySQLTest {

	CreateDDLMySQL myDDL;
	
	EdgeTable testTable = new EdgeTable("1|testIntVarChar");
	EdgeTable testTable2 = new EdgeTable("2|testBoolean");
	
	EdgeField[] testFields = new EdgeField[] {new EdgeField("1|id"), new EdgeField("2|testVarChar"), new EdgeField("3|testBoolean")};

	@Before
	public void setUp() throws Exception {
		testTable.addNativeField(1);
		testTable.addNativeField(2);
		testTable.makeArrays();
		
		testTable2.addNativeField(3);
		testTable2.makeArrays();
		
		testFields[0].setTableID(1);
		testFields[0].setDisallowNull(true);
		testFields[0].setDataType(3);
		testFields[0].setIsPrimaryKey(true);
		
		testFields[1].setVarcharValue(20);
		testFields[1].setDataType(0);
		testFields[1].setTableID(1);
		
		testFields[2].setTableID(2);
		testFields[2].setDisallowNull(true);
		testFields[2].setDataType(1);
		testFields[2].setDefaultValue("false");
		
		EdgeTable[] testTables = {testTable, testTable2};
		
		myDDL = new CreateDDLMySQL(testTables, testFields);
	}

	@Test
	public void testConvertStrBooleanToInt() {
		assertEquals("This tests that if the input of the method is the string true output 1", 1,
				myDDL.convertStrBooleanToInt("true"));
		assertEquals("This tests that if the input of the method ianything but true that it will output 0", 0,
				myDDL.convertStrBooleanToInt("false"));
	}
	
	@Test
	public void testGetDatabaseName() {
		myDDL.databaseName = "test";
		assertEquals("This tests that the database name is set correctly", "test",
				myDDL.getDatabaseName());
	}

	@Test
	public void testGetProductName() {
		assertEquals("Tests that the product is mySQL", "MySQL",
				myDDL.getProductName());
	}
	
	@Test
	public void testGenerateDatabaseName() {
		assertEquals("Tests that if the user Clicks the cancel button that the function returns an empty string", "", myDDL.generateDatabaseName());
	}
	
	
	@Test
	public void testGetSQLString() {
		assertEquals("Tests that the SQL string is correct if user uses MySQLDB as the db name", 
				"CREATE DATABASE MySQLDB;\r\n" + 
				"USE MySQLDB;\r\n" + 
				"CREATE TABLE testIntVarChar (\r\n" + 
				"	id DOUBLE NOT NULL,\r\n" + 
				"	testVarChar VARCHAR(20),\r\n" + 
				"CONSTRAINT testIntVarChar_PK PRIMARY KEY (id)\r\n" +
				");\r\n" +
				"\r\n" +
				"CREATE TABLE testBoolean (\r\n" + 
				"	testBoolean BOOL NOT NULL DEFAULT 0\r\n" + 
				");\r\n" + 
				"\r\n",
				myDDL.getSQLString());
	}
}
