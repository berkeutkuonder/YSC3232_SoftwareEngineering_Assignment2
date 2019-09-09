package p1;

//An abstract data type for different types of questions. 
//All types of question inherits this object
public abstract class Question implements CanGenerateXML{
    String id; //Name (id) of the question
    String question; //The question itself
    String[] choices; //Available choises for the question
    String[] matches; //If there is a matching, this list stores the other matching part
    String answer_correct; //Correct answer
    double point; // The point the question is worth
    
    abstract void perform(); //To display the question
    
    //Converts array to string in order to store the array in XML format
    //This function is needed because toString() method also includes the brackets
    public static String array_to_string(String[] arr) {
        String res = "";
        for(int i=0; i < arr.length-1; i++) {
            res += arr[i];
            res += ",";
        }
        res += arr[arr.length-1];
        return(res);
    }
    
    //Converts double to string in order to store the double in XML format
    //This function is needed because printf function puts ',' instead of '.'
    //which causes problems while uploading an XML file
    public static String double_to_string(double num) {
        double n = num - (int) num;
        int fl = (int) (n * 100000);
        String res = String.format("%d.%d", (int) num, fl);
        return(res);
    }
}
