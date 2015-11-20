package me.marangon;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.*;

/**
 *
 * @author marangon.pietro
 */
public class GUI {

    private JButton[] button = new JButton[2662];
    
    private int i;

    private String name;
    
    private JTextArea out;
    
    public GUI() {
        MyFrame frame = new MyFrame("Choco Install", 800, 405, 0, 0, 1, 2, 0, 0);

        JPanel pulsanti = new JPanel(new GridLayout(2662, 1));

        out = new JTextArea("", i, i);
        out.setForeground(Color.GREEN);
        out.setBackground(Color.BLACK);
        out.setEditable(false);

        //////////////////////////////////////////
        
        Init.init(button);


        for (JButton aButton : button) {
            pulsanti.add(aButton);
            aButton.addActionListener(new launch());
        }

        //////////////////////////////////////////

        JScrollPane prg = new JScrollPane(pulsanti, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(prg);
        
        prg.getVerticalScrollBar().setUnitIncrement(26);

        JScrollPane textlog = new JScrollPane(out, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(textlog);

        frame.setVisible(true);
        
        System.out.println(button[0].getHeight());
        
    }

    private class launch implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for(i = 0;i<button.length;i++){
                if (e.getSource() == button[i]) {
                    name = button[i].getText();
                    break;
                }
            }

            Process p;

            try {
                p = Runtime.getRuntime().exec("choco install -y "+name);
            
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line;

                while ((line = reader.readLine())!= null) {
                    //System.out.println(line);
                    out.setText(out.getText() + line + "\n");
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            
            out.setText(out.getText()+"\n########################\n");
            
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new GUI();
    }
}