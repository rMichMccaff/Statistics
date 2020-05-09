/*

The goal of the class is to create a program capable of eliminating known and controlled nuiscence variables from an experiment


GLOBAL VARIABLES 
ArrayList blocks 
ArrayList treatments


CONSTRUCTOR 
BlockedSample(ArrayList blocks, ArrayList treatments)

METHODS
blockSize()
treatementSize()
ssBlocks()
ssTreatments()
ssErrors()
ssTotal()
msBlocks()
msTreatments()
msErrors()
msTotal

*/
import java.util.ArrayList;
import java.util.Collections; 


public class BlockedSample
{

	ArrayList<Sample> blocks; 
	ArrayList<Sample> treatments; 


	public BlockedSample(ArrayList<Sample> blocks , ArrayList<Sample> treatments)
	{

		this.blocks = new ArrayList<Sample>(); 
		this.treatments = new ArrayList<Sample>(); 

		for (int i = 0 ; i < blocks.size() ; i++ ) 
		{
			
			this.blocks.add( blocks.get(i) );

		}//end for loop 

		for (int i = 0 ; i < treatments.size() ; i++ ) 
		{
			
			this.treatments.add( treatments.get(i) );

		}//end for loop 

	}//end constructor 


	public int blockSize()
	{

		return this.blocks.size(); 

	}//end blockSize()


	public int treatmentSize()
	{

		return this.treatments.size(); 

	}//end treatementSize() 


	public Sample getIthBlock(int i)
	{

		return this.blocks.get(i); 

	}//end getIthBlock()


	public Sample getIthTreatment(int i)
	{

		return this.treatments.get(i); 

	}//end getIthTreatment


	public double blockedSampleMean()
	{

		double sum = BlockingCalculator.sampleSum(this.treatments);

		double sampleSize = blockSize() * treatmentSize(); 


		return sum/sampleSize; 

	}//end blockedSampleMean


	public double ithBlockMean(int i)
	{

		return SampleCalculator.mean( this.blocks.get(i) );


	}//end ithBlockMean()


	public double getIthTreatmentMean(int i)
	{

		double sum = SampleCalculator.sum( this.treatments.get(i) );

		return sum/this.blocks.size(); 

	}//end getIthTreatmentMean()


	public double ssTreatments()
	{

		return blockSize() * BlockingCalculator.ssTreatments(this.treatments,blockedSampleMean()); 

	}//end ssTreatments


	public double ssBlocks()
	{

		return treatmentSize() * BlockingCalculator.ssBlocks(this.blocks,blockedSampleMean()); 

	}//end ssBlocks()


	public double ssErrors()
	{

		return BlockingCalculator.ssErrors(this.treatments,this.blocks,blockedSampleMean());  

	
	}//end ssErrors 


	public double msTreatments()
	{

		return (ssTreatments())/(treatmentSize() - 1);

	}//end msTreatments()


	public double msBlocks()
	{

		return (ssBlocks()/(blockSize() -1));

	}//end msBlocks()


	public double msErrors()
	{

		return ((ssErrors())/( (treatmentSize() - 1) * (blockSize() - 1) ) );

	}//end msErrors()


	public double fStatistic()
	{

		return msTreatments()/msErrors();

	}//end fStatistic()




}//end class 