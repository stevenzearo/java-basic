package steve.constructor;

import steve.reflect.Gender;

/**
 * @author steve
 */
public class Student {
    private final String id;
    private final String name;
    private final Integer age;
    private final Gender gender;
    private final Integer grade;
    private final double score;

    public static class StudentBuilder {
        private String id;
        private String name;
        private Integer age;
        private Gender gender;
        private Integer grade;
        private double score;

        public StudentBuilder(String id, String name, Gender gender) {
            this.id = id;
            this.name = name;
            this.gender = gender;
        }

        public StudentBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public StudentBuilder score(Double score) {
            this.score = score;
            return this;
        }

        public StudentBuilder grade(Integer grade) {
            this.grade = grade;
            return this;
        }

        public Student builder() {
            return new Student(this);
        }
    }

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.grade = builder.grade;
        this.score = builder.score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", gender=" + gender +
            ", grade=" + grade +
            ", score=" + score +
            '}';
    }
}
