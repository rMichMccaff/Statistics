
/*

The goal is to conduct an ANOVA test and the various assumptions for the test.  

	ANOVA(ArrayList<Sample>)
	

	

*/	
import java.util.ArrayList; 
import java.lang.Math;

public class Anova
{

	ArrayList<Sample> samples;


	public Anova(ArrayList<Sample> samples)
	{

		this.samples = samples; 

	}//end constructor



		
	public double getTotalMean()
	{

		return Math.round(ANOVACalculator.totalMean(samples) * 100)/100.00;  

	}//end getTotalMean


	public double getLocalMean(int location)
	{

		return Math.round(samples.get(location).getMean() * 100)/100.00;

	}//end getLocalMean 


	public ArrayList<Double> getFTest()
	{

		
		//if the if the normality assumption is passed 
		ArrayList<Double> results = new ArrayList<Double>();
		results.add(1.0);
		results.add(1.0);
		results.add(ANOVACalculator.fStatistic(this.samples));

		return results;
	}//end getFTest method 




}//end class 