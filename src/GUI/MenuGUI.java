package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DTO.StaffDTO;

public class MenuGUI extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	
	public MenuGUI() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 200, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton lblNewLabel = new JButton("MENU");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 180, 60);
		panel.add(lblNewLabel);
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 100, 200, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton lblNewLabel_1 = new JButton("Qu\u1EA3n l\u00FD kh\u00E1ch h\u00E0ng");
		lblNewLabel_1.addActionListener(new ActionListener() {
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
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 10, 180, 30);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel_1_1.setBackground(new Color(0, 128, 192));
		panel_1_1.setBounds(0, 150, 200, 50);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton lblNewLabel_2 = new JButton("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblNewLabel_2.addActionListener(new ActionListener() {
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
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 10, 180, 30);
		panel_1_1.add(lblNewLabel_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 128, 192));
		panel_1_2.setBounds(0, 200, 200, 50);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton lblNewLabel_3 = new JButton("Qu\u1EA3n l\u00FD ph\u00F2ng ");
		lblNewLabel_3.addActionListener(new ActionListener() {
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
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 10, 180, 30);
		panel_1_2.add(lblNewLabel_3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(0, 128, 192));
		panel_1_3.setBounds(0, 250, 200, 50);
		contentPane.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JButton lblNewLabel_4 = new JButton("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
		lblNewLabel_4.addActionListener(new ActionListener() {
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
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 10, 180, 30);
		panel_1_3.add(lblNewLabel_4);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(new Color(0, 128, 192));
		panel_1_4.setBounds(0, 300, 200, 50);
		contentPane.add(panel_1_4);
		panel_1_4.setLayout(null);
		
		JButton lblNewLabel_5 = new JButton("\u0110\u1EB7t ph\u00F2ng");
		lblNewLabel_5.addActionListener(new ActionListener() {
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
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(10, 10, 180, 30);
		panel_1_4.add(lblNewLabel_5);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(new Color(0, 128, 192));
		panel_1_5.setBounds(0, 350, 200, 50);
		contentPane.add(panel_1_5);
		panel_1_5.setLayout(null);
		
		JButton lblNewLabel_6 = new JButton("\u0110\u1EB7t d\u1ECBch v\u1EE5");
		lblNewLabel_6.addActionListener(new ActionListener() {
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
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(10, 10, 180, 30);
		panel_1_5.add(lblNewLabel_6);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBackground(new Color(0, 128, 192));
		panel_1_6.setBounds(0, 400, 200, 50);
		contentPane.add(panel_1_6);
		panel_1_6.setLayout(null);
		
		JButton lblNewLabel_7 = new JButton("T\u1EA1o h\u00F3a \u0111\u01A1n");
		lblNewLabel_7.addActionListener(new ActionListener() {
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
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(10, 10, 180, 30);
		panel_1_6.add(lblNewLabel_7);
		
		JPanel panel_1_7 = new JPanel();
		panel_1_7.setBackground(new Color(0, 128, 192));
		panel_1_7.setBounds(0, 450, 200, 233);
		contentPane.add(panel_1_7);
	}
}
