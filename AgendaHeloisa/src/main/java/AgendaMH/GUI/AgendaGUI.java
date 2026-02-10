package AgendaMH.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AgendaGUI extends JFrame {
    public AgendaGUI(){
        setTitle("Animes");
        setSize(500,500);
        setLocation(200,200);
        setResizable(false);
        getContentPane().setBackground(Color.magenta);
    }

    public static void main(String [] args){
        AgendaGUI janela = new AgendaGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){

                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);

    }

}
