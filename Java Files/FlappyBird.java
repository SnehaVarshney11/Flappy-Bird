import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyBird implements ActionListener{
    public static FlappyBird flappyBird;
    public final int w = 800, h = 800;
    public Renderer renderer;
    
    public FlappyBird(){
        JFrame jf = new JFrame();
        Timer timer = new Timer(20, this);
        
        renderer = new Renderer();
        
        jf.add(renderer);
        // After close the frame, it terminates the program
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(w,h);
        jf.setResizable(false);
        jf.setVisible(true);
        
        timer.start();
    }
    
    public void actionPerformed(ActionEvent ae){
        renderer.repaint();
    }
    
    public void repaint(Graphics g){
       
    }
    
    public static void main(String[] args){
        flappyBird = new FlappyBird(); 
        
    }
}
