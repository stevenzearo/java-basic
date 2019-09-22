package steve.jdk13.basic.io.serialize;

import steve.jdk13.basic.io.serialize.Gender;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.UUID;

/**
 * Author  ZLH
 * Date  2019/9/22
 * Time  17:04
 * Version  1.0
 */
public class Person implements Externalizable {
    final static long serialVersionUID = new Date().getTime();
    public String name;
    public Integer age;
    public Gender gender;

    public void eat() {
        System.out.println(name + " is eating...");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeLong(serialVersionUID);
        out.writeUTF(name);
        out.writeInt(age);
        out.writeObject(gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        serialVersionUID = new Date().getTime();
        in.readLong();
        name = in.readUTF();
        age = in.readInt();
        gender = (Gender) in.readObject();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender.name() +
                '}';
    }
}
