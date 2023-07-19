package company;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class Levels extends JFrame implements ActionListener {
//   JFrame frame=new JFrame();
//   JButton Button1=new JButton("Easy");
//   JButton Button2=new JButton("Medium");
//   JButton Button3=new JButton("Hard");
//
//   Levels() {
//     Button1.setBounds(150, 60, 20, 40);
//      Button2.setBounds(150, 60, 20, 40);
//      Button3.setBounds(150, 60, 20, 40);
//
//      Button1.setFocusable(false);
//     Button1.addActionListener(this);
//      Button2.setFocusable(false);
//      Button2.addActionListener(this);
//      Button3.setFocusable(false);
//      Button3.addActionListener(this);
//      frame.add(Button1);
//      frame.add(Button2);
//      frame.add(Button3);
//
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.setSize(420, 420);
//     frame.setLayout(null);
//     frame.setVisible(true);
//  }
//  @Override
//   public void actionPerformed(ActionEvent actionEvent)
//  {
//     if(actionEvent.getSource()==Button1||actionEvent.getSource()==Button2||actionEvent.getSource()==Button3)
//     {
//        GUI gui=new GUI();
//     }
//   }
//
//}


public class Levels extends JFrame implements ActionListener{

   JRadioButton Easy;
   JRadioButton Medium;
   JRadioButton Hard;
   JFrame frame=new JFrame();
//frame.setSize(420, 420);
   Levels(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new FlowLayout());

      //pizzaIcon = new ImageIcon("pizza.png");
      //hamburgerIcon = new ImageIcon("hamburger.png");
      //hotdogIcon = new ImageIcon("hotdog.png");

      Easy = new JRadioButton("Easy");
      Medium = new JRadioButton("Medium");
      Hard = new JRadioButton("Hard");

      ButtonGroup group = new ButtonGroup();
      group.add(Easy);
      group.add(Medium);
      group.add(Hard);

      Easy.addActionListener(this);
      Medium.addActionListener(this);
      Hard.addActionListener(this);

      this.add(Easy);
      this.add(Medium);
      this.add(Hard);
      this.pack();
      this.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==Easy) {
         GUI gui=new GUI();
      }
      else if(e.getSource()==Medium) {
         GUI gui=new GUI();      }
      else if(e.getSource()==Hard) {
         GUI gui=new GUI();
      }
   }
}