package pecci;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyMain {

	private JFrame frame;
	private JTextField sku1;
	private JTextField title1;
	private JTextField price1;
	private JTextField quantity1;
	private JTextField sku2;
	private JTextField sku3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JPanel panel;
	private JScrollPane inventory;
	private JScrollPane information;
	private JTextArea informationText;
	private JTextArea inventoryText;

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
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		button1 = new JButton("Add Textbook (SKU, title, price, quantity)");
		button1.setBounds(10, 10, 416, 21);
		panel.add(button1);
		
		button2 = new JButton("Remove Textbook (SKU)");
		button2.setBounds(10, 54, 416, 21);
		panel.add(button2);
		
		button3 = new JButton("Textbook Info Search (SKU)");
		button3.setBounds(10, 104, 416, 21);
		panel.add(button3);
		
		button4 = new JButton("Display Inventory");
		button4.setBounds(10, 164, 416, 21);
		panel.add(button4);
		
		sku1 = new JTextField();
		sku1.setBounds(10, 35, 96, 19);
		panel.add(sku1);
		sku1.setColumns(10);
		
		title1 = new JTextField();
		title1.setBounds(116, 35, 96, 19);
		panel.add(title1);
		title1.setColumns(10);
		
		price1 = new JTextField();
		price1.setBounds(223, 35, 96, 19);
		panel.add(price1);
		price1.setColumns(10);
		
		quantity1 = new JTextField();
		quantity1.setBounds(329, 35, 96, 19);
		panel.add(quantity1);
		quantity1.setColumns(10);
		
		sku2 = new JTextField();
		sku2.setBounds(171, 85, 96, 19);
		panel.add(sku2);
		sku2.setColumns(10);
		
		sku3 = new JTextField();
		sku3.setBounds(10, 135, 96, 19);
		panel.add(sku3);
		sku3.setColumns(10);
		
		information = new JScrollPane();
		information.setBounds(116, 123, 310, 41);
		panel.add(information);
		
		informationText = new JTextArea();
		information.setViewportView(informationText);
		
		inventory = new JScrollPane();
		inventory.setBounds(10, 195, 416, 48);
		panel.add(inventory);
		
		inventoryText = new JTextArea();
		inventory.setViewportView(inventoryText);
		
		
		
	}
	
	//create event listeners for buttons
	private void createEvents() {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parse int for SKU
				String sku1string = sku1.getText();
				int num = Integer.parseInt(sku1string);
				
				//get string for title
				String title1string = title1.getText();
				
				//get double for price
				double price1double = Double.parseDouble(price1.getText());
				//should probably put try catch here to display error if string cannot be parsed into double. ask if try catch is valid here
				
				//get integer for quantity
				int quantity1int = Integer.parseInt(quantity1.getText());
				
				//call method w try catch
				try {
					addTextbook(num, title1string, price1double, quantity1int);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sku2int = Integer.parseInt(sku2.getText());
				
				try {
					removeTextbook(sku2int);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sku3int = Integer.parseInt(sku3.getText());
				try {
					search(sku3int);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayInventory();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	//build outputs
	
	public void addTextbook(int sku, String title, double price, int quantity) throws IOException, ClassNotFoundException {
		//add textbook here
		Textbook textbook = new Textbook(sku, title, price, quantity);
		ArrayList<Textbook> list = readList();
		
		//I FOUND THE ERROR: IF THERE IS NO ARRAYLIST OBJECT INITIALLY STORED IN INVENTORY.EXE, THE PROGRAM DOESN"T RUN. HOW DO I FIX THIS?
		
		list.add(textbook);
		
		FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/markp/OneDrive/Desktop/CS/Semester 7/inventory.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(list);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	    
	    
	}
		
	public void removeTextbook(int sku) throws IOException, ClassNotFoundException {
		//remove textbook from list
		boolean hasRemoved = false;
		
		ArrayList<Textbook> list= readList();

	    //loop through and search for matching sku number
	    for(int i = 0; i < list.size(); i++) {
	    	if (sku == list.get(i).sku){
	    		list.remove(i);
	    		hasRemoved = true;
	    		}
	    	}
	    if(hasRemoved) {
	    	System.out.println("Textbook successfully removed");
	    } else {
	    	System.out.println("Error: No textbook with this SKU");
	    }

		FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/markp/OneDrive/Desktop/CS/Semester 7/inventory.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	    
	    objectOutputStream.writeObject(list);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	    
	    
	}
	

	@SuppressWarnings("unchecked")
	public void search(int sku) throws IOException, ClassNotFoundException {
		String output = "";
		ArrayList<Textbook> list= new ArrayList<Textbook>();

		
		FileInputStream fileInputStream = new FileInputStream("C:/Users/markp/OneDrive/Desktop/CS/Semester 7/inventory.txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    
	    list = (ArrayList<Textbook>) objectInputStream.readObject();
	    objectInputStream.close(); 
	    
	    for(int i = 0; i < list.size(); i++) {
	    	if(list.get(i).sku == sku) {
		    	output = "SKU: " + String.valueOf(list.get(i).sku) + "\n Title: " + String.valueOf(list.get(i).title) + "\n Price: " + String.valueOf(list.get(i).price) 
		    + "\n Quantity: " + String.valueOf(list.get(i).quantity);
		    } else {
		    	output = "Error: There is no textbook in our inventory with this SKU";
		    }
	    }
	    
	    
		informationText.setText(output);
	}

	@SuppressWarnings("unchecked")
	public void displayInventory() throws IOException, ClassNotFoundException {
		String output = "";
		ArrayList<Textbook> list= new ArrayList<Textbook>();

		
		FileInputStream fileInputStream = new FileInputStream("C:/Users/markp/OneDrive/Desktop/CS/Semester 7/inventory.txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    
	    list = (ArrayList<Textbook>) objectInputStream.readObject();
	    objectInputStream.close(); 
	    
	    for(int i = 0; i < list.size(); i++) {
	    	output += "Textbook #"+ (i+1) + ": \n SKU: " + String.valueOf(list.get(i).sku) + "\n Title: " + String.valueOf(list.get(i).title) + "\n Price: " 
	    	+ String.valueOf(list.get(i).price) 
		    + "\n Quantity: " + String.valueOf(list.get(i).quantity) + "\n\n";
	    }
	    
	    inventoryText.setText(output);
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Textbook> readList() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("C:/Users/markp/OneDrive/Desktop/CS/Semester 7/inventory.txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    ArrayList<Textbook> list = new ArrayList<Textbook>();
	    
	    list = (ArrayList<Textbook>) objectInputStream.readObject();
	    objectInputStream.close(); 

	    
	    return list;
	}
}


