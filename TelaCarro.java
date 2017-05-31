package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaCarro extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.hjghhhhhhjghj
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarro frame = new TelaCarro();
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
	public TelaCarro() {
		setTitle("Cadastro de Carro");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 34, 70, 15);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(71, 32, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMontadora = new JLabel("Montadora:");
		lblMontadora.setBounds(12, 82, 90, 15);
		getContentPane().add(lblMontadora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 77, 104, 24);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 204, 117, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(173, 204, 117, 25);
		getContentPane().add(btnNewButton_1);

	}
}
