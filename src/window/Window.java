package window;

import javax.swing.*;
import java.awt.*;

public class Window
{
    public Window(int width, int hight, String title, Game game)
    {
        game.setPreferredSize(new Dimension(width,hight));
        game.setMaximumSize(new Dimension(width,hight));
        game.setMinimumSize(new Dimension(width,hight));
        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//pojawia sie na srodku ekranu
        frame.setVisible(true);

        game.start();
    }
}
