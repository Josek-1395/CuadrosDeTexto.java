import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class checkbox {
    public static void main(String[] args) {
        new MarcoCheck();
    }
}
class MarcoCheck extends JFrame{
    public MarcoCheck(){
        setVisible(true);
        setTitle("Prueba con Checkboxes");
        setBounds(600, 400, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LayerCheck());
    }
}
class LayerCheck extends JPanel{
    public LayerCheck(){
        setLayout(new BorderLayout());
        Font fuente = new Font("Serif", Font.PLAIN,24);
        texto = new JLabel("la traigo pa varela pa tomar de la rica, alta colita");
        texto.setFont(fuente);
        JPanel laminatexto = new JPanel();
        laminatexto.add(texto);
        add(laminatexto,BorderLayout.CENTER);
        italic = new JCheckBox("Cursiva");
        bold = new JCheckBox("Negrita");
        italic.addActionListener(new oyenteCheck());
        bold.addActionListener(new oyenteCheck());
        JPanel lamina_checks = new JPanel();
        lamina_checks.add(italic);
        lamina_checks.add(bold);
        add(lamina_checks,BorderLayout.SOUTH);

    }
    private class oyenteCheck implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int tipo = 0;
            if(italic.isSelected())tipo += Font.ITALIC;
            if(bold.isSelected())tipo += Font.BOLD;
            texto.setFont(new Font("Serif",tipo,24));
        }
    }
    private JLabel texto;
    private JCheckBox italic, bold;
}