package conexion_y_funciones;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Slider extends JFrame  implements ActionListener{
ImageIcon imagenes[];
JLabel l;
JButton b1,b2;
int i,l1;
//JPanel panel;
public Slider(ImageIcon _imagenes[])
{
    imagenes=_imagenes;
    setLayout(new BorderLayout( ));
    setSize(800, 700);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setVisible(true);
    JPanel panel=new JPanel(new FlowLayout());
    b1=new JButton("<<");
    b2=new JButton(">>");
    panel.add(b1);
    panel.add(b2);
    add(panel,BorderLayout.SOUTH);
    b1.addActionListener(this);
    b2.addActionListener(this);
    /*imagenes = new ImageIcon[2]; 
    imagenes[0] = new ImageIcon("c:/slide2.jpg");
    imagenes[1] = new ImageIcon("c:/slide3.jpg");*/
    l = new JLabel("",JLabel.CENTER); 
    add(l,BorderLayout.CENTER);
    l.setIcon(imagenes[0]);
    
    
}
public  void actionPerformed(ActionEvent e){
    if(e.getSource()==b1)
    {
        if(i==0)
        {
            JOptionPane.showMessageDialog(null,"Primera Imagen");
        }
        else
            {
            i=i-1;
            l.setIcon(imagenes[i]);
        }
    }
    if(e.getSource()==b2)
    {
        if(i==imagenes.length-1)
        {
            JOptionPane.showMessageDialog(null,"Ultima Imagen");
        }
        else
            {
            i=i+1;
            l.setIcon(imagenes[i]);
            }
        }
     }

 }