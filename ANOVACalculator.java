import java.util.ArrayList;
import java.lang.Math;

public class ANOVACalculator
{



 	//sumOfSquaresTreatments 
	public static double sumOfSquaresTreatments(ArrayList<Sample> anovaSample)
	{

		double treatements = 0; 

		double totalAnovaMean = totalMean(anovaSample); 

		for(int i = 0 ; i < anovaSample.size() ; i++)
		{

			treatements = treatements + ( Math.pow( anovaSample.get(i).getMean() - totalAnovaMean , 2 ) ) ; 

		}//end for loop 


		treatements = treatements * anovaSample.get(0).getSize();


		return treatements; 

	}//end sumOfSquaresTreatments



	public static double sumOfSquaresErrors(ArrayList<Sample> anovaSample)
	{

		double errors = 0; 

		//loop over the sample arraylist 
		for (int i = 0 ; i < anovaSample.size() ; i++ )
		{
		
			//get a local sample mean
			double localMean = anovaSample.get(i).getMean();

			//loop over the sample  
			for (int j = 0 ; j < anovaSample.get(i).getSize()  ; j++) 
			{
				
				//find the sumOfsquares for the local row 
				errors = errors + Math.pow(
											
											anovaSample.get(i).getSampleList().get(j).getObservationValue() -  anovaSample.get(i).getMean()
										
											,
											 
											2

											); 

			}//end for loop

		}//end for loop 
			
		//return the answer 
		return Math.round( errors * 100)/100.00;
	
	}//end sumOfSquaresErrors 


	public static double totalMean(ArrayList<Sample> anovaSample)
	{


		//get the sample list sum all the entries 
		double totalSum = 0; 
		int counter = 0;

		for (int i = 0 ; i < anovaSample.size()  ; i++ ) 
		{
		


			for (int j = 0 ; j < anovaSample.get(i).getSize() ; j++) 
			{
			
				totalSum = totalSum + anovaSample.get(i).getSampleList().get(j).getObservationValue() ; 
				counter++;

			}//end for loop 

		
		}//end for loop 


		//divide by the total size of the entire sample 
		double totalMean = totalSum/counter; 


		return (Math.round(totalMean*100)/100.00);

	}//end totalMean 


	//fStatistic 
	public static double fStatistic(ArrayList<Sample> samples)
	{

		//find msTreatments
		double msTreatments = sumOfSquaresTreatments(samples)/(samples.size() - 1 );
		
		//find msErrors
		double msErrors = sumOfSquaresErrors(samples);
		int sampleCounter = 0; 
		for(int i = 0 ; i < samples.size() ; i++)
		{

			sampleCounter = sampleCounter + samples.get(i).getSize() ; 

		}//end for loop 


		//take the ratio 
		msErrors = msErrors/( sampleCounter - samples.size() );
		
		double fStat = msTreatments/msErrors; 

		//return a rounded version of the fStatisitic 
		return ( Math.round(fStat * 100) / 100.00 ) ; 

	}//end fStatistic


	public static ArrayList<Double> residuals(ArrayList<Sample> samples)
	{


		//create an arraylist to log the residuals
		ArrayList<Double> residuals = new ArrayList<Double>(); 

		//create a for loop to loop over the samples 
		for (int i = 0 ; i < samples.size() ; i++) 
		{
		

			//get a local mean from a sample on the list 
			double localMean = samples.get(i).getMean(); 
			//create a for loop to iterate over a sample 
			for (int j = 0 ; j < samples.get(i).getSampleList().size() ; j++) 
			{
			
				//subtract the mean from the observation and add it to the arraylist 
				residuals.add( samples.get(i).getSampleList().get(j).getObservationValue() - localMean ); 


			}//end for loop 



		}//end for loop 




		return residuals; 

	}//end normailtyTest method 

}//end class