package rave.code.utilitiy.java;

import org.openjdk.jol.info.ClassLayout;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 */
public class ObjectSizeAgent {

    public static void printObjectSizeDetail(Object object){
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }

    public static void main(String[] args) {
        String s = "Hello";
        ObjectSizeAgent.printObjectSizeDetail(s);
    }
}
