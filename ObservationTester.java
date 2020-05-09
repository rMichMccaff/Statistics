public class ObservationTester
{

	static Observation obs1 = new Observation(30,1);
	static Observation obs2 = new Observation(20,2);
	static Observation obs3 = new Observation(40,3); 


	public static void main(String[] args) 
	{
	
		constructorTest();
		compareTest(); 

	}//end main 


	public static void constructorTest()
	{

		if(obs1.getObservationValue() == 30 && obs1.getNumber() == 1)
		{

			System.out.println("Passed obs1 constructor test.");

		}
		else
		{

			System.out.println( "Failed obs1 constructor test looked for 30 and 1  but found  "+ obs1.getObservationValue() + " " +obs1.getNumber() ); 

		}
		if(obs2.getObservationValue() == 20 && obs2.getNumber() == 2) 
		{
			
			System.out.println("Passed obs2 constructor test.");
			
		}
		else
		{

			System.out.println("Failed obs2 constructor test looked for 20 and 2 and found  "+ obs2.getObservationValue() +" "+ obs2.getNumber() );

		}
		if(obs3.getObservationValue() == 40 && obs3.getNumber() == 3)
		{
		
			System.out.println("Passed obs3 constructor test.");

		}
		else
		{

			System.out.println(" Failed obs3 constructor test "+ obs3.getObservationValue() +" "+ obs3.getNumber() );

		}


	}//end constructorTest method 


	public static void compareTest()
	{

		if( obs1.compareObservation(obs1) == true )
		{

			System.out.println("Passed obs1 compareTest"); 

		}
		else
		{

			System.out.println("Failed obs1 compareTest looked for TRUE and found " +  obs1.compareObservation(obs1) ); 
		
		}

		if(obs1.compareObservation(obs2) == false)
		{

			System.out.println("Passed obs1 compare test False test."); 

		}
		else
		{

			System .out.println("Failed obs1 compare test false looked for false and found"+obs1.compareObservation(obs2));

		}

	}//end compareTest method 

}//end class 