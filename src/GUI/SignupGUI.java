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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BUS.StaffBUS;
import DTO.StaffDTO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class SignupGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfFullname;

    StaffBUS staffBUS = new StaffBUS();
    static public StaffDTO registerUser = new StaffDTO();
	
	public static void main(String[] args) {
		SignupGUI frame = new SignupGUI();
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);frame.setVisible(true);
	}

	public SignupGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 120, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePane = new JPanel();
		contentPane.add(titlePane, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Sign up");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		titlePane.add(lblTitle);
		
		JPanel formPane = new JPanel();
		contentPane.add(formPane, BorderLayout.CENTER);
		GridBagLayout gbl_formPane = new GridBagLayout();
		gbl_formPane.columnWidths = new int[] {0, 0};
		gbl_formPane.rowHeights = new int[] {0, 40, 0, 40};
		gbl_formPane.columnWeights = new double[]{0.0, 0.0};
		gbl_formPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		formPane.setLayout(gbl_formPane);
		
//		error
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 128));
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 32, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 0;
		formPane.add(lblError, gbc_lblError);
		
//		id
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
	
//		fullname
		JLabel lbFullname = new JLabel("Fullname:");
		lbFullname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lbFullname = new GridBagConstraints();
		gbc_lbFullname.anchor = GridBagConstraints.WEST;
		gbc_lbFullname.insets = new Insets(0, 0, 40, 10);
		gbc_lbFullname.gridx = 0;
		gbc_lbFullname.gridy = 3;
		formPane.add(lbFullname, gbc_lbFullname);
		
		tfFullname = new JTextField(30);
		tfFullname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfFullname = new GridBagConstraints();
		gbc_tfFullname.insets = new Insets(0, 0, 40, 0);
		gbc_tfFullname.gridwidth = 1;
		gbc_tfFullname.gridx = 1;
		gbc_tfFullname.gridy = 3;
		formPane.add(tfFullname, gbc_tfFullname);
		
//		phone
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 32, 10);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 5;
		formPane.add(lblPhone, gbc_lblPhone);
		
		JTextField tfPhone = new JTextField(30);
		tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfPhone = new GridBagConstraints();
		gbc_tfPhone.insets = new Insets(0, 0, 32, 0);
		gbc_tfPhone.gridx = 1;
		gbc_tfPhone.gridy = 5;
		formPane.add(tfPhone, gbc_tfPhone);
		
//		gender
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Dialog", Font.PLAIN, 22));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 32, 10);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 6;
		formPane.add(lblGender, gbc_lblGender);
		
//		JTextField tfGender = new JTextField(30);
                JComboBox<String> comboBox = new JComboBox<>();
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                model.addElement("Nam");
                model.addElement("Nữ");
                comboBox.setModel(model);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfGender = new GridBagConstraints();
		gbc_tfGender.insets = new Insets(0, 0, 32, 500);
		gbc_tfGender.gridx = 1;
		gbc_tfGender.gridy = 6;
		formPane.add(comboBox, gbc_tfGender);
		
//		birthday
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.WEST;
		gbc_lblBirthday.insets = new Insets(0, 0, 32, 10);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 7;
		formPane.add(lblBirthday, gbc_lblBirthday);
		
		JTextField tfBirthday = new JTextField(30);
		tfBirthday.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfBirthday = new GridBagConstraints();
		gbc_tfBirthday.insets = new Insets(0, 0, 32, 0);
		gbc_tfBirthday.gridx = 1;
		gbc_tfBirthday.gridy = 7;
		formPane.add(tfBirthday, gbc_tfBirthday);
		
//		password
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 32, 10);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 8;
		formPane.add(lblPassword, gbc_lblPassword);
		
		JTextField tfPassword = new JTextField(30);
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.insets = new Insets(0, 0, 32, 0);
		gbc_tfPassword.gridx = 1;
		gbc_tfPassword.gridy = 8;
		formPane.add(tfPassword, gbc_tfPassword);
		
		JButton btnSignup = new JButton("Signup");		
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfID.getText().trim().equals("") || tfFullname.getText().trim().equals("") || tfPhone.getText().trim().equals("") || comboBox.getSelectedItem().equals("") || tfBirthday.getText().trim().equals("") || tfPassword.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						StaffDTO em = new StaffDTO();
						em.setId(Integer.parseInt(tfID.getText().trim()));
						em.setFullname(tfFullname.getText().trim());
						em.setPhone(tfPhone.getText().trim());
                        String selectedValue = comboBox.getSelectedItem().toString();
						em.setGender(selectedValue.equals("Nam") ? 0 : 1);
						em.setBirthday(tfBirthday.getText().trim());
						em.setSalary(0);
						em.setPassword(tfPassword.getText().trim());
						
						lblError.setText(staffBUS.addStaff(em));
						if (lblError.getText() == "Thêm thành công") {

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
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnSignup = new GridBagConstraints();
		gbc_btnSignup.fill = GridBagConstraints.BOTH;
		gbc_btnSignup.gridwidth = 2;
		gbc_btnSignup.insets = new Insets(0, 0, 32, 0);
		gbc_btnSignup.gridx = 0;
		gbc_btnSignup.gridy = 9;
		formPane.add(btnSignup, gbc_btnSignup);
		
		
		JPanel buttonPane = new JPanel();
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        LoginGUI frame = new LoginGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
		
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonPane.add(btnLogin);
	}
}
