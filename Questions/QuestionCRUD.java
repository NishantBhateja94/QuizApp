package Questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import displayResult.ResultCRUD;
import jaco.mp3.player.MP3Player;

import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class QuestionCRUD extends JWindow {
	JButton btnSubmit = new JButton("Submit");
	int sum=0;
	int attempt;
	JProgressBar progressBar = new JProgressBar();
	boolean isVisible ;
	Timer timer;
	int progressCount=100 ;
	private MP3Player mp3;
	JLabel questionlbl = new JLabel("");
JRadioButton radio1 = new JRadioButton("");
JRadioButton radio2 = new JRadioButton("");
JRadioButton radio3 = new JRadioButton("");
JRadioButton radio4 = new JRadioButton("");
ButtonGroup bG = new ButtonGroup();
private int index=0;
private int totalQuestions;
	private JPanel contentPane;
	JButton btnPrevious = new JButton("Previous");
    JButton btnNewButton = new JButton("Next");
	public void playSound(){
		mp3 = new MP3Player(QuestionCRUD.class.getResource("clock.mp3"));
		mp3.play();
	}
    public void doAnimation(){
		timer  = new Timer(350,(e)->{
			//titlelbl.setVisible(isVisible);
			isVisible = !isVisible;
			progressBar.setValue(progressCount);
			progressCount--;
			if(progressCount==0){
				timer.stop();
				
				submit();
			}
		});

		timer.start();
	}
    private void printQuestion(int index){
    Question currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
    StringBuilder question = new StringBuilder();
    question.append("Q").append(index++).append("    ").append(currentQuestion.getQuestion());
  
    questionlbl.setText(question.toString());
    //to String isliye verna error
    radio1.setText(currentQuestion.getAnswers()[0]);
    radio2.setText(currentQuestion.getAnswers()[1]);
    radio3.setText(currentQuestion.getAnswers()[2]);
    radio4.setText(currentQuestion.getAnswers()[3]);
    if(!(currentQuestion.getYourAnswer()!=null&&currentQuestion.getYourAnswer().trim().length()>0))
    	clearAnswers();
    else{
    	switch(currentQuestion.getYourAnswer()){
    	case "a":
    		      radio1.setSelected(true);
    		      break;
    	case "b":
		      radio2.setSelected(true);
		      break;
    	case "c":
		      radio3.setSelected(true);
		      break;
    	case "d":
		      radio4.setSelected(true);
		     break;
//		      this.attempt= currentQuestion.getAttempt();
//				this.attempt=attempt+1;
//				currentQuestion.setAttempt(attempt);
		     // attempt();
    	}
    }
    }
    private void clearAnswers(){
    	bG.clearSelection();
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionCRUD frame = new QuestionCRUD();
					frame.setVisible(true);
					frame.playSound();
					frame.doAnimation();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public QuestionCRUD() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 506);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bG.add(radio1);
		
		
		radio1.setBounds(166, 172, 186, 23);
		contentPane.add(radio1);
		bG.add(radio2);
		
		
		radio2.setBounds(166, 217, 186, 23);
		contentPane.add(radio2);
		bG.add(radio3);
		
		
		radio3.setBounds(166, 263, 186, 23);
		contentPane.add(radio3);
		bG.add(radio4);
		
		
		radio4.setBounds(166, 312, 186, 23);
		contentPane.add(radio4);
		
		JLabel lblQuestions = new JLabel("Questions");
		lblQuestions.setForeground(Color.BLACK);
		lblQuestions.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestions.setBounds(299, 11, 105, 51);
		contentPane.add(lblQuestions);
		btnNewButton.setIcon(new ImageIcon(QuestionCRUD.class.getResource("/Questions/next.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alreadyStored=false;
				att=false;
				correctAns=false;
				next();
			}
		});
		btnPrevious.setIcon(new ImageIcon(QuestionCRUD.class.getResource("/Questions/previous.png")));
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		loadQuestions();
		printQuestion(this.index);
		enableDisable();
		this.totalQuestions= QuestionOperation.getInstance().getQuestions().size();
		 radio1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		updateAns(e);
		    	}
		    });
		 radio2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		updateAns(e);
		    	}
		    });
		 radio3.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		updateAns(e);
		    	}
		    });
		 radio4.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		updateAns(e);
		    	}
		    });
		
		
		btnNewButton.setBounds(529, 410, 169, 46);
		contentPane.add(btnNewButton);
		
		
		
		
		btnPrevious.setBounds(69, 405, 183, 51);
		contentPane.add(btnPrevious);
		btnSubmit.setIcon(new ImageIcon(QuestionCRUD.class.getResource("/Questions/submit.png")));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		
		btnSubmit.setBounds(299, 410, 169, 46);
		contentPane.add(btnSubmit);
		progressBar.setBackground(Color.RED);
		
		
		progressBar.setValue(100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(504, 68, 56, 31);
		contentPane.add(progressBar);
		
		
		questionlbl.setBounds(59, 54, 501, 125);
		contentPane.add(questionlbl);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{radio1, radio2, radio3, radio4, btnNewButton, btnPrevious, btnSubmit, lblQuestions}));
	}
	ArrayList<Question> array = new ArrayList<>();
	private void loadQuestions(){
		QuestionOperation questionOperation = QuestionOperation.getInstance();
		Question question = new Question();
		question.setId(0);
		question.setQuestion("When does Exceptions in Java arises in code sequence?");
		String answers [] = {" Run Time","Compilation Time","Can Occur Any Time","None of these"};
		question.setAnswers(answers);
		question.setRightAnswer("a");
		question.setScore(5);
		questionOperation.addQuestion(question);
		question  = new Question();
		question.setId(1);
		question.setQuestion("Which of these keywords is used to manually throw an exception?");
		String answers0 [] = {"try","finally","throw","catch"};
		question.setAnswers(answers0);
		question.setRightAnswer("c");
		question.setScore(5);
		questionOperation.addQuestion(question);
		array.add(question);
		question  = new Question();
		question.setId(2);
		question.setQuestion("Which exception is thrown by read() method?");
		 String answers1 [] = {"IOException","InterruptedException","SystemException","SystemInputException"};
		question.setAnswers(answers1);
		question.setRightAnswer("a");
		question.setScore(5);
		questionOperation.addQuestion(question);
		array.add(question);
		question  = new Question();
		question.setId(3);
		question.setQuestion("Which of these is used to read a string from the input stream?");
		 String answers2 [] = {"get()","getLine()","read()","readLine()"};
		question.setAnswers(answers2);
		question.setRightAnswer("c");
		question.setScore(5);
		questionOperation.addQuestion(question);
		array.add(question);
		
		question  = new Question();
		question.setId(4);
		question.setQuestion(" Which of the following reference types cannot be generic?");
		 String answers3 [] = {"Anonymous inner class","Interface","Inner class","All of the mentioned"};
		question.setAnswers(answers3);
		question.setRightAnswer("a");
		question.setScore(5);
		questionOperation.addQuestion(question);
		array.add(question);
	}
	private void enableDisable(){
		btnNewButton.setEnabled(index==totalQuestions-1?false:true);
	    //btnSubmit.setEnabled(index==totalQuestions-1?true:false);
	    btnPrevious.setEnabled(index>0?true:false);
	}
	int i=0;
	static int h=0;
	int[] arr = new int[5];
	String ans = new String();
	Boolean alreadyStored = false;
	Boolean att=false;
	Boolean correctAns=false;
	private void updateAns(ActionEvent e){
		int sum=0;
		Question question = new Question();
		Question currentQuestion= QuestionOperation.getInstance().getQuestionByIndex(index);
		if(e.getSource()==radio1)
			currentQuestion.setYourAnswer("a");
		else if(e.getSource()==radio2)
			currentQuestion.setYourAnswer("b");
		else if(e.getSource()==radio3)
			currentQuestion.setYourAnswer("c");
		else if(e.getSource()==radio4)
			currentQuestion.setYourAnswer("d");
		System.out.println("Update........."+currentQuestion.getYourAnswer());
		for(Question questions:array){
			if(currentQuestion.getYourAnswer()!=null){
				if(att)
					break;
				h++;                                    // no. of questions attempted
				att=true;
				break;
			}
		}
		for(Question questions:array){
			if(currentQuestion.getYourAnswer()==questions.getRightAnswer()){
				if(currentQuestion.getYourAnswer()==currentQuestion.getRightAnswer()){
				if(alreadyStored){
					correctAns=true;
					break;
				}                                                                  //no. of marks scored
				arr[i]=arr[i]+5;
				alreadyStored=true;
				ans=currentQuestion.getYourAnswer();
				correctAns=false;
//				h++;
				break;
			}
			}
			}
//			if(alreadyStored){
//			if(ans==question.getRightAnswer()){
//					arr[i]=arr[i]-5;
//				}
//			}
			if(currentQuestion.getYourAnswer()!=currentQuestion.getRightAnswer()){
				if(correctAns){
					
				}
				else{
					arr[i]=arr[i]-5;
					correctAns=true;
				}
			}
		
	
	}
	private void attempt() {
		this.attempt= currentQuestion.getAttempt();
		this.attempt=attempt+1;
		currentQuestion.setAttempt(attempt);
		System.out.println(currentQuestion.attempt);
	}
	private void prev(){
		if(index>0){
			index--;
			btnPrevious.setEnabled(true);
		}
		printQuestion(index);
		enableDisable();
	}
	private void next(){
		 if(index<totalQuestions)
			 index++;
//		 else if(index<=totalQuestions){
//			 btnSubmit.setEnabled(true);
//			 }
		 enableDisable();

		 printQuestion(index);
	 }Question currentQuestion = new Question();
	 ResultCRUD result = new ResultCRUD();
	private void check() {
		
		this.sum= currentQuestion.getSum();
		this.sum=sum+5;
		currentQuestion.setSum(sum);
		System.out.println(currentQuestion.sum);
		//result.getValues(currentQuestion.sum);
		
	}
	int average;
	private void submit(){
		//enableDisable();
		mp3.stop();
		timer.stop();
//		Question currentQuestion = new Question();
		JOptionPane.showMessageDialog(this,"Your Answers are submitted ");
		ResultCRUD frame = new ResultCRUD();
		frame.setVisible(true);
		frame.label1.setText(String.valueOf(arr[i]));
		frame.label_1.setText(String.valueOf(h));
		average = arr[i]/totalQuestions*20;
		frame.label_2.setText(String.valueOf(average));
	}
}
