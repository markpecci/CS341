package pecci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PasswordMain {

	private JFrame frame;
	private JTextField password;
	private JButton button;
	private JTextArea textAreaOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordMain window = new PasswordMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordMain() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPasswordChecker = new JLabel("Password Checker");
		lblPasswordChecker.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPasswordChecker.setBounds(136, 10, 170, 40);
		frame.getContentPane().add(lblPasswordChecker);
		
		JLabel lblNewLabel = new JLabel("Enter Password: ");
		lblNewLabel.setBounds(47, 85, 78, 23);
		frame.getContentPane().add(lblNewLabel);
		
		password = new JTextField();
		password.setBounds(171, 87, 96, 19);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 148, 346, 66);
		frame.getContentPane().add(scrollPane);
		
		textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
		
		button = new JButton("Check Strength");
		button.setBounds(290, 86, 103, 21);
		frame.getContentPane().add(button);
	}
	private void createEvents() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	private void buildOutput() {
		Password a = new Password(password.getText());
		textAreaOutput.setText(a.checkPassword());
	}
}
