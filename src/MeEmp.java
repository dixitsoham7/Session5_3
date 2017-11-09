/*Three types of Leaves are mentioned in the problem , our task is to manage the leaves and also we have to print 
 *salary based on criteria's given .Employee can take paid leave, casual leave or sick leave. In our application if
 *employee asks for leaves then it is checked with his balance leaves if his balance leaves are positive then he is
 *allowed to take leave or else he is not allowed to. Allowed number of paid leaves, sick leaves or casual leaves in our
 *application is 10. Application is implemented using OOPS concepts as follows :
 */

import java.util.Scanner;
class Employee //Base class which is further inherited
{
	//creating required variables
    int empId;
    String empName;
    int total_leaves;
    double total_salary;
    int bal_leave;
    int paid_leavet,sick_leavet,casual_leavet;
    int paid_leave,sick_leave,casual_leave;
    
    double basic,hra,pf; //variables essential for calculating salary
    
    Scanner sc=new Scanner(System.in);  //creating object of Scanner class
    
    void getEmpInfo() // getEmpInfo method to get required details of employee
    {
        System.out.print("Enter Employee ID : "); //inputting id
        empId=sc.nextInt(); //storing id
        System.out.print("Enter Employee Name : ");  //inputting name
        empName=sc.next(); //storing name
      
    }
    void calculate_balance_leaves() // calculate_balance_leaves method to check no of leaves left for the employee
    {
         System.out.print("Enter No of Leaves taken : ");  //entering leaves
         int leave_taken=sc.nextInt();  //storing leaves
         bal_leave=total_leaves-leave_taken;  //balance = total - taken;
         System.out.print("Total balance leaves : "+bal_leave);  //printing balance leaves
    }
    
    boolean avail_leave(int no_of_leaves,char type_of_leave) // avail_leave method to check whether employee can take a leave or not (applicable for casual leaves)
    {
       if(no_of_leaves<bal_leave && type_of_leave=='C')
        return true;   //if it is possible for employee to take leave based on condition
       else
        return false;   //if there are no balance leaves
       
    }
    void calculate_salary()  //method to calculate salary
    { }
}

class PermanentEmp extends Employee //PermanentEmp derived class
{
	
	 public PermanentEmp() //Constructor of child class
	 {
		//initializing
	     paid_leave=10;   
	     sick_leave=10;
	     casual_leave=10;
	 }
	 void print_leave_details() // method to print leave details
	 {
	     System.out.print("Paid leave: "+paid_leave);
	     System.out.print("Sick_leave: "+sick_leave);
	     System.out.print("Casual Leave: "+casual_leave);
	 }
	 void calculate_balance_leaves() // method to calculate balance leaves
	 {
		 System.out.println("------------------------------------------");
		 System.out.println("Note : Maximum no of each type of Leaves you can take is 10 :) ");
		 System.out.println("------------------------------------------");
		 System.out.print("Enter No of CASUAL LEAVES taken : ");
	     int casual_leavetaken=sc.nextInt();
	     System.out.print("Enter No of SICK LEAVES taken : ");
	     int sick_leavetaken=sc.nextInt();
	     System.out.print("Enter No of PAID LEAVES taken : ");
	     int paid_leavetaken=sc.nextInt();
	     
	     System.out.println("------------------------------------------");
	     
	     //if leaves are greater than 10 than you cannot take leave if you take then they are deducted from your remaining balance leaves
	     
	     int bcasual_leave=casual_leave-casual_leavetaken;
	     if(casual_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore CASUAL LEAVES");
	     }
	     if(casual_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+bcasual_leave+" more CASUAL LEAVES");
	     }
	     
	     int bsick_leave=sick_leave-sick_leavetaken;
	     if(sick_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore SICK LEAVES");
	     }
	     if(sick_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+bsick_leave+" more SICK LEAVES");
	     }
	     
	     int bpaid_leave=paid_leave-paid_leavetaken;
	     if(paid_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore PAID LEAVES");
	     }
	     if(paid_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+bpaid_leave+" more PAID LEAVES");
	     }
	     
	     bal_leave=bcasual_leave+bsick_leave+bpaid_leave;
	     System.out.println("------------------------------------------");
	     System.out.println("Total BALANCE LEAVES : "+bal_leave+" which can be categorized as follows : ");
    
         System.out.println("CASUAL LEAVES : "+bcasual_leave);
         System.out.println("SICK LEAVES : "+bsick_leave);
         System.out.println("PAID LEAVES : "+bpaid_leave);
         System.out.println("------------------------------------------");
	 }
	 
	 boolean avail_leave(int no_of_leaves,char type_of_leave) // method for avail_leave
	    {
	        return true;
	    }
	 
	 void calculate_salary() // calculate_salary method to calculate employees salary
	{
	     System.out.print("Enter Basic Salary for Permanent Employee : "); //inputting salary
	     basic=sc.nextDouble();
	     
	     //based on the given rates
	     pf=basic*12/100;
	     hra=basic*50/100;
	     total_salary=(basic+hra)-pf;
	     System.out.println("------------------------------------------");
	     System.out.println("TOTAL SALARY of Permanent Employee : "+total_salary);
	     System.out.println("------------------------------------------");
	}
}

class TemporaryEmp extends Employee  //TemporaryEmp derived class
{
    TemporaryEmp() //Constructor
    {
	     paid_leave=10;
	     sick_leave=10;
	     casual_leave=10;
    }
    void calculate_balance_leaves() // method for  calculate balance leaves
    {
    	 System.out.println("------------------------------------------");
    	 System.out.println("Note : Maximum no of each type of Leaves you can take is 10 :) ");
    	 System.out.println("------------------------------------------");
    	 System.out.print("Enter No of CASUAL LEAVES taken : ");
         int casual_leavetaken=sc.nextInt();
         System.out.print("Enter No of SICK LEAVES taken : ");
         int sick_leavetaken=sc.nextInt();
         System.out.print("Enter No of PAID LEAVES taken : ");
         int paid_leavetaken=sc.nextInt();
         
         System.out.println("------------------------------------------");
         casual_leave=casual_leave-casual_leavetaken;
         if(casual_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore CASUAL LEAVES");
	     }
	     if(casual_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+casual_leave+" more CASUAL LEAVES");
	     }
         sick_leave=sick_leave-sick_leavetaken;
         if(sick_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore SICK LEAVES");
	     }
	     if(sick_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+sick_leave+" more SICK LEAVES");
	     }
         
         paid_leave=paid_leave-paid_leavetaken;
         if(paid_leavetaken>10)
	     {
	    	 System.out.println("You cannot take anymore PAID LEAVES");
	     }
	     if(paid_leavetaken<=10)
	     {
	    	 System.out.println("You can take "+paid_leave+" more PAID LEAVES");
	     }
	     System.out.println("------------------------------------------");
	     bal_leave=casual_leave+sick_leave+paid_leave;
         System.out.println("Total BALANCE LEAVES : "+bal_leave+" which can be categorized as follows : ");
         System.out.println("CASUAL LEAVES : "+casual_leave);
         System.out.println("SICK LEAVES : "+sick_leave);
         System.out.println("PAID LEAVES : "+paid_leave);
         System.out.println("------------------------------------------");
         
    }
    boolean avail_leave(int no_of_leaves,char type_of_leave) // method for avail_leave
    {
        return true;
    }
    
    void calculate_salary() // calculate_salary method
    {
         System.out.print("Enter Temporary Employee Salary: "); //inputing salary
         basic=sc.nextDouble();
         //based on given rates
         pf=(basic*12)/100;
         hra=(basic*50)/100;
         total_salary=(basic+hra)-pf;
         System.out.println("------------------------------------------");
         System.out.println("Total Salary of Temporary Employee : "+total_salary); //printing
    }
}


public class MeEmp 
{

	public static void main(String[] args) 
	{
		char c;
		String s;
		int no_of_leaves;
		Scanner sc=new Scanner(System.in);
		
		//Permanent Employee Details
		PermanentEmp p_emp =new PermanentEmp();  //creating object for first child class
		System.out.println("Enter the Permanent Employee Details : ");
		System.out.println("------------------------------------------");
		p_emp.getEmpInfo();		
		p_emp.calculate_salary();
		System.out.print("Enter type of leave taken : \nC for CASUAL \nP for PAID \nS for SICK -> ");
		s=sc.next();
		c=s.charAt(0);
		   
		   
		System.out.print("Enter Total Number of Days Leave taken : ");
		no_of_leaves=sc.nextInt();
		if(p_emp.avail_leave(no_of_leaves, c))
		{
			p_emp.calculate_balance_leaves();
		}
		
		
		//Temporary Employee Details
		System.out.println("\nEnter the Temporary Employee Details : ");
		System.out.println("------------------------------------------");
		TemporaryEmp t_emp=new TemporaryEmp();  //creating object for second child class
		t_emp.getEmpInfo();		
		t_emp.calculate_salary();
		System.out.println("------------------------------------------");
		System.out.print("Enter type of leave taken : \nC for CASUAL\nP for PAID \nS for SICK -> ");
		s=sc.next();
		c=s.charAt(0);
		   
		   
		System.out.print("Enter Total Number of Days Leave taken : ");
		no_of_leaves=sc.nextInt();
		if(t_emp.avail_leave(no_of_leaves, c))
		{
			t_emp.calculate_balance_leaves();
		}
		sc.close();

	}

}