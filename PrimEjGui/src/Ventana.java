import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Ventana implements ActionListener{
		JFrame frame;
		JLabel label;
	public Ventana() {
		frame=new JFrame("titulo");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=(JPanel)frame.getContentPane(); 
		panel.setLayout(new BorderLayout());//;<BorderLayout.NORTH,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.SOUTH>;
		JMenuBar menuGeneral=new JMenuBar();
		JMenu menuArchivo=new JMenu("archivo");
		JMenu menuJuego=new JMenu("juego");
		menuGeneral.add(menuArchivo);
		menuGeneral.add(menuJuego);
		JMenuItem mSalir=new JMenuItem("salir");
		menuArchivo.add(mSalir);
		frame.setJMenuBar(menuGeneral);//seteo barra de arriba(opciones) 
		//panel.setLayout(new FlowLayout());
		//panel.setLayout(new GridLayout(3,2));//<MATRIZ DE 3X2>; (grid con 2 parametros mas es espacio)
		//panel.setLayout(new GridLayout(3,2,5,5));//<MATRIZ DE 3X2 de 5 en 5(espacios)>
		//panel.setLayout(new BoxLayout());
		label=new JLabel("etiqueta");
		panel.add(label,BorderLayout.NORTH);
		JPanel menu=new JPanel();
		menu.setLayout(new GridLayout(4,3));//divido el panel que luego va a estar en el Este en una matriz de 4x3
		
		JButton boton1= new JButton("boton1");
		boton1.addActionListener(this);//cuando tocamos boton, manda a la accion y se imprime comando
		JButton boton2= new JButton("boton2");
		boton2.addActionListener(this);
		JButton boton3= new JButton("boton");
		JButton boton4= new JButton("boton 4");
		boton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Se elijio opcion 4(mejor forma de implementar)");
				
			}
			
		});
		panel.add(label,BorderLayout.NORTH);
		menu.add(boton1);
		menu.add(boton2);
		menu.add(boton4);
		//panel.add(boton3);
		//panel.add(boton4);
		JPanel menu2=new JPanel();
		menu2.setLayout(new FlowLayout());//meto botones en un panel flow para que cuando agrando ventana no se agranden
		menu2.add(menu);
		panel.add(menu2,BorderLayout.EAST);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando= e.getActionCommand();
		if (comando.equals("boton1")){
			label.setText("se elijio boton 1");//cuando pasa algo, se va a actualizar esto
		
	}else{
		label.setText("algo paso(se elijio algo que no es opcion 1)");}
	}

}
 