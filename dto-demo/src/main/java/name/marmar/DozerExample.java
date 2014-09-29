package name.marmar;

import name.marmar.dto.PersonDto1;
import name.marmar.model.Person;
import org.dozer.DozerBeanMapper;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by martinmares on 28.09.14.
 */
public class DozerExample {

    public static void printIt(Object a, Object b) {
        System.out.println(a);
        System.out.println("      |");
        System.out.println("      V");
        System.out.println(b);
    }

    public static void printPerson(Object o) {
        printIt(Person.person, o);
    }

    public void ex1() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public void ex2() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList(new String[] {"dozermapping2.xml"}));
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public void ex3() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList(new String[] {"dozermapping3.xml"}));
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public static void main(String[] str) {
        if (str.length == 0) {
            System.out.println("USAGE: dozer <example_id> [example_id ...]");
        }
        //Execute
        DozerExample example = new DozerExample();
        for (String s : str) {
            Method m = null;
            try {
                m = example.getClass().getMethod("ex" + s);
            } catch (Exception e) {
                System.out.println("Can not locate example method name for: " + s);
                e.printStackTrace(System.out);

            }
            try {
                System.out.println("");
                System.out.println("==========================");
                System.out.println("Example: " + s);
                System.out.println("--------------------------");
                m.invoke(example);
            } catch (Exception e) {
                System.out.println("Issue with example invocation");
                e.printStackTrace(System.out);
            }
        }
    }
}
