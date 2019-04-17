import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdgeConvertCreateDDLTest {
   CreateDDLMySQL test;
   EdgeTable target;
   EdgeField tField;

	@Before
	public void setUp() throws Exception {
      
      EdgeTable faculty = new EdgeTable("1|Faculty");
      faculty.makeArrays(); 
      EdgeTable student = new EdgeTable("2|Student");
      student.makeArrays();
      EdgeTable course = new EdgeTable("3|Courses");
      course.makeArrays();
      EdgeTable[] table = { student, faculty, course };
      target = faculty;
      tField = new EdgeField("4|Number");
      EdgeField[] field = { new EdgeField("5|Grade"), new EdgeField("6|CourseName"), tField };
      test = new CreateDDLMySQL(table,field);   

      
	}
	
	@Test
	public void testGetTable() {
      
      int value = target.getNumFigure();
      assertEquals("Table with numerical figure " + value + " is returned ", target, test.getTable(value));
	}
   
   @Test
   public void testGetField() {
		
      int value = tField.getNumFigure();
      assertEquals("Table with numerical figure " + value + " is returned", tField, test.getField(value));
     } 

}