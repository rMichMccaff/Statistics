/*

The purpose of the class is to run a test on the BlockedSample and BlockingCalculator methods.  
The Main method for the program reads in data from an text file where a blocked sample is given.  
The first two lines of the text tile tell the number of treatments and the number of blocks.  
There will be a couple of miniproblems that will need to be dealt with.  First when reading in 
the data from the text file we're going to need to build one arrayList to to make our treatments. 
The next step is then to build the blocks by iterating over the treatments.  Finally we then build 
a BlockedSample  

*/
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.ArrayList; 
import java.util.Scanner; 

public class BlockedSampleCalcTest
{


	public static void main(String[] args) 
	{

		try
		{

			
			/*
			  create a file object and scanner object using the file object as
			  a parameter of the scanner object
			*/
			File experiment = new File("BlockingExperiment.txt"); 
			Scanner reader = new Scanner(experiment);
			

			/*
			  Read the first two integers to get an idea of how many blocks and treatments there 
			  are in the sample.   	  	
			*/
			int blocks = reader.nextInt(); 
			int treatments = reader.nextInt(); 


			/*
			  Create an arraylist of samples for the treatments. 
			*/
			ArrayList<Sample> treatment = new ArrayList<Sample>(); 

			
			/*
			  Read over the text document to build the treatments list read them in batches which 
			  divide them into samples 
			*/
			for (int i = 0 ; i < treatments ; i++ ) 
			{
			
				ArrayList<Observation> observationList = new ArrayList<Observation>(); 

				for (int j = 0 ; j < blocks ; j++ ) 
				{
					observationList.add( new Observation(reader.nextDouble() , j ) );
				}//end for 

				treatment.add( new Sample(observationList) ); 
			
			}//end for 

			/*
			  Read over the treatements list and build an arraylist of samples which divide the blocks
			*/
			ArrayList<Sample> block = new ArrayList<Sample>(); 
			for (int i = 0 ; i < blocks ; i++ ) 
			{

				ArrayList<Observation> localObservationList = new ArrayList<Observation>(); 
				for (int j = 0 ; j < treatments ; j++ ) 
				{

					localObservationList.add(new Observation 
											(treatment.get(j).getSampleList().get(i).getObservationValue(),
											 i ) 
											 );	

				}//end for loop 
				
				block.add( new Sample(localObservationList) );

			}//end for 

			BlockedSample sample = new BlockedSample(block,treatment);

			blockSizeTest(sample);
			treatmentSizeTest(sample);
			ssBlockTest(sample);
			ssTreatmentTest(sample);
			ssErrorsTest(sample);
			msBlockTest(sample);
			msTreatmentTest(sample); 
			msErrorsTest(sample);
			fStatisticTest(sample); 


		}//end try 
		catch(FileNotFoundException e)
		{

			System.out.println("Error");

		}//end catch
	
	}//end main


	public static void blockSizeTest(BlockedSample sample)
	{

		System.out.println(); 
		System.out.println("*****BLOCK SIZE TEST*****");
		System.out.println("The block size is " + sample.blockSize());
		System.out.println("*************************");  

	}//end blockSizeTest() 


	public static void treatmentSizeTest(BlockedSample sample)
	{

		System.out.println(); 
		System.out.println("*****TREATMENT SIZE TEST*****");
		System.out.println("The treatment size is " + sample.treatmentSize());
		System.out.println("*****************************"); 

	}//end treatmentSizeTest() 

	public static void ssBlockTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****SSBLOCKTEST*****");
		System.out.println("ssBlocks are " + sample.ssBlocks());
		System.out.println("*********************"); 

		
	}//end ssBlockTest


	public static void msBlockTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****MSBLOCKTEST*****");
		System.out.println("msBlocks are " + sample.msBlocks() ) ;
		System.out.println("**********************");


	}//msBlockTest

	
	public static void ssTreatmentTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****SSTREATMENTTEST*****");
		System.out.println("ssTreatments are " + sample.ssTreatments() );  
		System.out.println("*************************"); 

	}//end ssTreatmentTest


	public static void msTreatmentTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****MSTREATMENTTEST*****");
		System.out.println("msTreatments are " + sample.msTreatments() );
		System.out.println("**************************");


	}//end msTreatmentTest


	public static void ssErrorsTest(BlockedSample sample)
	{

		System.out.println(); 
		System.out.println("*****SSERRORSTEST*****"); 
		System.out.println("ssErrors are " + sample.ssErrors() ); 
		System.out.println("***********************"); 


	}//end ssErrorsTest


	public static void msErrorsTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****MSERRORSTEST*****");
		System.out.println("msErrors are " + sample.msErrors() );
		System.out.println("***********************");


	}//end msErrorsTest


	public static void ssTotalsTest()
	{



	}//end ssTotalsTest


	public static void treatmentMeanTest()
	{


	}//end treatmentMeanTest 


	public static void blockMeanTest()
	{



	}//end blockMeanTest



	public static void fStatisticTest(BlockedSample sample)
	{

		System.out.println();
		System.out.println("*****FSTATISTICTEST*****");
		System.out.println("fStatistic is " + sample.fStatistic());
		System.out.println("*************************");


	}//end fStatisticTest


}//end class 