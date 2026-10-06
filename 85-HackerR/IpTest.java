/*
@autor ivan.rodriguez@irnsmartsolutions.com
@date 27-6-2024
@All rigths reserved for irnsmartsolutions.com
Tutorial java SolutionsFromHackerRank
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class IpTest {
    
    
    
    
    public static boolean isIP(String s){
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
//String zeroTo255 = "(1[0-9][0-9]|0[0-9][0-9]|[0-9]{1,2}|25[0-5]|2[0-4][0-9])";
        String strPattern =  zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        
         Pattern p = Pattern.compile(strPattern);
         Matcher m = p.matcher(s);
         boolean b = m.matches();
        
        if (b==true)
         return true;
         else
         return false;
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n =bufferedReader.readLine();
        String out= "";
        do{
         boolean b = isIP(n);
         System.out.println(b);
         out=validateIpAddress(n);
         System.out.println(out);
         n =bufferedReader.readLine();
         System.out.println(n);
         if (n.equals("S")){
             break;
         }
        
        }while(n!=null&&n!="S");

        bufferedReader.close();
    }
    
    //Method to check validity
 public static String validateIpAddress(String ipAddress) {
      //Matcher ipMatcher=ipPattern.matcher(ipAddress);
        int[] arr=new int[4];
        int i=0;
        //Condition to check input IP format
        if(isIP(ipAddress)) {       

           //Split input IP Address on basis of .
           String[] octate=ipAddress.split("[.]");     
           for(String x:octate) { 

              //Convert String number into integer
              arr[i]=Integer.parseInt(x);             
              i++;
         }

        //Check whether input is Class A IP Address or not
         if(arr[0]<=127) {                          
             if(arr[0]==0||arr[0]==127)
                 return(" is Reserved IP Address of Class A");
             else if(arr[1]==0&&arr[2]==0&&arr[3]==0)
                 return(" is Class A Network address");
             else if(arr[1]==255&&arr[2]==255&&arr[3]==255)
                 return( " is Class A Broadcast address");
             else 
                 return(" is valid IP Address of Class A");
         }

        //Check whether input is Class B IP Address or not
         else if(arr[0]>=128&&arr[0]<=191) {        
             if(arr[2]==0&&arr[3]==0)
                 return(" is Class B Network address");
             else if(arr[2]==255&&arr[3]==255)
                 return(" is Class B Broadcast address");
             else
                 return(" is valid IP Address of Class B");
         }

        //Check whether input is Class C IP Address or not
         else if(arr[0]>=192&&arr[0]<=223) {        
             if(arr[3]==0)
                 return(" is Class C Network address");
             else if(arr[3]==255)
                 return(" is Class C Broadcast address");
             else
                 return( " is valid IP Address of Class C");
        }

        //Check whether input is Class D IP Address or not
        else if(arr[0]>=224&&arr[0]<=239) {          
             return(" is Class D IP Address Reserved for multicasting");
        }

        //Execute if input is Class E IP Address
        else  {                                   
             return(" is Class E IP Address Reserved for Research and Development by DOD");
        }

    }

    //Input not matched with IP Address pattern
    else                                     
        return(" is Invalid IP Address");


    }

}
