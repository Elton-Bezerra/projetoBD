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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPeca extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	
	
	/**
	 * Launch the application.ghjfhgjgsysout
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
		setTitle("Pe\u00E7as");
		setBounds(100, 100, 600, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 25, 42, 15);
		getContentPane().add(lblNome);
		
		JLabel lblCarro = new JLabel("Carro:");
		lblCarro.setBounds(12, 112, 70, 15);
		getContentPane().add(lblCarro);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o:");
		lblDesc.setBounds(12, 72, 80, 15);
		getContentPane().add(lblDesc);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 164, 93, 15);
		getContentPane().add(lblFabricante);
		
		textField = new JTextField();
		textField.setBounds(102, 22, 113, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 69, 113, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 107, 114, 24);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(102, 159, 114, 24);
		getContentPane().add(comboBox_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 243, 566, 121);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Carro", "Fabricante"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(365, 20, 93, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnPesquisarPorNome = new JButton("Pesquisar");
		btnPesquisarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisarPorNome.setBounds(240, 20, 93, 25);
		getContentPane().add(btnPesquisarPorNome);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(485, 21, 93, 23);
		getContentPane().add(btnExcluir);
		
		

	}
}
