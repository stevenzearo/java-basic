package steve.stream.collector;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class CollectorTest {
    public static void main(String[] args) {
        Student java = new Student(UUID.randomUUID().toString(), Category.JAVA, "java", 12);
        Student java2 = new Student(UUID.randomUUID().toString(), Category.JAVA, "java2", 22);
        Student scala = new Student(UUID.randomUUID().toString(), Category.SCALA, "scala", 23);
        Student python = new Student(UUID.randomUUID().toString(), Category.PYTHON, "python", 14);
        List<Student> students = List.of(java, scala, python, java2);
        // groupingBy(<group logic>, <aggregate logic>)
        Map<Category, Optional<Student>> collect1 = students.stream().collect(Collectors.groupingBy((Student s) -> s.category, Collectors.reducing((Student student1, Student student2) -> student1.age > student2.age ? student1 : student2)));
        Map<Category, Double> collect = students.stream().collect(Collectors.groupingBy((Student s) -> s.category, Collectors.averagingDouble(student -> student.age)));
        collect1.forEach((k, v) -> System.out.println(k + ":" + v.orElse(new Student())));
        System.out.println("------");
        collect.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    private static class Student {
        String id;
        Category category;
        String name;
        Integer age;

        Student() {
        }

        Student(String id, Category category, String name, Integer age) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", category=" + category +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    enum Category {
        JAVA, SCALA, PYTHON
    }
}
