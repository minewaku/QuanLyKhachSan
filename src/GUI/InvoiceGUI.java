/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import BUS.OrdersBUS;
import BUS.PaymentBUS;
import BUS.ReservationsBUS;
import DTO.OrdersDTO;
import DTO.PaymentDTO;
import DTO.ReservationsDTO;

public class InvoiceGUI extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton findBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable paymentTable;
    private javax.swing.JTable reservationTable;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel lblError;
    private javax.swing.JButton payBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JTextField tfPaymentId;
    // End of variables declaration//GEN-END:variables
    
	PaymentDTO payment = new PaymentDTO();
    
	private PaymentBUS paymentBUS = new PaymentBUS();
	private ReservationsBUS reservationBUS = new ReservationsBUS();
	private OrdersBUS orderBUS = new OrdersBUS();
	
    public InvoiceGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        exitBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();
        payBtn.setEnabled(false);
        tfPaymentId = new javax.swing.JTextField();
        findBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 192, 192));

        jLabel1.setBackground(new java.awt.Color(192, 192, 192));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiêu đề");
        jLabel1.setOpaque(true);

        paymentTable.setBackground(new java.awt.Color(192, 192, 192));
        jScrollPane1.setViewportView(paymentTable);

        jLabel2.setBackground(new java.awt.Color(192, 192, 192));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAYMENT");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(192, 192, 192));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RESERVATION");
        jLabel3.setOpaque(true);

        reservationTable.setBackground(new java.awt.Color(192, 192, 192));
        reservationTable.setGridColor(new java.awt.Color(192, 192, 192));
        jScrollPane2.setViewportView(reservationTable);

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        exitBtn.setText("exit");

        payBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(payment.getStatus() == true)
					lblError.setText("Hóa đơn đã thanh toán");
				else {
					
					String text = paymentBUS.pay(payment);
					lblError.setText(text); 
					
					if (text == "Thanh toán thành công") {
						loadPayment();
						loadReservation();
						loadOrder();
					}		
				}
				
			}
		});
        payBtn.setText("PAY");

        findBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPaymentId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						PaymentDTO em = new PaymentDTO();
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText().trim()));
						
						lblError.setText(paymentBUS.searchPayment(em));
						if(paymentBUS.searchPayment(em) != "Mã Thanh Toán không tồn tại") {
							payBtn.setEnabled(true);
							loadPayment();
							loadReservation();
							loadOrder();
						}
						
						else {
							DefaultTableModel dtm = new DefaultTableModel();
							loadPaymentList();
							reservationTable.setModel(dtm);
							orderTable.setModel(dtm);
						}
						
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Xảy ra lỗi");
				}
			}
		});
        findBtn.setText("find");

        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPaymentList();
				
				payBtn.setEnabled(false);
				
				DefaultTableModel dtm = new DefaultTableModel();
				reservationTable.setModel(dtm);
				orderTable.setModel(dtm);
			}
		});
        refreshBtn.setText("Refresh");

        reportBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reportBtn.setText("Report");

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setBackground(new java.awt.Color(192, 192, 192));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ORDER");
        jLabel4.setOpaque(true);

        orderTable.setBackground(new java.awt.Color(192, 192, 192));
        jScrollPane3.setViewportView(orderTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payBtn)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPaymentId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportBtn)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(307, 307, 307))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn)
                    .addComponent(payBtn)
                    .addComponent(tfPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findBtn)
                    .addComponent(refreshBtn)
                    .addComponent(reportBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGUI().setVisible(true);
            }
        });
    }

    private void loadPayment() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("paymentId");
		dtm.addColumn("cutomerId");
		dtm.addColumn("staffId");
		dtm.addColumn("create date");
		dtm.addColumn("payment date");
		dtm.addColumn("total");
		dtm.addColumn("status");
		paymentTable.setModel(dtm);
		
		payment = paymentBUS.getPayment(Integer.parseInt(tfPaymentId.getText().trim()));

		Object[] row = {payment.getPaymentId(), payment.getCustomerId(), payment.getStaffId(), payment.getCreateDate(), payment.getPaymentDate(), payment.getTotal(), (payment.getStatus()) ? "paid" : "unpaid"};
		
		dtm.addRow(row);
	}
		
	private void loadReservation() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("reservationId");
		dtm.addColumn("paymentId");
		dtm.addColumn("roomId");
		dtm.addColumn("arrival date");
		dtm.addColumn("rent date");
		dtm.addColumn("amount");
		
		reservationTable.setModel(dtm);
		
		ArrayList<ReservationsDTO> arr = new ArrayList<ReservationsDTO>();
		arr = reservationBUS.getReservation(payment.getPaymentId());
		
		for(int i = 0; i < arr.size(); i++){
			ReservationsDTO em = arr.get(i);
			
			int reservationId = em.getReservationId();
			int paymentId = em.getPaymentId();
			int roomId = em.getRoomId();
			String arrivalDate = em.getArrivalDate();
			int rentDate = em.getRentDate();
			int	amount = em.getAmount();
			
			Object[] row = {reservationId, paymentId, roomId, arrivalDate, rentDate, amount};
			
			dtm.addRow(row);
		}
	}
	
	public void loadOrder() {
    	DefaultTableModel dtm = new DefaultTableModel();
    	dtm.addColumn("orderId");
		dtm.addColumn("reservationId");
		dtm.addColumn("serviceId");
		dtm.addColumn("staffId");
		dtm.addColumn("quantity");
		dtm.addColumn("date");
		dtm.addColumn("amount");
		
		orderTable.setModel(dtm);
		
		ArrayList<OrdersDTO> arr = new ArrayList<OrdersDTO>();
		arr = orderBUS.getOrder(payment.getPaymentId());
		
		for(int i = 0; i < arr.size(); i++){
			OrdersDTO em = arr.get(i);
			
			int orderId = em.getOrderId();
			int reservationId = em.getReservationId();
			int serviceId = em.getServiceId();
			int staffId = em.getStaffId();
			int quantity = em.getQuantity();
			String date = em.getDate();
			int amount = em.getAmount();
			
			Object[] row = {orderId, reservationId, serviceId, staffId, quantity, date, amount};
			
			dtm.addRow(row);
		}
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
		paymentTable.setModel(dtm);
		
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
	

}
