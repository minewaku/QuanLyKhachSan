package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.PaymentBUS;
import BUS.ReservationsBUS;
import BUS.RoomBUS;
import DTO.PaymentDTO;
import DTO.ReservationsDTO;
import DTO.RoomDTO;

public class ReservationsGUI extends javax.swing.JFrame {
	
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reservationTable;
    private javax.swing.JTextField tfReservationId;
    private javax.swing.JTextField tfPaymentId;
    private javax.swing.JTextField tfRoomId;
    private javax.swing.JTextField tfArrivalDate;
    private javax.swing.JTextField tfRentDate;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JPanel panel_1;
    private JLabel lblDanhSchPhng;
    private JScrollPane scrollPane;
    private JTable paymentTable;
    private JPanel panel_2;
    private JLabel lblThanhTon;
    private JScrollPane scrollPane_1;
    private JTable roomTable;
    
    ReservationsBUS reservationBUS = new ReservationsBUS();
    PaymentBUS paymentBUS = new PaymentBUS();
    RoomBUS roomBUS = new RoomBUS();
    

    public ReservationsGUI() {
        initComponents();
        loadReservationList();
        loadPaymentList();
        loadRoomList();
    }

   
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfReservationId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPaymentId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfRoomId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfArrivalDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfRentDate = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        JLabel lblError = new JLabel("");
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Reservation information");

        jPanel2.setBackground(new java.awt.Color(192, 192, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ReservationID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("PaymentID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("RoomID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Arrival Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Rent Date");

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBtn.setText("edit");
        editBtn.setMaximumSize(new java.awt.Dimension(78, 31));
        editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfReservationId.getText().trim().equals("") || tfPaymentId.getText().trim().equals("") || tfRoomId.getText().trim().equals("") || tfArrivalDate.getText().trim().equals("") || tfRentDate.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						ReservationsDTO em = new ReservationsDTO();
						em.setReservationId(Integer.parseInt(tfReservationId.getText().trim()));
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText().trim()));
						em.setRoomId(Integer.parseInt(tfRoomId.getText().trim()));
						em.setArrivalDate(tfArrivalDate.getText().trim());
						em.setRentDate(Integer.parseInt(tfRentDate.getText().trim()));
						
						lblError.setText(reservationBUS.editReservations(em, em.getPaymentId(), em.getRoomId()));

						loadReservationList();
						loadPaymentList();
						loadRoomList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Thông tin không hợp lệ");
				}
			}
		});
 
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setText("add");
        addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfReservationId.getText().trim().equals("") || tfPaymentId.getText().trim().equals("") || tfRoomId.getText().trim().equals("") || tfArrivalDate.getText().trim().equals("") || tfRentDate.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						ReservationsDTO em = new ReservationsDTO();
						em.setReservationId(Integer.parseInt(tfReservationId.getText().trim()));
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText().trim()));
						em.setRoomId(Integer.parseInt(tfRoomId.getText().trim()));
						em.setArrivalDate(tfArrivalDate.getText().trim());
						em.setRentDate(Integer.parseInt(tfRentDate.getText().trim()));
						
						lblError.setText(reservationBUS.addReservations(em, em.getPaymentId(), em.getRoomId()));

						loadReservationList();
						loadPaymentList();
						loadRoomList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Thông tin không hợp lệ");
				}
			}
		});

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBtn.setText("delete");
        deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfReservationId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						ReservationsDTO em = new ReservationsDTO();
						em.setReservationId(Integer.parseInt(tfReservationId.getText().trim()));
						
						lblError.setText(reservationBUS.deleteReservations(em));
						
						loadReservationList();
						loadPaymentList();
						loadRoomList();
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Xảy ra lỗi");
				}
			}
		});

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitBtn.setText("exit");
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
        

        lblError.setForeground(new Color(255, 0, 128));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblError, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addComponent(editBtn, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel2)
        								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel4))
        							.addGap(25))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        								.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfArrivalDate, 137, 137, Short.MAX_VALUE)
        						.addComponent(tfRoomId, 137, 137, Short.MAX_VALUE)
        						.addComponent(tfPaymentId, 137, 137, Short.MAX_VALUE)
        						.addComponent(tfReservationId, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(tfRentDate, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
        				.addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addComponent(deleteBtn, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(43)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(tfReservationId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(37)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(tfPaymentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(38)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(tfRoomId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(tfArrivalDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(tfRentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(37)
        			.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addGap(86)
        			.addComponent(addBtn)
        			.addGap(18)
        			.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(deleteBtn)
        			.addGap(18)
        			.addComponent(exitBtn)
        			.addGap(22))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
        			.addGap(21))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel9.setBackground(new java.awt.Color(192, 192, 192));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("RESERVATION MANAGEMENT");
        jLabel9.setOpaque(true);
        
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setLayout(null);
        
        lblDanhSchPhng = new JLabel("Payment");
        lblDanhSchPhng.setBounds(528, 5, 120, 20);
        lblDanhSchPhng.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel_1.add(lblDanhSchPhng);
        
        panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.LIGHT_GRAY);
        
        lblThanhTon = new JLabel("Room");
        lblThanhTon.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblThanhTon.setBounds(528, 5, 120, 20);
        panel_2.add(lblThanhTon);
        
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 35, 1101, 167);
        panel_2.add(scrollPane_1);
        
        roomTable = new JTable();
        roomTable.setBackground(Color.LIGHT_GRAY);
        roomTable.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_1.setViewportView(roomTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(11)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(386)
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1121, Short.MAX_VALUE))
        					.addGap(25)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(25)
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap(41, Short.MAX_VALUE)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)))
        			.addGap(33))
        );
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 35, 1101, 167);
        panel_1.add(scrollPane);
        
        paymentTable = new JTable();
        paymentTable.setBorder(new LineBorder(new Color(0, 0, 0)));
        paymentTable.setBackground(Color.LIGHT_GRAY);
        scrollPane.setViewportView(paymentTable);
        panel.setLayout(null);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.setBounds(10, 38, 1101, 164);
        panel.add(jScrollPane1);
        reservationTable = new javax.swing.JTable();

        reservationTable.setBackground(new java.awt.Color(192, 192, 192));
        reservationTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(reservationTable);
        
        lblNewLabel = new JLabel("Reservation");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNewLabel.setBounds(516, 8, 148, 20);
        panel.add(lblNewLabel);
        getContentPane().setLayout(layout);

    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReservationsGUI frame = new ReservationsGUI();
                frame.setVisible(true);
            }
        });
    }
    
    public void loadReservationList(){
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("reservationId");
		dtm.addColumn("paymentId");
		dtm.addColumn("roomId");
		dtm.addColumn("arrival date");
		dtm.addColumn("rent date");
		dtm.addColumn("amount");
		
		reservationTable.setModel(dtm);
		
		ArrayList<ReservationsDTO> arr = new ArrayList<ReservationsDTO>();
		arr = reservationBUS.getAllReservationss();
		
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
	
	public void loadRoomList(){
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("roomId");
		dtm.addColumn("Size");
		dtm.addColumn("Type");
		dtm.addColumn("Price");
		dtm.addColumn("Status");
		
		roomTable.setModel(dtm);
		
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		arr = roomBUS.getAllRooms();
		
		for(int i = 0; i < arr.size(); i++){
			RoomDTO em = arr.get(i);
			
			int id = em.getRoomId();
			String size = em.getSize();
			String type = em.getType();
			int price = em.getPrice();
			String status = em.getStatus() ? "full" : "empty";
			
			Object[] row = {id, size, type, price, status};
			
			dtm.addRow(row);
		}
	}
}
