package support;

import main.MainPage;
import calculator.CalculatorPage;

public enum PageType {
	HOME(MainPage.getInstance()), 
	CALCULATOR(CalculatorPage.getInstance()), 
	GRAPHING(MainPage.getInstance()), 
	SPECIAL(MainPage.getInstance()), 
	SETTINGS(MainPage.getInstance());
	
	private Page currentPageClass = MainPage.getInstance();
	
	PageType(Page newPage) {
		currentPageClass = newPage;
	}
	
	public Page getPageClass() {
		return currentPageClass;
	}
}
