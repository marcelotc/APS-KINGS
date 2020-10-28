package View.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AdminController;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DeleteAdminScreen extends JFrame {

	private JPanel contentPane;
	private JTextField tfAdminId;
	private JButton btnNewButton_1;
	
    public AdminScreen adminScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAdminScreen frame = new DeleteAdminScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void deletaCadastroAluno() throws Exception {

        int id = Integer.parseInt(tfAdminId.getText());

        AdminController.getInstance().deleteAdmin(id);

    }

	/**
	 * Create the frame.
	 */
	public DeleteAdminScreen() {
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
                    JOptionPane.showMessageDialog(null, "Admin removido com sucesso", "Remover cadastro de admin", 1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel remover o admin, verifique o código digitado !", "Remover admin", 2);
                }
			}
		});
		btnNewButton.setBounds(92, 194, 89, 23);
		contentPane.add(btnNewButton);
		
		tfAdminId = new JTextField();
		tfAdminId.setBounds(169, 70, 164, 20);
		contentPane.add(tfAdminId);
		tfAdminId.setColumns(10);
		
		btnNewButton_1 = new JButton("cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    AdminScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(244, 194, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Digite o ID do admin");
		lblNewLabel.setBounds(36, 73, 134, 14);
		contentPane.add(lblNewLabel);
	}
}
