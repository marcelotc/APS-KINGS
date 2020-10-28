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

public class ViewDeleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField tfClientId;
	private JButton btnNewButton_1;
	
    public ViewEmployee viewEmployee;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDeleteEmployee frame = new ViewDeleteEmployee();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void delEmployee() throws Exception {

        int id = Integer.parseInt(tfClientId.getText());

        EmployeeController.getInstance().delEmployee(id);

    }

	/**
	 * Create the frame.
	 */
	public ViewDeleteEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    delEmployee();
                    JOptionPane.showMessageDialog(null, "Funcion�rio removido com sucesso", "Remover cadastro de funcion�rio", 1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "N�o foi possivel remover o funcion�rio, verifique o c�digo digitado !", "Remover funcion�rio", 2);
                }
			}
		});
		btnNewButton.setBounds(92, 194, 89, 23);
		contentPane.add(btnNewButton);
		
		tfClientId = new JTextField();
		tfClientId.setBounds(169, 70, 164, 20);
		contentPane.add(tfClientId);
		tfClientId.setColumns(10);
		
		btnNewButton_1 = new JButton("cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    viewEmployee.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(244, 194, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Digite o ID do funcion�rio");
		lblNewLabel.setBounds(10, 73, 149, 14);
		contentPane.add(lblNewLabel);
	}

}
