import javax.swing.JFrame;

public class FlappyBird {
    public static FlappyBird flappyBird;
    public final int w = 800, h = 800; 
    
    public FlappyBird(){
        JFrame jf = new JFrame();
        
        // After close the frame, it terminates the program
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(w,h);
        jf.setResizable(false);
        jf.setVisible(true);
        
    }
    
    public static void main(String[] args){
        flappyBird = new FlappyBird(); 
        
    }
}
