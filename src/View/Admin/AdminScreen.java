package View.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.EmployeeScreen;
import View.employee.ViewEmployee;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminScreen extends JFrame {

	private JPanel contentPane;
	
	public CreateAdminScreen createAdminScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen frame = new AdminScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Admin");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	CreateAdminScreen.inicializaTela();
		    	dispose();
			}
		});
		btnNewButton.setBounds(125, 31, 158, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar admins");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                ListAdminsScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(125, 64, 158, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deletar admin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DeleteAdminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_2.setBounds(125, 130, 158, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Editar admin");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_3.setBounds(125, 97, 158, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CRUD funcionário");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployee.inicializaTela();
				dispose();
			}
		});
		btnNewButton_4.setBounds(125, 240, 158, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Modo funcionario");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_4_1.setBounds(125, 193, 158, 21);
		contentPane.add(btnNewButton_4_1);
	}
}
