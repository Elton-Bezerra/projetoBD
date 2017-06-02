package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaVenda extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.fghfghf
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setTitle("Tela de Venda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 24, 70, 15);
		getContentPane().add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(74, 22, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(200, 19, 60, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblItemvenda = new JLabel("ItemVenda:");
		lblItemvenda.setBounds(12, 70, 86, 15);
		getContentPane().add(lblItemvenda);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 68, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(240, 65, 60, 25);
		getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 175, 416, 67);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Item do Pedido", "Cliente"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(12, 137, 117, 25);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(141, 137, 117, 25);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(281, 137, 117, 25);
		getContentPane().add(btnNewButton_4);

	}

}
