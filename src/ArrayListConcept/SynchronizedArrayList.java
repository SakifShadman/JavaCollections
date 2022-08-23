package ArrayListConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList {
    public static void main(String[] args) {

       //1. Collections.synchronizedList
       List<String> namesList = Collections.synchronizedList(new ArrayList<>());

       namesList.add("Java");
       namesList.add("Python");
       namesList.add("Ruby");

        //add, remove - we don't need explicit synchronization
        // to fetch/traverse the values from the list -- we have to use explicit synchronization

        synchronized (namesList) {
            Iterator<String> it = namesList.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        //2. copyOnWriteArrayList -- it's a class: Thread-safe/synchronized already.
        CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<>();
        empList.add("Tom");
        empList.add("Steve");
        empList.add("Naveen");

        //we don't need explicit synchronization for any operation: add/remove/traverse
        Iterator<String> it = empList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}