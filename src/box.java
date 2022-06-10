import java.awt.*;
import javax.swing.*;
public class box {
    public static void main(String[] args) {
        new MarcoBox();
    }
}
class MarcoBox extends JFrame{
    public MarcoBox(){
        setVisible(true);
        setTitle("Box Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 400, 200, 200);
        JLabel rotulo1 = new JLabel("Nombre");
        JTextField texto1 = new JTextField(10);
        texto1.setMaximumSize(texto1.getPreferredSize());
        Box cajah1 = Box.createHorizontalBox();
        cajah1.add(rotulo1); cajah1.add(Box.createHorizontalStrut(10)); cajah1.add(texto1);
        
        JLabel rotulo2 = new JLabel("Contrasenia");
        JTextField texto2 = new JTextField(10);
        texto2.setMaximumSize(texto2.getPreferredSize());
        Box cajah2 = Box.createHorizontalBox();
        cajah2.add(rotulo2); cajah2.add(Box.createHorizontalStrut(10)); cajah2.add(texto2);
        JButton boton1 = new JButton("OK");
        JButton boton2 = new JButton("Cancelar");
        Box cajah3 =  Box.createHorizontalBox();
        cajah3.add(boton1); cajah3.add(Box.createGlue()) ; cajah3.add(boton2);
        Box cajav = Box.createVerticalBox();
        cajav.add(cajah1); cajav.add(cajah2); cajav.add(cajah3);
        add(cajav, BorderLayout.CENTER);    
    }
}