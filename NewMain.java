package p1;

import java.util.Scanner;

public class NewMain {
    
    public static double score = 0; //Variable to store the current result
    public static double maxscore = 0; //Variable to store the maximum possible result
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //Printing the instructions of the exam
        System.out.println("Dear Student,");
        System.out.println("If you have a exam in XML format, plase type YES to upload your exam");
        System.out.println("If you want to take demo test, plase type NO to start the exam");
        //Getting an input from the user
        System.out.print("Please enter your response:");
        String myString = input.next();
        char response = myString.toUpperCase().charAt(0);
        //Checking the input and making sure that the input is valid
        while(response != 'Y' && response != 'N') {
            System.out.println("\n\nAn invalid response given. Please try again!\n");
            System.out.println("If you have taken the exam previously, plase type YES to upload your exam");
            System.out.println("If you have not taken the exam previously, plase type NO to start the exam");
            System.out.print("Please enter your response:");
            myString = input.next();
            response = myString.toUpperCase().charAt(0);
        }
        
        if (response == 'Y') { //Uploads the exam from the xml file
            System.out.println("\nUploading your exam...\n");
            Exam myexam = ReadXMLFile.read("exam.xml"); //Uploading the exam from an XML file 
            myexam.perform(); //Performs the test
            System.out.printf("Your final score is: %.2f out of %.2f", score, maxscore); //Printing the result
        }
        else { //Starts a new (demo) test
            System.out.println("\nStarting the exam...\n");
            Exam myexam = Exam.demo(); //Creates a demo test
            myexam.saveXML("exam.xml"); //Save the XML  format into a file
            myexam.perform(); //Performs the test
            System.out.printf("Your final score is: %.2f out of %.2f", score, maxscore); //Printing the result
        }   
    }  
}
