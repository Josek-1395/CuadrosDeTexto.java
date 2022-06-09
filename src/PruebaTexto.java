import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PruebaTexto {
    public static void main(String[] args) {
        new MarcoDeTexto();
    }
}
class MarcoDeTexto extends JFrame {
    public MarcoDeTexto(){
        setVisible(true);
        setTitle("Pruebas con cuadros de texto");
        setBounds(600, 400, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LayerDeTexto());
    }
}
class LayerDeTexto extends JPanel{
    public LayerDeTexto(){
        setLayout(new BorderLayout());
        JPanel layer2 = new JPanel();
        layer2.setLayout(new FlowLayout());
        resultado = new JLabel("",JLabel.CENTER);
        JLabel texto1 = new JLabel("Ingrese direccion de Mail:");
        layer2.add(texto1);
        campo1 = new JTextField("Ingrese direccion de Mail:",20);
        layer2.add(campo1);
        add(resultado,BorderLayout.CENTER);
        JButton boton1 = new JButton("Confirmar");
        DameTexto evento1 = new DameTexto();
        boton1.addActionListener(evento1);
        layer2.add(boton1);
        add(layer2,BorderLayout.NORTH);
    }
    private class DameTexto implements ActionListener{
        public void actionPerformed (ActionEvent e){
            short correcto = 0;
            String entrada = campo1.getText().trim();
            for(int i = 0 ; i < entrada.length() ; i++){
                if(entrada.charAt(i) == '@'){correcto++;}
            }
            if (correcto != 1) resultado.setText("Incorrecto");
            else {resultado.setText("Mail valido");;}

        }
    }
     private JTextField campo1;
     private JLabel resultado;
}
