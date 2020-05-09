/*



*/
import java.util.ArrayList; 
import java.lang.Math;

public class BlockingCalculator
{


	public static double sampleSum(ArrayList<Sample> sample)
	{

		double sum = 0; 

		for (int i = 0 ; i < sample.size() ; i++ ) 
		{
			
			sum = sum + SampleCalculator.sum(sample.get(i)); 

		}//end for loop 

		return sum; 

	}//end sampleSum()


	public static double ssTreatments(ArrayList<Sample> sample, double mean)
	{

		double ssTreat = 0; 

		for (int i = 0 ; i < sample.size() ; i++ ) 
		{
		
			ssTreat = ssTreat + Math.pow(SampleCalculator.mean(sample.get(i)) - mean ,2);

		}//end for loop 


		return ssTreat; 


	}//end ssTreatments



	public static double ssBlocks(ArrayList<Sample> sample , double mean)
	{

		double ssBlock = 0; 

		for (int i = 0 ; i < sample.size() ; i++) 
		{
			
			ssBlock = ssBlock + Math.pow(SampleCalculator.mean(sample.get(i)) - mean,2);

		}//end for loop 


		return ssBlock ; 

	}//end ssBlocks() 



	public static double ssErrors(ArrayList<Sample> treatments, ArrayList<Sample> blocks,double mean)
	{

		double errors = 0; 

		for (int i = 0 ; i < treatments.size() ; i++ ) 
		{
		
			for (int j = 0 ; j < blocks.size() ; j++ ) 
			{

				errors = errors + Math.pow(treatments.get(i).getSampleList().get(j).getObservationValue() -
						 SampleCalculator.mean(blocks.get(j)) - SampleCalculator.mean(treatments.get(i))
						 + mean,2); 

			}//end for loop 

		}//end for loopw 


		return errors;

	}//end ssErrors()

}//end class 