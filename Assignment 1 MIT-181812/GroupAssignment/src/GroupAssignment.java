/*...........................................................

MIT: 18 
Name: Turzo Ahsan Sami
ID: 181812
Course: MIT E 412
Assignment: 01

Problem Statement: 
Write a Java class named GroupAssignment.  
Write a method named assignGroup(int, int) which get two integers, for number of students and number of groups respectively. 
This method also ask you for course name using scanner. 
This method also does randomly uqual distributed group members for the respected students and groups. 
Complete the code for this method.
 
Input: assignGroup(10, 3); Course: Advanced OOP
 
Output: 
Course: Advanced OOP
Group 1: 2 5 7 10
Group 2: 1 6 8
Group 3: 3 4 9 
 
 ...............................................................*/


import java.util.*;


public class GroupAssignment {

	private int numStudents;
	private int numGroups;
	private String courseName;
	private Scanner input;
	private Random num;
	
	private void AssignCourseName()  {
		
		System.out.println("Input course Name: ");
		input = new Scanner(System.in); 
		this.courseName = input.nextLine(); 
        System.out.println();
        System.out.println("Course: " + this.courseName); 
        
	}	// End of method - AssignCourseName
	
	private void AssignMembers(int numStudents, int numGroups) {
		
		this.numStudents = numStudents;
		this.numGroups = numGroups;
		num = new Random();
		
		System.out.println("Students: " + this.numStudents + " Groups:" + this.numGroups);
		
		int studentsPerGroup = (this.numStudents / this.numGroups);	// minimum number of students in each group
		int rem = this.numStudents % this.numGroups;				// remaining students 
		
		int[][] groups = new int[this.numGroups +1][this.numStudents + 1];
		
		int[] randomRolls = new int[this.numStudents + 1];
			
				
		for(int i=1; i<=this.numStudents; i++)
		{
			randomRolls[i] = -1;		  		
		} 
		
		
		// assigning equal number of students in each group		
		for(int i=1; i<=this.numGroups; i++)
		{
			int j = 1;
			while(j<=studentsPerGroup)
			{
				int n = 1 + num.nextInt(this.numStudents);
				if(randomRolls[n] == -1)
				{					
					groups[i][j] = randomRolls[n] = n;
					j++;
				}
			}
		}
		
		
		// assigning the rest of the students to groups 				
		int i = 1; int j = studentsPerGroup + 1;
		while(i<=rem)
		{
			int n = 1 + num.nextInt(this.numStudents);
			if(randomRolls[n] == -1)
			{					
				groups[i][j] = randomRolls[n] = n;
				i++;
			}
		}
		
		
		// Output		
		for(int x=1; x<=this.numGroups; x++) 
		{
			System.out.print("Group "+x+" : ");
			for(int y=1; y<=(studentsPerGroup+1); y++)
			{
				System.out.print(groups[x][y] + " ");
			}
			System.out.println();
		}
		
		
	} // End of method - AssignMembers
	
	public static void main(String[] args) {
		GroupAssignment g1 = new GroupAssignment(); // 1st object
		g1.AssignCourseName();
		g1.AssignMembers(15, 4);  
		
		System.out.println();
		
		GroupAssignment g2 = new GroupAssignment(); // 2nd object
		g2.AssignMembers(41, 8); 
	}	// End of main method

} // End of Class GroupAssignment
