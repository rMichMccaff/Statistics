import java.util.ArrayList;

public class SampleCalcTest
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

		initializeTestCases(); 
		meanTest();
		standardDevTest();

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


	public static void meanTest()
	{


		if(SampleCalculator.mean(sample1) == 7.6)
		{

			System.out.println("Test PASSED for sample mean sample1"); 

		}//end if 		
	
		if(SampleCalculator.mean(sample2) == 8.4)
		{

			System.out.println("Test PASSED for sample mean sample2");

		}//end if 

	}//end mean test



	public static void standardDevTest()
	{
		if((Math.round(SampleCalculator.standardDeviation(sample1,sample1.getMean()) * 100) / 100.00) == 4.28) 
		{
		
			System.out.println("Test PASSED for standardDevTest sample1");


		}

		if((Math.round(SampleCalculator.standardDeviation(sample2,sample2.getMean()) * 100) / 100.00) == 6.88)
		{

			System.out.println("Test PASSED for standardDevTest sample2"); 

		}

	}//end standardDevTest
}//end class 