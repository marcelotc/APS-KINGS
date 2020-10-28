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

public class ViewUpdateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField tfClientId;
	
    public ViewEmployee viewEmployee;
    private JTextField tfSalary;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUpdateEmployee frame = new ViewUpdateEmployee();
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

	       EmployeeController.getInstance().updateEmployee(
	                id,
	                Float.parseFloat(tfSalary.getText())
	                
	        );
	    }

	/**
	 * Create the frame.
	 */
	public ViewUpdateEmployee() {
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
	                    JOptionPane.showMessageDialog(null, "O cadastro do funcion�rio foi atualizado com sucesso !", "Atualizar cadastro", 1);
	                    
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro de funcion�rio, verifique as informa��es digitadas !", "Atualizar cadastro", 2);
	                }

			}
		});
		btnNewButton.setBounds(158, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewEmployee.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(310, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tfClientId = new JTextField();
		tfClientId.setBounds(158, 113, 241, 20);
		contentPane.add(tfClientId);
		tfClientId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00F3digo do funcion\u00E1rio");
		lblNewLabel_4.setBounds(20, 115, 138, 17);
		contentPane.add(lblNewLabel_4);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		tfSalary.setBounds(158, 161, 241, 20);
		contentPane.add(tfSalary);
		
		lblNewLabel = new JLabel("Sal\u00E1rio");
		lblNewLabel.setBounds(37, 163, 121, 17);
		contentPane.add(lblNewLabel);
	}

}
