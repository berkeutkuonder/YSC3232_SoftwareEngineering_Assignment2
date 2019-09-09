package p1;

import java.util.ArrayList;
import java.util.List;

public class Section implements CanGenerateXML {
    String id; //Name of the section
    String type; //Type of the questions that are available in one section
    public List<Question> questions  = new ArrayList<>(); //Storing questions in a list
    
    //Creating a new Section object
    Section(String n, String t){
        this.id = n;
        this.type = t;
    }
    
    @Override
    //Creating xml for the object Section
    public String getXML(){
        String res = "\n\t<section ";
        res += String.format("id=\"%s\" type=\"%s\">", this.id, this.type);
        //looping all the Questions and getting their XML
        for(Question q : questions) {
            res += q.getXML();
        } 
        res += "\n\t</section>";
        return res;
    }
    
    //Creates a new Mcq object and puts into the list questions
    public void newMCQ(String n, String qs, String[] c, String a, double p) {
        Question q = new Mcq(n, qs, c, a, p);
        this.questions.add(q);
    }
    
    //Creates a new OpenEnded object and puts into the list questions
    public void newOpenEnded(String n, String qs, String a, double p) {
        Question q = new OpenEnded(n, qs, a, p);
        this.questions.add(q);
    }
    
    //Creates a new Matching object and puts into the list questions
    public void newMatching(String n, String qs, String[] c, String[] m, String a, double p) {
        Question q = new Matching(n, qs, c, m, a, p);
        this.questions.add(q);
    }
    
    //Creates a new Essay object and puts into the list questions
    public void newEssay(String n, String qs, double p) {
        Question q = new Essay(n, qs, p);
        this.questions.add(q);
    }
    
    //Performs the section, displays all questions in this object
    public void perform(){
        //Printing the instructions
        System.out.printf("Section %s has started\n", this.id);
        System.out.printf("There are %d %s questions in this section\n\n", this.questions.size(), this.type);
        for(Question q : questions) {
            q.perform(); //Displays each question
        }
        System.out.printf("Section %s has ended\n\n", this.id);
    }
}
