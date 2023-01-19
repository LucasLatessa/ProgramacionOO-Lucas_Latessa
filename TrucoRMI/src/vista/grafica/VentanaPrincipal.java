package vista.grafica;
import modelo.IJuego;
import modelo.IJugador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		table = new JTable();
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Puntos");
		lblNewLabel.setAlignmentY(2.0f);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JRadioButton carta1 = new JRadioButton("Carta1");
		JRadioButton carta2 = new JRadioButton("Carta2");
		JRadioButton carta3 = new JRadioButton("Carta3");
		ButtonGroup grupo= new ButtonGroup(); 
		grupo.add(carta1);
		grupo.add(carta2);
		grupo.add(carta3);
		panel_2.add(carta1);
		panel_2.add(carta2);
		panel_2.add(carta3);
		
		JButton buttonTirarCarta = new JButton("Tirar Carta");
		buttonTirarCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton seleccionado=getSelection(grupo);
				seleccionado.setVisible(false);
				switch(seleccionado.getText()) {
				case "Carta1":
					break;
				case "Carta2":
					break;
				case "Carta3":
				}
			}
		});
		panel_2.add(buttonTirarCarta);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(130, 130, 59, 24);
		panel_5.add(panel_6);
		
		JLabel cartaGana = new JLabel("");
		panel_6.add(cartaGana);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(200, 130, 69, 24);
		panel_5.add(panel_9);
		
		JLabel cartaPerdedora = new JLabel("");
		panel_9.add(cartaPerdedora);
		cartaPerdedora.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel nombreContra = new JLabel("New label");
		panel_4.add(nombreContra, BorderLayout.NORTH);
		
		JLabel nombreUsuario = new JLabel("New label");
		panel_4.add(nombreUsuario, BorderLayout.SOUTH);
	}
	public static JRadioButton getSelection(ButtonGroup group)
	{
	        for (Enumeration e=group.getElements(); e.hasMoreElements(); )
	        {
	            JRadioButton b = (JRadioButton)e.nextElement();
	            if (b.getModel() == group.getSelection())
	            {
	                return b;
	            }
	        }

	        return null;
	}
	public void onClickEnviar(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	public Object getTextoMensaje() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTextoMensaje(String string) {
		// TODO Auto-generated method stub
		
	}


}
