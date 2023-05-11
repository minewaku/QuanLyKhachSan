package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import BUS.OrdersBUS;
import BUS.ReservationBUS;
import BUS.ServiceBUS;
import DTO.OrdersDTO;
import DTO.PaymentDTO;
import DTO.ReservationsDTO;
import DTO.ServiceDTO;
import javax.swing.JTextField;


public class OrdersGUI extends javax.swing.JFrame {
	
	OrdersBUS orderBUS = new OrdersBUS();
	ReservationBUS reservationBUS = new ReservationBUS();
	ServiceBUS serviceBUS = new ServiceBUS();
	LoginGUI user = new LoginGUI();
	
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField tfReservationId;
    private javax.swing.JTextField tfServiceId;
    private javax.swing.JTextField tfStaffId;
    private javax.swing.JTextField tfQuantity;
    private JTable reservationTable;
    private JPanel panel_2;
    private JScrollPane jScrollPane1_2;
    private JLabel lblReservation_1;
    private JTable serviceTable;

  
	private Container titlePane;
	private Container mainPane;
	private JLabel lblError = new JLabel("");
	private JTextField tfOrderId;
    
	public OrdersGUI() {
        initComponents();
        loadStaffId();
        loadOrderList();
        loadReservationList();
        loadServiceList();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfReservationId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfServiceId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfStaffId = new javax.swing.JTextField();
        tfStaffId.setEditable(false);
        jLabel5 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel2.setBackground(new java.awt.Color(192, 192, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ReservationID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("ServiceID");


        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("StaffID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editBtn.setText("edit");
        editBtn.setMaximumSize(new java.awt.Dimension(78, 31));
        editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfOrderId.getText().trim().equals("") || tfReservationId.getText().trim().equals("") || tfServiceId.getText().trim().equals("") || tfQuantity.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						OrdersDTO em = new OrdersDTO();
						em.setOrderId(Integer.parseInt(tfOrderId.getText().trim()));
						em.setReservationId(Integer.parseInt(tfReservationId.getText().trim()));
						em.setServiceId(Integer.parseInt(tfServiceId.getText().trim()));
						em.setQuantity(Integer.parseInt(tfQuantity.getText().trim()));
						
						lblError.setText(orderBUS.editOrders(em));
						loadOrderList();
						loadReservationList();
						loadServiceList();
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
					if (tfOrderId.getText().trim().equals("") || tfReservationId.getText().trim().equals("") || tfServiceId.getText().trim().equals("") || tfQuantity.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						OrdersDTO em = new OrdersDTO();
						em.setOrderId(Integer.parseInt(tfOrderId.getText().trim()));
						em.setReservationId(Integer.parseInt(tfReservationId.getText()));
						em.setServiceId(Integer.parseInt(tfServiceId.getText()));
						em.setQuantity(Integer.parseInt(tfQuantity.getText().trim()));
						
						lblError.setText(orderBUS.addOrders(em));
						loadOrderList();
						loadReservationList();
						loadServiceList();
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
					if (tfOrderId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						OrdersDTO em = new OrdersDTO();
						em.setOrderId(Integer.parseInt(tfOrderId.getText().trim()));
						
						lblError.setText(orderBUS.deleteOrders(em));
						loadOrderList();
						loadReservationList();
						loadServiceList();
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
        
        JLabel lblOrderId = new JLabel("OrderId");
        lblOrderId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        tfOrderId = new JTextField();
        tfOrderId.setColumns(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        				.addComponent(editBtn, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        				.addComponent(deleteBtn, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        				.addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        				.addComponent(lblError, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(jLabel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jLabel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        					.addGap(15)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfQuantity, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        						.addComponent(tfStaffId, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        						.addComponent(tfServiceId, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lblOrderId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(7)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(tfOrderId, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        						.addComponent(tfReservationId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblOrderId)
        				.addComponent(tfOrderId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(tfReservationId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(tfServiceId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(tfStaffId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(tfQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(297)
        			.addComponent(addBtn)
        			.addGap(18)
        			.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(deleteBtn)
        			.addGap(18)
        			.addComponent(exitBtn)
        			.addContainerGap(122, Short.MAX_VALUE))
        );
        lblError.setForeground(new Color(255, 0, 128));
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(26)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 714, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel9.setBackground(new java.awt.Color(192, 192, 192));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ORDER MANAGEMENT");
        jLabel9.setOpaque(true);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.LIGHT_GRAY);
        
        JScrollPane jScrollPane1_1 = new JScrollPane();
        jScrollPane1_1.setBounds(0, 29, 1148, 155);
        panel_1.add(jScrollPane1_1);
        
        reservationTable = new JTable();
        reservationTable.setBackground(Color.LIGHT_GRAY);
        jScrollPane1_1.setViewportView(reservationTable);
        
        JLabel lblReservation = new JLabel("RESERVATION");
        lblReservation.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblReservation.setBounds(552, 6, 123, 13);
        panel_1.add(lblReservation);
        
        panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.LIGHT_GRAY);
        
        jScrollPane1_2 = new JScrollPane();
        jScrollPane1_2.setBounds(0, 29, 1148, 155);
        panel_2.add(jScrollPane1_2);
        
        serviceTable = new JTable();
        serviceTable.setBackground(Color.LIGHT_GRAY);
        jScrollPane1_2.setViewportView(serviceTable);
        
        lblReservation_1 = new JLabel("SERVICE");
        lblReservation_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblReservation_1.setBounds(552, 6, 123, 13);
        panel_2.add(lblReservation_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
        					.addGap(416))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1148, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1148, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1148, GroupLayout.PREFERRED_SIZE))
        					.addGap(25))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        					.addGap(58)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        					.addGap(31)
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        					.addGap(35))))
        );
        panel.setLayout(null);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(0, 29, 1148, 155);
        panel.add(jScrollPane1);
        orderTable = new javax.swing.JTable();
        
        orderTable.setBackground(new java.awt.Color(192, 192, 192));
        orderTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);
        
        JLabel lblNewLabel = new JLabel("ORDER");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNewLabel.setBounds(552, 6, 45, 13);
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
            java.util.logging.Logger.getLogger(OrdersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersGUI().setVisible(true);
            }
        });
    }
    
    private void loadStaffId() {
    	tfStaffId.setText(Integer.toString(user.loginUser.getId()));
    }
    
    public void loadOrderList() {
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
		arr = orderBUS.getAllOrders();
		
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
    
	public void loadServiceList(){
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Id");
		dtm.addColumn("Name");
		dtm.addColumn("Price");
		
		serviceTable.setModel(dtm);
		
		ArrayList<ServiceDTO> arr = new ArrayList<ServiceDTO>();
		arr = serviceBUS.getAllServices();
		
		for(int i = 0; i < arr.size(); i++){
			ServiceDTO em = arr.get(i);
			
			int id = em.getServiceId();
			String name = em.getName();
			int price = em.getPrice();
			
			Object[] row = {id, name, price};
			
			dtm.addRow(row);
		}
	}
}
