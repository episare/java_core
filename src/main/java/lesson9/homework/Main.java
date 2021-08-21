package lesson9.homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Course> courseList = Arrays.asList(
                new Course("Mathe"),
                new Course("Biology"),
                new Course("History"),
                new Course("Geography"),
                new Course("Physic"),
                new Course("Economy"),
                new Course("Chemistry"));

        List<Student> studentList = Arrays.asList(
                new Student("Oleg", Arrays.asList(
                        courseList.get(2), courseList.get(6))),
                new Student("Svetlana", Arrays.asList(courseList.get(1),
                        courseList.get(2), courseList.get(3), courseList.get(4),
                        courseList.get(6))),
                new Student("Anton", Arrays.asList(courseList.get(0),
                        courseList.get(4))),
                new Student("Alex", Arrays.asList(courseList.get(1),
                        courseList.get(2), courseList.get(3), courseList.get(6))),
                new Student("Vadim", Arrays.asList(courseList.get(3),
                        courseList.get(4), courseList.get(6))),
                new Student("Anna", Arrays.asList(courseList.get(0),
                        courseList.get(3), courseList.get(4), courseList.get(2),
                        courseList.get(6))));
        System.out.println(studentList);

        System.out.println("List of the unique courses: " + listUniqueCourses(studentList));
        System.out.println("List of the most inquisitive students: " + listTheMostInquisitiveStudents(studentList));

        System.out.println("List of students to course \n");
        for (Course course : courseList) {
            System.out.println(course.getName() + ": "
                    + listStudentsToCourse(studentList, course));
        }

    }

    private static List<Course> listUniqueCourses(List<Student> students) {
        return (students.stream()
                .map(Student::getCourseList)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList()));
    }

    private static List<Student> listTheMostInquisitiveStudents (List<Student> studentList) {
        return studentList.stream()
                .sorted((s1, s2) -> (s2.getCourseList().size() - s1.getCourseList().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Student> listStudentsToCourse (List<Student> students, Course course) {
        return students.stream()
                .filter(s -> s.getCourseList().contains(course))
                .collect(Collectors.toList());
    }

}
