package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import BUS.CustomerBUS;
import BUS.PaymentBUS;
import BUS.StaffBUS;
import DTO.CustomerDTO;
import DTO.PaymentDTO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PaymentGUI extends javax.swing.JFrame {
	
	PaymentBUS paymentBUS = new PaymentBUS();
	CustomerBUS cusBUS = new CustomerBUS();
	LoginGUI user = new LoginGUI();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_2;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable table_1;
    private javax.swing.JTextField tfPaymentId;
    private javax.swing.JTextField tfCustomerId;
    private javax.swing.JTextField tfStaffId;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField tfSearchX;
    private javax.swing.JTextField tfSearchY;
    private javax.swing.JButton btnSearch;

    
    // End of variables declaration//GEN-END:variables
    
    public PaymentGUI() {
        initComponents();
        loadStaffId();
        loadPaymentList();
        loadCustomerList();
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        tfPaymentId = new javax.swing.JTextField();
        lblFullname = new javax.swing.JLabel();
        tfCustomerId = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        tfStaffId = new javax.swing.JTextField();
        tfStaffId.setEditable(false);
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_2 = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tfSearchX = new javax.swing.JTextField();
        tfSearchY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách sạn");
        setBackground(new java.awt.Color(204, 255, 204));

        contentPane.setBackground(new java.awt.Color(192, 192, 192));
        contentPane.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Payment Information");

        jPanel2.setBackground(new java.awt.Color(192, 192, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerID.setText("Payment ID");

        lblFullname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFullname.setText("Customer ID");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setText("Staff ID");

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBtn.setText("Edit");
        editBtn.setMaximumSize(new java.awt.Dimension(78, 31));
        editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPaymentId.getText().trim().equals("") || tfCustomerId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						PaymentDTO em = new PaymentDTO();
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText()));
						em.setCustomerId(Integer.parseInt(tfCustomerId.getText()));
						
						lblError.setText(paymentBUS.editPayment(em, em.getCustomerId()));
						loadPaymentList();
						loadCustomerList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Thông tin không hợp lệ");
				}
			}
		});

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPaymentId.getText().trim().equals("") || tfCustomerId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						PaymentDTO em = new PaymentDTO();
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText()));
						em.setCustomerId(Integer.parseInt(tfCustomerId.getText()));
						
						lblError.setText(paymentBUS.addPayment(em, em.getCustomerId()));
						loadPaymentList();
						loadCustomerList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Thông tin không hợp lệ");
				}
			}
		});

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPaymentId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						PaymentDTO em = new PaymentDTO();
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText().trim()));
						
						lblError.setText(paymentBUS.deletePayment(em));
						loadPaymentList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Xảy ra lỗi");
				}
			}
		});

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame.setDefaultLookAndFeelDecorated(false);
				
		        MenuGUI frame = new MenuGUI();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblError, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblPhone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblFullname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblCustomerID, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        					.addGap(28)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfCustomerId)
        						.addComponent(tfStaffId)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(tfPaymentId, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        							.addGap(0, 0, Short.MAX_VALUE))))
        				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        						.addComponent(deleteBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(editBtn, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
        			.addGap(21))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCustomerID)
        				.addComponent(tfPaymentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblFullname)
        				.addComponent(tfCustomerId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPhone)
        				.addComponent(tfStaffId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(39)
        			.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addBtn)
        				.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(deleteBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(168))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setBackground(new java.awt.Color(192, 192, 192));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PAYMENT MANAGEMENT");
        lblTitle.setOpaque(true);

        table_1.setBackground(new java.awt.Color(192, 192, 192));
        table_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(table_1);
        
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                if (tfSearch.getText().trim().equals("")) {
                                    lblError.setText("Vui lòng nhập đầy đủ thông tin ");
                                }
                                
                                else {
                                    searchPaymentByID();
                                }
                                
                            } catch (NumberFormatException ex) {
                                lblError.setText("Xảy ra lỗi");
                            }
			}
		});

        table_2.setBackground(new java.awt.Color(192, 192, 192));
        table_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(table_2);
        
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                if (tfSearchX.getText().trim().equals("") || tfSearchY.getText().trim().equals("") ) {
                                    lblError.setText("Vui lòng nhập đầy đủ thông tin ");
                                }
                                
                                else {
                                    searchRange();
                                }
                                
                            } catch (NumberFormatException ex) {
                                lblError.setText("Xảy ra lỗi");
                            }
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearchY, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(tfSearchX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearchY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

    }//GEN-LAST:event_tableMouseClicked

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed

    }//GEN-LAST:event_exitBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
       
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentGUI().setVisible(true);
            }
        });
    }
    
    public void searchRange() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("paymentId");
        model.addColumn("cutomerId");
        model.addColumn("staffId");
        model.addColumn("create date");
        model.addColumn("payment date");
        model.addColumn("total");
        model.addColumn("status");
        table_1.setModel(model);
        int x = Integer.parseInt(tfSearchX.getText().trim());
        int y = Integer.parseInt(tfSearchY.getText().trim());
        ArrayList<PaymentDTO> arr = paymentBUS.searchRange(x, y);
            if (!arr.isEmpty()) {
                for (int i = 0; i < arr.size(); i++) {
                    PaymentDTO dto = arr.get(i);
                    int paymentId = dto.getPaymentId();
                    int customerId = dto.getCustomerId();
                    int staffId = dto.getStaffId();
                    String createDate = dto.getCreateDate();
                    String paymentDate = dto.getPaymentDate();
                    int total = dto.getTotal();
                    String status = (dto.getStatus() ? "paid" : "unpaid");
                    Object[] rowData = {paymentId, customerId, staffId, createDate, paymentDate, total, status};
                    model.addRow(rowData);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin thỏa điều kiện !");
            }
        
    }
    
    public void searchPaymentByID() {
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<PaymentDTO> arr = new ArrayList<PaymentDTO>();
        arr = paymentBUS.getAllPayments();
        PaymentDTO em = new PaymentDTO();
        int id = Integer.parseInt(tfSearch.getText().trim());
        em.setPaymentId(id);
        String message = paymentBUS.searchPayment(em);

        if (message.equals("thành công")) {
            for (int i = 0; i < arr.size(); i++) {
                PaymentDTO dto = arr.get(i);
                if (dto.getPaymentId()== id) {
                    int paymentId = em.getPaymentId();
                    int customerId = em.getCustomerId();
                    int staffId = em.getStaffId();
                    String createDate = em.getCreateDate();
                    String paymentDate = em.getPaymentDate();
                    int total = em.getTotal();
                    String status = (em.getStatus() ? "paid" : "unpaid");
                    Object[] rowData = {paymentId, customerId, staffId, createDate, paymentDate, total, status};
                    model.addRow(rowData);
                    table_1.setRowSelectionInterval(i, i);
                    break;
                }
            }
        
        } else {
            JOptionPane.showMessageDialog(null, message);
        }
    }

    private void loadStaffId() {
    	tfStaffId.setText(Integer.toString(user.loginUser.getId()));
    }
    
	private void loadPaymentList() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("paymentId");
		dtm.addColumn("cutomerId");
		dtm.addColumn("staffId");
		dtm.addColumn("create date");
		dtm.addColumn("payment date");
		dtm.addColumn("total");
		dtm.addColumn("status");
		table_1.setModel(dtm);
		
		ArrayList<PaymentDTO> arr = new ArrayList<PaymentDTO>();
		arr = paymentBUS.getAllPayments();
		
		for(int i = 0; i < arr.size(); i++){
			PaymentDTO em = arr.get(i);
			
			
			int paymentId = em.getPaymentId();
			int customerId = em.getCustomerId();
			int staffId = em.getStaffId();
			String createDate = em.getCreateDate();
			String paymentDate = em.getPaymentDate();
			int total = em.getTotal();
			String status = (em.getStatus() ? "paid" : "unpaid");
			
			Object[] row = {paymentId, customerId, staffId, createDate, paymentDate, total, status};
			
			dtm.addRow(row);
		}
	}
	
	private void loadCustomerList() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Id");
		dtm.addColumn("fullname");
		dtm.addColumn("phone");
		dtm.addColumn("gender");
		dtm.addColumn("birthday");
		dtm.addColumn("address");
		table_2.setModel(dtm);
		
		ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
		arr = cusBUS.getAllCustomers();
		
		for(int i = 0; i < arr.size(); i++){
			CustomerDTO em = arr.get(i);
			
			int id = em.getId();
			String fullname = em.getFullname();
			String phone = em.getPhone();
			String gender = "";
			if (em.getGender() == 0)
				gender = "male";
			else if (em.getGender() == 1)
				gender = "female";
			String birthday = em.getBirthday();
			String address = em.getAddress();
			
			Object[] row = {id, fullname, phone, gender, birthday, address};
			
			dtm.addRow(row);
		}
	}

}
