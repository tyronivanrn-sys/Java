//import com.sun.org.apache.xerces.internal.util.SymbolTable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //show the message
        object.showMessage();

        /*

        //StringBuider s = new StringBuilder("ABC");

        //String reversedStr =s.reverse().toString();

        //System.out.println(reversedStr);

       */



    }
    public static String reverseStr(String s){

        int leng = s.length();
        int j = 0 ;
        char[] aux = s.toCharArray();
        char[] aux1 = s.toCharArray() ;
        for(int i=leng-1; i>=0;i--) {
            aux1[j] =  aux[i];
            j++;
        }
        s = aux1.toString();
        String w = new String(aux1);
        s = w;
        System.out.println(s);
        return s;
    }


}
