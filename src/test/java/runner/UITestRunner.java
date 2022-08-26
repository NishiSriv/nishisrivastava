package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	
	features= {"src/test/java/Features"},
	glue= {"src/test/java/StepDefination"}
	)



public class UITestRunner extends AbstractTestNGCucumberTests{

	
	

}
