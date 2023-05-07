package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TransactionGUI extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel contentPane;
	private JTable table;
    private JTextField tfSearch_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

	public static void main(String[] args) {
		TransactionGUI frame = new TransactionGUI();
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);frame.setVisible(true);
	}

	public TransactionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 120, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

// ContentPane	

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
// MainPane		
		
		JPanel mainPane = new JPanel();
		GridBagConstraints gbc_mainPane = new GridBagConstraints();
		gbc_mainPane.fill = GridBagConstraints.BOTH;
		gbc_mainPane.gridx = 0;
		gbc_mainPane.gridy = 0;
		contentPane.add(mainPane, gbc_mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
		
// TitlePane		
		
		JPanel titlePane = new JPanel();
		GridBagLayout gbl_titlePane = new GridBagLayout();
		gbl_titlePane.rowHeights = new int[] {80, 32};
		gbl_titlePane.columnWeights = new double[]{0.0};
		gbl_titlePane.rowWeights = new double[]{0.0, 0.0};
		titlePane.setLayout(gbl_titlePane);
		
		JLabel lblTitle = new JLabel("Transaction");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.weightx = 1.0;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		titlePane.add(lblTitle, gbc_lblTitle);
		
		JLabel lblError = new JLabel("*Error");
		lblError.setForeground(new Color(255, 0, 128));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 40, 60, 0);
		gbc_lblError.weightx = 1.0;
		gbc_lblError.anchor = GridBagConstraints.WEST;
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 1;
		titlePane.add(lblError, gbc_lblError);
		mainPane.add(titlePane, BorderLayout.NORTH);
		
		JPanel functionPane = new JPanel();
		mainPane.add(functionPane);
		functionPane.setLayout(new BorderLayout(0, 0));
		
		JPanel inputPane = new JPanel();
		functionPane.add(inputPane, BorderLayout.NORTH);
		GridBagLayout gbl_inputPane = new GridBagLayout();
		gbl_inputPane.columnWidths = new int[] {120, 420};
		gbl_inputPane.rowHeights = new int[] {40, 40, 40, 40, 40};
		gbl_inputPane.columnWeights = new double[]{0.0, 1.0};
		gbl_inputPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		inputPane.setLayout(gbl_inputPane);
		
		JLabel lblTransactionID = new JLabel("TransactionID:");
		lblTransactionID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblTransactionID = new GridBagConstraints();
		gbc_lblTransactionID.anchor = GridBagConstraints.EAST;
		gbc_lblTransactionID.insets = new Insets(0, 0, 40, 10);
		gbc_lblTransactionID.gridx = 0;
		gbc_lblTransactionID.gridy = 0;
		inputPane.add(lblTransactionID, gbc_lblTransactionID);
		
		JTextField tfTransactionID = new JTextField(30);
		tfTransactionID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfTransactionID = new GridBagConstraints();
		gbc_tfTransactionID.insets = new Insets(0, 0, 40, 0);
		gbc_tfTransactionID.gridx = 1;
		gbc_tfTransactionID.gridy = 0;
		inputPane.add(tfTransactionID, gbc_tfTransactionID);
		
		JLabel lblReservationID = new JLabel("ReservationID:");
		lblReservationID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblReservationID = new GridBagConstraints();
		gbc_lblReservationID.anchor = GridBagConstraints.EAST;
		gbc_lblReservationID.insets = new Insets(0, 0, 40, 10);
		gbc_lblReservationID.gridx = 0;
		gbc_lblReservationID.gridy = 1;
		inputPane.add(lblReservationID, gbc_lblReservationID);
		
		JTextField tfReservationID = new JTextField(30);
		tfReservationID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfReservationID = new GridBagConstraints();
		gbc_tfReservationID.insets = new Insets(0, 0, 40, 0);
		gbc_tfReservationID.gridx = 1;
		gbc_tfReservationID.gridy = 1;
		inputPane.add(tfReservationID, gbc_tfReservationID);
		
		JLabel lblServiceID = new JLabel("ServiceID:");
		lblServiceID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblServiceID = new GridBagConstraints();
		gbc_lblServiceID.anchor = GridBagConstraints.EAST;
		gbc_lblServiceID.insets = new Insets(0, 0, 40, 10);
		gbc_lblServiceID.gridx = 0;
		gbc_lblServiceID.gridy = 2;
		inputPane.add(lblServiceID, gbc_lblServiceID);
		
		JTextField tfServiceID = new JTextField(30);
		tfServiceID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfServiceID = new GridBagConstraints();
		gbc_tfServiceID.insets = new Insets(0, 0, 40, 0);
		gbc_tfServiceID.gridx = 1;
		gbc_tfServiceID.gridy = 2;
		inputPane.add(tfServiceID, gbc_tfServiceID);
		
		JLabel lblStaffID = new JLabel("StaffID:");
		lblStaffID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblStaffID = new GridBagConstraints();
		gbc_lblStaffID.anchor = GridBagConstraints.EAST;
		gbc_lblStaffID.insets = new Insets(0, 0, 40, 10);
		gbc_lblStaffID.gridx = 0;
		gbc_lblStaffID.gridy = 3;
		inputPane.add(lblStaffID, gbc_lblStaffID);
		
		JTextField tfStaffID = new JTextField(30);
		tfStaffID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 40, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		inputPane.add(tfStaffID, gbc_textField);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 40, 10);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 4;
		inputPane.add(lblQuantity, gbc_lblQuantity);
		
		JTextField tfQuantity = new JTextField(30);
		tfQuantity.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 40, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		inputPane.add(tfQuantity, gbc_textField_1);
		
		JPanel buttonPane = new JPanel();
		functionPane.add(buttonPane, BorderLayout.CENTER);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[] {200, 260, 200};
		gbl_buttonPane.rowHeights = new int[] {70, 70};
		gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_buttonPane.rowWeights = new double[]{0.0, 0.0};
		buttonPane.setLayout(gbl_buttonPane);
		
		JButton addbtn = new JButton("Add");
		addbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_addbtn = new GridBagConstraints();
		gbc_addbtn.fill = GridBagConstraints.BOTH;
		gbc_addbtn.insets = new Insets(0, 0, 20, 60);
		gbc_addbtn.gridx = 0;
		gbc_addbtn.gridy = 0;
		buttonPane.add(addbtn, gbc_addbtn);
		
		JButton eidtPane = new JButton("Edit");
		eidtPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eidtPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_eidtPane = new GridBagConstraints();
		gbc_eidtPane.fill = GridBagConstraints.BOTH;
		gbc_eidtPane.insets = new Insets(0, 60, 20, 60);
		gbc_eidtPane.gridx = 1;
		gbc_eidtPane.gridy = 0;
		buttonPane.add(eidtPane, gbc_eidtPane);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.fill = GridBagConstraints.BOTH;
		gbc_deleteBtn.insets = new Insets(0, 60, 20, 0);
		gbc_deleteBtn.gridx = 2;
		gbc_deleteBtn.gridy = 0;
		buttonPane.add(deleteBtn, gbc_deleteBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_exitBtn = new GridBagConstraints();
		gbc_exitBtn.fill = GridBagConstraints.BOTH;
		gbc_exitBtn.gridwidth = 3;
		gbc_exitBtn.insets = new Insets(20, 0, 0, 0);
		gbc_exitBtn.gridx = 0;
		gbc_exitBtn.gridy = 1;
		buttonPane.add(exitBtn, gbc_exitBtn);
		
//		TABLEPANE
		
		JPanel tablePane = new JPanel();
		tablePane.setPreferredSize(new Dimension(((int) screenSize.getWidth() - 10 ) / 2, (int) tablePane.getPreferredSize().getHeight()));
		GridBagConstraints gbc_tablePane = new GridBagConstraints();
		gbc_tablePane.fill = GridBagConstraints.BOTH;
		gbc_tablePane.gridx = 1;
		gbc_tablePane.gridy = 0;
		contentPane.add(tablePane, gbc_tablePane);
		GridBagLayout gbl_tablePane = new GridBagLayout();
		gbl_tablePane.columnWidths = new int[] {0};
		gbl_tablePane.rowHeights = new int[] {300, 60, 300, 60};
		gbl_tablePane.columnWeights = new double[]{0.0};
		gbl_tablePane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		tablePane.setLayout(gbl_tablePane);
		
//		TABLE_1
		
		JTable table_1 = new JTable();
		table_1.setPreferredSize(new Dimension(((int) screenSize.getWidth() - 10 ) / 2, 300));
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TransactionID", "ReservationID", "ServiceID", "StaffID", "Quantity", "Date"
			}
		));
		
//		SCROLLPANE_1
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setPreferredSize(new Dimension(((int) screenSize.getWidth() - 10 ) / 2, 300));
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		tablePane.add(scrollPane_1, gbc_scrollPane_1);
		
//		SEARCHPANE_1
		
		JPanel searchPane_1 = new JPanel();
		GridBagConstraints gbc_searchPane_1 = new GridBagConstraints();
		gbc_searchPane_1.insets = new Insets(10, 0, 10, 0);
		gbc_searchPane_1.fill = GridBagConstraints.BOTH;
		gbc_searchPane_1.anchor = GridBagConstraints.NORTH;
		gbc_searchPane_1.gridx = 0;
		gbc_searchPane_1.gridy = 1;
		tablePane.add(searchPane_1, gbc_searchPane_1);
		GridBagLayout gbl_searchPane_1 = new GridBagLayout();
		gbl_searchPane_1.columnWidths = new int[] {360};
		gbl_searchPane_1.rowHeights = new int[] {30, 30};
		gbl_searchPane_1.columnWeights = new double[]{1.0};
		gbl_searchPane_1.rowWeights = new double[]{0.0, 0.0};
		searchPane_1.setLayout(gbl_searchPane_1);
		
//		TFSEARCH_1
		
		tfSearch_1 = new JTextField();
		tfSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_tfSearch_1 = new GridBagConstraints();
		gbc_tfSearch_1.insets = new Insets(0, 0, 10, 0);
		gbc_tfSearch_1.fill = GridBagConstraints.VERTICAL;
		gbc_tfSearch_1.gridx = 0;
		gbc_tfSearch_1.gridy = 0;
		searchPane_1.add(tfSearch_1, gbc_tfSearch_1);
		tfSearch_1.setColumns(10);
		
//		BTNSEARCCH_1		
		
		JButton btnSearch_1 = new JButton("Search");
		GridBagConstraints gbc_btnSearch_1 = new GridBagConstraints();
		gbc_btnSearch_1.gridx = 0;
		gbc_btnSearch_1.gridy = 1;
		searchPane_1.add(btnSearch_1, gbc_btnSearch_1);
		
//		TABLE_2
		
		JTable table_2 = new JTable();
		table_2.setPreferredSize(new Dimension(((int) screenSize.getWidth() - 10 ) / 2, 300));
		table_2.setFillsViewportHeight(true);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ServiceId", "Name", "Price"
			}
		));
		
//		SCROLLPANE_2		
	
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setPreferredSize(new Dimension(((int) screenSize.getWidth() - 10 ) / 2, 300));
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		tablePane.add(scrollPane_2, gbc_scrollPane_2);
	
//		SEARCHPANE_2		
		
		JPanel searchPane_2 = new JPanel();
		GridBagConstraints gbc_searchPane_2 = new GridBagConstraints();
		gbc_searchPane_2.insets = new Insets(10, 0, 0, 0);
		gbc_searchPane_2.anchor = GridBagConstraints.NORTH;
		gbc_searchPane_2.fill = GridBagConstraints.BOTH;
		gbc_searchPane_2.gridx = 0;
		gbc_searchPane_2.gridy = 3;
		tablePane.add(searchPane_2, gbc_searchPane_2);
		GridBagLayout gbl_searchPane_2 = new GridBagLayout();
		gbl_searchPane_2.columnWidths = new int[] {360};
		gbl_searchPane_2.rowHeights = new int[] {30, 30};
		gbl_searchPane_2.columnWeights = new double[]{1.0};
		gbl_searchPane_2.rowWeights = new double[]{0.0, 0.0};
		searchPane_2.setLayout(gbl_searchPane_2);
		
//		TFSEARCH_2		
	
		JTextField tfSearch_2 = new JTextField();
		tfSearch_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tfSearch_2.setColumns(10);
		GridBagConstraints gbc_tfSearch_2 = new GridBagConstraints();
		gbc_tfSearch_2.fill = GridBagConstraints.VERTICAL;
		gbc_tfSearch_2.insets = new Insets(0, 0, 10, 0);
		gbc_tfSearch_2.gridx = 0;
		gbc_tfSearch_2.gridy = 0;
		searchPane_2.add(tfSearch_2, gbc_tfSearch_2);
		
//		BTNSEARCH_2	
		
		JButton btnSearch_2 = new JButton("Search");
		GridBagConstraints gbc_btnSearch_2 = new GridBagConstraints();
		gbc_btnSearch_2.gridx = 0;
		gbc_btnSearch_2.gridy = 1;
		searchPane_2.add(btnSearch_2, gbc_btnSearch_2);
	}
}

