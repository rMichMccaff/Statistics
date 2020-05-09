/*

The purpose of the class is to represent a sample object. 

*/

import java.util.ArrayList;

public class Sample
{



	ArrayList<Observation> sample;




	public Sample(ArrayList<Observation> sampleList)
	{

		this.sample = new ArrayList<Observation>(sampleList.size());
				
		for (int i = 0 ;i < sampleList.size() ; i++ ) {
		
			this.sample.add(sampleList.get(i));

		}//end for loop 



	}//end constructor 


	public Sample(Sample newSample)
	{


		this.sample = newSample.getSampleList(); 


	}//end constructor 


	//getSampleList
	public ArrayList<Observation> getSampleList()
	{

		ArrayList<Observation> returnSampleList = new ArrayList<Observation>();

		for (int i = 0 ; i < this.sample.size() ; i++ ) {
			
			returnSampleList.add(this.sample.get(i));

		}//end for loop 


		return returnSampleList;

	}//end getSampleList


	//getSample
	public Sample getSample()
	{

		return new Sample(this.sample);

	}//end getSample 

	

	//setSampleList
	public void setSampleList(ArrayList<Observation> newSampleList)
	{

		
		ArrayList<Observation> localSampleList = new ArrayList<Observation>();

		for (int i = 0 ; i < newSampleList.size()  ; i++ ) {
			
			localSampleList.add(newSampleList.get(i));

		}//end for loop 
		
		this.sample = localSampleList; 


	}//end setSampleList



	//setSample 
	public void setSample(Sample newSample)
	{

		this.sample = newSample.getSampleList();

	}//end setSample 


	public int getSize()
	{

		return sample.size(); 	

	}//end getSize



	public double getMean()
	{

		return SampleCalculator.mean(this);

	}

	public double getStandardDeviation()
	{

		return SampleCalculator.standardDeviation( this , getMean() );

	}//end getStandardDeviation method 


	public boolean compareSample(Sample otherSample)
	{

		if(otherSample.getSize() != this.sample.size() )
		{

			return false; 

		}

		for(int i = 0; i < this.sample.size() ; i++ ) 
		{
			
			if(otherSample.getSampleList().get(i).compareObservation(this.sample.get(i)) == false)
			{

				return false; 

			}

		}//end for loop 

		return  true; 

		

	}//end compareSample 

}//end class