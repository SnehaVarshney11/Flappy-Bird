import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Renderer extends JPanel{
    private static final long serialVersionId = 1L;
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        FlappyBird.flappyBird.repaint(g);
    }
}
