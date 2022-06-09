import javax.swing.*;
import java.awt.*;
public class MenuEmergente {
    public static void main(String[] args) {
        new MarcoMenuEmergente();
    }
}
class MarcoMenuEmergente extends JFrame{
    public MarcoMenuEmergente(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 500, 500);
        setTitle("Menu con marco emergente");
        add(new LayerMenuEmergente());
    }
}
class LayerMenuEmergente extends JPanel {
    public LayerMenuEmergente(){
        setLayout(new BorderLayout());
        JPanel laminamenu = new JPanel();
        JMenuBar barramenu = new JMenuBar();
        JMenu fuente = new  JMenu("fuente");JMenu estilo = new  JMenu("estilo");JMenu tamano = new  JMenu("tamano");
        barramenu.add(fuente);barramenu.add(estilo);barramenu.add(tamano);
        laminamenu.add(barramenu);
        add(laminamenu,BorderLayout.NORTH);
        JTextPane area = new JTextPane();
        add(area,BorderLayout.CENTER);
        JPopupMenu emergente = new JPopupMenu();
        JMenuItem opcion1 = new JMenuItem("opcion 1");
        emergente.add(opcion1);
        area.setComponentPopupMenu(emergente);

    }
}