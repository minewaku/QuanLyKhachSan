package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuGUI extends JFrame {
	
	LoginGUI user = new LoginGUI();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2048, 1152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 475, 1520, 360);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 10, 0, 0));
		
		JButton btnNewButton = new JButton("Staff");
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Room");
		btnNewButton_1.setBackground(new Color(255, 128, 64));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("Service");
		btnNewButton_5.setBackground(new Color(255, 128, 64));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Payment");
		btnNewButton_3.setBackground(new Color(255, 128, 64));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("Invoice");
		btnNewButton_8.setBackground(new Color(255, 128, 64));
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_2 = new JButton("Customer");
		btnNewButton_2.setBackground(new Color(255, 128, 64));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("Orders");
		btnNewButton_6.setBackground(new Color(255, 128, 64));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Reservations");
		btnNewButton_4.setBackground(new Color(255, 128, 64));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_9 = new JButton("Statistic");
		btnNewButton_9.setBackground(new Color(255, 128, 64));
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_7 = new JButton("Exit");
		btnNewButton_7.setBackground(new Color(255, 128, 64));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("HOTEL MANAGER");
		lblNewLabel.setBounds(10, 113, 1520, 200);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(10, 10, 70, 40);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 50, 70, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(user.loginUser.getId()));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(90, 10, 200, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(user.loginUser.getFullname());
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(90, 50, 200, 40);
		contentPane.add(lblNewLabel_2_1);
		
//		statistic
		btnNewButton_9 .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        StatisticGUI frame = new StatisticGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		
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
		
// 		invoice
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        InvoiceGUI frame = new InvoiceGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
	}

}

