package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Student implements Comparable<Student>{

	public String id, firstName, lastName, eyeColor;
	public int monthsEmployed;
	static ArrayList<Student> roster = new ArrayList<Student>();
	
	public Student(String id, String fName, String lName, String eye, int monEmployed)
	{
		this.id = id;
		firstName = fName;
		lastName = lName;
		eyeColor = eye;
		monthsEmployed = monEmployed;
	}
	
	public Student()
	{
		roster.add(new Student("004014", "Aisha", "Covington", "brown", 10));
		roster.add(new Student("772223", "Daniel", "Kiros", "brown", 3));
		roster.add(new Student("004400", "Kevin", "Tran", "other", 12));
		roster.add(new Student("005255", "Joseph", "Hill", "brown", 13));
		roster.add(new Student("306700", "Li", "Lui", "brown", 12));
		roster.add(new Student("009999", "Stephen", "Ellwood", "other", 2));
		roster.add(new Student("001212", "Stephen", "Rook", "brown", 11));
		roster.add(new Student("004444", "Peter", "Choi", "brown", 2));
		roster.add(new Student("001122", "Michael", "Claire", "other", 12));
		roster.add(new Student("132617", "Reuben", "Turner", "blue", 12));
		roster.add(new Student("267252", "Dax", "Richards", "brown", 12));
		roster.add(new Student("006789", "Arun", "Soma", "brown", 2));
		roster.add(new Student("229949", "Michael", "Sykes", "brown", 13));
		roster.add(new Student("215296", "Joshua", "Franey", "other", 27));
		roster.add(new Student("523420", "Gabriel", "Hamilton", "other", 10));
		roster.add(new Student("474143", "Jonathon", "Stafford", "brown", 13));
		roster.add(new Student("005295", "Kyle", "Deen", "blue", 2));
		roster.add(new Student("343769", "Shaquil", "Timmons", "brown", 11));
		roster.add(new Student("001449", "Karen", "Riter", "blue", 10));
		roster.add(new Student("008888", "Evan", "Tizard", "brown", 12));
	}
	
	public int compareTo(Student s1)
	{
		return firstName.compareTo(s1.firstName);
		//return id.compareTo(s1.id);
	}
	
	public void printClassRoster()
	{
		System.out.println("Part 2");
		Collections.sort(roster);
		print();
		
		//create hashmap of students
		HashMap<String, Student> roster2 = new HashMap<String, Student>();
		for(Student stud : roster)
		{
			roster2.put(stud.id, stud);
		}
		
		//retrive student with id closest but less
		Set<String> keys = roster2.keySet();
		ArrayList<String> list = new ArrayList<String>(keys);
		Collections.sort(list);
		
		System.out.println("\nPart 3");
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals("004400"))
			{
				printRecord(roster2.get(list.get(i-1)));
				printRecord(roster2.get(list.get(i)));
				printRecord(roster2.get(list.get(i+1)));
			}
		}
		
		
	
		
		
	}
	
	public void print()
	{
		System.out.printf("Empl Id  First name       Last name         Eye Color  Months at SSA\n");
		System.out.printf("=======  ===============  ================  =========  =============\n");
		for(Student stud : roster)
		{
			printRecord(stud);
		}
	}
	
	public void printRecord(Student stud)
	{
		System.out.printf("%6s   %-9s        %-9s         %-5s           %d\n", stud.id, stud.firstName,
				stud.lastName, stud.eyeColor, stud.monthsEmployed);
	}
}
