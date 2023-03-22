package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExample 
{
	

	private List<Employee> getSortedList()
	{
		List<Employee> list = new ArrayList<>();
		
		Comparator<Employee> parentComparator= Comparator.comparing(Employee:: getName,Comparator.nullsLast(Comparator.naturalOrder()));
		Comparator<Employee> ageComparator= Comparator.comparing(Employee:: getAge,Comparator.nullsLast(Comparator.naturalOrder()));
		
		
		return list.stream().sorted(parentComparator.thenComparing(ageComparator)).collect(Collectors.toList());
	}

}
