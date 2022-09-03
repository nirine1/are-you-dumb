import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyWindow extends JFrame
{
    protected Font myFont;
    protected JButton yes_button, no_button;
    protected JLabel label;
    protected Timer timer;

    public MyWindow()
    {
        this.setTitle(" ");
        this.setBounds(550, 350, 350, 350);
        this.setResizable(false);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                disposeWindow();
            }
        });

        timer = new Timer();
        myFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 40);
        
        label = new JLabel("Are You Dumb ?");
        label.setFont(myFont);
        label.setFocusable(false);
        this.getContentPane().add(label);
        label.setBounds(20, 50, 350, 50);

        yes_button = new JButton("Yes");
        no_button = new JButton("No");
        this.add(yes_button);
        this.add(no_button);
        yes_button.setBounds(40,200, 75, 30);
        no_button.setBounds(180,200, 75, 30);

        yes_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                label.setText("I knew It :)");
                label.setLocation(75, 125);
                yes_button.setVisible(false);
                no_button.setVisible(false);
                startCountDown();
            }
        });

        no_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int random_x = (int)Math.ceil(Math.random()*250);
                int random_y = (int)Math.ceil(Math.random()*250);
                no_button.setLocation(random_x, random_y);
            }
        });

        this.setVisible(true);
    }

    public void disposeWindow()
    {
        this.dispose();
        System.exit(0);
    }

    public void startCountDown() 
    {
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                disposeWindow();;
            }
        }, 3*1000);
    }
}