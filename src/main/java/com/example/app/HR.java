package com.example.app;

import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

public class HR implements IHRFunctions {
	
	public String[] employeeList(String[] listOfEmployees) {
		String sortedEmployeeList[] = new String[listOfEmployees.length];
		sortedEmployeeList = Arrays.copyOf(listOfEmployees,listOfEmployees.length);
		Arrays.sort(sortedEmployeeList); 
		return sortedEmployeeList;
	}
	
	public String[] topPerformers(String[] listOfEmployees, List<int[]> parameters) {
		String topPerformers[] = new String[3];
		Integer[] performance = new Integer[listOfEmployees.length];
		
		for (int i = 0; i < parameters.size(); i++) {
			int[] employeeParameter = parameters.get(i);
			int sum = 0;
			for (int j = 0; j < employeeParameter.length; j++) {
		      sum = sum+employeeParameter[j];
		    }
			performance[i] = sum;
		}
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		for (int i = 0; i < performance.length; i++) {
			map.put(listOfEmployees[i], performance[i]);
		}
		Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        int count = 0;
        
        for(Map.Entry<String, Integer> entry:list){
        	if(count <3){
        		count++;
        	}else{
        		break;
        	}
        	topPerformers[count-1] = entry.getKey();
         
        }
        return topPerformers;
	}
	
	public String parameterTopper(String[] listOfEmployees, List<int[]> parameters, String parameterType) {
		int performancePosition = Arrays.asList(App.performanceParameters).indexOf(parameterType);
		String parameterTopper = "";
		Integer[] performanceParameter = new Integer[listOfEmployees.length];
		int maximum = 0, position=-1;
		for (int i = 0; i < parameters.size(); i++) {
			int[] employeeParameter = parameters.get(i);
			performanceParameter[i] = employeeParameter[performancePosition];
			if(performanceParameter[i] > maximum){
				maximum = performanceParameter[i];
				position = i;
			}
		}
		parameterTopper = listOfEmployees[position];
		return parameterTopper;
	}
	
	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList) {
		String lazyEmployeesList[] = new String[3];
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		for (int i = 0; i < attendenceList.length; i++) {
			map.put(listOfEmployees[i], attendenceList[i]);
		}
		Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );
        int count = 0;
        for(Map.Entry<String, Integer> entry:list){
        	if(count <3){
        		count++;
        	}else{
        		break;
        	}
        	lazyEmployeesList[count-1] = entry.getKey();
        }
        return lazyEmployeesList;
	}

}
