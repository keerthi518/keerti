package com.mph.activity;

import com.sun.jndi.toolkit.ctx.HeadTail;

/*import java.util.OptionalLong;

public class Test {
public static void main(String[] args) {
    OptionalLong optional = OptionalLong.empty();
    System.out.println(optional.isPresent() + " : " + optional.getAsLong());
}
}*/

/*
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("#####", "#", "##", "####", "###");
        Comparator<String> comp = Comparator.comparing(s -> s);
        Collections.sort(list, comp.reversed());
        printCodes(list);
 
    }
 
    private static void printCodes(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
ans:#####
####
###
##
#
*/



/*

import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {
        final String password = "Oracle";
        UnaryOperator<String> opr1 = s -> s.replace('a', '@'); //Line n1
        UnaryOperator<String> opr2 = s -> password.concat(s); //Line n2
        System.out.println("Password: " + opr1.apply(opr2.apply("!"))); //Line n3
    }
}

ans: Password: Or@cle!

*/



/*

import java.util.ArrayList;
import java.util.List;
 
abstract class Animal {}
class Dog extends Animal{}
 
public class Test {
    public static void main(String [] args) {
        List<Dog> list = new ArrayList<Dog>();
        list.add(0, new Dog());
        System.out.println(list.size() > 0);
    }
}

ans: true
*/


/*
class Player {
	String name;
	int age;
	
	Player() {
		this.name = "Yuvaraj";
		this.age = 36;
	}
	public String toString() {
		return name +"," + age;
		
	}
}
public class Test {
	public static void main (String[] args) {
		System.out.println(new Player());
	}
}
	
ans:Yuvaraj,36

*/
/*
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		Stream<Double> stream = Arrays.asList(1.8,2.2,3.5).stream();
		System.out.println(stream.reduce((d1,d2) -> d1 + d2));
	}
}
	
ans:Optional[7.5]
		*/

/*
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        LongStream.iterate(0, i -> i + 2).limit(4).forEach(System.out::print);
    }
}

ans:0246
*/

/*
enum Status {
    PASS, FAIL;
}
 
public class Test {
    public static void main(String[] args) {
        System.out.println(Status.FAIL);
    }
}
ans : FAIL
*/


interface Jumper{public void jump();}
class Animal{}
class Dog extends Animal{
	HeadTail tail;
}
class Beagle extends Dog implements Jumper{
	public void jump(){}
}
class Cat implements Jumper{
	public void jump(){}
}



