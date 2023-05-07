package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import BUS.StaffBUS;
import DTO.StaffDTO;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfPassword;
	
    StaffBUS staffBUS = new StaffBUS();
    
    static public StaffDTO loginUser = new StaffDTO();

	public static void main(String[] args) {
		LoginGUI frame = new LoginGUI();
	}
	
	public LoginGUI() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 120, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePane = new JPanel();
		contentPane.add(titlePane, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		titlePane.add(lblTitle);
		
		JPanel formPane = new JPanel();
		contentPane.add(formPane, BorderLayout.CENTER);
		GridBagLayout gbl_formPane = new GridBagLayout();
		gbl_formPane.columnWidths = new int[] {0, 0};
		gbl_formPane.rowHeights = new int[] {0, 40, 40, 0};
		gbl_formPane.columnWeights = new double[]{0.0, 0.0};
		gbl_formPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		formPane.setLayout(gbl_formPane);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 128));
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.anchor = GridBagConstraints.WEST;
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 40, 20, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 0;
		formPane.add(lblError, gbc_lblError);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.WEST;
		gbc_lblID.insets = new Insets(0, 0, 40, 10);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		formPane.add(lblID, gbc_lblID);
		
		tfID = new JTextField(30);
		tfID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfID = new GridBagConstraints();
		gbc_tfID.insets = new Insets(0, 0, 40, 0);
		gbc_tfID.gridx = 1;
		gbc_tfID.gridy = 1;
		formPane.add(tfID, gbc_tfID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 40, 10);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		formPane.add(lblPassword, gbc_lblPassword);
		
		tfPassword = new JTextField(30);
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.insets = new Insets(0, 0, 40, 0);
		gbc_tfPassword.gridwidth = 1;
		gbc_tfPassword.gridx = 1;
		gbc_tfPassword.gridy = 2;
		formPane.add(tfPassword, gbc_tfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfID.getText().trim().equals("") || tfPassword.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						StaffDTO em = new StaffDTO();
						em.setId(Integer.parseInt(tfID.getText().trim()));
						em.setPassword(tfPassword.getText().trim());
						
						lblError.setText(staffBUS.login(em.getId(), em.getPassword()));
						if (lblError.getText() == "Đăng nhập thành công") {
							loginUser = staffBUS.loginUser(em);
							
							dispose();
							JFrame.setDefaultLookAndFeelDecorated(false);
							
					        MenuGUI frame = new MenuGUI();
							frame.setLocationRelativeTo(null);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							frame.setUndecorated(true);
							frame.setVisible(true);
						}
					}		
				} catch (NumberFormatException ex) {
					lblError.setText("Thông tin không hợp lệ");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 3;
		formPane.add(btnLogin, gbc_btnLogin);
		
		JPanel buttonPane = new JPanel();
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnSignup = new JButton("Sign up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        SignupGUI frame = new SignupGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
		
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonPane.add(btnSignup);
	}
	
	
}
