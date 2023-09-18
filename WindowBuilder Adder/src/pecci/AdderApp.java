package pecci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AdderApp {

	private JFrame frame;
	private JTextField num1;
	private JTextField num2;
	private JButton button;
	private JTextArea textAreaOutput; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdderApp window = new AdderApp();
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
	public AdderApp() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("BIG INTEGER ADDER");
		Title.setBounds(167, 10, 102, 39);
		frame.getContentPane().add(Title);
		
		button = new JButton("ADD");
		button.setBounds(167, 127, 85, 21);
		frame.getContentPane().add(button);
		
		JLabel plus = new JLabel("+");
		plus.setBounds(214, 98, 14, 13);
		frame.getContentPane().add(plus);
		
		num1 = new JTextField();
		num1.setBounds(79, 95, 96, 19);
		frame.getContentPane().add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setBounds(255, 95, 96, 19);
		frame.getContentPane().add(num2);
		num2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 160, 272, 71);
		frame.getContentPane().add(scrollPane);
		
		textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
	}
	
	
	
	
	private void createEvents() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	private void buildOutput() {
		BigNumber number = new BigNumber(num1.getText() , num2.getText());
		textAreaOutput.setText(number.addNumbers());
	}
	
}
