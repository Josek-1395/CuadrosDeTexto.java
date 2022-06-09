import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
public class Slider {
    public static void main(String[] args) {
        new MarcoSlider();
    }
}
class MarcoSlider extends JFrame{
    public MarcoSlider(){
        setVisible(true);
        setTitle("Prueba con sliders");
        setBounds(400, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LayerSlider());
    }
}
class LayerSlider extends JPanel{
    public LayerSlider(){
        setLayout(new BorderLayout());
        rotulo = new JLabel("hola mononononono");
        add(rotulo,BorderLayout.CENTER);

        control = new JSlider(/* JSlider.VERTICAL, */8,50,16);
        control.setMajorTickSpacing(10);
        control.setMinorTickSpacing(2);
        control.setPaintTicks(true);
        control.setFont(new Font("Serif",0,12));
        control.setPaintLabels(true);
        control.setSnapToTicks(true);
        control.addChangeListener(new oyente());
        JPanel lamina_slider = new JPanel();
        lamina_slider.add(control);
        add(lamina_slider,BorderLayout.NORTH);

       
    }
    private class oyente implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            rotulo.setFont(new Font("Serif",0,control.getValue()));
        }

    }
    private JLabel rotulo;
    private JSlider control;
}