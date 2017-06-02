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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	BorderLayout bd;
	JDesktopPane desktopPane;
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
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 384);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmPecas = new JMenuItem("Pe\u00E7as");
		mntmPecas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPeca t = new TelaPeca();
				desktopPane.add(t);
				t.setVisible(true);
			}
		});
		mntmPecas.setIcon(new ImageIcon("C:\\Users\\Elton Bezerra\\Desktop\\Projeto BD Colevati\\workspace\\Projeto\\imgs\\gear_icon-icons.com_70125.png"));
		menuBar.add(mntmPecas);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaVenda tv = new TelaVenda();
				desktopPane.add(tv);
				tv.setVisible(true);
				
			}
		});
		mntmVendas.setIcon(new ImageIcon("C:\\Users\\Elton Bezerra\\Desktop\\Projeto BD Colevati\\workspace\\Projeto\\imgs\\currency.png"));
		menuBar.add(mntmVendas);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		mntmSair.setIcon(new ImageIcon("C:\\Users\\Elton Bezerra\\Desktop\\Projeto BD Colevati\\workspace\\Projeto\\imgs\\exit_icon-icons.com_70975.png"));
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		bd = new BorderLayout();
		contentPane.setLayout(bd);
		
		desktopPane= new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
