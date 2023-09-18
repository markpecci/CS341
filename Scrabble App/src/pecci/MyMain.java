package pecci;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyMain {

	// GUI ELEMENTS
	private JFrame frame;
	private JTextField Letter1;
	private JTextField Letter2;
	private JButton ScrabbleBtn;
	private JTextField Letter3;
	private JTextField Letter4;
	private JScrollPane scrollPane;
	private JTextArea showResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
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
	public MyMain() {
		initialize();

		// CREATE A BUTTON EVENT LISTENER
		ScrabbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrabble();
			}
		});
	}

	private void scrabble() {
		Scrabble b = new Scrabble(Letter1.getText(),Letter2.getText(),Letter3.getText(),Letter4.getText());
		b.checkLetters();
		if(!b.error) {
			Scrabble.permutations(b.getL1()+b.getL2()+b.getL3()+b.getL4(), "");
		}
		showResult.setText(b.getOutput());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//SCRABBLE TITLE
		JLabel lblNewLabel = new JLabel("Scrabble");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblNewLabel.setBounds(-12, 30, 438, 34);
		frame.getContentPane().add(lblNewLabel);

		Letter1 = new JTextField();
		Letter1.setBounds(129, 74, 26, 26);
		frame.getContentPane().add(Letter1);
		Letter1.setColumns(10);

		Letter2 = new JTextField();
		Letter2.setBounds(165, 74, 26, 26);
		frame.getContentPane().add(Letter2);
		Letter2.setColumns(10);
		
		Letter3 = new JTextField();
		Letter3.setBounds(206, 74, 26, 26);
		frame.getContentPane().add(Letter3);
		Letter3.setColumns(10);
		
		Letter4 = new JTextField();
		Letter4.setBounds(242, 74, 26, 26);
		frame.getContentPane().add(Letter4);
		Letter4.setColumns(10);

		//SCRABBLE BUTTON
		ScrabbleBtn = new JButton("Go!");
		ScrabbleBtn.setFont(new Font("Arial Black", Font.BOLD, 10));
		ScrabbleBtn.setBounds(149, 148, 118, 29);
		frame.getContentPane().add(ScrabbleBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 191, 228, 48);
		frame.getContentPane().add(scrollPane);
		
		showResult = new JTextArea();
		scrollPane.setViewportView(showResult);

	}
}