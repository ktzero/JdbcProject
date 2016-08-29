package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassRoster {

	ArrayList<Student> roster = new ArrayList<Student>();
	
	public ClassRoster()
	{
		//roster.add(new Student(""Jarrett");
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
	
	public void classRosterReport()
	{
		//Collections.sort(roster);
		Collections.sort(roster);
		Collections.sort(roster, new Comparator());
		print();
		System.out.println();
		Collections.sort(roster, Collections.reverseOrder());
		//Collections.reverse(roster);
		print();
		
		
		
	}
	
	private void print()
	{
		for(String name : roster)
			System.out.println(name);
	}
	
	
	
}
