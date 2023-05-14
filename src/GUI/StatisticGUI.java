/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.PaymentBUS;
import BUS.RoomBUS;
import BUS.ServiceBUS;
import DAO.PaymentDAO;
import DAO.RoomDAO;
import DAO.ServiceDAO;
import DTO.PaymentDTO;
import DTO.RoomDTO;
import DTO.ServiceDTO;

/**
 *
 * @author ADMIN
 */
public class StatisticGUI extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton roomStBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfFrom;
    private javax.swing.JTextField tfTo;
    private javax.swing.JLabel lblContent;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton paymentStBtn;
    private javax.swing.JButton serviceStBtn;
    private JLabel lblError;
    // End of variables declaration//GEN-END:variables
    
	PaymentBUS paymentBUS = new PaymentBUS();
	RoomBUS roomBUS = new RoomBUS();
	ServiceBUS serviceBUS = new ServiceBUS();
	
	PaymentDAO payment = new PaymentDAO();
	RoomDAO room = new RoomDAO();
	ServiceDAO service = new ServiceDAO();
	ArrayList<PaymentDTO> arr = new ArrayList<PaymentDTO>();
	
    public StatisticGUI() {
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

        lblContent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        paymentStBtn = new javax.swing.JButton();
        serviceStBtn = new javax.swing.JButton();
        roomStBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfFrom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfTo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 192, 192));

        lblContent.setBackground(new java.awt.Color(192, 192, 192));
        lblContent.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContent.setText("STATISTIC");

        table.setBackground(new java.awt.Color(192, 192, 192));
        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(table);

        paymentStBtn.setText("Highest payment");
        paymentStBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfFrom.getText().trim().equals("") || tfTo.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					else {
						String from = tfFrom.getText().trim();
						String to = tfTo.getText().trim();
						
						if (payment.checkIfDateIsValid(from) && payment.checkIfDateIsValid(to)) {
							if(payment.compareDate(from, to)) {
								loadPaymentStatistic(from, to);
								lblError.setText("");
							}
							else {
								lblError.setText("Ngày đầu phải bé hơn ngày cuối");
							}
						}
						else
							lblError.setText("Ngày không hợp lệ(yyyy-MM-dd)");
					}
				} catch (NumberFormatException ex) {
					System.out.println(ex);
				}
			}
		});
        
        serviceStBtn.setText("Most ordered service");
        serviceStBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				try {
					if (tfFrom.getText().trim().equals("") || tfTo.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					else {
						String from = tfFrom.getText().trim();
						String to = tfTo.getText().trim();
						
						if (service.checkIfDateIsValid(from) && service.checkIfDateIsValid(to)) {
							if(service.compareDate(from, to)) {
								loadServiceStatistic(from, to);
								lblError.setText("");
							}
							else {
								lblError.setText("Ngày đầu phải bé hơn ngày cuối");
							}
						}
						else
							lblError.setText("Ngày không hợp lệ(yyyy-MM-dd)");
					}
				} catch (NumberFormatException ex) {
					System.out.println(ex);
				}
			}
		});

        roomStBtn.setText("Most booked room");
        roomStBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				try {
					if (tfFrom.getText().trim().equals("") || tfTo.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					else {
						String from = tfFrom.getText().trim();
						String to = tfTo.getText().trim();
						
						if (room.checkIfDateIsValid(from) && room.checkIfDateIsValid(to)) {
							if(room.compareDate(from, to)) {
								loadRoomStatistic(from, to);
								lblError.setText("");
							}
							else {
								lblError.setText("Ngày đầu phải bé hơn ngày cuối");
							}
						}
						else
							lblError.setText("Ngày không hợp lệ(yyyy-MM-dd)");
					}
				} catch (NumberFormatException ex) {
					System.out.println(ex);
				}
			}
		});

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

        exportBtn.setText("export");
        exportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	JFileChooser jf = new JFileChooser();
                	jf.showSaveDialog(null);
                	File saveFile = jf.getSelectedFile();
                	if(saveFile != null) {
                		saveFile = new File(saveFile.toString() + ".xlsx");
                		Workbook wb = new XSSFWorkbook();
                		Sheet sheet = wb.createSheet("payment");
                		
                		Row rowCol = sheet.createRow(0);
                		for(int i = 0; i < table.getColumnCount(); i++) {
                			Cell cell = rowCol.createCell(i);
                			cell.setCellValue(table.getColumnName(i));
                		}
                		
                		for(int j = 0; j < table.getRowCount(); j++) {
                			Row row = sheet.createRow(j);
                			for(int k = 0; k < table.getColumnCount(); k++) {
	                			Cell cell = row.createCell(k);
	                			if(table.getValueAt(j, k) != null) 
	                				cell.setCellValue(table.getValueAt(j, k).toString());
                			}
                		}
                		
                		FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                		wb.write(out);
                		wb.close();
                		out.close();
                		openFile(saveFile.toString());
                	}
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                	System.out.println(ex);
                }
			}
		});

        refreshBtn.setText("refresh");
    	refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEmpty();
			}
		});

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("From");

        tfFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("To");

        tfTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        
        lblError = new JLabel("");
        lblError.setForeground(new Color(255, 0, 128));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(refreshBtn)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(paymentStBtn, GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(serviceStBtn, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(roomStBtn, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE))
        				.addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(exportBtn))
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblContent, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(116)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tfFrom, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tfTo, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(tfFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2)
        				.addComponent(tfTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblError))
        			.addGap(8)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(paymentStBtn)
        						.addComponent(serviceStBtn)
        						.addComponent(roomStBtn))
        					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        					.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        				.addComponent(exportBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(refreshBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticGUI().setVisible(true);
            }
        });
    }

    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
    private void loadPaymentStatistic(String from, String to) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("paymentId");
		dtm.addColumn("cutomerId");
		dtm.addColumn("staffId");
		dtm.addColumn("create date");
		dtm.addColumn("payment date");
		dtm.addColumn("total");
		dtm.addColumn("status");
		table.setModel(dtm);
		
		ArrayList<PaymentDTO> arr = new ArrayList<PaymentDTO>();
		arr = paymentBUS.mostPayment(from, to);
		
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
    
    private void loadRoomStatistic(String from, String to) {
     	DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("roomId");
		dtm.addColumn("size");
		dtm.addColumn("type");
		dtm.addColumn("totalRent");
		
		table.setModel(dtm);
		
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		arr = roomBUS.mostRoom(from, to);
		
		for(int i = 0; i < arr.size(); i++){
			RoomDTO em = arr.get(i);
			
			int roomId = em.getRoomId();
			String size = em.getSize();
			String type = em.getType();
			int totalRent = em.getPrice();
			
			Object[] row = {roomId, size, type, totalRent};
			
			dtm.addRow(row);
		}
		
    }
    
    private void loadServiceStatistic(String from, String to) {
    	DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("serviceId");
		dtm.addColumn("name");
		dtm.addColumn("total");

		table.setModel(dtm);
		
		ArrayList<ServiceDTO> arr = new ArrayList<ServiceDTO>();
		arr = serviceBUS.mostOrder(from, to);
		
		for(int i = 0; i < arr.size(); i++){
			ServiceDTO em = arr.get(i);
			
			int serviceId = em.getServiceId();
			String name = em.getName();
			int total = em.getPrice();
			
			Object[] row = {serviceId, name, total};
			
			dtm.addRow(row);
		}
		
    }
	
	private void loadEmpty() {
		DefaultTableModel dtm = new DefaultTableModel();
		table.setModel(dtm);
	}
    
}
