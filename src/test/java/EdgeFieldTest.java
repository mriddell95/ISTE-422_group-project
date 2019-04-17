import static org.junit.Assert.*;

import org.junit.Before;
import  org.junit.Test;

public class EdgeFieldTest{
	EdgeField  test;
	public static String edgeField; 
	public static int tableId;
	public static int tableBound;
	public static int fieldBound;
	public static boolean disallowNull;
	public static boolean isPrimaryKey;
	public static String defaultValue;
	public static int varcharValue;
	public static int dataType;
	
	public static void prepare(String edgeField, int tableId, int tableBound, int fieldBound, boolean disallowNull, boolean isPrimaryKey, String defaultValue, int varcharValue, int dataType){
		EdgeFieldTest.edgeField = edgeField;
		EdgeFieldTest.tableId = tableId;
		EdgeFieldTest.tableBound = tableBound;
		EdgeFieldTest.fieldBound = fieldBound;
		EdgeFieldTest.disallowNull = disallowNull;
		EdgeFieldTest.isPrimaryKey = isPrimaryKey;
		EdgeFieldTest.defaultValue = defaultValue;
		EdgeFieldTest.varcharValue = varcharValue;
		EdgeFieldTest.dataType = dataType;
	}
	
	@Before
	public void  setUp() throws Exception{
	  test = new EdgeField(edgeField);
	}
	
	@Test
	public void testSetAndGetTableID(){
		test.setTableID(tableId);
		assertEquals("tableID was set to 100",tableId,test.getTableID());
	}

	@Test
	public void testGetNumFigure(){
		assertEquals("numFigure was initialized as " + edgeField.split("\\|")[0],Integer.parseInt(edgeField.split("\\|")[0]),test.getNumFigure());
	}

	@Test
	public void testGetName(){
		assertEquals("name was initialized as " + edgeField.split("\\|")[1],edgeField.split("\\|")[1],test.getName());
	}

	@Test
	public void testSetAndGetTableBound(){
		test.setTableBound(tableBound);
		assertEquals("tableBound was set to " + tableBound,tableBound,test.getTableBound());
	}
	@Test
	public void testSetAndGetFieldBound(){
		test.setFieldBound(fieldBound);
		assertEquals("fieldBound was set to " + fieldBound,fieldBound,test.getFieldBound());
	}
	
	@Test
	public void testSetAndGetDisallowNull(){
		test.setDisallowNull(disallowNull);
		assertEquals("disallowNull was set to " + disallowNull,disallowNull,test.getDisallowNull());
	}

	@Test
	public void testSetAndGetIsPrimaryKey(){
		test.setIsPrimaryKey(isPrimaryKey);
		assertEquals("isPrimaryKey was set to " + isPrimaryKey,isPrimaryKey,test.getIsPrimaryKey());
	}

	@Test
	public void testSetAndGetDefaultValue(){
		test.setDefaultValue(defaultValue);
		assertEquals("defaultValue was set to " + defaultValue,defaultValue,test.getDefaultValue());
	}

	@Test
	public void testSetAndGetVarcharValue(){
		test.setVarcharValue(varcharValue);
		assertEquals("varcharValue was set to " + varcharValue,varcharValue,test.getVarcharValue());
	}

	@Test
	public void testSetAndGetDataType(){
		test.setDataType(dataType);
		assertEquals("dataType was set to " + dataType,dataType,test.getDataType());
	}

}
