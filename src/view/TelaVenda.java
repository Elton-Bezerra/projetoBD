package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.ItemVenda;
import model.ItemVendaModel;
import model.Peca;
import model.Venda;
import model.VendaModel;
import persistence.impl.ItemVendaDAOImpl;
import persistence.impl.PecaDAOImpl;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaVenda extends JInternalFrame implements ActionListener {
	private JTextField tfQtd;
	private JTable tableItemVenda;
	private JTextField tfValorTotal;
	private ItemVendaModel model = new ItemVendaModel();
	private JTextField tfNVenda;
	private JTable tableVenda;
	private JComboBox cbPeca;
	private List<ItemVenda> itens = new ArrayList<ItemVenda>();
	private VendaModel vendaModel = new VendaModel();
	private ItemVendaModel ivModel = new ItemVendaModel();

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
		setBounds(100, 100, 450, 465);
		getContentPane().setLayout(null);
		
		JLabel lblPeça = new JLabel("Pe\u00E7a:");
		lblPeça.setBounds(12, 24, 45, 15);
		getContentPane().add(lblPeça);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(12, 70, 86, 15);
		getContentPane().add(lblQuantidade);
		
		tfQtd = new JTextField();
		tfQtd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PecaDAOImpl pdao = new PecaDAOImpl();
				List<Peca> lst = pdao.listarTodos();
				Peca p = lst.get(cbPeca.getSelectedIndex());
				ItemVenda iv = new ItemVenda();
				iv.setPeca(p);			
				iv.setQtd(Integer.parseInt(tfQtd.getText()));
				if(!tfQtd.getText().isEmpty()){
					if(Integer.parseInt(tfQtd.getText()) > 0){
						tfValorTotal.setText(Double.toString(iv.getQtd() * p.getValor()));
					}
				}
			}
		});
		tfQtd.setBounds(94, 67, 114, 19);
		getContentPane().add(tfQtd);
		tfQtd.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 332, 416, 92);
		getContentPane().add(scrollPane);
		
		tableItemVenda = new JTable();
		tableItemVenda.setModel(model);
		tableItemVenda.getColumnModel().getColumn(1).setPreferredWidth(110);
		scrollPane.setViewportView(tableItemVenda);
		
		JButton btnAdicionarItem = new JButton("+");
		btnAdicionarItem.addActionListener(this);
		btnAdicionarItem.setBounds(218, 24, 41, 20);
		getContentPane().add(btnAdicionarItem);
		
		JButton btnCadastrarVenda = new JButton("Cadastrar Venda");
		btnCadastrarVenda.addActionListener(this);
		btnCadastrarVenda.setBounds(12, 139, 117, 25);
		getContentPane().add(btnCadastrarVenda);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(290, 139, 117, 25);
		getContentPane().add(btnPesquisar);
		
		cbPeca = new JComboBox();
		PecaDAOImpl pdao = new PecaDAOImpl();
		for(Peca p : pdao.selectIDNome()){
			cbPeca.addItem(p.getNome());
		}
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
		spVenda.setBounds(12, 203, 412, 118);
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
			Venda v = new Venda();	
			double vlTotal = 0;
			for(ItemVenda iv : itens){
				vlTotal += iv.getSubTotal();
			}
			v.setValorTotal(vlTotal);
			vendaModel.adicionarVenda(v);
			ivModel.adicionarItens(itens);
			atualizarTableItem();
			itens.clear();
		} else if ("+".equals(cmd)){
			PecaDAOImpl pdao = new PecaDAOImpl();
			List<Peca> lst = pdao.listarTodos();
			Peca p = lst.get(cbPeca.getSelectedIndex());
			ItemVenda iv = new ItemVenda();
			iv.setPeca(p);			
			iv.setQtd(Integer.parseInt(tfQtd.getText()));
			iv.setSubTotal(iv.getQtd() * p.getValor());
			itens.add(iv);
			System.out.println(itens.get((itens.size()-1)).getSubTotal());
		}
		
	}
	
	
	public void atualizarTableItem(){
		tableVenda.invalidate();
		tableVenda.revalidate();
		tableVenda.repaint();
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
