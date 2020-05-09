/*

The main idea of the runner is going to read in from a given text file the start of 
a sample will be given with a character 's' an answer will be logged folling an 'a'.

The idea will be to make a sample object using the SampleBuilder.  Note, there should
be two samples with an 's'. The samples should be stored in an arraylist of samples.  
An experiment is then constructed and the result is displayed.  The test result is then 
compared to the other.  

The ANOVA portion will read in several samples and output the format for the text
file will be one that each line will start with an integer which will tell the 
scanner how long to read for the scanner will then read, create a sample and then 
add the sample to the list and run the ANOVA test and print the result


Ideally, I would like to have this read over several samples for each putting a loop 
in after the choice 

*/

import java.util.Scanner;
import java.io.File;	
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Runner
{


	public static void main(String[] args) 
	{
	
		
		//ask the user if they want to do ANOVA or Simple Experiment
		//build scanner 
		Scanner scan = new Scanner(System.in); 
		System.out.println(" Enter '1' for a Simple Experiment and enter '2' for ANOVA. ");
		System.out.println();
		int choice = scan.nextInt(); 

		//if the the user chooses Simple Experiment 
		if(choice == 1)
		{

			//execute simple experiment method 
			simpleExperiment(); 

		}//end if statement


		//if the user chooses the ANOVA path 		
		if(choice == 2)
		{


			//execute ANOVA experiment method
			anova();

		}//end if
		
 

	}//end main



	//SimpleExperiment
	public static void simpleExperiment()
	{

		//create a file object 
		try
		{

			File simpleExperiment = new File("Experiment.txt"); 
			Scanner newScanner = new Scanner(simpleExperiment);		

			ArrayList<Sample> sampleList = new ArrayList<Sample>();
			ArrayList<Observation> observationList1 = new ArrayList<Observation>(); 
			ArrayList<Observation> observationList2 = new ArrayList<Observation>(); 

			int length = newScanner.nextInt(); 

			while(length != 0)
			{

				observationList1.add(new Observation(newScanner.nextDouble() , length--) );

			}
			sampleList.add(new Sample( observationList1) );


			//read the second line 
			length = newScanner.nextInt();

				//create a sample 
			while(length != 0)
			{

				observationList2.add( new Observation(newScanner.nextDouble() , length--) ); 

			}
			sampleList.add(new Sample(observationList2) );	
			//create an experiment 

			SimpleExperiment experiment = new SimpleExperiment( sampleList.get(0) , sampleList.get(1) );


			//print result 
			System.out.println(" The result of the experiment is  " + experiment.testStatistic() ); 
		}
		
		catch(FileNotFoundException e)
		{

			e.printStackTrace();

		}



		



	}//end simpleExperiment method 



	public static void anova()
	{

		try
		{

			//create a file object 
			File anovaFile = new File("ANOVAFile.txt"); 

			//create a scanner object 
			Scanner scan = new Scanner(anovaFile); 
			//create a boolean which is toggled by the character 'c'
			boolean exitBoolean = true; 

			//create an arraylist of samples 
			ArrayList<Sample> anovaSampleList = new ArrayList<Sample>(); 

			//read the first number which tells you how many samples there are 
			int length = scan.nextInt(); 
			//create a while loop to read over the collection of samples
			while(length != 0)
			{

				//read the first number of the sample line telling read length 
				int sampleLength = scan.nextInt();

				int observationCounter = 1;
 				
				ArrayList<Observation> observationList = new ArrayList<Observation>();


				//create a while loop to read over a line of text 
				while(sampleLength != 0)
				{

					//create an observation 
					observationList.add(new Observation( scan.nextDouble() ,observationCounter++) ); 
					sampleLength--;

				}//end while 

				//build a sample using the observation list 
				anovaSampleList.add( new Sample( observationList ) ); 

				//deincrement length 
				length--;

			}//end while loop 
			Anova anova = new Anova(anovaSampleList); 
			System.out.println(anova.getFTest()); 


		}//end try
		catch(FileNotFoundException e)
		{

			e.printStackTrace();

		}//end catch


	}//end anova method 



}//end class 