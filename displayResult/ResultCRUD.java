package displayResult;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Questions.Question;
import Questions.QuestionCRUD;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class ResultCRUD extends JFrame {

	private JPanel contentPane;
	public JLabel label1;
	public JLabel label_1;
	public JLabel label_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultCRUD frame = new ResultCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ResultCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setForeground(Color.BLUE);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(285, 25, 129, 38);
		contentPane.add(lblResult);
		
		JLabel lblCorrectAnswers = new JLabel("Total Marks");
		lblCorrectAnswers.setForeground(Color.RED);
		lblCorrectAnswers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCorrectAnswers.setBounds(127, 108, 140, 29);
		contentPane.add(lblCorrectAnswers);
		
		JLabel lblTotalQuestions = new JLabel("Questions Attempted");
		lblTotalQuestions.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalQuestions.setForeground(Color.RED);
		lblTotalQuestions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQuestions.setBounds(104, 162, 173, 28);
		contentPane.add(lblTotalQuestions);
		
		JLabel Average = new JLabel("Average Percentage");
		Average.setFont(new Font("Tahoma", Font.BOLD, 15));
		Average.setForeground(Color.RED);
		Average.setBounds(116, 279, 151, 28);
		contentPane.add(Average);
		
		label1 = new JLabel("");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(290, 92, 162, 45);
		contentPane.add(label1);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(287, 148, 162, 45);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(363, 275, 162, 45);
		contentPane.add(label_2);
		
		JLabel lblTotalQuestions_1 = new JLabel("Total Questions");
		lblTotalQuestions_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalQuestions_1.setForeground(Color.RED);
		lblTotalQuestions_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQuestions_1.setBounds(104, 225, 173, 28);
		contentPane.add(lblTotalQuestions_1);
		
		JLabel label = new JLabel("5");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(290, 219, 162, 45);
		contentPane.add(label);
		int sum = 0;
//		Question currentQuestion = new Question();
////		sum=currentQuestion.getSum();
////		String Sum = String.valueOf(sum);
////		System.out.println(Sum);
//		label1.setText(String.valueOf(currentQuestion.getSum()));
	}
//	public void getValues(int sum){
//		
//		String Sum = String.valueOf(sum);
//		System.out.println(Sum);
//		label1.setText(Sum);
//		}
}
