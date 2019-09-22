package steve.jdk13.basic.io.console;

import java.io.Console;

/**
 * Author  ZLH
 * Date  2019/9/22
 * Time  20:53
 * Version  1.0
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console(); // console只能在原生命令行中使用
        String s = console.readLine("userName:");
        System.out.println("userName:" + s);
    }
}
