import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Question
 *
 * @author Sarayu Namineni
 * @version 2018-04-21
 */
public class Question
{
    private String question;
    private String[] answers;
    private int right_answer_index = 0;
    
    public Question(String question, String[] answers){
        this.question = question;
        this.answers = answers;
    }
    
    public ArrayList<String> randomize_answers(){
        //creates a copy of the String answer 
        ArrayList<String> answers_copy = new ArrayList<String>();
        for (int i = 0; i < answers.length; i++){
            answers_copy.add(i, answers[i]);
        }
        
        //randomizes answers
        Collections.shuffle(answers_copy);
        
        //sets the index of right answer
        for (int i = 0; i < answers_copy.size(); i++){
            if (answers_copy.get(i).equals(answers[0])){
                right_answer_index = i;
                break;
            }
        }
        return answers_copy;
    }
    
    public String get_question(){
        return this.question;
    }
    
    public String[] getAnswers(){
        return answers;
    }
    
    public String get_answer(int index){
        if (index < 0 || index > 3){
            return "Not valid index";
        } else {
            return answers[index];
        }
    }
    
    public int get_right_answer_index(){
        return this.right_answer_index;
    }
}