package name.marmar;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.CopyByReferenceConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import ma.glasnost.orika.metadata.Type;
import name.marmar.dto.PersonDto1;
import name.marmar.dto.PersonDto2;
import name.marmar.dto.PersonDto3;
import name.marmar.dto.PersonDto4;
import name.marmar.model.Person;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by martinmares on 28.09.14.
 */
public class OrikaExample {

    public static class AgeYearConverter extends BidirectionalConverter<Integer, Integer> {

        @Override
        public Integer convertTo(Integer integer, Type<Integer> integerType) {
            if (integer != null) {
                return 2014 - integer;
            } else {
                return null;
            }
        }

        @Override
        public Integer convertFrom(Integer integer, Type<Integer> integerType) {
            if (integer != null) {
                return 2014 - integer;
            } else {
                return null;
            }
        }
    }

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
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public void ex2() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto1.class).register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public void ex3() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto1.class)
                .byDefault()
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        PersonDto1 result = mapper.map(Person.person, PersonDto1.class);
        printPerson(result);
    }

    public void ex4() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto2.class)
                .field("firstName", "name.firstName")
                .field("surname", "name.surname")
                .byDefault()
                .register();
        //Better performance
        BoundMapperFacade<Person, PersonDto2> mapper
                = mapperFactory.getMapperFacade(Person.class, PersonDto2.class, false); //No cycle dependencies
        PersonDto2 result = mapper.map(Person.person);
        printPerson(result);
    }

    public void ex5() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto3.class)
                .byDefault()
                .register();
        BoundMapperFacade<Person, PersonDto3> mapper
                = mapperFactory.getMapperFacade(Person.class, PersonDto3.class, false);
        PersonDto3 result = mapper.map(Person.person);
        printPerson(result);
        System.out.println("Is address the same object: " + (Person.person.getAddress() == result.getAddress()));
    }

    public void ex6() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter("byRefConv", new CopyByReferenceConverter());
        mapperFactory.classMap(Person.class, PersonDto3.class)
                .fieldMap("address", "address").converter("byRefConv").add()
                .byDefault()
                .register();
        BoundMapperFacade<Person, PersonDto3> mapper
                = mapperFactory.getMapperFacade(Person.class, PersonDto3.class, false);
        PersonDto3 result = mapper.map(Person.person);
        printPerson(result);
        System.out.println("Is address the same object: " + (Person.person.getAddress() == result.getAddress()));
    }

    public void ex7() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter("ageYear", new AgeYearConverter());
        mapperFactory.classMap(Person.class, PersonDto4.class)
                .fieldMap("age", "yearOfBirth").converter("ageYear").add()
                .field("age", "age")
                .byDefault()
                .register();
        BoundMapperFacade<Person, PersonDto4> mapper
                = mapperFactory.getMapperFacade(Person.class, PersonDto4.class, false);
        PersonDto4 result = mapper.map(Person.person);
        printPerson(result);
        //And back
        System.out.println(" --- V [BACK] V ---");
        Person res2 = mapper.mapReverse(result);
        System.out.println(res2);
    }

    public static void main(String[] str) {
        if (str.length == 0) {
            System.out.println("USAGE: orika <example_id> [example_id ...]");
        }
        //Execute
        OrikaExample example = new OrikaExample();
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
