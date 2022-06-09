import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.*;
public class RadioBox {
    public static void main(String[] args) {
        new MarcoRadio();
    }
}
class MarcoRadio extends JFrame{
    public MarcoRadio(){
        setVisible(true);
        setTitle("Prueba con RadioBoxes");
        setBounds(400, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LayerRadio());
    }
}
class LayerRadio extends JPanel{
    public LayerRadio(){
        setLayout(new BorderLayout());
        texto = new JLabel("hola mai vega");
        //texto.setFont(new Font("Serif",0,12));
        add(texto,BorderLayout.CENTER);

        grupo1 = new ButtonGroup();
        boton1 = new JRadioButton("Pequeño",false);
        boton2 = new JRadioButton("Mediano",false);
        boton3 = new JRadioButton("Grande", false);
        boton4 = new JRadioButton("Gigante", false);
        boton1.addActionListener(new OyenteRadio());boton2.addActionListener(new OyenteRadio());boton3.addActionListener(new OyenteRadio());boton4.addActionListener(new OyenteRadio());
        grupo1.add(boton1);grupo1.add(boton2);grupo1.add(boton3);grupo1.add(boton4);
         lamina_radio = new JPanel();
        lamina_radio.add(boton1);lamina_radio.add(boton2);lamina_radio.add(boton3);lamina_radio.add(boton4);
        add(lamina_radio,BorderLayout.SOUTH);

    }
    /* 
    public void colocar_boton (String nombre, boolean seleccionado, final int tamano){
        JRadioButton boton = new JRadioButton(nombre,seleccionado);
        grupo1.add(boton);
        lamina_Radio.add(boton);
        ActionListener oyente = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                texto.setFont(new Font("serif",0,tamano))
            }
        };
        boton.addActionListener(oyente);

    }
    */
    private class OyenteRadio implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==boton1) texto.setFont(new Font("Serif",0,10));
            if(e.getSource()==boton2)texto.setFont(new Font("Serif",0,15));
            if(e.getSource()==boton3)texto.setFont(new Font("Serif",0,20));
            if(e.getSource()==boton4)texto.setFont(new Font("Serif",0,45));
        }
    }
    private JLabel texto;
    private JRadioButton boton1,boton2,boton3,boton4;
    private ButtonGroup grupo1;
    JPanel lamina_radio;
} 