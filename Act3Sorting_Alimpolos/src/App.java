import java.util.Scanner;

class Student {
    private final String name;
    private final double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + "-" + grade;
    }
}

class StudentSort {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

           
            System.out.print("How many students?: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); 

           
            Student[] students = new Student[numStudents];

         
            for (int i = 0; i < numStudents; i++) {
                System.out.println("Enter details for student #" + (i + 1));
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Grade: ");
                double grade = scanner.nextDouble();
                scanner.nextLine(); 

                students[i] = new Student(name, grade);
            }

            
            selectionSortByGrade(students);

    
            System.out.println("\nSorted Students by Grade (Ascending):");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void selectionSortByGrade(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].getGrade() < students[minIdx].getGrade()) {
                    minIdx = j;
                }
            }
            Student temp = students[minIdx];
            students[minIdx] = students[i];
            students[i] = temp;
        }
    }
}