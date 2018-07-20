package Register;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginCRUD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterCRUD extends JFrame {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField password;
	private JButton btnLogin = new JButton("");
	private JTextField textField;
	private JTextField textField_1;
	public JLabel validation_1 = new JLabel("please enter character values");
	public static void main(String[] args) {
		RegisterCRUD frame = new RegisterCRUD();
					frame.setVisible(true);
		
	}

	public RegisterCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 393);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Screen");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 11, 205, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(121, 85, 64, 23);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(261, 83, 138, 28);
		contentPane.add(name);
		name.setColumns(10);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(121, 237, 82, 23);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(264, 232, 159, 33);
		contentPane.add(password);
		JButton btnRegister = new JButton("Register");
		btnRegister.setIcon(new ImageIcon(RegisterCRUD.class.getResource("/Register/register-button.png")));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewItem();
			}
		});
		btnRegister.setBounds(92, 303, 184, 40);
		contentPane.add(btnRegister);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginItem();
			}
		});
		
		btnLogin.setIcon(new ImageIcon(RegisterCRUD.class.getResource("/images/login.png")));
		btnLogin.setVisible(false);
		btnLogin.setBounds(324, 303, 113, 40);
		contentPane.add(btnLogin);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setBounds(124, 134, 95, 23);
		contentPane.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(261, 131, 205, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO:");
		lblPhoneNo.setForeground(Color.BLUE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNo.setBounds(121, 180, 82, 23);
		contentPane.add(lblPhoneNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 180, 176, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		validation_1.setBackground(Color.RED);
		validation_1.setBounds(401, 87, 119, 23);
		contentPane.add(validation_1);
		validation_1.setVisible(false);
	}
	   private void addNewItem() {
		   String Name=name.getText();
		   if(Name=="nishant") {
		   JOptionPane.showMessageDialog(this,"please enter characters");
		   }
//		   if(stringContainsNumber( Name) ) {
//			   validation_1.setVisible(false);
//		   }
		   String Password= password.getText();
		   Register register = new Register(Name,Password);
		   RegisterOperations registerOperations=RegisterOperations.getInstance();
		   String result= registerOperations.addItem(register);
		   JOptionPane.showMessageDialog(this,result);
		   btnLogin.setVisible(true);
		   
	   }
	   private void loginItem() {
		   LoginCRUD login = new LoginCRUD();
		   login.setVisible(true);
	   }
}
