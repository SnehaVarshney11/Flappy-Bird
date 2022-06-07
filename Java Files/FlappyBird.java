package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener{
    
    public static FlappyBird flappyBird;
    public final int width = 800, height = 650;
    public Renderer renderer;
    //Rectangle is a class of awt
    public Rectangle bird;
    public ArrayList<Rectangle> r; // it is column or pole
    public Random rand;
    public int ticks, motion;
   
    public FlappyBird(){
        JFrame jf = new JFrame();
        Timer timer = new Timer(20, this);
        
        renderer = new Renderer();
        rand = new Random();
        
        jf.add(renderer);
        // After close the frame, it terminates the program
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Flappy Bird");
        jf.setSize(width,height);
        jf.setResizable(false);
        jf.setVisible(true);
        
        bird = new Rectangle(width/2 - 10, height/2 - 10, 20, 20);
        r = new ArrayList<Rectangle>();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        
        timer.start();
    }
    
    public void addColumn(boolean start){
        int space = 300;
        int w = 100;
        int h = 50 + rand.nextInt(300); // min height is 50 and max height is 300
        
        if(start){
            // We have two columns and these are add right at the begining
            r.add(new Rectangle(width + w + r.size() * 300, height - h - 120, w, h));
            r.add(new Rectangle(width + w + (r.size() - 1) * 300, 0, w, height - h - space));
        }else{
            r.add(new Rectangle(r.get(r.size() - 1).x + 600, height - h - 120, w, h));
            r.add(new Rectangle(r.get(r.size() - 1).x, 0, w, height - h - space));
        }
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        int speed = 10;
        
        ticks++;
        
        for(int i = 0; i < r.size(); i++){
            Rectangle col = r.get(i);
            col.x -= speed;
        }
        
        if(ticks%2 == 0 && motion < 15){
            motion += 2;
        }
        
        bird.y += motion;
        renderer.repaint();
    }
    
    public void paintColumn(Graphics g, Rectangle r){
        g.setColor(Color.green.darker());
        g.fillRect(r.x, r.y, r.width, r.height);
    }
    
    public void repaint(Graphics g){
       g.setColor(Color.cyan);
       g.fillRect(0, 0, width, height);
       
       g.setColor(Color.orange);
       g.fillRect(0, height - 120, width, 120);
       
       g.setColor(Color.green);
       g.fillRect(0, height - 120, width, 20);
       
       g.setColor(Color.red);
       g.fillRect(bird.x, bird.y, bird.width, bird.height);
       
       for(Rectangle col : r){
           paintColumn(g, col);
       }
    }
    
    public static void main(String[] args){
        flappyBird = new FlappyBird(); 
        
    }
}
