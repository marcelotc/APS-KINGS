package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ClientController;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DeleteClientScreen extends JFrame {

	private JPanel contentPane;
	private JTextField tfClientId;
	private JButton btnNewButton_1;
	
    public EmployeeScreen employeScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteClientScreen frame = new DeleteClientScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void deletaCadastroAluno() throws Exception {

        int id = Integer.parseInt(tfClientId.getText());

        ClientController.getInstance().deletaAluno(id);

    }

	/**
	 * Create the frame.
	 */
	public DeleteClientScreen() {
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
                    deletaCadastroAluno();
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso", "Remover cadastro de cliente", 1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel remover o cliente, verifique o código digitado !", "Remover cliente", 2);
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
			    employeScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(244, 194, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Digite o ID do cliente");
		lblNewLabel.setBounds(36, 73, 134, 14);
		contentPane.add(lblNewLabel);
	}
}
