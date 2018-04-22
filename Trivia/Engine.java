
/**
 * Write a description of class Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Engine
{
    public static void main(String[] args){
        DrawQuestion myDrawQuestion = new DrawQuestion("Trivia.txt");
        myDrawQuestion.main(null);
        
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        DrawQuestion2 myDrawQuestion2 = new DrawQuestion2("Trivia2.txt");
        myDrawQuestion2.main(null);
        
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        DrawQuestion3 myDrawQuestion3 = new DrawQuestion3("Trivia3.txt");
        myDrawQuestion3.main(null);
        
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        DrawQuestion4 myDrawQuestion4 = new DrawQuestion4("Trivia4.txt");
        myDrawQuestion4.main(null);
        
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        DrawQuestion5 myDrawQuestion5 = new DrawQuestion5("Trivia5.txt");
        myDrawQuestion5.main(null);
    }
}
