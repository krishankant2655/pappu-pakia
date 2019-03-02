package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Demo extends JPanel implements KeyListener  {
    private static int playerYCord=200,playerYVel,playerYAcc=16;
    private static int xVel=-10;
    private static int xCord1=1000,xCord2=1200,xCord3=1400,xCord4=1600,xCord5=1800,xGrassCord;


    public static void main(String[] args) {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 500));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        panel.setFocusable(true);
        panel.addKeyListener(new Demo());
        panel.setForeground(Color.CYAN);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Graphics g = panel.getGraphics();


        panel.requestFocus();
        Image ground,forkHandle,forkHead,grass,bg,backTrees,sadPappu;
        Image[] pappu = new Image[8];
        Image bigImage = new BufferedImage(1000,500, BufferedImage.TYPE_INT_RGB);



        try {
            grass = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/grass.png"));
            bg = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/bg_combined.png"));
            backTrees = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/back_trees.png"));
            ground = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/ground.png"));
            pappu[0] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu0.png"));
            pappu[1] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu1.png"));
            pappu[2] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu2.png"));
            pappu[3] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu3.png"));
            pappu[4] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu4.png"));
            pappu[5] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu5.png"));
            pappu[6] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu6.png"));
            pappu[7] = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/pappu7.png"));
            sadPappu = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/sad_pakia.png"));
            forkHandle = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/fork_handle.png"));
            forkHead = ImageIO.read(Demo.class.getClassLoader().getResource("game/images/fork_head.png"));

            } catch (IOException e) {
            System.out.println("Installation problem. Re-install the game");
            return;
        }

        Graphics imageGrahipcs = bigImage.getGraphics();
        panel.paint(imageGrahipcs);


        imageGrahipcs.clearRect(0, 0, 1000, 500);
        imageGrahipcs.dispose();

        imageGrahipcs.drawImage(bigImage, 0, 0, null);




        for(int i=0;true;i++) {

            playerYVel+=playerYAcc;
            if(playerYCord>450||playerYCord<0)
            {
                g.drawImage(sadPappu, 300, 0, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.clearRect(0,0,1000,500);
            if (i>7){
                i=0;
            }


            g.drawImage(bg,0,0,null);



            if(Collision(300,playerYCord,57,60,xCord1,500-202,22,312,xCord1-8,500-251,33,59))
            {
                g.drawImage(sadPappu, 300, playerYCord, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                return;
            }

            if(xCord1<16)
            {
                xCord1=1200;
            }
            xCord1+=xVel;

            g.drawImage(backTrees,xCord1,0,null); // back trees



            g.drawImage(forkHandle,xCord1,500-202,null);
            g.drawImage(forkHead,xCord1-8,500-251,null);


            if (Collision(300,playerYCord,57,60,xCord2,500-312,22,312,xCord2-8,500-361,33,59))
            {
                g.drawImage(sadPappu, 300, playerYCord, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                return;
            }

            if(xCord2<16){
                xCord2=1200;
            }
            xCord2+=xVel;



            g.drawImage(forkHandle,xCord2,500-312,null);
            g.drawImage(forkHead,xCord2-8,500-361,null);

            if (Collision(300,playerYCord,57,60,xCord3,500-250,22,312,xCord3-8,500-300,33,59))
            {
                g.drawImage(sadPappu, 300, playerYCord, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                return;
            }

            if (xCord3<16){
                xCord3=1200;
            }
            xCord3+=xVel;



            g.drawImage(forkHandle,xCord3,500-250,null);
            g.drawImage(forkHead,xCord3-8,500-300,null);

            if (Collision(300,playerYCord,57,60,xCord4,500-242,22,312,xCord4-8,500-291,33,59))
            {
                g.drawImage(sadPappu, 300, playerYCord, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                                                                                                        return;
            }

            if (xCord4<16){
                xCord4=1200;
            }
            xCord4+=xVel;



            g.drawImage(forkHandle,xCord4,500-242,null);
            g.drawImage(forkHead,xCord4-8,500-291,null);

            if (Collision(300,playerYCord,57,60,xCord5,500-242,22,312,xCord5-8,500-291,33,59))
            {
                g.drawImage(sadPappu, 300, playerYCord, null);
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over",400,50);
                return;
            }

            if (xCord5<16){
                xCord5=1200;
            }
            xCord5+=xVel;



            g.drawImage(forkHandle,xCord5,500-242,null);
            g.drawImage(forkHead,xCord5-8,500-291,null);

            //ground nd grass

            g.drawImage(ground, 0, 0, null);

            if(xGrassCord<-1000){
                xGrassCord=1000;
            }
            xGrassCord+=xVel;
            g.drawImage(grass, xGrassCord, 0, null);

            playerYCord+=playerYVel;


            g.drawImage(pappu[i], 300, playerYCord, null);

    }



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_SPACE) {
            playerYVel = -20;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    private static boolean Collision(int x1,int y1, int w1, int h1,int x2,int y2, int w2,int h2, int x3,int y3, int w3, int h3)
    {
        boolean c1 =(x1<x2&&x2<x1+w1);
        boolean c2 =(y1<y2&&y2<y1+h1);
        boolean c3 =(x1<x3&&x3<x1+w1)||(x3<x1&&x1<x3+w3);
        boolean c4 =(y1<y3&&y3<y1+h1)||(y3<y1&&y1<y3+h3);
        return c1&&c2&&c3&&c4;
    }
}
