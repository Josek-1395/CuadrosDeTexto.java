import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ComboBox {
    public static void main(String[] args) {
        new MarcoCombo();
    }
}
class MarcoCombo extends JFrame{
    public MarcoCombo (){
        setVisible(true);
        setTitle("Prueba ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,400,400,400);
        add(new LayerCombo());
    }
}
class LayerCombo extends JPanel{
    public LayerCombo(){
        setLayout(new BorderLayout());
        texto = new JLabel("hola mundo");
        texto.setFont(new Font("Serif",0,18));
        add(texto,BorderLayout.CENTER);
        JPanel lamina_combo = new JPanel();
        combo = new JComboBox();
        //combo.setEditable(true);
        //combo.addItem("Serif");combo.addItem("SansSerif");combo.addItem("Monospaced");combo.addItem("Dialog");
        combo.addActionListener(new oyente());
        lamina_combo = new JPanel();
        lamina_combo.add(combo);
        add(lamina_combo,BorderLayout.NORTH);

    }
    private class oyente implements ActionListener{
        public void actionPerformed(ActionEvent e){
            texto.setFont(new Font((String)combo.getSelectedItem(),0,30));
        }
    }
    private JLabel texto;
    private JComboBox combo;
    private JPanel lamina_combo;
}