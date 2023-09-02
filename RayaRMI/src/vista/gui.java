package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class gui extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		table = new JTable();
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Puntos");
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		panel_1.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		panel_1.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("New radio button");
		panel_1.add(rdbtnNewRadioButton_5);
		
		JButton btnNewButton = new JButton("Tirar carta");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		panel_2.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_2 = new JButton("Tirar Carta");
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_2 = new JLabel("cartagana");
		panel_7.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_5 = new JLabel("cartaperded");
		panel_8.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
	}

}
