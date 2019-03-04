import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

public class CreateDDLMySQLTest {

	CreateDDLMySQL myDDL;
	
	EdgeTable testTable = new EdgeTable("1|test");
	EdgeTable testTable2 = new EdgeTable("2|tester2");
	
	EdgeField[] testFields = new EdgeField[] {new EdgeField("1|testField"), new EdgeField("2|otherTestField")};

	@Before
	public void setUp() throws Exception {
		testTable.addNativeField(1);
		testTable.makeArrays();
		
		testTable2.addNativeField(2);
		testTable2.makeArrays();
		
		testFields[0].setTableID(1);
		testFields[1].setTableID(2);
		testFields[1].setVarcharValue(20);
		
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
	public void testGetSQLString() {
		assertEquals("Tests that the SQL string is correct if user uses MySQLDB as the db name", "CREATE DATABASE MySQLDB;\r\n" + 
				"USE MySQLDB;\r\n" + 
				"CREATE TABLE test (\r\n" + 
				"	testField VARCHAR(1),\r\n" + 
				");\r\n" + 
				"\r\n" + 
				"CREATE TABLE tester2 (\r\n" + 
				"	otherTestField VARCHAR(20),\r\n" + 
				");\r\n" + 
				"\r\n",
				myDDL.getSQLString());
	}
}
