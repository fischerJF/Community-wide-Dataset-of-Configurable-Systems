package baseline;


import java.util.ArrayList;
import java.util.List;
 
public class PowerSet {
 
 public static void main(String[] args) {
  List<Integer> list = new ArrayList<Integer>();
  list.add(1);
  list.add(2);
  list.add(3);
  list.add(4);
  list.add(5);
  list.add(6);
  list.add(7);
  list.add(8);
  list.add(9);
  list.add(10);
  list.add(11);
  list.add(12);
  list.add(13);
  list.add(14);
  list.add(15);
  list.add(16);
  list.add(17);
  list.add(18);
  list.add(19);
  list.add(20);
  list.add(21);
  list.add(22);
  
  
  print(list);
   
  System.out.println(getSubsetUsingBitMap(list));
 }
 

 public static void print(List<Integer> list) {
	 int cont =0;
	 for (ArrayList<Integer> integer : getSubsetUsingBitMap(list)) {
		 cont++;
		 System.out.println("linha: "+ cont);
		
		 for (Integer integer2 : integer) {
		System.out.print(integer2+" ");
		}
		System.out.println();
	}
 }
  
 public static  ArrayList<ArrayList<Integer>> getSubsetUsingBitMap(List<Integer> list){
   
	 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
   
  int numOfSubsets = 1 << list.size(); //OR Math.pow(2, list.size())
 
  // For i from 0 to 7 in case of [a, b, c], 
  // we will pick 0(0,0,0) and check each bits to see any bit is set, 
  // If set then element at corresponding position in a given Set need to be included in a subset. 
  for(int i = 0; i < numOfSubsets; i++){
       
   ArrayList<Integer> subset = new ArrayList<Integer>();
 
   int mask = 1; // we will use this mask to check any bit is set in binary representation of value i.
    
   for(int k = 0; k < list.size(); k++){
     
    if((mask & i) != 0){ // If result is !=0 (or >0) then bit is set.
     subset.add(list.get(k)); // include the corresponding element from a given set in a subset.
    }
     
    // check next bit in i.
    mask = mask << 1;
   }
    
   // add all subsets in final result.
   result.add(subset);
  }
  return result;  
 }
 
}