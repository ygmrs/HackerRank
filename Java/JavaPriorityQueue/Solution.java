import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student>{

    int id;
    String name = new String();;
    double cgpa;

    public Student(String name, double cgpa, int id){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID(){
        return this.id;
    }


    public String getName(){
        return this.name;
    }

    public double getCGPA(){
        return this.cgpa;
    }

    public int compareTo(Student student){
        if(cgpa == student.cgpa){
            if(name.equals(student.name)){
                if(id == student.id){
                    return 0;
                }else if(id > student.id){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return name.compareTo(student.name);
            }
        }else if(cgpa > student.cgpa){
            return -1;
        }else{
            return 1;
        }
    }

}

class Priorities{

    public ArrayList<Student> getStudents(List<String> events){
        int n = events.size();
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        for(String i: events){
            String[] s = new String[4];
            s = i.split("\\s");
            if(s.length>1){
                pq.add(new Student(s[1], Double.valueOf(s[2]), Integer.valueOf(s[3])));
            }else{
                pq.poll();
            }
        }
        while(pq.size()>1){
            System.out.println(pq.poll().name);
        }
        return new ArrayList<Student>(pq);
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}