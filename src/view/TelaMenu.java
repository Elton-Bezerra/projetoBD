package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrarPea = new JMenuItem("Cadastrar Pe\u00E7a");
		mnNewMenu.add(mntmCadastrarPea);
		
		JMenuItem mntmCadastrarFabricante = new JMenuItem("Cadastrar Fabricante ");
		mnNewMenu.add(mntmCadastrarFabricante);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Montadora");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmCadastrarCarro = new JMenuItem("Cadastrar Carro");
		mnNewMenu.add(mntmCadastrarCarro);
		
		JMenuItem mntmCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor");
		mnNewMenu.add(mntmCadastrarFornecedor);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cadastrar Cliente ");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnNewMenu.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
