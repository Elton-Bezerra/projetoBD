package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.VendaModel;

import javax.swing.JComboBox;

public class TelaVenda extends JInternalFrame {
	private JTextField textField_1;
	private JTable table;
	private JTextField tfValorTotal;
	private VendaModel model = new VendaModel();

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
		
		JLabel lblPeça = new JLabel("Pe\u00E7a:");
		lblPeça.setBounds(12, 24, 45, 15);
		getContentPane().add(lblPeça);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(12, 70, 86, 15);
		getContentPane().add(lblQuantidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 67, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 175, 416, 67);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
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
		
		JComboBox cbPeca = new JComboBox();
		cbPeca.setBounds(94, 24, 114, 20);
		getContentPane().add(cbPeca);
		
		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setBounds(11, 96, 53, 14);
		getContentPane().add(lblValorTotal);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setEnabled(false);
		tfValorTotal.setBounds(94, 96, 114, 20);
		getContentPane().add(tfValorTotal);
		tfValorTotal.setColumns(10);

	}
}
