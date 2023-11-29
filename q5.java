import java.util.*;
public class q5 {
    static ArrayList<CourseInfo> courses = new ArrayList<>();
    static ArrayList<StudentInfo> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Courses");
            System.out.println("2. Register Student");
            System.out.println("3. Remove Registration");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showCourseDetails();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    removeStudentEnrollment();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    static void showCourseDetails() {
        System.out.println("Course Details:");
        for (CourseInfo course : courses) {
            System.out.println("Code: " + course.courseCode + ", Title: " + course.courseTitle +
                    ", Capacity: " + course.courseCapacity + ", Available Slots: " + course.getAvailableSlots());
        }
    }

    static void enrollStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code to register: ");
        String courseCode = scanner.next();

        StudentInfo student = findStudentById(studentId);
        CourseInfo course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (course.getAvailableSlots() > 0) {
                student.registerForCourse(course);
                course.registerStudent(student);
                System.out.println("Student " + student.studentName + " registered for course " + course.courseTitle);
            } else {
                System.out.println("Sorry, the course is full. Cannot register.");
            }
        } else {
            System.out.println("Invalid student ID or course code. Please check and try again.");
        }
    }

    static void removeStudentEnrollment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code to unregister: ");
        String courseCode = scanner.next();

        StudentInfo student = findStudentById(studentId);
        CourseInfo course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.removeCourseRegistration(course);
            course.removeStudentRegistration(student);
            System.out.println("Student " + student.studentName + " removed from course " + course.courseTitle);
        } else {
            System.out.println("Invalid student ID or course code. Please check and try again.");
        }
    }

    static StudentInfo findStudentById(String studentId) {
        for (StudentInfo student : students) {
            if (student.studentId.equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    static CourseInfo findCourseByCode(String courseCode) {
        for (CourseInfo course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}

class CourseInfo {
    String courseCode;
    String courseTitle;
    String courseDescription;
    int courseCapacity;
    ArrayList<StudentInfo> enrolledStudents;

    CourseInfo(String code, String title, String description, int capacity) {
        this.courseCode = code;
        this.courseTitle = title;
        this.courseDescription = description;
        this.courseCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    int getAvailableSlots() {
        return courseCapacity - enrolledStudents.size();
    }

    void registerStudent(StudentInfo student) {
        enrolledStudents.add(student);
    }

    void removeStudentRegistration(StudentInfo student) {
        enrolledStudents.remove(student);
    }
}

class StudentInfo {
    String studentId;
    String studentName;
    ArrayList<CourseInfo> registeredCourses;

    StudentInfo(String id, String name) {
        this.studentId = id;
        this.studentName = name;
        this.registeredCourses = new ArrayList<>();
    }

    void registerForCourse(CourseInfo course) {
        registeredCourses.add(course);
    }

    void removeCourseRegistration(CourseInfo course) {
        registeredCourses.remove(course);
    }
}
