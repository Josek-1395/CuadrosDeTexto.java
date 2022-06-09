import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import java.awt.event.*;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
        new MarcoMenu();
    }
}
class MarcoMenu extends JFrame{
    public MarcoMenu(){
        setVisible(true);
        setTitle("primer menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,300,600,600);
        add(new LayerMenu());
    }
}
class LayerMenu extends JPanel{
    public LayerMenu(){
        setLayout(new BorderLayout());
        JMenuBar barramenu = new JMenuBar();
        JMenu fuente = new JMenu("fuente");JMenu estilo = new JMenu("estilo");JMenu tamano = new JMenu("tamano");
        arial = new JCheckBoxMenuItem("arial", new ImageIcon("icons/blueball.png"));arial.setHorizontalTextPosition(SwingConstants.LEFT); arial.addActionListener(new OyenteFuente()); fuente.add(arial);
        serif = new JRadioButtonMenuItem("serif", new ImageIcon("icons/redball.png"));serif.addActionListener(new OyenteFuente()); fuente.add(serif);
        cursiva = new JMenuItem("cursiva"); cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK)); cursiva.addActionListener(new OyenteEstilo()); estilo.add(cursiva);
        negrita = new JMenuItem("negrita"); negrita.addActionListener(new OyenteEstilo()); estilo.add(negrita);
        doce = new JMenuItem("12"); doce.addActionListener(new OyenteTamano()); tamano.add(doce);
        veinte = new JMenuItem("20"); veinte.addActionListener(new OyenteTamano()); tamano.add(veinte);
        barramenu.add(fuente);barramenu.add(estilo);barramenu.add(tamano);
        add(barramenu,BorderLayout.NORTH);
        JPanel lamina_texto = new JPanel();
        lamina_texto.setLayout(new BorderLayout());
        texto = new JTextArea(20,30);
        texto.setLineWrap(true);
        lamina_texto.add(texto);
        add(lamina_texto,BorderLayout.CENTER);

    }
    private class OyenteFuente implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (e.getSource()== arial) texto.setFont(new Font("Arial",texto.getFont().getStyle(),texto.getFont().getSize()));
            if (e.getSource()== serif) texto.setFont(new Font("Serif",texto.getFont().getStyle(),texto.getFont().getSize()));
        }
    }
    private class OyenteEstilo implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==cursiva) texto.setFont(texto.getFont().deriveFont(Font.ITALIC));
            if(e.getSource()==negrita) texto.setFont(texto.getFont().deriveFont(Font.BOLD));
    }
    }
    private class OyenteTamano implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==doce) texto.setFont(texto.getFont().deriveFont(12f));
            if(e.getSource()==veinte) texto.setFont(texto.getFont().deriveFont(20f));
    }
    }   
    private JTextArea texto;
    private JMenuItem arial;
    private JMenuItem serif;
    private JMenuItem cursiva;
    private JMenuItem negrita;
    private JMenuItem doce;
    private JMenuItem veinte;
}