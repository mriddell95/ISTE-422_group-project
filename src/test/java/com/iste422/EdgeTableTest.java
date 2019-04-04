package com.iste422;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeTableTest{
   EdgeTable test;

	public static String edgeTable; 
	public static int relatedTable;
	public static int nativeFields;


   public static void prepare(String edgeTable, int relatedTable, int nativeFields){
      EdgeTableTest.edgeTable = edgeTable;
      EdgeTableTest.relatedTable = relatedTable;
      EdgeTableTest.nativeFields = nativeFields;      
	}
   
   @Before
	public void  setUp() throws Exception{
	  test = new EdgeTable(edgeTable);
	}
   
   @Test
	public void testGetNumFigure(){
		assertEquals("numFigure was initialized as " + edgeTable.split("\\|")[0],Integer.parseInt(edgeTable.split("\\|")[0]),test.getNumFigure());
	}
   
   @Test
	public void testGetName(){
      assertEquals("name was initialized as " + edgeTable.split("\\|")[1],edgeTable.split("\\|")[1],test.getName());
	}
   
   @Test
   public void testAddRelatedTable(){
      test.addRelatedTable(relatedTable);
      test.makeArrays();
      int[] relatedTables = test.getRelatedTablesArray();
      assertEquals("Test if there is a table in the RelatedTables Array",relatedTable,relatedTables[0]);
   }
   
   @Test
   public void testGetRelatedFieldsArray(){
      assertEquals("Test if not initialized", null, test.getRelatedFieldsArray());
   }
   
   @Test
   public void testAddNativeField(){
      test.addNativeField(nativeFields);
      test.makeArrays();
      int [] nativeTables = test.getNativeFieldsArray();
      assertEquals("Test if 1 field is added to NativeFields Array",nativeFields, nativeTables[0]);
   }
}