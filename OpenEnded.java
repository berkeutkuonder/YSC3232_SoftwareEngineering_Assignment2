package p1;

import java.util.Scanner;

//Abstract Question class is its parent class
public class OpenEnded extends Question {
    
    //Creating a new OpenEnded object
    OpenEnded(String n, String qs, String a, double p) {
        this.id = n;
        this.question = qs;
        this.answer_correct = a;
        this.point = p;
    }
    
    @Override
    //Creating xml for the object OpenEnded
    public String getXML(){
        String res = "\n\t\t<open ";
        res += String.format("id=\"%s\" qs=\"%s\" a=\"%s\" p=\"%s\">", this.id, this.question,this.answer_correct,double_to_string(this.point));
        res += "\n\t\t</open>";
        return res;
    }
    
    @Override
    //Displays the OpenEnded question
    public void perform(){
        //Printing the instructions
        System.out.printf("Question %s\n", this.id);
        System.out.printf("This question is worth %.2f points\n", this.point);
        NewMain.maxscore += this.point; //Updating maxscore
        System.out.println(this.question); //Printing the question
        //Getting an answer from the user
        System.out.print("\nYour answer:");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String response = s.toLowerCase();
        //Checking whether the given answer is correct or not
        if (this.answer_correct.equals(response)) { 
            System.out.println("Correct answer!\n");
            NewMain.score += this.point; //Updating score
        }
        else {
            System.out.printf("Wrong answer! Your answer was %s, but the correct answer was %s\n\n",response, this.answer_correct);
        } 
    }
}
