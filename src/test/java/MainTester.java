import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.iste422.EdgeFieldTest;
import com.iste422.EdgeTableTest;
import org.junit.runner.notification.Failure;
import org.gradle.api.GradleException;

public class MainTester{
	ArrayList<String[]> testObjects = new ArrayList<String[]>();
	ArrayList<Failure> failures = new ArrayList<Failure>();
   
	@Test
	public void runTests(){
		JUnitCore junit = new JUnitCore();
		String fileName = System.getProperty("-f", "");
		String commandLineObject = System.getProperty("-n", "");
		if(!fileName.equals("")) {
			File file = new File(fileName);
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String parse = sc.nextLine();
					parseLineObjects(parse);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				throw new GradleException(e.getMessage(), e);
			}
		}else if(!commandLineObject.equals("")) {
			parseLineObjects(commandLineObject);
		}
		if(!fileName.equals("") || !commandLineObject.equals("")) {
			for(String[] testObject : testObjects) {
				if(testObject[0].equalsIgnoreCase("EdgeFieldTest")) {
					EdgeFieldTest.prepare(testObject[1].trim(), Integer.parseInt(testObject[2].trim()),
							Integer.parseInt(testObject[3].trim()), Integer.parseInt(testObject[4].trim()), Boolean.parseBoolean(testObject[5].trim()), 
							Boolean.parseBoolean(testObject[6].trim()), testObject[7].trim(), Integer.parseInt(testObject[8].trim()), Integer.parseInt(testObject[9].trim()));
					failures.addAll(junit.run(EdgeFieldTest.class).getFailures());
				}else if (testObject[0].equalsIgnoreCase("EdgeTableTest")){
					EdgeTableTest.prepare(testObject[1].trim(), Integer.parseInt(testObject[2].trim()), Integer.parseInt(testObject[3].trim()));
					failures.addAll(junit.run(EdgeTableTest.class).getFailures());
				}else{
					throw new GradleException("No Test class found with the name" + testObject[0]);
				}
			}
		}else {
			EdgeFieldTest.prepare("1|test1", 100, 35, 35, true, true, "words", 100, 1);
			EdgeTableTest.prepare("1|test2", 1, 2);
			failures.addAll(junit.run(EdgeFieldTest.class, EdgeTableTest.class).getFailures());
		}
		if(!failures.isEmpty()){
			throw new GradleException(failures.get(0).getMessage(), failures.get(0).getException());
		}
	}

	public void parseLineObjects(String line){
		String[] objects = line.split("^");
		for(String object : objects){
			String[] parameters = object.split(",");
			testObjects.add(parameters);
		}
	}
   
   
}