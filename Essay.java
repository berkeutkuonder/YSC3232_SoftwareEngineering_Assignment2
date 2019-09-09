package p1;

import java.util.Scanner;

//Abstract Question class is its parent class
public class Essay extends Question {
    
    //Creating a new Essay object
    Essay(String n, String qs, double p) {
        this.id = n;
        this.question = qs;
        this.point = p;
    }
    
    @Override
    //Creating xml for the object Essay
    public String getXML(){
        String res = "\n\t\t<essay ";
        res += String.format("id=\"%s\" qs=\"%s\" p=\"%s\">", this.id, this.question, double_to_string(this.point));
        res += "\n\t\t</essay>";
        return res;
    }
    
    @Override
    //Displays the Essay question
    public void perform(){
        //Printing the instructions
        System.out.printf("Question %s\n", this.id);
        System.out.printf("This question is worth %.2f points\n", this.point);
        System.out.println(this.question); //Printing the question
        //Getting an answer from the user
        System.out.print("\nYour answer:");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println("Thank you for your answer! This question will be read by your teacher\n"); 
    }
}
