package pecci;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MyMain {

	private static JButton inputBtn;
	private static JFrame jframeWindow;
	private static JPanel panel;
	private static File fileToRead;
	private static File fileToSave;
	private static ArrayList<Line> lines = new ArrayList<Line>();

	public static void main(String[] args) {
		//GUI
		constructAppWindow();
		addListenerEvents();
	}

	private static void constructAppWindow() {
		jframeWindow = new JFrame();
		jframeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//layout
		panel = new JPanel(new GridLayout(3, 0)); 
		panel.setPreferredSize(new Dimension(500, 150));
		panel.setBackground(Color.DARK_GRAY);

		inputBtn = new JButton("Specify Input Text File");
		panel.add(inputBtn);

		jframeWindow.getContentPane().add(panel);

		//set to visible
		jframeWindow.pack();
		jframeWindow.setVisible(true);
	}

	private static void addListenerEvents() {
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestInputFile();
			}
		});

	}

	public static void requestInputFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fileToRead = jfc.getSelectedFile();
			try {
				Scanner myReader = new Scanner(fileToRead);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					if (data.contains("}") || data.contains(";") || data.contains("{")) {
						lines.add(new Line(data.trim()));
					}
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		performCalculations();
	}

	public static void performCalculations() {
		Counter program = new Counter();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).getFor()) {
				program.addFor();
			}
			if (lines.get(i).getWhile()) {
				program.addWhile();
			}
			if (lines.get(i).getIf()) {
				program.addIf();
			}
			if (lines.get(i).getComment()) {
				program.addComment();
			}
			if (lines.get(i).methodHeader()) {
				program.addMethodHeader(lines.get(i).getCodeLine());
			}
			program.addLine();
		}
		System.out.println("# of lines: " + program.getLines() + "\n# of for loops: " + program.getFor()
				+ "\n# of while loops: " + program.getWhile() + "\n# of comments: " + program.getComment() + "\n# of if/else statements: "
				+ program.getIf() + "\n# of methods: " + program.getMethodHeaders().size());
		for (int i = 0; i < program.getMethodHeaders().size(); i++) {
			System.out.println(program.getMethodHeaders().get(i));
		}
	}
}