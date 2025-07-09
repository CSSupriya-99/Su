
package javaapplication33;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class labfinalproject implements ActionListener {
   
   JFrame frame;
    Container c;
    JLabel lb1, lb2, lb3, lb4;
    JTextField tf1, tf2;
    JButton convert, clear;
    JComboBox cb1, cb2;
    JButton[] btn = new JButton[12];
    JPanel p;
 
    labfinalproject() {
        
       
        
        frame = new JFrame();
        frame.setTitle("GUI Application");
        frame.setBounds(300, 100, 330, 480);
        
        
        c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
        lb1 = new JLabel("simple calculator");
        lb1.setBounds(10, 10, 100, 30);
        
        tf1 = new JTextField();
        tf1.setBounds(10, 40, 150, 30);
        
        lb2 = new JLabel("From");
        lb2.setBounds(170, 10, 100, 30);
        
      
        String[] unit = {"Celsius", "Fahrenheit", "Kelvin"};
        
        cb1 = new JComboBox(unit);
        cb1.setBounds(170, 40, 130, 30);
      
        
        lb3 = new JLabel("Converted Value");
        lb3.setBounds(10, 80, 100, 30);
        
        tf2 = new JTextField();
        tf2.setBounds(10, 110, 150, 30);
        
        lb4 = new JLabel("To");
        lb4.setBounds(170, 80, 100, 30);
        
        cb2 = new JComboBox(unit);
        cb2.setBounds(170, 110, 130, 30);
        
      
        
        
        convert = new JButton("Convert");
        convert.setBounds(10, 160, 140, 30);
        convert.addActionListener(this);
        
        clear = new JButton("Clear");
        clear.setBounds(160, 160, 140, 30);
        clear.addActionListener(this);
        
        
        p = new JPanel();
        p.setBounds(10, 200, 290, 200);
        p.setBackground(Color.DARK_GRAY);
        p.setLayout(new GridLayout(3,4,5,5));
        
        
        for(int i=0; i<btn.length; i++)
        {
            btn[i] = new JButton();
            if(i<9)
            {
               btn[i].setText(Integer.toString(i+1)); 
            }
            btn[i].addActionListener(this);
            p.add(btn[i]);
        }
        btn[9].setText("0");
        btn[10].setText(".");
        btn[11].setText("+-");
             
        c.add(lb1);
        c.add(tf1);
        c.add(lb2);
       
        c.add(lb3);
        c.add(tf2);
        c.add(lb4);
        c.add(cb1);
        c.add(cb2);
        
        c.add(convert);
        c.add(clear);
        c.add(p);
      
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn[0])
        {
            tf1.setText(tf1.getText()+"1");
        }
        else if(e.getSource()==btn[1])
        {
            tf1.setText(tf1.getText()+"2");
        }
         else if(e.getSource()==btn[2])
        {
            tf1.setText(tf1.getText()+"3");
        }
          else if(e.getSource()==btn[3])
        {
            tf1.setText(tf1.getText()+"4");
        }
           else if(e.getSource()==btn[4])
        {
            tf1.setText(tf1.getText()+"5");
        }
            else if(e.getSource()==btn[5])
        {
            tf1.setText(tf1.getText()+"6");
        }
             else if(e.getSource()==btn[6])
        {
            tf1.setText(tf1.getText()+"7");
        }
              else if(e.getSource()==btn[7])
        {
            tf1.setText(tf1.getText()+"8");
        }
               else if(e.getSource()==btn[8])
        {
            tf1.setText(tf1.getText()+"9");
        }
                else if(e.getSource()==btn[9])
        {
            tf1.setText(tf1.getText()+"0");
        }
        else if(e.getSource()==btn[10])
        {
            String currentText=tf1.getText();
            int dotCount=0;
            for(char c:currentText.toCharArray()){
                if(c=='.'){
                    dotCount++;
                }
            }
            if(dotCount>=1){
                JOptionPane.showMessageDialog(frame, "more than one '.'is not allowed");
            }
            else{
                tf1.setText(tf1.getText()+".");
            }
            
        }
        
        else if(e.getSource()==btn[11])
        {
            try{
            String v = tf1.getText();
            double a = Double.parseDouble(v);
            a = a*(-1);
             String from = (String) cb1.getSelectedItem();
                    String to = (String) cb2.getSelectedItem();
            tf1.setText(Double.toString(a));}
            catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } 
        }
        else if(e.getSource()==clear)
        {
            tf1.setText(null);
            tf2.setText(null);
        }
        else if(e.getSource()==convert)
        {
            String v = tf1.getText();
            double a = Double.parseDouble(v);
            if(cb1.getSelectedIndex()==0 && cb2.getSelectedIndex()==1)
            {
                a = ((9*a)/5)+32;
            }
            else if(cb1.getSelectedIndex()==0 && cb2.getSelectedIndex()==2)
            {
                a = a + 273.15; //celcius to kelvin
            }
            else if(cb1.getSelectedIndex()==1 && cb2.getSelectedIndex()==0)
            {
               a=(5*(a-32))/9;
            }
             else if(cb1.getSelectedIndex()==1 && cb2.getSelectedIndex()==2)
            {
               a=(((a-32)*5)/9)+273.15;
            }
            else if(cb1.getSelectedIndex()==2 && cb2.getSelectedIndex()==0)
            {
               a=(((a-273.15)/5)*5);
            }
            else if(cb1.getSelectedIndex()==2 && cb2.getSelectedIndex()==1)
            {
               a=(((a-273.15)/5)*9)+32;
            }
            
            
            // conditions for other units
            
            tf2.setText(Double.toString(a));
            
        }
    }
      public static void main(String[] args) 
    {
        labfinalproject a =new labfinalproject();
    }

    private void setIconImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    }
   
   
    

