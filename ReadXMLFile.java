package p1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile { //A class to store read function
    public static Exam read(String filename) { //Reads xml files and creates an exam
       
        Exam myexam = new Exam(); // A variable to store the exam
        try {
            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //Getting the Sections in the Exam
            NodeList sections = doc.getElementsByTagName("section");
            
            //looping all the Sections
            for (int i = 0; i < sections.getLength(); i++) {
                Node section = sections.item(i);
                Element s = (Element) section;
                NodeList questions;
                String name = s.getAttribute("id"); //Getting id
                String type = s.getAttribute("type"); //Getting type
                myexam.newSection(name,type); //Creating a new Section and adding it to myexam
                switch(type) { //For different types, there are different importing ways
                    case "MCQ":
                        questions = s.getElementsByTagName("mcq"); //Getting the Mcqs in the Section
                        //Looping all the questions
                        for (int j = 0; j < questions.getLength(); j++) {
                            Node question = questions.item(j);
                            Element q = (Element) question;
                            //Getting credentials to create a new Mcq
                            String id = q.getAttribute("id");
                            String qs = q.getAttribute("qs");
                            String c = q.getAttribute("c");
                            String a = q.getAttribute("a");
                            double p = Double.parseDouble(q.getAttribute("p"));
                            //Creating a new Mcq and adding it to the current section
                            myexam.sections.get(i).newMCQ(id,qs, c.split(","),a,p);
                        }
                        break;
                    case "OpenEnded":
                        questions = s.getElementsByTagName("open"); //Getting the OpenEndeds in the Section
                        //Looping all the questions
                        for (int j = 0; j < questions.getLength(); j++) {
                            Node question = questions.item(j);
                            Element q = (Element) question;
                            //Getting credentials to create a new OpenEnded
                            String id = q.getAttribute("id");
                            String qs = q.getAttribute("qs");
                            String a = q.getAttribute("a");
                            double p = Double.parseDouble(q.getAttribute("p"));
                            //Creating a new OpenEnded and adding it to the current section
                            myexam.sections.get(i).newOpenEnded(id,qs,a,p);
                        }
                        break;
                    case "Matching":
                        questions = s.getElementsByTagName("matching"); //Getting the Matchings in the Section
                        //Looping all the questions
                        for (int j = 0; j < questions.getLength(); j++) {
                            Node question = questions.item(j);
                            Element q = (Element) question;
                            //Getting credentials to create a new Matching
                            String id = q.getAttribute("id");
                            String qs = q.getAttribute("qs");
                            String c = q.getAttribute("c");
                            String m = q.getAttribute("m");
                            String a = q.getAttribute("a");
                            double p = Double.parseDouble(q.getAttribute("p"));
                            //Creating a new Matching and adding it to the current section
                            myexam.sections.get(i).newMatching(id,qs, c.split(","),m.split(","),a,p);
                        }
                        break;
                    case "Essay":
                        questions = s.getElementsByTagName("essay"); //Getting the Essays in the Section
                        //Looping all the questions
                        for (int j = 0; j < questions.getLength(); j++) {
                            Node question = questions.item(j);
                            Element q = (Element) question;
                            //Getting credentials to create a new Essay
                            String id = q.getAttribute("id");
                            String qs = q.getAttribute("qs");
                            double p = Double.parseDouble(q.getAttribute("p"));
                            //Creating a new Essay and adding it to the current section
                            myexam.sections.get(i).newEssay(id,qs,p);
                        }
                        break;
                    default:
                        System.out.print("This shouldn't happen!");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return myexam;
    }
}
