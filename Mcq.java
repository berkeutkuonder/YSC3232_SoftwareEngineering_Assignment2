package p1;

import java.util.Scanner;

//Abstract Question class is its parent class
public class Mcq extends Question {
    
    //Creating a new Mcq object
    Mcq(String n, String qs, String[] c, String a, double p) {
        this.id = n;
        this.question = qs;
        this.choices = c;
        this.answer_correct = a;
        this.point = p;
    }
    
    @Override
    //Creating xml for the object Mcq
    public String getXML(){
        String res = "\n\t\t<mcq ";
        res += String.format("id=\"%s\" qs=\"%s\" c=\"%s\" a=\"%s\" p=\"%s\">", this.id, this.question,array_to_string(this.choices),this.answer_correct,double_to_string(this.point));
        res += "\n\t\t</mcq>";
        return res;
    }
    
    @Override
    //Displays the Mcq question
    public void perform(){
        //Printing the instructions
        System.out.printf("Question %s\n", this.id);
        System.out.printf("This question is worth %.2f points\n", this.point);
        NewMain.maxscore += this.point; //Updating maxscore
        System.out.println(this.question); //Printing the question
        for(String s: this.choices) { //Printing the choices
            System.out.println(s);
        }
        //Getting an answer from the user
        System.out.print("\nYour answer:");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char response = s.toUpperCase().charAt(0);
        //Checking whether the given answer is correct or not
        if (response == this.answer_correct.charAt(0)) { 
            System.out.println("Correct answer!\n");
            NewMain.score += this.point; //Updating score
        }
        else { 
            System.out.printf("Wrong answer! The correct choice was %s\n\n",this.answer_correct);
        }
    }
}
