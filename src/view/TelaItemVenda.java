package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaItemVenda extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.fghgfhgfhf
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaItemVenda frame = new TelaItemVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaItemVenda() {
		setTitle("Tela Item da venda");
		setBounds(100, 100, 613, 426);
		getContentPane().setLayout(null);
		
		JLabel lblPea = new JLabel("Peça:");
		lblPea.setBounds(64, 38, 70, 15);
		getContentPane().add(lblPea);
		
		JLabel lblQtd = new JLabel("Qtd:");
		lblQtd.setBounds(64, 76, 70, 15);
		getContentPane().add(lblQtd);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(64, 119, 70, 15);
		getContentPane().add(lblSubtotal);
		
		textField = new JTextField();
		textField.setBounds(112, 36, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 74, 114, 19);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 117, 114, 19);
		getContentPane().add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 274, 537, 85);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Subtotal", "Quantidade", "Pe\u00E7a"
			}
		));
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(91, 215, 117, 25);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(338, 215, 117, 25);
		getContentPane().add(btnNewButton_1);

	}

}
