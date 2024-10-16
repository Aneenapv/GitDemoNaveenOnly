package com.naveenlabs.browsersEnum;

public enum Browsers {
	
	CHROME("Google Chrome"),
	FIREFOX("Mozilla Firefox"),
	EDGE("Microsoft Edge");

	private String browserNameWithCompanies;
	
    Browsers(String browserName) {
		this.browserNameWithCompanies = browserName;
	}

	public String getBrowserNameWithCompanies() {
		return browserNameWithCompanies;
	}


	
    
    
	
	
	

}
