package first.careercup.microsoft;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class Dictionary
{
    // not working.
    public static void main(String args[]) {

        java.util.Dictionary<String, String> employees = new Hashtable();
        employees.put("A", "C");
        employees.put("B", "C");
        employees.put("C", "F");
        employees.put("D", "E");
        employees.put("E", "F");
        employees.put("F", "F");

        java.util.Dictionary<String, Integer> stringIntegerDictionary = reportSystem(employees);

        Enumeration<String> keys = stringIntegerDictionary.keys();

        while(keys.hasMoreElements()) {
            System.out.println("Keys:"+keys.nextElement());
        }

        Enumeration<Integer> elements = stringIntegerDictionary.elements();
        while(elements.hasMoreElements()) {
            System.out.println("elements:"+elements.nextElement());
        }

    }

    public static java.util.Dictionary<String, Integer> reportSystem(java.util.Dictionary<String, String> employees)
    {

        final java.util.Dictionary<String, Integer> countOfEmpl = new Hashtable();

        int[] count = new int[256];

        Enumeration<String> keys = employees.keys();
        while (keys.hasMoreElements())
        {
            String key = keys.nextElement();
            final String value = employees.get(key);

            if (countOfEmpl.get(key) == null)
            {
                count[value.charAt(0)] = count[value.charAt(0)] + 1;
                countOfEmpl.put(key, count[key.charAt(0)]);
            }

            if(count[key.charAt(0)] > 0) {
                count[value.charAt(0)] = count[value.charAt(0)] + count[key.charAt(0)];
            }
        }

        return countOfEmpl;
    }

    //Geeks for geeks.
    //http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
    //https://disqus.com/home/discussion/geeksforgeeks/find_number_of_employees_under_every_manager/
}
