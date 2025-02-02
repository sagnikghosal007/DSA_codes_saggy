package collectionsPackage;


import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparator {

    private int id;

    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //internally ei method ta use hoye jekhane hashcode thake

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int compare(Object o1, Object o2){
        //-ve ---> o1 before o2
        //+ve ---> o1 after o2
        //we are doing type casting here
        Employee e1=(Employee)o1;
        Employee e2=(Employee)o2;
        if(e1.getId()>e2.getId()){
            return 1;
        }
        else if(e1.getId()<e2.getId()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        Employee emp1=new Employee(2,"Sagnik");
        Employee emp2=new Employee(1,"Sagni");
        Employee emp3=new Employee(3,"Sagn");
        Employee emp4=new Employee(4,"Sag");

        TreeSet<Employee> treeSet=new TreeSet<>(new Employee());
        treeSet.add(emp1);
        treeSet.add(emp2);

        //we will now get the sorted set on basis of their id in adcending order
        System.out.println(treeSet);

    }

}
