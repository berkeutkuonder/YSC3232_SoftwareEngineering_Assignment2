package p1;

import java.util.Scanner;

//Abstract Question class is its parent class
public class Matching extends Question {
    
    //Creating a new Matching object
    Matching(String n, String qs, String[] c, String[] m, String a, double p) {
        this.id = n;
        this.question = qs;
        this.choices = c;
        this.matches = m;
        this.answer_correct = a;
        this.point = p;
    }
    
    @Override
    //Creating xml for the object Matching
    public String getXML(){
        String res = "\n\t\t<matching ";
        res += String.format("id=\"%s\" qs=\"%s\" c=\"%s\" m=\"%s\" a=\"%s\" p=\"%s\">", this.id, this.question,array_to_string(this.choices),array_to_string(this.matches),this.answer_correct,double_to_string(this.point));
        res += "\n\t\t</matching>";
        return res;
    }
    
    @Override
    //Displays the Matching question
    public void perform(){
        //Printing the instructions
        System.out.printf("Question %s\n", this.id);
        System.out.printf("This question is worth %.2f points\n", this.point);
        NewMain.maxscore += this.point; //Updating maxscore
        System.out.println(this.question); //Printing the question
        for(String s: this.choices) { //Printing the choices
            System.out.printf("%s ", s);
        }
        System.out.println();
        for(String s: this.matches) { //Printing the possible matching partners
            System.out.printf("%s ", s);
        }
        String[] answers = this.answer_correct.split(" ");
        System.out.println("\nPlease only type the letter of the option!");
        //Loops all the choices to see the potential partners
        for(int i = 0; i < this.choices.length; i++) {
            //Getting an answer from the user
            System.out.printf("\nYour answer for %s:",this.choices[i]);
            Scanner input = new Scanner(System.in);
            String s = input.next();
            char response = s.toUpperCase().charAt(0);
            //Checking whether the given answer is correct or not
            if (response == answers[i].charAt(0)) { 
                System.out.println("Correct answer!\n");
                NewMain.score += this.point / (double) this.choices.length; //Updating score
            }
            else { 
                System.out.printf("Wrong answer! The correct choice was %s\n\n",answers[i]);
            } 
        }
    }
}
