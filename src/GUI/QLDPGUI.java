package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLDPGUI extends javax.swing.JFrame {

    public QLDPGUI() {
        initComponents();
        QLDPGUI.setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setVisible(true);

    }

   
    @SuppressWarnings("unchecked")
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý đặt phòng");
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(192, 192, 192));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thông tin đặt phòng");

        jPanel2.setBackground(new java.awt.Color(192, 192, 192));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã phòng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số Điện Thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ngày nhận phòng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày trả phòng");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Loại phòng");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new ImageIcon(QLDPGUI.class.getResource("/bt/fix.jpg"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.setMaximumSize(new java.awt.Dimension(78, 31));
 
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new ImageIcon(QLDPGUI.class.getResource("/bt/add.jpg"))); // NOI18N
        jButton3.setText("Thêm");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new ImageIcon(QLDPGUI.class.getResource("/bt/delette.jpg"))); // NOI18N
        jButton1.setText("Xóa");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new ImageIcon(QLDPGUI.class.getResource("/bt/remove.jpg"))); // NOI18N
        jButton4.setText("Thoát");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addComponent(jButton3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(jLabel2)
        									.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        									.addComponent(jLabel4))
        								.addGap(25))
        							.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        								.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        									.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        									.addComponent(jLabel8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        									.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        								.addPreferredGap(ComponentPlacement.RELATED)))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel7)
        							.addGap(43)))
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jTextField4, 137, 137, Short.MAX_VALUE)
        						.addComponent(jTextField3, 137, 137, Short.MAX_VALUE)
        						.addComponent(jTextField2, 137, 137, Short.MAX_VALUE)
        						.addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(jTextField7, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        				.addComponent(jButton1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(43)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(37)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(38)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(39)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(33)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(35)
        			.addComponent(jButton3)
        			.addGap(18)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jButton1)
        			.addGap(18)
        			.addComponent(jButton4)
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
        jLabel9.setText("QUẢN LÝ ĐẶT PHÒNG");
        jLabel9.setOpaque(true);

        jTable1.setBackground(new java.awt.Color(192, 192, 192));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A.001", "Nguyễn Phước Luân", "0909090909", "Nam", "03/05/2023", "05/05/2023", "Vip"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Họ và tên", "Số điện thoại", "Giới tính", "Ngày nhận phòng", "Ngày trả phòng", "Loại phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(21, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
        					.addGap(437))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1176, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addGap(17)
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap(41, Short.MAX_VALUE)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)))
        			.addGap(33))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
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
            java.util.logging.Logger.getLogger(QLDPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDPGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
}
