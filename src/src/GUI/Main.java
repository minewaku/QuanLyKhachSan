package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.StaffDTO;

import javax.swing.UIManager;

public class Main extends JFrame {
	public Main() {
	}
	private JPanel contentPane;

	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(false);
		LoginGUI frame = new LoginGUI();
		
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

}
