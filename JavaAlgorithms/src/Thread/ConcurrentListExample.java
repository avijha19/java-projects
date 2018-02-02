package Thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       // List<String> list = new CopyOnWriteArrayList<>();

        
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        
        // get the iterator
        Iterator<String> it = list.iterator();
        
        //manipulate list while iterating
        while(it.hasNext()){
            System.out.println("list is:"+list);
            String str = it.next();
            System.out.println(str);
           //if(str.equals("2"))list.remove("5");
            if(str.equals("2"))it.remove();
           // if(str.equals("3"))list.add("3 found");
            
            //below code don't throw ConcurrentModificationException
            //because it doesn't change modCount variable of list
            if(str.equals("4")) list.set(1, "4");
        }
    }

}