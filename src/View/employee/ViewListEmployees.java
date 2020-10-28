package View.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controllers.DAO.EmployeeDAO;
import Models.Employee;

public class ViewListEmployees extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ViewEmployee viewEmployee;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListEmployees frame = new ViewListEmployees();
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
	public ViewListEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 32, 373, 175);
		contentPane.add(scrollPane);

		/*
		 * table = new JTable(); table.setModel(new DefaultTableModel( new Object[][] {
		 * }, new String[] { "ID", "Nome", "CPF", "Sal�rio" } ));
		 */

		String[] colunasInfoFuncionario = { "ID", "Nome", "CPF", "Sal�rio" };
		table = new JTable(carregaDadosTabela(), colunasInfoFuncionario);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Voltar ao menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewEmployee.inicializaTela();
				dispose();
			}
		});
		btnNewButton.setBounds(282, 227, 123, 23);
		contentPane.add(btnNewButton);
	}

	private Object[][] carregaDadosTabela() {

		int i = 0;
		int numeroColunas = 4;
		int numeroLinhas = EmployeeDAO.cacheEmployees.size();

		Object[][] employees = new Object[numeroLinhas][numeroColunas];
		for (Employee employee : EmployeeDAO.getInstance().getList()) {

			employees[i][0] = employee.getId();
			employees[i][1] = employee.getName();
			employees[i][2] = employee.getCpf();
			employees[i][3] = employee.getSalary();
			i++;
		}

		return employees;
	}

}
