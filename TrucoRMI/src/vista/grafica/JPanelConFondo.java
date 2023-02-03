package vista.grafica;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//...
 
public class JPanelConFondo extends JPanel {
 
    private Image imagen;
 
    //...
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
                        this);
 
        setOpaque(false);
        super.paint(g);
    }
 
    //...
    public JPanelConFondo(Image imagenInicial ) {
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
    }
}