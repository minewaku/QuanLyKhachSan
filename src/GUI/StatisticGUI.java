package GUI;

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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import DTO.PaymentDTO;
import DTO.RoomDTO;
import DTO.ServiceDTO;
public class StatisticGUI extends JFrame{
	
	PaymentBUS paymentBUS = new PaymentBUS();
	RoomBUS roomBUS = new RoomBUS();
	ServiceBUS serviceBUS = new ServiceBUS();
	ArrayList<PaymentDTO> arr = new ArrayList<PaymentDTO>();
	
	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(false);
		StatisticGUI frame = new StatisticGUI();
		
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	public StatisticGUI() {
		initComponents();
		loadPaymentList();
	}
	
	public void initComponents() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Payment");
		
		JButton serviceStBtn = new JButton("ServiceStatistic");
		serviceStBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadServiceStatistic();
			}
		});
		
		JButton roomStBtn = new JButton("RoomStatistic");
		roomStBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRoomStatistic();
			}
		});
		
		JButton paymentStBtn = new JButton("PaymentStatistic");
		paymentStBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPaymentStatistic();
			}
		});
		
		JButton refreshBtn = new JButton("New button");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPaymentList();
			}
		});
		
		JButton exportBtn = new JButton("New button");
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
		
		JButton exitBtn = new JButton("New button");
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(serviceStBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(roomStBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(paymentStBtn))
						.addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(exportBtn)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addComponent(exportBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(serviceStBtn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(roomStBtn)
								.addComponent(paymentStBtn))
							.addGap(18)
							.addComponent(exitBtn)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
	
	private JTable table;
	
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
    private void loadPaymentStatistic() {
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
		arr = paymentBUS.mostPayment("1", "1", "2000");
		
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
    
    private void loadRoomStatistic() {
     	DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("roomId");
		dtm.addColumn("size");
		dtm.addColumn("type");
		dtm.addColumn("totalRent");
		
		table.setModel(dtm);
		
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		arr = roomBUS.mostRoom("1", "1", "2000");
		
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
    
    private void loadServiceStatistic() {
    	DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("serviceId");
		dtm.addColumn("name");
		dtm.addColumn("total");

		table.setModel(dtm);
		
		ArrayList<ServiceDTO> arr = new ArrayList<ServiceDTO>();
		arr = serviceBUS.mostOrder("1", "1", "2000");
		
		for(int i = 0; i < arr.size(); i++){
			ServiceDTO em = arr.get(i);
			
			int serviceId = em.getServiceId();
			String name = em.getName();
			int total = em.getPrice();
			
			Object[] row = {serviceId, name, total};
			
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
		table.setModel(dtm);
		
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
