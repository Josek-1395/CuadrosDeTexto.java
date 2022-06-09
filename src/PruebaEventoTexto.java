import javax.swing.event.*;
import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
public class PruebaEventoTexto {
    public static void main(String[] args) {
        new MarcoDeEventoDeTexto();
    }
}
class MarcoDeEventoDeTexto extends JFrame{
    public MarcoDeEventoDeTexto() {
        setVisible(true);
        setBounds(500, 300, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Prueba de eventos con texto");
        add(new LayerDeEvento());
    }
}
class LayerDeEvento extends JPanel{
    public LayerDeEvento(){
        setLayout(new BorderLayout());
        JPanel laminasuperior = new JPanel();
        laminasuperior.setLayout(new GridLayout(2,2));
        add(laminasuperior,BorderLayout.NORTH);
        EscuchaTexto oyente = new EscuchaTexto();
        JLabel usuario = new JLabel("Ingrese usuario: ");
        JLabel contra = new JLabel("Ingrese contra: ");
        JTextField campousuario = new JTextField(20);
        campocontra = new JPasswordField(20);  //para que se vean asteriscos mientras usuario escribe en campo
        laminasuperior.add(usuario);
        laminasuperior.add(campousuario);
        laminasuperior.add(contra);
        laminasuperior.add(campocontra);
        JButton enviar = new JButton("enviar");
        add(enviar,BorderLayout.SOUTH);
        //Document midoc = campousuario.getDocument();   //necesitamos un obj de clase documento para hacerlo oyente
        //midoc.addDocumentListener(oyente);
        campocontra.getDocument().addDocumentListener(oyente);

        
        
    }
    private class EscuchaTexto implements DocumentListener{

        public void insertUpdate(DocumentEvent e) {
            char [] contrase;
            contrase = campocontra.getPassword();
            if (contrase.length < 8 || contrase.length > 12){
                campocontra.setBackground(Color.red);
            }
            else {
                campocontra.setBackground(Color.white);
            }
        }

        public void removeUpdate(DocumentEvent e) {
            System.out.println("borraste texto");
        }

        public void changedUpdate(DocumentEvent e) {
            
        }

    }
    private JPasswordField  campocontra;
}
