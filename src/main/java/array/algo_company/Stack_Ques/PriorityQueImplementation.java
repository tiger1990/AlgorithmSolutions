package array.algo_company.Stack_Ques;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueImplementation
{
    public static void main(String... args)
    {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());

        // Invoking a parameterized Student constructor with
        // name and cgpa as the elements of queue
        Student student1 = new Student("Nandini", 3.2);

        // Adding a student object containing fields
        // name and cgpa to priority queue
        pq.add(student1);
        Student student2 = new Student("Anmol", 3.6);
        pq.add(student2);
        Student student3 = new Student("Palak", 4.0);
        pq.add(student3);


        // Printing names of students in priority order,poll()
        // method is used to access the head element of queue
        System.out.println("Students served in their priority order");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }


    static class StudentComparator implements Comparator<Student>
    {

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.cgpa < o2.cgpa)
            {
                return 1;
            }
            else if (o1.cgpa > o2.cgpa)
            {
                return -1;
            }
            return 0;
        }
    }

     static class Student {

        String name;
        double cgpa;

        Student(String name, double cgpa)
        {
            this.name = name;
            this.cgpa = cgpa;
        }

         public String getName() {
             return name;
         }
    }
}
