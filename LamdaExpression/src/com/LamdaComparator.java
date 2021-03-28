package com;

import java.util.ArrayList;
import java.util.List;


public class LamdaComparator {
	
	
	
	public static void main(String[] args) {
		LamdaComparator l = new LamdaComparator();
		List<Employee> list= l.getEmployees();
		list.forEach(s-> System.out.println(s.getAge()));
	}
  
	
	public   List<Employee> getEmployees() {
	List<Employee>  list= new ArrayList<Employee>();
		list.add(new Employee("Sandhya", 20, 0));
		list.add(new Employee("Kemp", 24, 2));
		list.add(new Employee("Anil", 22, 3));
		list.add(new Employee("Kumar", 30, 6));
		list.add(new Employee("Tim", 32, 7));
		list.sort( (o1,o2)-> o1.getAge() - (o2.getAge()));
		
         return list;
    }
	

}
