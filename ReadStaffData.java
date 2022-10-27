

import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;


public class ReadStaffData {

	public static void main(String[] args) throws Exception{
		//parsing and reading the CSV file data into the staff (object) array
		// provide the path here...
        File directory = new File("./");
  		String name = directory.getAbsolutePath() + "//Staff.csv";
		Scanner sc = new Scanner(new File(name));
		ArrayList<Staff> staffs = new ArrayList<Staff>();

		// this will just print the header in CSV file
		sc.nextLine();

		int i = 0; String st = "";
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		
		while (sc.hasNextLine())  //returns a boolean value
		{
			st = sc.nextLine();
			String[] data = st.split(",");
			staffs.add(new Staff(Integer.parseInt(data[0]), data[1], data[2], ft.parse(data[3]), Float.parseFloat(data[4]), ft.parse(data[5])));
		}
		sc.close();  //closes the scanner
		 
		// We can print staff details due to overridden toString method in film class

		// we can compare staff based on their ID due to overridden CompareTo method in film class
		//Print top 50 rows
		
		
		////Part 1
		////////Question 1 && 2/////Sorting the data && Testing the time complexity of quick sort algorithm
		System.out.println("==================================ALGoRiTHeM CA================================================================================================================");
		System.out.println("Jama Massalha\n" +"21118426" );
		System.out.println();
		System.out.println("Part 1: Sorting && Searching algorithem");
		System.out.println();
		long start_time_sorting = System.nanoTime();
        Staff.quickSort(staffs, 0, staffs.size()-1);
        
        
       
        //Printing 10000 records from sorted list
        System.out.println("Sorting 10000 records");
        for(int emp=0;emp<staffs.size()-1;emp++)
       	
        //Printing 5000 records from sorted list
        //System.out.println("Sorting 5000 records");
        //for(int emp=0;emp<5000;emp++) 
        
   
        //Printing 1000 records from sorted list
        //System.out.println("Sorting 1000 records");
        //for(int emp=0;emp<1000;emp++)
        
         //Printing 100 records from sorted list
        //System.out.println("Sorting 100 records");
        //for(int emp=0;emp<100;emp++)
        
        //Printing 10 records from sorted list
        //System.out.println("Sorting 10 records");
        //for(int emp=0;emp<10;emp++)
        
        //Printing 1 records from sorted list
        //System.out.println("Sorting 1 record");
        //for(int emp=0;emp<1;emp++)
        
       
        
        
        {
			System.out.println(staffs.get(emp).toString());
		}
        long end_time_sorting = System.nanoTime();
        long elapsed_time_sorting = end_time_sorting-start_time_sorting;
        System.out.println();
        System.out.println("==================Time Complexity Qucik Sort=============================================================================");
        System.out.println();
        System.out.println("Execution time of quickSort in Nano Second: " + elapsed_time_sorting);
        System.out.println("Execution time of quickSort in Milliseconds: " + elapsed_time_sorting / 1000000);
        System.out.println("Execution time of quickSort in Second: " + elapsed_time_sorting / 100000000);
        System.out.println();
		System.out.println("===========================================================================================================================");
       
       
       ////////////////////////////////////Questions 3 && 4//////////////////////////////////////////////////////////////////////
		
		System.out.println("---------------QUESTIONS 3 && 4-----------");
		System.out.println();
        // Using Binary Search to find records with birth date.
        // It returns the ArrayList of indexes
       
		ArrayList<Integer> index_array = new ArrayList<Integer>();
		long start_time_searching = System.nanoTime();
		
		
		//we test our searching method with non existing record.
		//index_array = Staff.binarySearch(staffs, ft.parse("1976-02-24"));
		
		//we test our searching method with existing record.
		index_array = Staff.binarySearch(staffs, ft.parse("1990-02-04"));
		
		
		if(index_array.size()!=0)//if the array is not empty
		{
			for(Integer emp :index_array)
			{
				System.out.println("All Matches\n" + staffs.get(emp).toString());
			}
		}
		else
		{
			System.out.println("Not an existing X!" );
			
		} 
		
		 long end_time_searching = System.nanoTime();
	     long elapsed_time_searching = end_time_searching - start_time_searching;
	     System.out.println();
	     System.out.println("==================Time Complexity Binary Search================================================================================================================");
	     System.out.println();
         System.out.println("Execution time of Binary Search in NanoSecond: " + elapsed_time_searching);
         System.out.println("Execution time of Binary Search in Milliseconds: " + elapsed_time_searching / 1000000);
         System.out.println("Execution time of Binary Search in Second: " + elapsed_time_searching / 100000000);
         System.out.println();
         
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
         //Part 2: Defensive Programming and Exception Handling
        //Questions 1, 2, 3
        // New record input validation and testing
         //Question 1 accept new record 
        System.out.println("===============================================================================================================================================================");
        System.out.println();
        System.out.println("Part 2: Defensive Programming and Exception Handling");
        System.out.println("Questions 1, 2, 3");
        System.out.println();
		System.out.println("Input new record : ");
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			//Using Scanner class to accept user input
			String input = scan.nextLine();
			/*Substring is a frequently used method in the java lang package.
			 *  String class that is used to split larger strings into smaller ones.
			 *  Because strings in Java are immutable, the old string is preserved,
			 *  and the method returns a new string.*/
			input = input.substring(1,input.length());
			String[] data = input.split(",");
			//System.out.println(data[2]);
			//Date d1=ft.parse(data[2]);
			boolean tmp=Staff.validate(data);
			if(tmp==true) ////returns a boolean value
			{
				//determining the input data and increasing the data set size by 1 once a new record has been entered. [new Staff(staffs.size()+1].
				// add: first name, last name, 
				staffs.add(new Staff(staffs.size()+1, data[0], data[1], ft.parse(data[2]), Float.parseFloat(data[3]), ft.parse(data[4])));
				break;
			}
		}
		System.out.println(staffs.get(staffs.size()-1).toString());
		
	}

}


class Staff implements Comparable<Object>{

	private int empNo;
	private String fName;
	private String sName;
	private Date birthDate;
	private float wage;
	private Date hireDate;


	// constructor
	public Staff(int empNo, String fName, String sName, Date birthDate, float wage, Date hireDate) {
		super();
		this.empNo = empNo;
		this.fName= fName;
		this.sName= sName;
		this.birthDate= birthDate;
		this.wage = wage;
		this.hireDate = hireDate;
	}

	// setters and getters
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getWage(){
		return wage;
	}

	public void setWage(float wage){
		this.wage = wage;
	}
	@Override
	public int compareTo(Object obj) {
		//comparing object to another 
		Staff sff = (Staff)obj;
		//creating a new integer "temp" and assign it to birthDate to be able to compare the object according to birthDate 
		int tmp=birthDate.compareTo(sff.birthDate);
		if(tmp==0)//if the birthDate of both object match each other then return 0; 
		{
			//if this object is less than the other then return -1
			if(empNo<sff.empNo)
				tmp=-1;
			//if this object is greater than the other then return 1
			else if(empNo>sff.empNo)
				tmp=1;
			//if this object is equal other then return 0 
			else
				tmp=0;
		}
		return tmp; 
	}

	@Override
	public String toString() {
		return "\n Staff [EmpNo\t" + empNo + "\n first name\t" + fName+ "\n last Name\t" + sName+ "\n birth date\t"
				+ birthDate+  "\n wage\t" + wage+ "\n hire date\t"
				+ hireDate+ "]";
	}


	/////////////////////////////////////Quick Sort Method/////////////////////////////////////////////////////////////////////
	//Three stages are needed to build quick sort method.
	//1- First stage is to select an index from a given an array 
	//as pivot to assign it as a comparetor to compare
	//the array's values according to larger or lesser than the pivot's value .
	//2- Second stage is a swap method to be able to swap the values 
	//once they passed the comparison process with pivot value.
	//3- Third stage Partitioning is last but not least,
	// we need to create a method to divide the values according to their size compare to the pivot size,
	// in another word, we need to move all the lower values to the left pivot 
	//and the higher values to the right pivot.
	
	//After all these phases, we call quick sort method recursively
	// to sort both sub arrays
	//(right sub array greater than pivot and left sub array lees than pivot) 
	
	
	//First we are creating a swap method to be able to swap indexes
	static void swap(ArrayList<Staff> array, int index1, int index2)
	{
	 Collections.swap(array, index1, index2);
	}
	
	//Partitioning method, moving all the lower values to the left pivot 
	//and the higher values to the right pivot
	static int partition(ArrayList<Staff> array, int lowIndex, int highIndex)
	{// we select the higher index(last index) in the array as pivot
	 Staff pivot = array.get(highIndex);
	 int index1 = (lowIndex - 1);
	 //here we assign lowIndex is left pointer and highIndex is right pointer to understand how they move 
	 int leftPointer = lowIndex;
	 int rightPointer = highIndex;
	 /*Now we want two pointers to move toward each other
	that rightPointer is going to traverse from left to right
	and leftPointer is going to be traversing from right to left
	and we want to stop when both pointers cross each other, 
	at that point, we call our swap method to allow us to swap the crossing index with pivot */

	 for(int index2 = lowIndex; index2 <= highIndex - 1; index2++)
	 {//if current value is lees than the pivot
	     if (array.get(index2).compareTo(pivot) == -1)
	     {
	         index1++; // increment index of smaller value
	         swap(array, index1, index2);
	     }
	 }
	 swap(array, index1 + 1, highIndex);
	 return (index1 + 1);
	}

	
	
	//creating quick sort and calling it recursively 
	static void quickSort(ArrayList<Staff> array, int lowIndex, int highIndex)
	{
		
	 if (lowIndex < highIndex)
	 {
		 /*recursive calls,, 
		  * we've repositioned the elements so that everything
		  *  to the left of the pivot is smaller than the pivot 
		  *  and everything to the right of the pivot is greater than the pivot,
		  *  and then we call the quick sort the left sub-array and want to quick sort the right sub-array.
		  Once we're finished, the full array will be sorted.*/
	     int pi = partition(array, lowIndex, highIndex);
	     quickSort(array, lowIndex, pi - 1);//before pivot
	     quickSort(array, pi + 1, highIndex);//after pivot
	 }

	}

///////////BinarySearch///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*The algorithm compares the key value to the middle element 
	 *of the array, whether the half is below or above our target value,
	 * and take that half. 
	 * The half in which the key cannot be part of is eliminated, 
	 * and the search for the remaining half continues until it finds.*/
	
	static ArrayList<Integer> binarySearch(ArrayList<Staff> array,Date birthDate)
	{
		int index=biSearchImpl(array,0,9999,birthDate);/*The binarySearch method of the Java Arrays class is called with two arguments: 
		a sortedArray and an int key, which specifies which integers should be searched for in the array of numbers.*/
		ArrayList<Integer> index_array = new ArrayList<Integer>();
		if(index!=-1)// if the given array is not empty
		{
			//check behind the middle point(reversing) the half is less than the target value  
			int i=index-1;
			while (i>=0)
			{	//if the target value is located on determined index then the target values is found.
				if(array.get(i).getBirthDate().compareTo(birthDate)==0)
					index_array.add(i);
				else // if the target value is not on determined index then continue searching
					break;
				i--;//decrement from middle point until the target value is found
			}
			//check after the middle point(forward) the half is greater than the target value
			i=index+1;
			while(i<=9999)
			{	//if the target value is located on determined index then the target values is found.
				if(array.get(i).getBirthDate().compareTo(birthDate)==0)
					index_array.add(i);
				else // if the target value is not on determined index then continue searching
					break;
				i++;//increment from middle point until the target value is found
			}
			return index_array;
		}
		else
		{
			return index_array;
		}
	}
	
	static int biSearchImpl(ArrayList<Staff> array, int left, int right, Date birthDate)
    {
        if (right >= left) {// we need to check if the given data is sorted
            int mid = left + (right - left) / 2;//get the middle point that divides the array into two halves 
            if (array.get(mid).getBirthDate().compareTo(birthDate)==0)
                return mid;//if the our target value is located on the middle point then the target value is found
            
            // if the target value is less than the middle value then continue searching by decrement until you reach the index of the target value.
            if (array.get(mid).getBirthDate().compareTo(birthDate)==1)
                return biSearchImpl(array, left, mid - 1, birthDate);
            
            //where the target value is greater than the middle value, then continue searching by increment until you reach the index of the target value  
            return biSearchImpl(array, mid + 1, right, birthDate);
        }
 
        return -1;// the target value is not in the array
    }
	
	
///////////////////////////////////////////////////////////////////////////////////////////
	//Part 2
	
	static boolean validate(String[] data) throws Exception
	{   //This programme has been developed to validate the user input, and throw an exception in case the input are not matching the program conditions and allowing the user to enter again  
		//using throws an exception to suppress the error that might occur.
		
		//BirthDate check
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		Date d1 = ft.parse("1950-01-01");// reference date to able to validate the input birth date
		Date bDate = ft.parse(data[2]);// applying the validation on data[2] where the birth date located in the data set  
		if(bDate.compareTo(d1)==-1)// we compare the input date with fixed condition "1950-01-01"// if the given date birth is lower than "1950-01-01" its above retirement age,
		{
			System.out.println("Invalid Birth Date (above retirement age), It should be greater than 1950-01-01");
			return false;
		}
		//Age Validation
		Date hire_date=ft.parse(data[4]);// applying the validation on data[4] where the hire date located in the data set
		long time_difference = hire_date.getTime() - bDate.getTime();// taking the hire date and subtracting it from the birth date to get the precise age 
		long years_difference = (time_difference / (1000l*60*60*24*365)); // here is the formula to calculate the exact age.  
		if(years_difference<18)// company should not hire employees younger than 18 years
		{
			System.out.println("company should not hire employees younger than 18 years");
			return false;
		}
		//First Name Validation
		boolean result = data[0].matches("[0-9]+");// applying the validation on data[0] where the first name located in the data set
		if(result==true || data[0].length()==0)// the condition is that the name should not contains number or cannot be left empty
		{
			System.out.println("Employee first_name cannot be empty. It cannot have only digits! Please correct this");
			return false;
		}
		return true;
	}
}