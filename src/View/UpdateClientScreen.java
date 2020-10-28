package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ClientController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateClientScreen extends JFrame {

	private JPanel contentPane;
	private JTextField tfClientId;
	private JTextField tfWeight;
	private JTextField tfHeight;
	private JTextField tfAge;
	
    public EmployeeScreen employeScreen;
    private JTextField tfName;
    private JTextField tfCpf;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClientScreen frame = new UpdateClientScreen();
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

	        ClientController.getInstance().alteraCadastro(
	                id,
	                tfName.getText(),
	                tfCpf.getText(),
	                Float.parseFloat(tfWeight.getText()),
	                Float.parseFloat(tfHeight.getText()),
	                Integer.parseInt(tfAge.getText())
	        );
	    }

	/**
	 * Create the frame.
	 */
	public UpdateClientScreen() {
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
	                    JOptionPane.showMessageDialog(null, "O cadastro do aluno foi atualizado com sucesso !", "Atualizar cadastro", 1);
	                    
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro de cliente, verifique as informações digitadas !", "Atualizar cadastro", 2);
	                }

			}
		});
		btnNewButton.setBounds(127, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeScreen.inicializaTela();
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
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setBounds(35, 102, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Altura");
		lblNewLabel_2.setBounds(35, 133, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setBounds(35, 164, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(127, 99, 241, 20);
		contentPane.add(tfWeight);
		tfWeight.setColumns(10);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(127, 130, 241, 20);
		contentPane.add(tfHeight);
		tfHeight.setColumns(10);
		
		tfAge = new JTextField();
		tfAge.setBounds(127, 161, 241, 20);
		contentPane.add(tfAge);
		tfAge.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(127, 40, 241, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(127, 71, 241, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00F3digo do aluno");
		lblNewLabel_4.setBounds(35, 11, 121, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setBounds(35, 40, 121, 17);
		contentPane.add(lblNewLabel_5);
	}
}
