package View.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewEmployee extends JFrame {

	private JPanel contentPane;

	 public ViewRegisterEmployee registerEmployee;
	 public ViewDeleteEmployee deleteEmployee;
	 public ViewUpdateEmployee updateEmployee;
	 public ViewListEmployees listEmployees;
	 

		/**
		 * Launch the application.
		 */
		public static void inicializaTela() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewEmployee frame = new ViewEmployee();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public ViewEmployee() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnNewButton = new JButton("Cadastrar funcion�rio");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registerEmployee.inicializaTela();
			    	dispose();
				}
			});
			btnNewButton.setBounds(125, 31, 158, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Listar funcion�rios");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
	                listEmployees.inicializaTela();
					dispose();
				}
			});
			btnNewButton_1.setBounds(125, 78, 158, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Deletar funcion�rio");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	                deleteEmployee.inicializaTela();
					dispose();
				}
			});
			btnNewButton_2.setBounds(125, 182, 158, 23);
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Editar funcion�rio");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateEmployee.inicializaTela();
					dispose();
				}
			});
			btnNewButton_3.setBounds(125, 128, 158, 23);
			contentPane.add(btnNewButton_3);
		}

}
