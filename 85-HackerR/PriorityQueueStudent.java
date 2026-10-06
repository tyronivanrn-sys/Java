/*
@autor ivan.rodriguez@irnsmartsolutions.com
@date 27-6-2024
@All rigths reserved for irnsmartsolutions.com
Tutorial java SolutionsFromHackerRank
ENUNCIADO
In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. 
In a priority queue, an element with high priority is served before an element with low priority. - Wikipedia

In this problem we will test your knowledge on Java Priority Queue.

There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.

ENTER: A student with some priority enters the queue to be served. (add)
SERVED: The student with the highest priority is served (removed) from the queue. (remove)
A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

The student having the highest Cumulative Grade Point Average (CGPA) is served first.
Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
Any students having the same CGPA and name will be served in ascending order of the id.
Create the following two classes:
https://www.hackerrank.com/challenges/java-priority-queue/submissions
The Student class should implement:
The constructor Student(int id, String name, double cgpa).
The method int getID() to return the id of the student.
The method String getName() to return the name of the student.
The method double getCGPA() to return the CGPA of the student.
The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.
Input Format

The first line contains an integer, , describing the total number of events. Each of the  subsequent lines will be of the following two forms:

ENTER name CGPA id: The student to be inserted into the priority queue.
SERVED: The highest priority student in the queue was served.
The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.

Constraints

Output Format

The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints EMPTY.

Sample Input 0

12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Sample Output 0

Dan    3.95   50
Ashley  3.9   42
Shafaet  3.7  35
Maria    3.6  46 
Explanation 0

In this case, the number of events is 12. Let the name of the queue be Q.

John is added to Q. So, it contains (John, 3.75, 50).
Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
Now, four more students are added to Q. So, it contains (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
Anik is served because though both Anil and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).
As all events are completed, the name of each of the remaining students is printed on a new line.
*/
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class PriorityQueueStudent {

  static StudentComparator studentComparator= new StudentComparator();

  static PriorityQueue<Student> queue= new PriorityQueue<Student>(8,studentComparator);
  
  public static void main(String[] args){

  List<String> events = List.of("ENTER John 3.75 50",
                                  "ENTER Mark 3.8 24",
                                  "ENTER Shafaet 3.7 35",
                                  "SERVED",
                                  "SERVED",
                                  "ENTER Samiha 3.85 36",
                                  "SERVED",
                                  "ENTER Ashley 3.9 42",
                                  "ENTER Maria 3.6 46",
                                  "ENTER Anik 3.95 49",
                                  "ENTER Dan 3.95 50",
                                  "SERVED"
  									);

                                  
   List<Student> lstStudents = getStudents(events);
   
   
    for(Student student:lstStudents){
       queue.add(student);
    }
        
   
   
   //lstStudents.forEach(s->System.out.println(s.getName()));
   queue.forEach(s->System.out.println(s.getName()));

  }
  
   
  public  static List<Student> getStudents(List<String> events){

    List<Student> ls = new ArrayList<>();
    Comparator<Student> cmpCgpa = Comparator.comparing(st->st.getCgpa()*-1);
    Comparator<Student> cmpName = Comparator.comparing(st->st.getName());
    Comparator<Student> cmpId = Comparator.comparing(st->st.getId());
    
	  for(String event : events){
	  System.out.println("pase x aqui"+event);
	     if(ls!=null && event.equals("SERVED")){
	          //removeif(Predicate<? super E> filter);
         ls.remove(0);
	     	//queue.remove(); //the head of the queue
	     	ls.sort(cmpCgpa);
	      cmpName = cmpCgpa.thenComparing(cmpName).reversed();
	      ls.sort(cmpName);
	      cmpId = cmpName.thenComparing(cmpId).reversed();
	      ls.sort(cmpId);

	     }
	     else {
	     
	     
	      //event map to student and add to queue)
	      String[] dataStudent = event.split(" ");
	      Student s = new Student(dataStudent[1],new Double(dataStudent[2]),new Integer(dataStudent[3]));
	    
        ls.add(s);  
			  //queue.add(s);
	      ls.sort(cmpCgpa);
	      cmpName = cmpCgpa.thenComparing(cmpName).reversed();
	      ls.sort(cmpName);
	      cmpId = cmpName.thenComparing(cmpId).reversed();
	      ls.sort(cmpId);
	   
	      
	     }
	  }
	  
 
	  List<Student> res = new ArrayList<>(ls);
    return res;
  }

}

/*
class Student {

     String name;
     Double cgpa;
     Integer id;
     
     Student(String name,Double cgpa,Integer id) {
	    
	     this.name =name;
	     this.cgpa =cgpa;
	     this.id = id;
     }
     
     Integer getId(){
         return this.id;
     }
     String getName(){
        return this.name;
     }
     Double getCgpa(){
        return this.cgpa;
     }

}

class StudentComparator implements Comparator<Student> {

  public int compare(Student s1,Student s2) {
  
      if(s1.getCgpa().doubleValue() < s2.getCgpa().doubleValue() )
        return 1;
      else if(s1.getCgpa().doubleValue() >s2.getCgpa().doubleValue() )
        return -1;
     return 0;   
  }

}
*/