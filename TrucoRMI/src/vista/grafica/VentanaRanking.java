package vista.grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JLabel;

public class VentanaRanking extends JFrame{
	DefaultTableModel modelo;
	JTable tabla;
	public VentanaRanking() {
		
		setTitle("Ranking");
		setBounds(100, 100, 300, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Cantidad partidas ganadas");
        tabla = new JTable (modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);    
       
    }

	public void mostrarTabla(ArrayList listaGanadores,ArrayList listaCantidad) {
		modelo.setRowCount(0);
		for(int x=0;x<listaGanadores.size();x++) {
			Object[] data = 
					 {listaGanadores.get(x), listaCantidad.get(x)};
			modelo.addRow(data);;
		}
	}

}
