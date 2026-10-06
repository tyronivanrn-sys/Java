/*
@autor ivan.rodriguez@irnsmartsolutions.com
@date 27-6-2024
@All rigths reserved for irnsmartsolutions.com
Tutorial java SolutionsFromHackerRank
}
*/
import java.io.*;
import java.util.*;
import java.lang.IndexOutOfBoundsException;

public class Solution {
    
    static StudentComparator studentComparator= new StudentComparator();

  static PriorityQueue<Student> queue= new PriorityQueue<Student>(8,studentComparator);
  
    
      public  static List<Student> getStudents(List<String> events1){

    int size = events1.size();
    List<Student> ls = new ArrayList<Student>();
    

    
    Comparator<Student> cmpCgpa = Comparator.comparing(st->st.getCgpa()*-1);
    Comparator<Student> cmpName = Comparator.comparing(st->st.getName());
    Comparator<Student> cmpId = Comparator.comparing(st->st.getId());
    
      for(String event : events1){
       
         //System.out.println("IN getStudents");
         if(!event.equals("SERVED")){
             //event map to student and add to queue)
            // System.out.println("IN students");
          String[] dataStudent = event.split(" ");
          Student s = new Student(dataStudent[1],new Double(dataStudent[2]),new Integer(dataStudent[3]));
           // System.out.println("adding a students"+s.getName());
          ls.add(s);  
              //queue.add(s);
          ls.sort(cmpCgpa);
          cmpName = cmpCgpa.thenComparing(cmpName).reversed();
          ls.sort(cmpName);
          cmpId = cmpName.thenComparing(cmpId).reversed();
          ls.sort(cmpId);
      
         }
         else {
            if(!ls.isEmpty()){ 
            Student s = ls.get(0);
            //System.out.println("removing a students"+s.getName());
             ls.remove(0);
             ls.sort(cmpCgpa);
             cmpName = cmpCgpa.thenComparing(cmpName).reversed();
             ls.sort(cmpName);
             cmpId = cmpName.thenComparing(cmpId).reversed();
             ls.sort(cmpId);
           }
         }
      }
      
 
      List<Student> res = new ArrayList<>(ls);
      return res;
  }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        
        List<String> events= new ArrayList<String>();
        //BufferedReader bufferedReader;
        String line="";
        boolean inLoop=true;
        try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
        
         System.out.println("En el try");
         //line =bufferedReader.readLine();
         do{
          System.out.println("line addedd:"+line);

            line =bufferedReader.readLine();
            if(line==null){
                break;
            }else{
                if(!line.trim().equals(""))
                events.add(line);
                else
                    inLoop= true;
            }
         }while( line!=null);
         //events.forEach(System.out::println);
             bufferedReader.close();
         }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
           //  bufferedReader.close();
         }
         finally{
             System.out.println("saliendo del try");
             int size = events.size();
             System.out.println("size:"+size);
             List<String> events1 = new ArrayList<String>(size-2);
             events1 = events.subList(0,size-1);
             events1.forEach(System.out::println);
              size = events1.size();
              System.out.println("size events1:"+size);
              List<Student> lstStudents = getStudents(events1);
              //lstStudents.forEach(s->System.out.println(s.getName()+" "+s.getCgpa()+" "+s.getId()));       
             for(Student student:lstStudents){
                      queue.add(student);
             }
             queue.forEach(s->System.out.println(s.getName()));
             

         }
    }
}
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

