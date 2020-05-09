
/*

A simple experiment will constist of two samples sent into the object upon consturction.
The simple experiment will have a confidence interval, and test statistic.  There are 
two kinds of tests that will be run over will be ones where the standard deviation is the 
same, or different.  We also need to be able to test the assumptions the first being a test
for normality, the second being a check for sample size.  


	SimpleExperiment(Sample sampleOne, Sample sampleTwo)

	testStatistic() 

	confidenceInterval() 

	normalityTest() 

	pValue()

*/
import java.lang.Math; 
import java.util.ArrayList; 

public class SimpleExperiment
{


	Sample sampleOne;
	Sample sampleTwo; 


	public SimpleExperiment(Sample sampleOne, Sample sampleTwo)
	{

		this.sampleOne = sampleOne; 

		this.sampleTwo = sampleTwo;

	}//end SimpleExperiment



	public ArrayList<Double> testStatistic()
	{


		ArrayList<Double> testStatisticData = new ArrayList<Double>(); 


		//find the firstMean 
		double firstMean = SampleCalculator.mean(this.sampleOne);
		
		//find the secondMean 
		double secondMean = SampleCalculator.mean(this.sampleTwo); 

		//find pooledStandardDeviation
		double pooledStdDev  = pooledStandardDeviation(); 
		
		//check that the sample size is adequate
		testStatisticData.add(1.0);

		//check that normality assumption holds 
			//if not say that test may not be applied
		testStatisticData.add(1.0);

		//check that standardDeviation is the same 
		testStatisticData.add(1.0);

		//if sampleSize and normalityTest is passed  
		double numerator = this.sampleOne.getMean() - this.sampleTwo.getMean();
		double denominatorPt2 = (double)( 1.0/this.sampleOne.getSize() ) + (double)(1.0/this.sampleTwo.getSize()); 
		double denominator = pooledStdDev * Math.sqrt( denominatorPt2 );  

		double statistic = Math.round( (numerator/denominator) * 10000 ) / 10000.0000;
		testStatisticData.add( statistic  ); 


		return testStatisticData; 
		
	}//end testStatistic


	public double pooledStandardDeviation()
	{

		//get the first and second standard deviations and square them multiplying them by one less sample size 
		double firstStandardDeviation = ( this.sampleOne.getSize() - 1 ) * Math.pow( this.sampleOne.getStandardDeviation(),2 ) ;
		double secondStandardDeviation = ( this.sampleTwo.getSize() - 1 ) * Math.pow(this.sampleTwo.getStandardDeviation(),2 ) ;

		//add them together dividing the result 
		double numerator = (firstStandardDeviation) + (secondStandardDeviation);
		double denominator = this.sampleOne.getSize() + this.sampleTwo.getSize() - 2; 



		//return the pooled standardDeviation 
		return Math.sqrt(numerator/denominator) ; 

	}//end pooledStandardDeviation



	public void confidenceInterval()
	{

		

	}//end confidenceInterval



	public boolean normalityTest()
	{	


		ArrayList<Observation> sampleOneList = new ArrayList<Observation>();
		ArrayList<Observation> sampleTwoList = new ArrayList<Observation>(); 

		//sort the observations 
		for(int i = 0 ; i < this.sampleOne.getSampleList().size() ; i++ )
		{

			Observation smallest = this.sampleOne.getSampleList().get(i); 

			for(int j = 0  ; j < this.sampleOne.getSampleList().size() ; j++ )
			{

				if(this.sampleOne.getSampleList().get(j).getObservationValue() < smallest.getObservationValue() )
				{

					smallest = this.sampleOne.getSampleList().get(j);

				}//end if 

			}//end for loop 

			sampleOneList.add(smallest); 

		}//end for loop 
		for(int i = 0 ; i < this.sampleTwo.getSampleList().size() ; i++ )
		{

			Observation smallest = this.sampleTwo.getSampleList().get(i); 

			for(int j = 0  ; j < this.sampleTwo.getSampleList().size() ; j++ )
			{

				if(this.sampleTwo.getSampleList().get(j).getObservationValue() < smallest.getObservationValue() )
				{

					smallest = this.sampleTwo.getSampleList().get(j);

				}//end if 

			}//end for loop 

			sampleOneList.add(smallest); 

		}//end for loop 
 		
 		//find values for cumulative probability
 		ArrayList<Double> cumulativeProbabilityOne = new ArrayList<Double>();
 		ArrayList<Double> cumulativeProbabilityTwo = new ArrayList<Double>();
 		
 		double size1 = (double)this.sampleOne.getSampleList().size(); 
 		double size2 = (double)this.sampleTwo.getSampleList().size(); 

		for(double i = 1.0 ; i <= this.sampleOne.getSampleList().size() ; i++)
		{
			
			cumulativeProbabilityOne.add( (i-.5)/size1 ); 

		}
		for (double i = 1.0 ; i <= this.sampleTwo.getSampleList().size() ; i++ ) 
		{
		
			cumulativeProbabilityTwo.add( (i-.5)/size2 ); 

		}
		 


		//form a linear model 

		//test the fit of the distribution against the linear model 

		//return the boolean

		return true; 
	}//end normalityTest



	public boolean sampleAdequacy()
	{

		return true; 
	}//end sampleAdequacy







}//end class 