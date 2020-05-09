public class Observation
{


	double observation; 
	int number; 
	

	public Observation(double observation, int number)
	{

		this.observation = observation; 
		this.number = number; 

	}//end constructor 


	public Observation(Observation newObservation)
	{

		this.observation = newObservation.getObservationValue(); 
		this.number = newObservation.getNumber();

	}//end constructor 


	public double getObservationValue()
	{

		return this.observation; 

	}//end getObservationValue


	public int getNumber()
	{

		return this.number; 

	}//end getNumber


	public void setNumber(int newNumber)
	{

		this.number = newNumber; 


	}//end setNumber


	public void setNumber(Observation newObservation)
	{

		this.number = newObservation.getNumber();

	}//end setNumber


	public void setObservationValue(double newObservationValue)
	{

		this.observation = newObservationValue; 

	}//end setObservationValue 


	public void setObservationValue(Observation newObeservation)
	{

		this.observation = newObeservation.getObservationValue();

	}//end setObservationValue 


	public boolean compareObservation(Observation comparingObservation)
	{

		if(comparingObservation.getObservationValue() != observation || comparingObservation.getNumber() != this.number)
		{

			return false; 

		}//end if 

		else
		{

			return true; 

		}//end else 

	}//end compareObservation


}//end class 