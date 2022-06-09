import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AreaDeClase {
    public static void main(String[] args) {
        new MarcoDeArea2();
    }
}
class MarcoDeArea2 extends JFrame{
    public MarcoDeArea2(){
        setVisible(true);
        setTitle("Prueba con area de texto 2");
        setBounds(500, 300, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        lamina_botones = new JPanel();
        boton_insertar = new JButton("Insertar");
        boton_insertar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                texto.append("Te felicito que bien actuas");
            }
        });
        lamina_botones.add(boton_insertar);
        boton_saltolinea = new JButton("Salto de linea?");
        boton_saltolinea.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !texto.getLineWrap();
                texto.setLineWrap(saltar);
                /* if(saltar)boton_saltolinea.setText("Quitar salto");
                else { boton_saltolinea.setText("Salto linea");} */
                boton_saltolinea.setText(saltar ? "Quitar salto" : "Salto linea");
            }
        });     
        lamina_botones.add(boton_saltolinea);
        add(lamina_botones,BorderLayout.SOUTH);
        texto = new JTextArea(8,20); 
        lamina_barra = new JScrollPane(texto);
        add(lamina_barra,BorderLayout.CENTER);

    }
    private JPanel lamina_botones;
    private JButton boton_insertar;
    private JButton boton_saltolinea;
    private JTextArea texto;
    private JScrollPane lamina_barra;
}