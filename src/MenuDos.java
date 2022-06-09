import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import java.awt.event.*;
import java.awt.*;

public class MenuDos {
    public static void main(String[] args) {
        new MarcoMenu2();
    }
}
class MarcoMenu2 extends JFrame{
    public MarcoMenu2(){
        setVisible(true);
        setTitle("segundo menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,300,600,600);
        add(new LayerMenu2());
    }
}
class LayerMenu2 extends JPanel{
    public LayerMenu2(){
        setLayout(new BorderLayout());
        JMenuBar barramenu = new JMenuBar();
        fuenteswin = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fuente = new JMenu("fuente");JMenu estilo = new JMenu("estilo"); tamano = new JMenu("tamano");
        agregar_fuentes(fuenteswin);
        cursiva = new JMenuItem("cursiva"); cursiva.addActionListener(new OyenteEstilo()); estilo.add(cursiva);
        negrita = new JMenuItem("negrita"); negrita.addActionListener(new OyenteEstilo()); estilo.add(negrita);
        agregar_tamano();
        barramenu.add(fuente);barramenu.add(estilo);barramenu.add(tamano);
        add(barramenu,BorderLayout.NORTH);
        JPanel lamina_texto = new JPanel();
        lamina_texto.setLayout(new BorderLayout());
        texto = new JTextArea(20,30);
        texto.setLineWrap(true);
        lamina_texto.add(texto);
        add(lamina_texto,BorderLayout.CENTER);
        JMenuItem cursivae= new JMenuItem("cursiva");
        JPopupMenu menuem = new JPopupMenu();
        menuem.add(cursivae);
        texto.setComponentPopupMenu(menuem);

    }
    public void agregar_fuentes(String [] fuenteswin){  
        for(int i = 0 ; i < fuenteswin.length ; i++){
            JMenuItem itemfuente = new JMenuItem (fuenteswin[i]); itemfuente.addActionListener(new OyenteFuente()); fuente.add(itemfuente);
        }
    }
    public void agregar_tamano(){
        for (int i = 8 ; i < 50 ; i++){
            JMenuItem itemtamano = new JMenuItem(" "+ i); itemtamano.addActionListener(new OyenteTamano()); tamano.add(itemtamano);
        }
    }
    private class OyenteFuente implements ActionListener{
        public void actionPerformed (ActionEvent e){ 
            for(int i = 0 ; i < fuenteswin.length ; i++){
                if(e.getActionCommand()== fuenteswin[i]) texto.setFont(new Font(fuenteswin[i],texto.getFont().getStyle(),texto.getFont().getSize()));
            }
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
            for (int i = 8 ; i < 50 ; i++){
                if(e.getActionCommand() == " "+ i){
                    float x = i;
                    texto.setFont(texto.getFont().deriveFont(x));
                }
            }
            /* if(e.getSource()==doce) texto.setFont(texto.getFont().deriveFont(12f));
            if(e.getSource()==veinte) texto.setFont(texto.getFont().deriveFont(20f)); */
    }
    }   
    private JTextArea texto;
    private JMenuItem cursiva;
    private JMenuItem negrita;
    private JMenu fuente;
    private JMenu tamano;
    String fuenteswin [];
}