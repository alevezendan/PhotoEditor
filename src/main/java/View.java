import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JFrame frame;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menu1,menu2,menu3;
    private JMenuItem i1,i2,i3;

    public View(String s,int x,int y) {
        frame=new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x,y);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        mainPanel= new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setLayout(new FlowLayout());

        menuBar=new JMenuBar();
        mainPanel.add(menuBar);
        menu1=new JMenu("File");
        i1=new JMenuItem("Add Image");
        i2=new JMenuItem("Open Image");
        i3= new JMenuItem("Recents");
        mainPanel.add(menuBar);
        menuBar.add(menu1);
        //menuBar.add(menu2);
       // menuBar.add(menu3);
        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);





       // frame.pack();


    }

}
