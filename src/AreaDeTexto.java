import javax.swing.*;
import java.awt.event.*;
//import java.awt.*;
public class AreaDeTexto {
    public static void main(String[] args) {
        new MarcoDeArea();
    }
}
class MarcoDeArea extends JFrame{
    public MarcoDeArea(){
        setVisible(true);
        setTitle("Area de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 300, 500, 500);
        add(new LayerDeArea());
    }
}
class LayerDeArea extends JPanel{
    public LayerDeArea(){
        area1 = new JTextArea(8,20);
        JScrollPane laminascroll = new JScrollPane(area1); //para que el area de texto tenga scrolls
        area1.setLineWrap(true);   //el salto de linea respeta los bordes definidos
        
        add(laminascroll);
        JButton aceptar = new JButton("OK");
        aceptar.addActionListener(new oyente());
        add(aceptar);

    }
    private class oyente implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println(area1.getText());
        }
    }
    private JTextArea area1;
}
