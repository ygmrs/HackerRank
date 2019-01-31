/*
"The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
This is useful when exactly one object is needed to coordinate actions across the system."
    Complete the Singleton class in your editor which contains the following components:
        A private Singleton non parameterized constructor.
        A public String instance variable named .
        Write a static method named getSingleInstance that returns the single instance of the Singleton class.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{

    static Singleton instance = new Singleton();
    private Singleton(){}
    public  String str;

    static Singleton getSingleInstance(){
        return instance;
    }

}