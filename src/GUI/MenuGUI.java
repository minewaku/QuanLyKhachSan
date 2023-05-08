package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGUI extends JFrame {

	private JPanel contentPane = new JPanel();
	
	public MenuGUI() {
		initComponents();
	}
			
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2048, 1152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 475, 1520, 360);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 8, 0, 0));
		
		JButton btnNewButton = new JButton("Staff");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Room");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("Service");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Payment");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Customer");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("Orders");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Reservations");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Exit");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("HOTEL MANAGER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1520, 340);
		contentPane.add(lblNewLabel);
		
//		staff
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        StaffGUI frame = new StaffGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
		
//		room
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        RoomGUI frame = new RoomGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
		
//		service
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        ServiceGUI frame = new ServiceGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
	
//		payment
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        PaymentGUI frame = new PaymentGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
		
//		customer
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        CustomerGUI frame = new CustomerGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
		
//		order
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        OrdersGUI frame = new OrdersGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});

//		reservation
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        ReservationsGUI frame = new ReservationsGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);

			}
		});
		
//		exit
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}

	
