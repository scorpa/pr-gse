package innere_klassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo
{
	private ArrayList<Person> personen;
	private int x;   // Instanzattribut
	
	public Demo()
	{
		x = 5;
		personen = new ArrayList<Person>();
		personen.add(new Person("Susi"));
		personen.add(new Person("Franz"));
		personen.add(new Person("Alois"));
		personen.add(new Person("Petra"));
		personen.add(new Person("Maximilian"));
	}
	
	public void sortieren1()
	{
		// innere Klasse 
		Collections.sort(personen, new PersonenComparator());
	}
	
	public void sortieren2()
	{
		/*
		 * anonyme innere Klasse.
		 * Hier handelt es sich um eine namenlose Klasse, die innerhalb einer
		 * Anweisung definiert und auch instanziiert wird.
		 */
		Collections.sort(personen, new Comparator<Person>(){
			public int compare(Person p1, Person p2)
			{
				return p1.getName().compareTo(p2.getName());
			}});
	}
	
	
	

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		for (Person p : personen)
			str.append(" ").append(p);
		return str.toString();
	}




	// "normale" inner Klasse
	// gehört zu einer Instanz der Klasse Demo
	// hat daher Zugriff auf Instanzattribute
	// Nachteil: Ich benötige eine Instanz von Demo, 
	// um diese Klasse verwenden zu können.
	public class PersonenComparator implements Comparator<Person>
	{
		public int compare(Person p1, Person p2)
		{
			System.out.println("x=" + x);  // hat Zugriff auf Instanzattribut
			return p1.getName().compareTo(p2.getName());
		}
	}
	
	// statische inner Klasse
	// gehört zur Klasse Demo
	// hat daher KEINEN Zugriff auf Instanzattribute
	// Vorteil: Ich benötige eine Instanz von Demo, 
	// um diese Klasse verwenden zu können.
	public static class PersonenComparatorStatic implements Comparator<Person>
	{
		public int compare(Person p1, Person p2)
		{
			// System.out.println("x=" + x);  // hat KEINEN Zugriff auf Instanzattribut
			return p1.getName().compareTo(p2.getName());
		}
	}
	
	public static void main(String[] args)
	{
		Demo demo1 = new Demo();
		System.out.println("============ vor Sortieren ===========");
		System.out.println(demo1);
		System.out.println("============ nach Sortieren ===========");
		demo1.sortieren1();
		System.out.println(demo1);
		
		Demo demo2 = new Demo();
		System.out.println("============ vor Sortieren ===========");
		System.out.println(demo2);
		System.out.println("============ nach Sortieren ===========");
		demo2.sortieren2();
		System.out.println(demo2);
		
		// Folgendes geht nicht, weil der PersonenComparator nur mit einer
		// Instanz von Demo verwendet werden kann
		// PersonenComparator pc = new PersonenComparator(); 
		
		// So funktioniert es:
		PersonenComparator pc = demo1.new PersonenComparator();

		// Für das Verwenden einer statischen inneren Klasse benötige ich keine Instanz von Demo:
		PersonenComparatorStatic pcs = new PersonenComparatorStatic();
		
	}
	
	
}
