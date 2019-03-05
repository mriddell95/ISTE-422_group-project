import static org.junit.Assert.*;

import org.junit.Before;
import  org.junit.Test;


public class EdgeFieldTest{
	   EdgeField  test;
	
	@Before
	public void  setUp() throws Exception{
	  test = new EdgeField("1|test1");
	}
	
	@Test
	public void testSetAndGetTableID(){
		test.setTableID(100);
		assertEquals("tableID was set to 100",100,test.getTableID());
	}

	@Test
	public void testGetNumFigure(){
		assertEquals("numFigure was instalized as 1",1,test.getNumFigure());
	}

	@Test
	public void testGetName(){
		assertEquals("name was instalized as 'Ben'","Ben",test.getName());
	}

	@Test
	public void testSetAndGetTableBound(){
		test.setTableBound(35);
		assertEquals("tableBound was set to 35",35,test.getTableBound());
	}
	@Test
	public void testSetAndGetFieldBound(){
		test.setFieldBound(35);
		assertEquals("fieldBound was set to 35",35,test.getFieldBound());
	}
	
	@Test
	public void testSetAndGetDisallowNull(){
		test.setDisallowNull(true);
		assertEquals("disallowNull was set to True",true,test.getDisallowNull());
	}

	@Test
	public void testSetAndGetIsPrimaryKey(){
		test.setIsPrimaryKey(true);
		assertEquals("isPrimaryKey was set to True",true,test.getIsPrimaryKey());
	}

	@Test
	public void testSetAndGetDefaultValue(){
		test.setDefaultValue("words");
		assertEquals("defaultValue was set to 'words'","words",test.getDefaultValue());
	}

	@Test
	public void testSetAndGetVarcharValue(){
		test.setVarcharValue(100);
		assertEquals("varcharValue was set to 100",100,test.getVarcharValue());
	}

	@Test
	public void testSetAndGetDataType(){
		test.setDataType(1);
		assertEquals("dataType was set to 1",1,test.getDataType());
	}

}
