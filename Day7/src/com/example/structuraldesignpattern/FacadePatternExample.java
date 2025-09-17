package com.example.structuraldesignpattern;

class ComputeService
{
void startServer()
{
System.out.println("compute server started : ");	
}

}

class DatabaseService
{
void configureDatabase()
{
System.out.println("Database Configured : ");	
}

}

class SecurityService
{
void setSecurityRules()
{
System.out.println("Security Rules Applied: ");	
}

}


class AWSCloudFacade{
	
	private ComputeService compute=null; ;
	private DatabaseService database=null ;
	private SecurityService security=null ;
	
	AWSCloudFacade()
	{
		  compute = new ComputeService();
	      database = new DatabaseService();
	      security = new SecurityService();
		
	}
	
	public void deployApplication()
	{
		
		System.out.println("Starting Cloud Deployement ..");
		compute.startServer();
		database.configureDatabase();
		security.setSecurityRules();
	}
}


// client 
public class FacadePatternExample {

	public static void main(String[] args) {
		
		AWSCloudFacade clf = new AWSCloudFacade();
		clf.deployApplication();  //Reduces the complexity of calling different services , you are giving one single entry point for deployement

	}

}