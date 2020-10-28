package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ClientController;
import Controllers.MainController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateClientScreen extends JFrame {
	
    private int id;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfCPF;
	private JTextField tfWeight;
	private JTextField tfHeight;
	private JTextField tfAge;
	
    public EmployeeScreen employeScreen;

	/**
	 * Launch the application.
	 */
	public static void inicializaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateClientScreen frame = new CreateClientScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		public void cadastraAluno() throws Exception {
        
	    id = MainController.getInstance().geraCodigoRandomicoUnico();

        
        ClientController.getInstance().adicionaAluno(
                id,
                tfName.getText(),
                tfCPF.getText(),
                Float.parseFloat(tfWeight.getText()),
                Float.parseFloat(tfHeight.getText()),
                Integer.parseInt(tfAge.getText()));
    }

	/**
	 * 
	 * Create the frame.
	 */
	public CreateClientScreen() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Peso");
		lblNewLabel_2.setBounds(43, 90, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(124, 93, 216, 20);
		contentPane.add(tfWeight);
		tfWeight.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Altura");
		lblNewLabel_3.setBounds(43, 121, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(124, 124, 216, 20);
		contentPane.add(tfHeight);
		tfHeight.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Idade");
		lblNewLabel_4.setBounds(43, 163, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfAge = new JTextField();
		tfAge.setBounds(124, 160, 216, 20);
		contentPane.add(tfAge);
		tfAge.setColumns(10);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					cadastraAluno();
	                 JOptionPane.showMessageDialog(null, "O aluno foi cadastrado com sucesso! ");
				} catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar um cliente! Preencha todos os campos!", "Cadastro aluno", 2);
				}
			}
		});
		btnNewButton.setBounds(124, 224, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeScreen.inicializaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(251, 224, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
