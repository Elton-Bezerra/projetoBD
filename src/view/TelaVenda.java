package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.ItemVendaModel;
import model.Peca;
import model.Venda;
import model.VendaModel;

import javax.swing.JComboBox;

public class TelaVenda extends JInternalFrame implements ActionListener {
	private JTextField textField_1;
	private JTable tableItemVenda;
	private JTextField tfValorTotal;
	private ItemVendaModel model = new ItemVendaModel();
	private JTextField tfNVenda;
	private JTable tableVenda;
	private VendaModel vendaModel = new VendaModel();

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
		setClosable(true);
		setTitle("Tela de Venda");
		setBounds(100, 100, 450, 396);
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
		scrollPane.setBounds(10, 288, 416, 67);
		getContentPane().add(scrollPane);
		
		tableItemVenda = new JTable();
		tableItemVenda.setModel(model);
		tableItemVenda.getColumnModel().getColumn(1).setPreferredWidth(110);
		scrollPane.setViewportView(tableItemVenda);
		
		JButton btnAdicionarItem = new JButton("+");
		btnAdicionarItem.setBounds(218, 24, 41, 20);
		getContentPane().add(btnAdicionarItem);
		
		JButton btnCadastrarVenda = new JButton("Cadastrar Venda");
		btnCadastrarVenda.addActionListener(this);
		btnCadastrarVenda.setBounds(12, 139, 117, 25);
		getContentPane().add(btnCadastrarVenda);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(290, 139, 117, 25);
		getContentPane().add(btnPesquisar);
		
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
		
		tfNVenda = new JTextField();
		tfNVenda.setBounds(307, 115, 86, 20);
		getContentPane().add(tfNVenda);
		tfNVenda.setColumns(10);
		
		JLabel lblNVenda = new JLabel("N\u00BA venda");
		lblNVenda.setBounds(250, 118, 46, 14);
		getContentPane().add(lblNVenda);
		
		JScrollPane spVenda = new JScrollPane();
		spVenda.setBounds(12, 203, 412, 74);
		getContentPane().add(spVenda);
		
		tableVenda = new JTable();
		tableVenda.setModel(vendaModel);
		spVenda.setViewportView(tableVenda);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if("Cadastrar Venda".equals(cmd)){
			
		}
	}
	
	public Venda formToVenda(){
		Venda v = new Venda();
		v.setValorTotal(calcularTotal());		
		return v;
	}
	
	
	public double calcularTotal(){
		double val = 0;
		
		return val;
		
	}
}
