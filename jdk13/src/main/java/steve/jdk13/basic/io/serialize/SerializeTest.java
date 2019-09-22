package steve.jdk13.basic.io.serialize;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.Date;

/**
 * Author  ZLH
 * Date  2019/9/22
 * Time  17:27
 * Version  1.0
 */
public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Person person = new Person();
        person.name = "steve";
        person.age = 33;
        person.gender = Gender.MALE;
        File file = new File("test.dta");
        if (file.exists()) file.delete();
        boolean create = file.createNewFile();
        if (create) {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file, false));
            outputStream.writeObject(person);
            outputStream.close();
        }*/
        File file = new File("test.dta");

//        person.serialVersionUID = new Date().getTime();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Person person2 = (Person) inputStream.readObject();
        System.out.println(person2.toString());
    }
}
