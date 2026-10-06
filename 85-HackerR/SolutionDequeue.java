/*
@autor ivan.rodriguez@irnsmartsolutions.com
@date 27-6-2024
@All rigths reserved for irnsmartsolutions.com
Tutorial java SolutionsFromHackerRank

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, 
for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
You can find more details about Deque here.

In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is  second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. 
The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input

6 3
5 3 5 2 3 2
Sample Output

3
Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .

*/
import java.util.*;
public class SolutionDequeue {
    
	 public static void main(String[] args) {
	
            List<List<Integer>> lsts = new ArrayList<List<Integer>>();
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n=0,m=0;
		        String nums =(in.nextLine()).trim();
		        if(!nums.equals("")){
		          String[] tamanios= nums.split(" ");
		          n= new Integer(tamanios[0]);
		          m= new Integer(tamanios[1]);
		          System.out.println("tamanios:"+n+" "+m);
		        }else {
		           System.out.println("Ingrese Cantidad Total de Nums del Arreglo espacio Cantidad de elementos en los substrings: ");
		        }
		        System.out.println(nums);
		        nums =(in.nextLine()).trim();
		        System.out.println(nums);
		        String[] arrNums = nums.split(" ");
             if(!nums.equals("")){    
                List<Integer> lst = new ArrayList<Integer>();
                for(int i=0;i<arrNums.length-1;i++){
                  Integer inte=new Integer(arrNums[i]); 
                  lst.add(inte);            
                }
                lsts = chunkList(lst,m);
                Integer result = maxQuantityElementsDistinctInSubArrays(lsts,m);
                System.out.println("Maximun= "+ result.intValue());
             }else {
		           System.out.println("Ingrese numeros del arreglo separados por espacios ");
		        }   
             
        }
        
  public static Integer maximunOfSubArrays(List<List<Integer>> lsts) {
        
		    List<Integer> res = new ArrayList<Integer>();
		    
		    for(List<Integer> eachLst : lsts) {
			     Integer max =	Collections.max(eachLst);
			     res.add(max);
		    }
		    Integer maxOfArrays = Collections.max(res);
		    
		    return maxOfArrays;
        
	 }
	   public static Integer maxQuantityElementsDistinctInSubArrays(List<List<Integer>> lsts,int m) {
        
		    List<Integer> res = new ArrayList<Integer>();
		    
		    for(List<Integer> eachLst : lsts) {

		      int count=0;
		      int len =eachLst.size();
		      System.out.println(len);
		      for(int i=0;i<len-1;i++) {
		         int element = eachLst.get(i);
		         int sig = eachLst.get(i+1);
		         if(element!=sig) {
		            count++;
		         }
		       }
		       count= count+1;
			     //int max =	(int)eachLst.stream().map((i->{if(i.get() {count++; return count;}}).distinct().count()+1;
			     res.add(count);
		    }
		    Integer maxOfArrays = Collections.max(res);
		    
		    return maxOfArrays;
        
	 }
        
	 public static  <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
	    if (chunkSize <= 0) {
	        throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
	    }
	    List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);
	    for (int i = 0; i < list.size(); i += chunkSize) {
	        chunkList.add(list.subList(i, i + chunkSize >= list.size() ? list.size()-1 : i + chunkSize));
	    }
	    return chunkList;
	 }
}

