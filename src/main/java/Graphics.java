import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*Sources used: https://www.geeksforgeeks.org/java-jframe/, https://blog.idrsolutions.com/how-to-read-png-files-in-java/ , https://medium.com/@michael71314/java-lesson-22-inserting-images-onto-the-jframe-a0a0b6540cca 
https://coderanch.com/t/548154/java/Display-image-Swing */
public final class Graphics {
    private Graphics(){
    }
    public static void beginningMessage(){
        //Create a new JFrame
        JFrame frame = new JFrame("Mr.Kalisz Simulator");

        //Text


        frame.setSize(1430,1000);
        //Create a new image
        ImageIcon image = new ImageIcon(Graphics.class.getResource("/kaliszavatar.png"));
        //Add a new created label to the frame
        frame.add(new JLabel(image));

        //Frame visible
        frame.setVisible(true);

        //Closes operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
