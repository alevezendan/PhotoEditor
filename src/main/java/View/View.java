package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menu1,menu2,menu3;
    private JMenuItem i1,i2,i3;


    public View(String s,int x,int y) {
        JFrame frame=new JFrame(s);
        menuBar=new JMenuBar();
        menuBar.setSize(50,400);
        menuBar.setForeground(new Color(0,0,255));
        createFileMenu();
        createImageMenu();
        createColorMenu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x,y);
        // frame.setContentPane(mainPanel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);




       // frame.pack();


    }

    public void createFileMenu(){
        menu1=new JMenu("File");
        JMenuItem i1,i2,i3,i4,i5;
        i1=new JMenuItem("Add Image");
        i2=new JMenuItem("Open Image");
        i3= new JMenuItem("Recents");
        i4=new JMenuItem("Save image");
        i5= new JMenuItem("Exit");
        menu1.setBorderPainted(true);

        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu1.add(i4);
        menu1.add(i5);
        menuBar.add(menu1);
    }



    public void createImageMenu(){
        menu2=new JMenu("Image");
        JMenuItem i1,i2,i3,i4,i5,i6;
        JMenu rotSubmenu=new JMenu("Rotate");
        JMenu flipSubmeu=new JMenu("Flip");
        i1=new JMenuItem("Crop");
        i2=new JMenuItem("Resize");
        i3=new JMenuItem("Rotate");
        i4=new JMenuItem("Filp");
        i5=new JMenuItem("Mirror");
        i6=new JMenuItem("Change orientation");
        menu2.add(i1);
        menu2.add(i2);
        menu2.add(rotSubmenu);
        menu2.add(flipSubmeu);
        menu2.add(i5);
        menu2.add(i6);
        rotSubmenu.add(new JMenuItem("Rotate right"));
        rotSubmenu.add(new JMenuItem("Rotate left"));
        flipSubmeu.add(new JMenuItem("Flip vertical"));
        flipSubmeu.add(new JMenuItem("Flip horizontal"));
        menuBar.add(menu2);
    }


    public void createColorMenu(){
        menu3=new JMenu("Color");
        JMenuItem i1,i2,i3,i4,i5;
        i1=new JMenuItem("Negative");
        i2=new JMenuItem("Sepia");
        i3=new JMenuItem("Greyscale");
        i4=new JMenuItem("RedGreenBlue");
        i5=new JMenuItem();
        menuBar.add(menu3);
    }

}
