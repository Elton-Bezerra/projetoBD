package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import model.Carro;
import model.Fabricante;
import model.Peca;
import model.PecaModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaPeca extends JInternalFrame implements ActionListener, ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfAplicacao;
	private JTable table;
	private PecaModel model = new PecaModel();
	private JTextField tfTipo;
	private JTextField tfValor;
	private JComboBox cbCarro;
	private JComboBox cbFabricante;
	private JTextField tfData;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField tfQuantidade;
	
	/**
	 * Launch the application.ghjfhgjgsysout
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
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
		setClosable(true);
		
		setTitle("Pe\u00E7as");
		setBounds(100, 100, 600, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 25, 42, 15);
		getContentPane().add(lblNome);
		
		JLabel lblCarro = new JLabel("Carro:");
		lblCarro.setBounds(14, 161, 70, 15);
		getContentPane().add(lblCarro);
		
		JLabel lblAplicacao = new JLabel("Aplica\u00E7\u00E3o:");
		lblAplicacao.setBounds(12, 72, 80, 15);
		getContentPane().add(lblAplicacao);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(12, 213, 93, 15);
		getContentPane().add(lblFabricante);
		
		tfNome = new JTextField();
		tfNome.setBounds(102, 22, 113, 19);
		getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfAplicacao = new JTextField();
		tfAplicacao.setBounds(102, 69, 113, 19);
		getContentPane().add(tfAplicacao);
		tfAplicacao.setColumns(10);
		
		cbCarro = new JComboBox();
		cbCarro.setBounds(103, 156, 114, 24);
		for(Carro c: Carro.values()){
			cbCarro.addItem(c.name());
		}
		getContentPane().add(cbCarro);
		
		
		cbFabricante = new JComboBox();
		cbFabricante.setBounds(104, 208, 114, 24);
		for(Fabricante f: Fabricante.values()){
			cbFabricante.addItem(f.name());
		}
		getContentPane().add(cbFabricante);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 243, 566, 121);
		getContentPane().add(scrollPane);
		
		table = new JTable(model);	
		table.getSelectionModel().addListSelectionListener(this);
		table.getColumnModel().getColumn(5).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBounds(365, 20, 93, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnPesquisarPorNome = new JButton("Pesquisar");
		btnPesquisarPorNome.addActionListener(this);
		btnPesquisarPorNome.setBounds(240, 20, 93, 25);
		getContentPane().add(btnPesquisarPorNome);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		btnExcluir.setBounds(485, 21, 93, 23);
		getContentPane().add(btnExcluir);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(8, 109, 46, 14);
		getContentPane().add(lblTipo);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(102, 106, 113, 20);
		getContentPane().add(tfTipo);
		tfTipo.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(240, 72, 46, 14);
		getContentPane().add(lblValor);
		
		tfValor = new JTextField();
		tfValor.setBounds(296, 69, 86, 20);
		getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(240, 109, 46, 14);
		getContentPane().add(lblData);
		
		tfData = new JTextField();
		tfData.setBounds(296, 106, 86, 20);
		getContentPane().add(tfData);
		tfData.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(240, 161, 56, 14);
		getContentPane().add(lblQuantidade);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(307, 158, 86, 20);
		getContentPane().add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(489, 68, 89, 23);
		getContentPane().add(btnEditar);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		Peca p = model.getPecaByRow(table.getSelectedRow());
		pecaToForm(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if ("Cadastrar".equals(cmd)) { 
			Peca p = formToPecaCadastrar();
			model.adicionar( p );
			atualizaTable();
		} else if ("Pesquisar".equals(cmd)){				
			model.pesquisarPorNome(tfNome.getText());	
			atualizaTable();
		} else if ("Excluir".equals(cmd)){
			Peca p = formToPeca();
			model.deletar(p);
			atualizaTable();
		} else if("Editar".equals(cmd)){
			Peca p = formToPeca();
			model.editar(p);
			atualizaTable();
		}
	}
	
	public Peca formToPeca(){
		Peca p = new Peca();
		p.setId(model.getPecaByRow(table.getSelectedRow()).getId());
		System.out.println(model.getPecaByRow(table.getSelectedRow()).getId());
		p.setTipo(this.tfTipo.getText());
		p.setNome(this.tfNome.getText());
		p.setAplicacao(this.tfAplicacao.getText());
		try{
			p.setDtAdc(sdf.parse(this.tfData.getText()));
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		p.setValor(Double.parseDouble(this.tfValor.getText()));
		p.setFabricante(this.cbFabricante.getSelectedIndex());
		p.setCarro(this.cbCarro.getSelectedIndex());
		p.setQuantidade(Integer.parseInt(this.tfQuantidade.getText()));
		return p;
	}
	
	public Peca formToPecaCadastrar(){
		Peca p = new Peca();
		p.setTipo(this.tfTipo.getText());
		p.setNome(this.tfNome.getText());
		p.setAplicacao(this.tfAplicacao.getText());
		try{
			p.setDtAdc(sdf.parse(this.tfData.getText()));
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		p.setValor(Double.parseDouble(this.tfValor.getText()));
		p.setFabricante(this.cbFabricante.getSelectedIndex());
		p.setCarro(this.cbCarro.getSelectedIndex());
		p.setQuantidade(Integer.parseInt(this.tfQuantidade.getText()));
		return p;
	}
	
	public void atualizaTable(){
		table.invalidate();
		table.revalidate();
		table.repaint();
		
	}
	public void pecaToForm(Peca p){
		if(p != null){
			tfNome.setText(p.getNome());
			tfAplicacao.setText(p.getAplicacao());
			tfData.setText(sdf.format(p.getDtAdc()));
			tfTipo.setText(p.getTipo());
			tfValor.setText(Double.toString(p.getValor()));
			cbCarro.setSelectedIndex(p.getCarro());
			cbFabricante.setSelectedIndex(p.getFabricante());			
			tfQuantidade.setText(Integer.toString(p.getQuantidade()));
		}
	}
}
