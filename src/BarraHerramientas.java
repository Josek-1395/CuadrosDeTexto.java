import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BarraHerramientas{
    public static void main(String[] args) {
        new Barra_Herramientas();
    }
}
class Barra_Herramientas extends JFrame{
    public Barra_Herramientas(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("barra de herramientas");
        setBounds(400, 400, 500, 500);
        lamina = new JPanel();
        add(lamina);
        /* configuracion de acciones  */
        Action accionazul = new AccionColor("Azul", new ImageIcon("icons/blueball.png"),  Color.blue);
        Action accionrojo = new AccionColor("Rojo", new ImageIcon("icons/redball.png"),  Color.red);
        Action accionamarillo = new AccionColor("Amarillo", new ImageIcon("icons/yellowball.png"),  Color.yellow);
        Action salir = new AbstractAction("salir", new ImageIcon("icons/instagram.png")) {
           public void actionPerformed (ActionEvent e){
               System.exit(0); //sale de la aplicacion
           } 
        };
        JMenu menuh = new JMenu("Color");
        menuh.add(accionamarillo);menuh.add(accionazul);menuh.add(accionrojo);
        JMenuBar barramenu = new JMenuBar();
        barramenu.add(menuh);
        setJMenuBar(barramenu); //agrega barra de menu a lamina
        //barra de herramientas:
        JToolBar barrah = new JToolBar();
        barrah.add(accionamarillo);barrah.add(accionrojo);barrah.add(accionazul);
        barrah.addSeparator();
        barrah.add(salir);
        //para hacer la barra movediza tenemos que definirla como borderlayout
        add(barrah,BorderLayout.NORTH);

    }
    private class AccionColor extends AbstractAction{
        public AccionColor ( String nombre, Icon icono, Color c) /* Creates an Action with the specified name and small icon */{
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "color de fondo " + nombre);
            putValue("Color", c);

        }
        public void actionPerformed (ActionEvent e){
            Color c = (Color) getValue("Color");
            lamina.setBackground(c);
        }
    }
    private JPanel lamina;
}
 