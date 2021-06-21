package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fondo extends javax.swing.JPanel{

    String fondo;

    public Fondo(String fondo) {
          this.setSize(400, 280);
          putbackground (fondo);
         }

         @Override
         public void paintComponent(Graphics g) {
          Dimension tamanio = getSize();
          ImageIcon imagenFondo = new ImageIcon(getClass().getResource(fondo));
          g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
          setOpaque(false);
          super.paintComponent(g);
          }
         
         public void putbackground (String fondo) {
             this.fondo=fondo;
         }
}