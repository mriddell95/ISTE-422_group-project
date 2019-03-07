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
      assertEquals("Test if not initialized", null, defaultTest.getRelatedFieldsArray());
   }
   
   @Test
   public void testSetRelatedField(){
      //dont know how to test this assertEquals();
   }
   
   @Test
   public void testAddNativeField(){
      test.addNativeField(1);
      test.makeArrays();
      int [] nativeTables = defaultTest.getNativeFieldsArray();
      assertEquals("Test if 1 field is added to NativeFields Array",1, nativeTables[0]);
   }
   
   @Test
   public void testMoveFieldUp(){
      //dont know how to test this assertEquals();
   }
   
   @Test
   public void testMoveFieldDown(){
      //dont know how to test this assertEquals();
   }
}