package p1;

import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;

public class Exam implements CanGenerateXML{
    
    public List<Section> sections = new ArrayList<>(); //Storing sections in a list
    
    //Creating a new section and appending it to "sections"
    public void newSection(String n, String type) {
        Section s = new Section(n, type);
        this.sections.add(s);
    }
    
    @Override
    //Creating xml for the object Exam
    public String getXML() { 
       String res = "<?xml version=\"1.0\"?>\n<exam>";
       //looping all the Sections and getting their XML
        for(Section s : sections) {
            res += s.getXML();
        } 
        res += "\n</exam>";
        return res; 
    }
    
    //Creating a test case, this helps us to test the objects and the program
    public static Exam demo(){
        //Creating a new Exam object
        Exam myexam = new Exam();
        //Adding a new Section object to myexam
        myexam.newSection("s1","MCQ");
        //Adding Mcq questions to the Section
        myexam.sections.get(0).newMCQ("q1","What is 2 + 2?", new String[]{"A) 0","B) 2","C) 3","D) 4" },"D",5);
        myexam.sections.get(0).newMCQ("q2","What is the symbol of Helium?", new String[]{"A) H","B) He","C) Hl","D) Hm" },"B",5);
        myexam.sections.get(0).newMCQ("q3","What is the capital of Turkey?", new String[]{"A) Ankara","B) Bursa","C) Istanbul","D) Izmir" },"A",5);
        //Adding a new Section object to myexam
        myexam.newSection("s2","OpenEnded");
        //Adding penEnded questions to the Section
        myexam.sections.get(1).newOpenEnded("q1","What is 4 + 4?","8",5);
        myexam.sections.get(1).newOpenEnded("q2","What is 4 * 4?","16",5);
        myexam.sections.get(1).newOpenEnded("q3","Who is the surname of best prof in the world?","bodin",5);
        //Adding a new Section object to myexam
        myexam.newSection("s3","Matching");
        //Adding a Matching question to the Section
        myexam.sections.get(2).newMatching("q1","Match countries with their capital", new String[]{"1- Germany","2- France","3- Italy","4- Spain"},new String[]{"A- Rome","B- Berlin","C- Madrid","D- Paris"},"B D A C",20);
        //Adding a new Section object to myexam
        myexam.newSection("s4","Essay");
        //Adding an Essay question to the Section
        myexam.sections.get(3).newEssay("q1","Write an in which you explain the importance of water",50);
        return myexam;
    }
    
    //Storing the XML format in a file
    public void saveXML(String filename) throws Exception {
        FileWriter fw =  new FileWriter(filename);
        String res = getXML(); //Gets the XML in a String form
        fw.write(res);
        fw.close();
    }
    
    //Starts the object exam, displays all the sections in this object
    public void perform(){
        System.out.println("The exam has started\nGood luck!!!\n"); //Printing the instructions
        for(Section s : sections) {
            s.perform(); //Displays each section
        }
        System.out.println("The exam has ended\n");
    }
    
}
