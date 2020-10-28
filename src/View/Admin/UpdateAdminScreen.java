package View.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AdminController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateAdminScreen extends JFrame {

	private JPanel contentPane;
	private JTextField tfClientId;
	private JTextField tfSalary;
	private JTextField tfHeight;
	private JTextField tfAge;
	
    public AdminScreen adminScreen;
    private JTextField tfName;
    private JTextField tfCpf;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAdminScreen frame = new UpdateAdminScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		public void mostraTela() {
	        setVisible(true);
    }
	
	 public void atualizaCadastro() throws Exception {
	        int id = Integer.parseInt(tfClientId.getText());

	        AdminController.getInstance().updateAdmin(
	                id,
	                tfName.getText(),
	                tfCpf.getText(),
	                Float.parseFloat(tfSalary.getText())
	        );
	    }

	/**
	 * Create the frame.
	 */
	public UpdateAdminScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    atualizaCadastro();
	                    JOptionPane.showMessageDialog(null, "O cadastro do admin foi atualizado com sucesso !", "Atualizar cadastro", 1);
	                    
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro de admin, verifique as informações digitadas !", "Atualizar cadastro", 2);
	                }
			}
		});
		btnNewButton.setBounds(127, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(279, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tfClientId = new JTextField();
		tfClientId.setBounds(127, 9, 241, 20);
		contentPane.add(tfClientId);
		tfClientId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(35, 71, 121, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setBounds(35, 102, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfSalary = new JTextField();
		tfSalary.setBounds(127, 99, 241, 20);
		contentPane.add(tfSalary);
		tfSalary.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(127, 40, 241, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(127, 71, 241, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo do admin");
		lblNewLabel_4.setBounds(35, 11, 121, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setBounds(35, 40, 121, 17);
		contentPane.add(lblNewLabel_5);
	}
}
