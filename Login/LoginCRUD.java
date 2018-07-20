package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Questions.QuestionCRUD;
import Register.RegisterOperations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginCRUD extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCRUD frame = new LoginCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setForeground(Color.BLACK);
		lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLoginScreen.setBounds(169, 11, 165, 53);
		contentPane.add(lblLoginScreen);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(124, 108, 108, 32);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(271, 114, 151, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(114, 171, 108, 32);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(271, 177, 151, 24);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(LoginCRUD.class.getResource("/Login/login.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginItem();
				}
		});
		btnNewButton.setBounds(108, 291, 151, 53);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setIcon(new ImageIcon(LoginCRUD.class.getResource("/images/reset.png")));
		btnReset.setBounds(320, 291, 151, 53);
		contentPane.add(btnReset);
	}
	public void LoginItem() {
		String Name=name.getText();
		String Password = password.getText();
		String result = RegisterOperations.getInstance().search(Name,Password)>=0?"Login successful":"Invalid user id or password";
//		if(result==0)
		 JOptionPane.showMessageDialog(this,result);
		 if(result=="Login successful"){
		 QuestionCRUD obj= new QuestionCRUD();
		 obj.setVisible(true);
		 obj.doAnimation();
		 obj.playSound();}
//		else
//		JOptionPane.showMessageDialog(this,"User id or Password mismatched");	
		}
	public void reset(){
		name.setText(null);
		password.setText(null);
	}
}
