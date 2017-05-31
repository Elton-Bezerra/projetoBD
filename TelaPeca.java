package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaPeca extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.ghjfhgjg
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPeca frame = new TelaPeca();
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
	public TelaPeca() {
		setTitle("Cadastro de Peça");
		setBounds(100, 100, 600, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 25, 70, 15);
		getContentPane().add(lblNome);
		
		JLabel lblCarro = new JLabel("Carro:");
		lblCarro.setBounds(12, 112, 70, 15);
		getContentPane().add(lblCarro);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 72, 80, 15);
		getContentPane().add(lblDescrio);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(12, 150, 93, 15);
		getContentPane().add(lblFornecedor);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(12, 193, 93, 15);
		getContentPane().add(lblFabricante);
		
		textField = new JTextField();
		textField.setBounds(75, 23, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 70, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(75, 107, 114, 24);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(101, 145, 114, 24);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(101, 188, 114, 24);
		getContentPane().add(comboBox_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 243, 566, 71);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Carro", "Fabricante", "Fornecedor"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(201, 20, 70, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(238, 67, 53, 25);
		getContentPane().add(btnNewButton_1);
		
		

	}
}
