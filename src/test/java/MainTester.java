import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.iste422.EdgeFieldTest;

public class MainTester{
   
	@Test
	public void runTests(){
		JUnitCore junit = new JUnitCore();
		String fileName = System.getProperty("-f", "");
		String commandLineObject = System.getProperty("-h", "");
		ArrayList<String[]> edgeFieldTestObjects = new ArrayList<String[]>();
		if(!fileName.equals("")) {
			File file = new File(fileName);
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String parse = sc.nextLine();
					String[] parameters = parse.split(",");
					edgeFieldTestObjects.add(parameters);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else if(!commandLineObject.equals("")) {
			String[] objects = commandLineObject.split("^");	
			for(String object : objects) {
				String[] parameters = object.split(",");
				edgeFieldTestObjects.add(parameters);
			}	
		}
		if(!fileName.equals("") || !commandLineObject.equals("")) {
			for(String[] edgeFieldTestObject : edgeFieldTestObjects) {
				if(edgeFieldTestObject[0].equalsIgnoreCase("EdgeFieldTest")) {
					EdgeFieldTest.prepare(edgeFieldTestObject[1].trim(), Integer.parseInt(edgeFieldTestObject[2].trim()), edgeFieldTestObject[3].trim(), 
							Integer.parseInt(edgeFieldTestObject[4].trim()), Integer.parseInt(edgeFieldTestObject[5].trim()), Boolean.parseBoolean(edgeFieldTestObject[6].trim()), 
							Boolean.parseBoolean(edgeFieldTestObject[7].trim()), edgeFieldTestObject[8].trim(), Integer.parseInt(edgeFieldTestObject[9].trim()), Integer.parseInt(edgeFieldTestObject[10].trim()));
					junit.run(EdgeFieldTest.class);
				}
			}
		}else {
			EdgeFieldTest.prepare("1|test", 100, "test1", 35, 35, true, true, "words", 100, 1);
			junit.run(EdgeFieldTest.class);
		}
	}
   
   
}