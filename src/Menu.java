
import javax.swing.*;
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
        JToolBar barra = new JToolBar();
        barra.setOrientation(1); //1 vertical y 0 horizontal
        negritabarra = new JButton("Negrita", new ImageIcon("icons/negrita.png"));
        cursivabarra = new JButton("cursiva", new ImageIcon("icons/cursiva.png"));
        azulbarra = new JButton("Azul", new ImageIcon("icons/azul.png"));
        rojobarra = new JButton("Rojo", new ImageIcon("icons/rojo.png"));
        cursivabarra.addActionListener(new OyenteEstilo());
        negritabarra.addActionListener(new OyenteEstilo());
        barra.add(azulbarra); barra.add(rojobarra);
        barra.add(negritabarra); barra.add(cursivabarra);
        add(barra,BorderLayout.WEST);

    }
    private class OyenteFuente implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (e.getSource()== arial) texto.setFont(new Font("Arial",texto.getFont().getStyle(),texto.getFont().getSize()));
            if (e.getSource()== serif) texto.setFont(new Font("Serif",texto.getFont().getStyle(),texto.getFont().getSize()));
        }
    }
    private class OyenteEstilo implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==cursiva || e.getSource() == cursivabarra) texto.setFont(texto.getFont().deriveFont(Font.ITALIC));
            if(e.getSource()==negrita || e.getSource() == negritabarra) texto.setFont(texto.getFont().deriveFont(Font.BOLD));
    }
    }
    private class OyenteTamano implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource()==doce) texto.setFont(texto.getFont().deriveFont(12f));
            if(e.getSource()==veinte) texto.setFont(texto.getFont().deriveFont(20f));
    }
    }   
    JButton rojobarra;
    JButton negritabarra;
    JButton cursivabarra;
    JButton azulbarra;
    private JTextArea texto;
    private JMenuItem arial;
    private JMenuItem serif;
    private JMenuItem cursiva;
    private JMenuItem negrita;
    private JMenuItem doce;
    private JMenuItem veinte;
}