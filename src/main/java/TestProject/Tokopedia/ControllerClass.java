
package TestProject.Tokopedia;

import java.lang.ModuleLayer.Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageClass.SwagLabsPage;

public class ControllerClass {
WebDriver driver;	

	
	private static ControllerClass controllerInstance;
	private SwagLabsPage swaglab;
	
	
    private ControllerClass(WebDriver driver) {
    	this.driver=driver;
		}
  
    public static ControllerClass getInstance() {
	  if(null==controllerInstance)
	  {
		  controllerInstance=new ControllerClass(BaseClass.getInstance().getDriver());
	  }
	  return controllerInstance;
	  
     }

    
    
    private <T> T initPage(Class<T> t){
    	T page= PageFactory.initElements(driver, t);
    	return page;
    	
    	
    	
    }
    
    public SwagLabsPage swagPage() {
    	swaglab=new SwagLabsPage(driver);
    	return initPage(SwagLabsPage.class);
    }

  
  
  
}
