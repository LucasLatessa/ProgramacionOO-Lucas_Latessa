package vista.grafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;import java.awt.GridLayout;
import java.awt.FlowLayout;

public class VentanaInicioSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAddJug;
	private JPanel panel;
	private JTextField textUsuario;
	private JPanel panel_1;
	private JLabel lblUsuario;
	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		lblUsuario = new JLabel("Ingrese usuario");
		panel_1.add(lblUsuario);
		
		panel = new JPanel();
		contentPane.add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 10, 0);
		panel.setLayout(fl_panel);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(15);
		panel.add(textUsuario);
		
		btnAddJug = new JButton("Agregar jugador");
		panel.add(btnAddJug);
		SwingUtilities.getRootPane(btnAddJug).setDefaultButton(btnAddJug);
	}
	public void onClickAddJug(ActionListener listener) {
		this.btnAddJug.addActionListener(listener);
	}
	public String getTextUsuario() {
		return this.textUsuario.getText();
	}
	public void nombreRepetido() {
		this.lblUsuario.setText("Ingrese usuario(El nombre de usuario ya esta usado)");
	}
}
