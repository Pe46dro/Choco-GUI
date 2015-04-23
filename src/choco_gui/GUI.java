package choco_gui;

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

    private MyFrame frame;
    
    private JPanel console;
    private JPanel pulsanti;
    
    private JScrollPane prg;
    private JScrollPane textlog;
    
    private JButton[] button = new JButton[2662];
    
    private int i;
    private Command obj;
    
    private String name;
    
    private JTextArea out;
    
    public GUI() {
        frame = new MyFrame("Choco Install" , 800 , 405, 0, 0, 1, 2, 0, 0); 
       
        console = new JPanel(new FlowLayout());
        pulsanti = new JPanel(new GridLayout(2662, 1));

        out = new JTextArea("", i, i);
        out.setForeground(Color.GREEN);
        out.setBackground(Color.BLACK);
        out.setEditable(false);

        //////////////////////////////////////////
        
        init.init(button);

        
        for (int j = 0; j < button.length; j++) {
          pulsanti.add(button[j]);
          button[j].addActionListener(new launch());
        }

        //////////////////////////////////////////
        
        prg = new JScrollPane(pulsanti, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(prg);
        
        prg.getVerticalScrollBar().setUnitIncrement(26);
        
        textlog = new JScrollPane (out, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(textlog);
        
        
        
        frame.setVisible(true);
        
        System.out.println(button[0].getHeight());
        
    }

    private class launch implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for(i = 0;i<button.length;i++){
                if (((JButton) e.getSource()) == button[i]) {
                    obj = new Command();
                    name = button[i].getText();
                    break;
                }
            }
            
            StringBuffer output = new StringBuffer();
 
            Process p;

            try {
                p = Runtime.getRuntime().exec("choco install "+name);
            
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";

                while ((line = reader.readLine())!= null) {
                    //output.append(line + "\n");
                    System.out.println(line);
                    out.setText(out.getText() + line + "\n");
                }
            } catch (Exception ex) {
                ex.toString();
            }
            
            out.setText(out.getText()+"\n########################\n");
            
        }
    }

    public static void main(String[] args) throws InterruptedException{
            GUI a = new GUI();
    }
    
}