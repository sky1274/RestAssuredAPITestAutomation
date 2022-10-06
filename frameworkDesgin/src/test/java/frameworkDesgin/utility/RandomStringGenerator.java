package frameworkDesgin.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {
	
	public static String generateName() {
		String name =  RandomStringUtils.randomAlphabetic(2);
		return "Tester"+name;		
	}
	
	public static String generateAge() {
		String age =  RandomStringUtils.randomNumeric(2);
		return age;		
	}

}
