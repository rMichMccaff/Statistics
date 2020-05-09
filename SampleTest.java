import java.util.ArrayList; 

public class SampleTest
{


	static Observation obs1;
	static Observation obs2;
	static Observation obs3;
	static Observation obs4;
	static Observation obs5;
	static Observation obs6;
	static Observation obs7;
	static Observation obs8;
	static Observation obs9; 
	static Observation obs10; 

	static ArrayList<Observation> sampleList1;
	static ArrayList<Observation> sampleList2; 

	static Sample sample1; 
	static Sample sample2; 


	public static void main(String[] args) 
	{
		
		//initialize test cases 
		initializeTestCases(); 
		getSampleListTest(); 
		comparisonTest(); 
		sampleConstructorTest(); 
		setSampleListTest();


	}//end main 


	public static void initializeTestCases()
	{

		obs1 = new Observation(5,1);
		obs2 = new Observation(8,2);
		obs3 = new Observation(2,3);
		obs4 = new Observation(10,4);
		obs5 = new Observation(13,5);
		obs6 = new Observation(5,1);
		obs7 = new Observation(8,2);
		obs8 = new Observation(2,3);
		obs9 = new Observation(7,4);
		obs10 = new Observation(20,5);

		sampleList1 = new ArrayList<Observation>();
		sampleList2 = new ArrayList<Observation>(); 

		sampleList1.add(obs1);
		sampleList1.add(obs2);
		sampleList1.add(obs3);
		sampleList1.add(obs4);
		sampleList1.add(obs5);
		sampleList2.add(obs6);
		sampleList2.add(obs7);
		sampleList2.add(obs8);
		sampleList2.add(obs9);
		sampleList2.add(obs10);


		sample1 = new Sample(sampleList1);
		sample2 = new Sample(sampleList2);  
	
	}//end initializeTestCases


	public static void getSampleListTest()
	{
 



		boolean getSampleBool1 = true;
		for(int i = 0 ; i < sample1.getSize() ; i++ ) 
		{
		

			if(sample1.getSampleList().get(i).compareObservation(sampleList1.get(i)) == false)
			{

				getSampleBool1 = false;

			}//end if 

		}//end for loop

		boolean getSampleBoolFalse = true;  
		for(int i = 0 ; i < sample1.getSize() ; i++ ) 
		{
			
			if( sample2.getSampleList().get(i).compareObservation(sampleList1.get(i)) == false )
			{

				getSampleBoolFalse = false; 

			}//end if 

		}//end for loop 

		boolean getSampleBool2 = true; 
		for(int i = 0 ; i < sampleList2.size() ; i++ ) 
		{
			
			if(sample2.getSampleList().get(i).compareObservation(sampleList2.get(i)) == false)
			{

				getSampleBool2 = false; 

			}//end if 

		}//end for loop 

		if(getSampleBool1 == true )
		{

			System.out.println("Test PASSED for getSampleList for sample 1 with itself");

		}
		if(getSampleBoolFalse == false)
		{

			System.out.println("Test PASSED for getSampleList for false comparison");	

		}
		if(getSampleBool2 == true)
		{

			System.out.println("Test PASSED for getSampleList for sample 2 with itself"); 

		}


	}//end getSampleList 


	public static void comparisonTest()
	{

		boolean compareBoolean1 = false;
		if(sample1.compareSample(sample1) == true)
		{

			compareBoolean1 = true; 

		}

		boolean compareBoolean2 = false;
		if(sample1.compareSample(sample2) == false)
		{

			compareBoolean2 = true;  	

		}

		boolean compareBoolean3 = false; 
		if(sample2.compareSample(sample1) == false )
		{

			compareBoolean3 = true; 

		}
		if(compareBoolean1 == true)
		{

			System.out.println("Test PASSED for comparing sample1 with itself.");

		}
		if(compareBoolean2 == true)
		{

			System.out.println("Test PASSED for comparing sample 1 and sample 2"); 

		}
		if(compareBoolean3 == true)
		{

			System.out.println("Test PASSED for comparing sample 1 and sample 2 in reverse order"); 

		}

	}//end comparisonTest


	public static void sampleConstructorTest()
	{

		Sample newSample = new Sample(sample1);

		if(newSample.compareSample(sample1) == true)
		{

			System.out.println("Test PASSED for constructor with Sample Object"); 

		} 

		if(newSample.compareSample(sample2) == false)
		{

			System.out.println("Test PASSED for for constructor with Sample Object false"); 

		}


	}//end sampleConstructorTest

	public static void setSampleListTest()
	{

		Sample sampleRestore = sample1.getSample(); 
		sample1.setSampleList(sample2.getSampleList());
		if(sample2.compareSample(sample1) == true)
		{

			System.out.println("Test PASSED set Sample1 with Sample2 list"); 

		} 
		if(sample1.compareSample(sampleRestore) == false)
		{
		
			System.out.println("Test PASSED set Sample1 with Sample2 list false test"); 

		}

		sample1.setSampleList(sampleList1);

		if(sample1.compareSample(sampleRestore) == true )
		{

			System.out.println("Test PASSED for sampleRestore and sample1 turned back to original state"); 
		}

	}//end setSampleListTest

	public static void setSampleTest()
	{

		sample1.setSample(sample2);
		if(sample1.compareSample(sample2) == true)
		{

			System.out.println("Test PASSED changed sample1 to sample2"); 

		} 
		sample1.setSampleList(sampleList1);
		if(sample1.compareSample(sample2) == false)
		{

			System.out.println("Test PASSED changed sample1 back to original and ran false case");

		}


	}//end setSampleTest


}//end class 