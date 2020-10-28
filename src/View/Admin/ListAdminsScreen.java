package View.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controllers.DAO.AdminDAO;
import Models.Admin;

public class ListAdminsScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
    public AdminScreen adminScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAdminsScreen frame = new ListAdminsScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListAdminsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 32, 373, 175);
		contentPane.add(scrollPane);
		
		String[] adminInfoColumns = {"ID", "Nome", "CPF", "Salario"};
		table = new JTable(loadTableData(), adminInfoColumns);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar ao menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton.setBounds(282, 227, 123, 23);
		contentPane.add(btnNewButton);
	}
	
	private Object[][] loadTableData() {

        int i = 0;
        int numeroColunas = 6;
        int numeroLinhas = AdminDAO.cacheAdmins.size();

        Object[][] alunos = new Object[numeroLinhas][numeroColunas];
        for (Admin admin : AdminDAO.getInstance().getList()) {

            alunos[i][0] = admin.getId();
            alunos[i][1] = admin.getName();
            alunos[i][2] = admin.getCpf();
            alunos[i][3] = admin.getSalary();
            i++;
        }

        return alunos;
    }
}
