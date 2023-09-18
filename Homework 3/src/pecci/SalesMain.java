package pecci;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class SalesMain {

	private JFrame frame;
	private JTextField item;
	private JTextField price;
	private JTextField quantity;
	private JTextField salesSlipTxt;
	private JTextField total;
	private JButton addItemBtn;
	private JLabel lblNewLabel;
	private JLabel Item;
	private JLabel Price;
	private JLabel Quantity;
	private JLabel Total;
	private JScrollBar scrollBar;
    private SalesSlip s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMain window = new SalesMain();
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
	public SalesMain() {
		initialize();
		s = new SalesSlip();
		addItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
	}
	
	public  void addItem() {
		SalesItem a = new SalesItem(item.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));
		s.addSalesItem(a);
		salesSlipTxt.setText(s.toString());
		total.setText(s.computeTotal());
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setBounds(172, 11, 82, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Item = new JLabel("Item: ");
		Item.setBounds(62, 33, 49, 14);
		frame.getContentPane().add(Item);
		
		JLabel Price = new JLabel("Price: ");
		Price.setBounds(62, 58, 49, 14);
		frame.getContentPane().add(Price);
		
		JLabel Quantity = new JLabel("Quantity: ");
		Quantity.setBounds(62, 83, 67, 14);
		frame.getContentPane().add(Quantity);
		
		item = new JTextField();
		item.setBounds(156, 30, 226, 20);
		frame.getContentPane().add(item);
		item.setColumns(10);
		
		price = new JTextField();
		price.setBounds(156, 55, 226, 20);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(156, 80, 226, 20);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JButton addItemBtn = new JButton("Add Item to Sales List");
		addItemBtn.setBounds(113, 112, 170, 23);
		frame.getContentPane().add(addItemBtn);
		
		salesSlipTxt = new JTextField();
		salesSlipTxt.setBounds(62, 146, 320, 78);
		frame.getContentPane().add(salesSlipTxt);
		salesSlipTxt.setColumns(10);
		
		JLabel Total = new JLabel("Total: ");
		Total.setBounds(62, 238, 82, 14);
		frame.getContentPane().add(Total);
		
		total = new JTextField();
		total.setBounds(156, 235, 226, 20);
		frame.getContentPane().add(total);
		total.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(365, 146, 17, 78);
		frame.getContentPane().add(scrollBar);
		
	}
}