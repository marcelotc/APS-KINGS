package View;

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

import Controllers.DAO.ClientDAO;
import Models.Client;

public class ListClientsScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
    public EmployeeScreen employeScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClientsScreen frame = new ListClientsScreen();
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
	public ListClientsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 32, 373, 175);
		contentPane.add(scrollPane);
		
		/*table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Idade", "Altura", "Peso"
			}
		));*/
		
		String[] colunasInfoAluno = {"ID", "Nome", "CPF", "Idade", "Altura", "Peso"};
		table = new JTable(carregaDadosTabela(), colunasInfoAluno);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar ao menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton.setBounds(282, 227, 123, 23);
		contentPane.add(btnNewButton);
	}
	
	private Object[][] carregaDadosTabela() {

        int i = 0;
        int numeroColunas = 6;
        int numeroLinhas = ClientDAO.cacheClients.size();

        Object[][] alunos = new Object[numeroLinhas][numeroColunas];
        for (Client aluno : ClientDAO.getInstance().getList()) {

            alunos[i][0] = aluno.getId();
            alunos[i][1] = aluno.getName();
            alunos[i][2] = aluno.getCpf();
            alunos[i][3] = aluno.getWeight();
            alunos[i][4] = aluno.getHeight();
            alunos[i][5] = aluno.getAge();
            i++;
        }

        return alunos;
    }
}
