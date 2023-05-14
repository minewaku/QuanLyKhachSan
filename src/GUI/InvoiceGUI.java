package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import BUS.OrdersBUS;
import BUS.PaymentBUS;
import BUS.ReservationsBUS;
import DTO.OrdersDTO;
import DTO.PaymentDTO;
import DTO.ReservationsDTO;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class InvoiceGUI extends JFrame{
	PaymentDTO payment = new PaymentDTO();
	
	private JTextField tfPaymentId;
	private JTable paymentTable;
	private JTable reservationTable;
	private JTable orderTable;
	JLabel lblError = new JLabel("New label");
	
	private PaymentBUS paymentBUS = new PaymentBUS();
	private ReservationsBUS reservationBUS = new ReservationsBUS();
	private OrdersBUS orderBUS = new OrdersBUS();
	
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		InvoiceGUI frame = new InvoiceGUI();
		
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public InvoiceGUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		tfPaymentId = new JTextField();
		panel.add(tfPaymentId);
		tfPaymentId.setColumns(10);
		
		JButton findBtn = new JButton("find");
		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPaymentId.getText().trim().equals(""))
						lblError.setText("Vui lòng nhập đủ thông tin");
					
					else {
						PaymentDTO em = new PaymentDTO();
						em.setPaymentId(Integer.parseInt(tfPaymentId.getText().trim()));
						
						lblError.setText(paymentBUS.searchPayment(em));
						loadPayment();
						loadReservation();
						loadOrder();
						
					}	
				} catch (NumberFormatException ex) {
					lblError.setText("Xảy ra lỗi");
				}
			}
		});
		panel.add(findBtn);
		
		JButton payBtn = new JButton("pay");
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(payment.getStatus() == true)
					lblError.setText("Hóa đơn đã thanh toán");
				
				else {
					paymentBUS.pay(payment);
					loadPayment();
					loadReservation();
					loadOrder();
				}
				
			}
		});
		panel.add(payBtn);
		
		JButton reportBtn = new JButton("report");
		reportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(payment.getStatus() == false)
					lblError.setText("Hóa đơn chưa thanh toán");
				else {
					
				}
				
			}
		});
		panel.add(reportBtn);
		
		lblError.setForeground(new Color(255, 0, 128));
		panel.add(lblError);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane paymentPane = new JScrollPane();
		paymentPane.setPreferredSize(new Dimension(800, 260));
		panel_1.add(paymentPane, BorderLayout.NORTH);
		
		paymentTable = new JTable();
		paymentTable.setPreferredSize(new Dimension(800, 260));
		paymentPane.add(paymentTable);
	    paymentPane.setViewportView(paymentTable);
		
		JScrollPane reservationPane = new JScrollPane();
		reservationPane.setPreferredSize(new Dimension(800, 260));
		panel_1.add(reservationPane, BorderLayout.CENTER);
		
		reservationTable = new JTable();
		reservationTable.setPreferredSize(new Dimension(800, 260));
		reservationPane.add(reservationTable);
		reservationPane.setViewportView(reservationTable);
		
		JScrollPane orderPane = new JScrollPane();
		orderPane.setPreferredSize(new Dimension(800, 260));
		panel_1.add(orderPane, BorderLayout.SOUTH);
		
		orderTable = new JTable();
		orderTable.setPreferredSize(new Dimension(800, 260));
		orderPane.add(orderTable);
		orderPane.setViewportView(orderTable);
	
	}
	
	
	private void reportpayment() {
		try {
	      	JFileChooser jf = new JFileChooser();
	    	jf.showSaveDialog(null);
	    	File saveFile = jf.getSelectedFile();
	    	if(saveFile != null) {
	    		saveFile = new File(saveFile.toString() + ".pdf");
	    		String path = saveFile.getAbsolutePath();
	    		
	    		PdfWriter pdfWritter = new PdfWriter(path);
	    		PdfDocument pdfDocument = new PdfDocument(pdfWritter);
	    		pdfDocument.setDefaultPageSize(PageSize.A4);
	    		Document document = new Document(pdfDocument);
	    		
	    		Table titleTable = new Table(new float[] {285f, 435f}); 
	    		titleTable.addCell(new Cell().add(new Paragraph("PAYMENT").setBorder(Border.NO_BORDER).setBold()));
	    		Table nestedTable = new Table(new float[] {143f, 143f});
	    		nestedTable.addCell(new Cell().add(new Paragraph("Payment Id.").setBold().setBorder(Border.NO_BORDER).setBold()));
	    		nestedTable.addCell(new Cell().add(new Paragraph(Integer.toString(payment.getPaymentId())).setBorder(Border.NO_BORDER).setBold()));
	    		nestedTable.addCell(new Cell().add(new Paragraph("Create date.").setBold().setBorder(Border.NO_BORDER).setBold()));
	    		nestedTable.addCell(new Cell().add(new Paragraph(payment.getCreateDate())).setBorder(Border.NO_BORDER).setBold());
	    		nestedTable.addCell(new Cell().add(new Paragraph("Payment date.").setBold().setBorder(Border.NO_BORDER).setBold()));
	    		nestedTable.addCell(new Cell().add(new Paragraph(payment.getPaymentDate()).setBorder(Border.NO_BORDER).setBold()));
	    		
	    		Table reservationTable = new Table(new float[] {80f, 80f, 80f, 80f, 80f, 80f});
	    		reservationTable.addCell(new Cell().add(new Paragraph("paymentId")));
	    		reservationTable.addCell(new Cell().add(new Paragraph("reservationId")));
	    		reservationTable.addCell(new Cell().add(new Paragraph("roomId")));
	    		reservationTable.addCell(new Cell().add(new Paragraph("arrivalDate")));
	    		reservationTable.addCell(new Cell().add(new Paragraph("rentDate")));
	    		reservationTable.addCell(new Cell().add(new Paragraph("amount")));
	    		document.add(reservationTable);
	    		
	    		System.out.println("tao thanh cong");
	    		
	    		document.close();
	    	}
		} catch (FileNotFoundException ex) {System.out.println(ex);}
		
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
		  
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
