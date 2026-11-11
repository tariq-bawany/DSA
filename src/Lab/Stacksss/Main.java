package Lab.Stacksss;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner  sc =new Scanner(System.in);
        Stack stack1 = new Stack();
//        push , pop , peek , isEmpty

//        push sab se end  mein value insert
//        pop sab se end ki value delete krta hai
//        peek sab se end ki value show krta hai
//        isEmpty return true ya false , false -> empty na ho , true jab empty ho


        stack1.push("Tariq");
        stack1.push("Tariq");
        stack1.push("Tariq");
        stack1.push("Tariq hsdsd");

//        System.out.println(stack1.isEmpty());
        System.out.println(stack1);
        while (!stack1.isEmpty()) {
            stack1.pop();
        }

        System.out.println("stack underflow.");
        System.out.println(stack1);

//        1 , 2 , exit
//        stack zero

//      input , delete
//        no of input > no of delete
//        unbalanced

//        { , } , exit
//        { -> input -> koi value stack push
//        } -> delete -> pop
//        exit

//        stack empty ya nhi
//        stack empty hai , zero values stack balanced

        char c;
        do {
            System.out.print("Enter Parenthesis { or } OR  0 to exit: ");
            c = new Scanner(System.in).next().charAt(0);
            if (c == '{') {
                stack1.push(1);
            }
            else if (c == '}') stack1.pop();
        } while (c != '0');

        if (!stack1.isEmpty()){
            System.out.println("not balanced");
        }else System.out.println("balanced");
    }
}