package com.naveenlabs.RandomPackage;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
	
	//Random random = new Random();
	
	public static String RandomNameGenerator()
	{
	String name = RandomStringUtils.randomAlphabetic(4);
	return name; 
	}

	
		
	
}
