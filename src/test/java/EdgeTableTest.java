import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeTableTest{
   EdgeTable test;
   
   @Before
	public void  setUp() throws Exception{
	  test = new EdgeTable("1|test1");
	}
   
   @Test
	public void testGetNumFigure(){
		assertEquals("numFigure was initialized as 1",1,test.getNumFigure());
	}
   
   @Test
	public void testGetName(){
      assertEquals("name was initialized as 'test1'","test1",test.getName());
	}
   
   @Test
   public void testAddRelatedTable(){
      test.addRelatedTable(1);
      test.makeArrays();
      int[] relatedTables = test.getRelatedTablesArray();
      assertEquals("Test if there is a table in the RelatedTables Array",1,relatedTables[0] );
   }
   
   @Test
   public void testGetRelatedFieldsArray(){
      assertEquals("Test if not initialized", null, test.getRelatedFieldsArray());
   }
   
   @Test
   public void testAddNativeField(){
      test.addNativeField(1);
      test.makeArrays();
      int [] nativeTables = test.getNativeFieldsArray();
      assertEquals("Test if 1 field is added to NativeFields Array",1, nativeTables[0]);
   }
}