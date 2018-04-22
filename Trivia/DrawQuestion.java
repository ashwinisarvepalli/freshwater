import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
/**
 * Class DrawQuestion
 *
 * @author Sarayu Namineni
 * @version 2018-04-21
 */
public class DrawQuestion extends JPanel
{
    private static ArrayList<Question> questions = new ArrayList<Question> ();
    private static String username;
    private static boolean right;
    private static int total_right;
    private static int total_wrong;
    private static boolean end_game;
    private static Scanner in;
    private static FileWriter out;
    
    public DrawQuestion(String username){
        this.username = username;
        input_file();
    }
    
    public void input_file(){
        File file = new File("Trivia.txt");
        Scanner in;
        try{
            in = new Scanner(file);
            String str;
            String[] splitString;
            String[] answers = new String[4];
            while(in.hasNext()){
                str = in.nextLine();
                splitString = str.split(";");
                String question = splitString[0];
                String correctAnswer = splitString[1];
                String incorrect1 = splitString[2];
                String incorrect2 = splitString[3];
                String incorrect3 = splitString[4];
                answers[0] = splitString[1];
                answers[1] = splitString[2];
                answers[2] = splitString[3];
                answers[3] = splitString[4];
                questions.add(new Question(splitString[0], answers));
            }
        }
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
    }
    
    public static void output_file(){
        try{
            in = new Scanner(new File("Trivia_Data.txt"));
            while(in.hasNext()){
                String str = in.nextLine();
                String[] splitString = str.split(";");
                if (splitString[0].equals(username)){
                    int user_total_right = Integer.parseInt(splitString[1]);
                    total_right += user_total_right;
                    int user_total_wrong = Integer.parseInt(splitString[2]);
                    total_wrong += user_total_wrong;
                } 
            }
            in.close();
            
            out = new FileWriter("Trivia_Data.txt");
            
            
            out.write(username + ";" + total_right + ";" + total_wrong);
            
            out.close();
        } catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }
    }
    
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        super.paintComponent(g2);
        
        g2.setColor(Color.BLACK);
        Font font = g.getFont().deriveFont(12.0f);
        g2.setFont(font);
        
        //Display question and answers on JFrame
    
        String[] letter_choices = new String[4];
        letter_choices[0] = "(A)"; letter_choices[1] = "(B)"; letter_choices[2] = "(C)";
        letter_choices[3] = "(D)";
        for (int i = 0; i < questions.size(); i++){
            //ArrayList<String> random_answers = new ArrayList<String>();
            //random_answers = questions.get(i).randomize_answers();
            //System.out.println("Random_answers: " + random_answers);
            g.drawString(questions.get(i).get_question(), 100, 100);
            for(int j = 0; j < 4; j++){
                g.drawString(letter_choices[j], 100, 40*j + 150);
                g.drawString(questions.get(i).get_answer(j), 125, 40*j+150);
            }
        }
        setBackground(Color.WHITE);
    }
    
    // public static void selectionButtonPressed(int option){
        // if (option == 4){
            // end_game = true;
        // } else if (option == questions.get(0).get_right_answer_index()){
            // total_right++;
            // JLabel correct = new JLabel("That's right!");
            // correct.setVerticalTextPosition(JLabel.BOTTOM);
            // correct.setHorizontalTextPosition(JLabel.CENTER);
            // add(correct);
            // //System.out.println("That's right");
            // //right = true;
        // } else{
            // JLabel wrong = new JLabel("Nope...", JLabel.TRAILING);
            // wrong.setVerticalTextPosition(JLabel.BOTTOM);
            // wrong.setHorizontalTextPosition(JLabel.CENTER);
            // add(wrong);
            // //System.out.println("Nope...");
            // //right = false;
        // }
    // }
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(750, 750);
        frame.setTitle("Trivia!"); 
        DrawQuestion question = new DrawQuestion("User");
        
        frame.setLayout(new BorderLayout());
        frame.add(question, BorderLayout.CENTER);
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.add(buttons, BorderLayout.PAGE_END);
        
        JLabel correct = new JLabel("That's right!");
        JLabel wrong = new JLabel("Nope...");
        //frame.add(correct);
        //frame.add(wrong);
        
        JButton buttonA = new JButton("A");
        buttonA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (0 == questions.get(0).get_right_answer_index()){
                    total_right++;
                    frame.add(correct);
                    correct.setVisible(true);
                    System.out.println("That's right!");
                } else{
                    total_wrong++;
                    frame.add(wrong);
                    wrong.setVisible(true);
                    System.out.println("Nope...");
                }
            }
        });
        buttons.add(buttonA);
        
        JButton buttonB = new JButton("B");
        buttonB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (1 == questions.get(0).get_right_answer_index()){
                    total_right++;
                    correct.setVisible(true);
                    System.out.println("That's right!");
                } else{
                    total_wrong++;
                    wrong.setVisible(true);
                    System.out.println("Nope...");
                }
                output_file();
            }
        });
        buttons.add(buttonB);
        
        JButton buttonC = new JButton("C");
        buttonC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (2 == questions.get(0).get_right_answer_index()){
                    total_right++;
                    correct.setVisible(true);
                    System.out.println("That's right!");
                } else{
                    total_wrong++;
                    wrong.setVisible(true);
                    System.out.println("Nope...");
                }
                output_file();
            }
        });
        buttons.add(buttonC);
        
        JButton buttonD = new JButton("D"); 
        buttonD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (3 == questions.get(0).get_right_answer_index()){
                    total_right++;
                    correct.setVisible(true);
                    System.out.println("That's right!");
                } else{
                    total_wrong++;
                    wrong.setVisible(true);
                    System.out.println("Nope...");
                }
                output_file();
            }
        });
        buttons.add(buttonD);
        
        JButton exit = new JButton("Exit"); 
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                end_game = true;
            }
        });
        buttons.add(exit); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
