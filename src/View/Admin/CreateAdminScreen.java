package View.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AdminController;
import Controllers.MainController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAdminScreen extends JFrame {
	
    private int id;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfCPF;
	private JTextField tfSalary;
	
    public AdminScreen adminScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAdminScreen frame = new CreateAdminScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		public void cadastraAdmin() throws Exception {
        
	    id = MainController.getInstance().geraCodigoRandomicoUnico();

        
        AdminController.getInstance().addAdmin(
                id,
                tfName.getText(),
                tfCPF.getText(),
                Float.parseFloat(tfSalary.getText()));
    }

	/**
	 * 
	 * Create the frame.
	 */
	public CreateAdminScreen() {
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
		
		JLabel lblNewLabel_4 = new JLabel("Salario");
		lblNewLabel_4.setBounds(43, 163, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfSalary = new JTextField();
		tfSalary.setBounds(124, 160, 216, 20);
		contentPane.add(tfSalary);
		tfSalary.setColumns(10);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					cadastraAdmin();
	                 JOptionPane.showMessageDialog(null, "O admin foi cadastrado com sucesso! ");
				} catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar um admin! Preencha todos os campos!", "Cadastro aluno", 2);
				}
			}
		});
		btnNewButton.setBounds(124, 224, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(251, 224, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
