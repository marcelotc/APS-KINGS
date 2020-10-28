package View.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.EmployeeController;
import Controllers.MainController;

public class ViewRegisterEmployee extends JFrame {

	private int id;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfCPF;
	
    public ViewEmployee viewEmployee;
    private JTextField tfSalary;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRegisterEmployee frame = new ViewRegisterEmployee();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		public void addEmployee() throws Exception {
        
	    id = MainController.getInstance().geraCodigoRandomicoUnico();

        
        EmployeeController.getInstance().addEmployee(
                id,
                tfName.getText(),
                tfCPF.getText(),
                Float.parseFloat(tfSalary.getText()));
    }

	/**
	 * 
	 * Create the frame.
	 */
	public ViewRegisterEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(43, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(124, 31, 216, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(43, 65, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(124, 62, 216, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					addEmployee();
	                 JOptionPane.showMessageDialog(null, "O funcion�rio foi cadastrado com sucesso! C�digo do funcion�rio: "+id);
				} catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcion�rio! Preencha todos os campos!", "Cadastro funcion�rio", 2);
				}
			}
		});
		btnNewButton.setBounds(53, 202, 122, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewEmployee.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(251, 202, 122, 45);
		contentPane.add(btnNewButton_1);
		
		tfSalary = new JTextField();
		tfSalary.setBounds(124, 99, 216, 20);
		contentPane.add(tfSalary);
		tfSalary.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sal\u00E1rio");
		lblNewLabel_1_1.setBounds(43, 102, 71, 14);
		contentPane.add(lblNewLabel_1_1);
	}
}
