package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {
    public Object copy(Object object) throws Exception{
        Class classType = object.getClass();
        System.out.println("Class:"+classType.getName());

        Object objectCopy = classType.getConstructor(new Class[]{})
                .newInstance(new Object[]{});

        Field fields[]=classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field=fields[i];

            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0,1).toUpperCase();
            String getMethodName = "get"+firstLetter+fieldName.substring(1);
            String setMethodName = "set"+firstLetter+fieldName.substring(1);

            Method getMethod = classType.getMethod(getMethodName,new Class[]{});
            Method setMethod = classType.getMethod(setMethodName,new Class[]{field.getType()});

            Object value = getMethod.invoke(object,new Object[]{});

            System.out.println(fieldName+":"+value);
            setMethod.invoke(objectCopy, new Object[]{value});

        }//end of for

        return objectCopy;
    }

    public static   void main(String[] args) throws Exception {
        Customer customer = new Customer("Tom",2);
        customer.setId(new Long(1));

        Customer customer1Copy=(Customer)new ReflectTester().copy(customer);
        System.out.println("Copy information:"+customer1Copy.getName()+""+customer1Copy.getAge());
    }//end of main

    static class Customer{
        private Long id;
        private String name;
        private int age;

        public Customer() {
        }

        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
