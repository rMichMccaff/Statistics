import java.util.ArrayList;

public class SampleCalculator
{



	
	public static double mean(Sample sample)
	{

	
		double sum = 0;  

		for(int i = 0 ; i  < sample.getSize(); i++)
		{

			sum = sum + sample.getSampleList().get(i).getObservationValue();


		}//end for loop 


		double mean = sum / sample.getSize(); 

		return mean; 


	}//end mean 


	public static double standardDeviation(Sample sample, double mean)
	{

		double sumOfSquares = 0; 

		for (int i = 0 ; i < sample.getSize() ; i++) 
		{
		
			sumOfSquares = sumOfSquares + Math.pow((sample.getSampleList().get(i).getObservationValue() - mean),2);

		}//end for 

		double variance = (sumOfSquares)/(sample.getSize() - 1);

		return Math.sqrt(variance);

	}//end standardDeviation method 

	public static double sum(Sample sample)
	{

		double sum = 0; 

		for (int i = 0 ; i < sample.getSize() ; i++ ) 
		{
				
			sum = sum + sample.getSampleList().get(i).getObservationValue(); 

		}//end for 

		return sum; 

	}//end sum 


	public static double sumOfSquares(Sample sample, double mean)
	{

		double sumSquare = 0; 

		for (int i = 0 ; i < sample.getSize() ; i++ ) 
		{
			
			sumSquare = sumSquare + Math.pow(sample.getSampleList().get(i).getObservationValue() - mean,2); 

		}//end for loop 

		return sumSquare; 

	}//end sumOfSquares() 

}//end class 