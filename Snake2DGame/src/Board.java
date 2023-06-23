import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    int B_Height = 400;//board height
    int B_Width = 400;//board width
    int Max_Dots = 1600;//max dots we can put in board or max length of snake
    int Dots_Size = 10;
    int Dots;
    int []x = new int[Max_Dots];
    int []y = new int[Max_Dots];
    int apple_x;
    int apple_y;
    //Image
    Image body,head,apple;
    Timer timer;
    int delay = 200;//it will delay the time for 300 millisec
    boolean leftDirection = true;
    boolean rightDirection = false;
    boolean upDirection = false;
    boolean downDirection =false;
    boolean inGame = true;
    Board(){
        TAdapter tAdapter = new TAdapter();
        addKeyListener(tAdapter);
        setFocusable(true);
        setPreferredSize(new Dimension(B_Width , B_Height));
        setBackground(Color.black);
        initgame();
        loadImages();
        timer = new Timer(delay,this);
        timer.start();
    }
    //Initializing game
    public void initgame()
    {
        //Initialize snake size
        Dots = 3;
        //Initialize snake position
        x[0]=250;
        y[0]=250;
        for(int i=0;i<Dots;i++)
        {

            x[i] = x[0]+Dots_Size*i;
            y[i] = y[0];
        }
        locateApple();
    }
    //Load images from resource folder to image object
    public void loadImages() {
        ImageIcon bodyIcon = new ImageIcon("src/resources/dot.png");
        body = bodyIcon.getImage();
        ImageIcon headIcon = new ImageIcon("src/resources/head.png");
        head = headIcon.getImage();
        ImageIcon appleIcon = new ImageIcon("src/resources/apple.png");
        apple = appleIcon.getImage();
    }
    // Draw images at snakes and apple's position
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
    //draw images
    public void doDrawing(Graphics g){
       if(inGame){
           g.drawImage(apple,apple_x,apple_y,this);
           for(int i=0;i<Dots;i++){
               if(i==0){
                   g.drawImage(head,x[0],y[0],this);
               }
               else{
                   g.drawImage(body,x[i],y[i],this);
               }
           }
       }
       else{
           gameOver(g);
           timer.stop();
       }
    }
    //Randomize Apple's Location
    public void locateApple() {
        apple_x = ((int)(Math.random()*39))*Dots_Size;
        apple_y = ((int)(Math.random()*39))*Dots_Size;
    }
    //check collision with border and body
    public void checkCollision(){
        // collision with body
        for(int i=1;i<Dots;i++){
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
                break;
            }
        }
        // colision with borders
        if(x[0]<0 || x[0]>=B_Width){
            inGame=false;
        }
        if(y[0]<0 || y[0]>=B_Height){
            inGame=false;
        }
    }
    //Display gameover
    public void gameOver(Graphics g){
        String msg ="Game Over";
        int score = (Dots-3)*100;
        String scoremsg = "Score :" + score;
        Font small = new Font("Helvetica",Font.BOLD,14);
        FontMetrics fontMetrics = getFontMetrics(small);
        g.setColor(Color.cyan);
        g.setFont(small);
        g.drawString(msg,(B_Width - fontMetrics.stringWidth(msg))/2,B_Width/4);
        g.drawString(scoremsg,(B_Width - fontMetrics.stringWidth(scoremsg))/2,(3*B_Width)/4);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
       if(inGame){
           checkApple();
           checkCollision();
           move();
       }
        repaint();//this will repaint the position of snake
    }
    public void move(){
        for(int i=Dots-1;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        if(leftDirection){
            x[0]-=Dots_Size;
        }
        if(rightDirection){
            x[0]+=Dots_Size;
        }
        if(upDirection){
            y[0]-=Dots_Size;
        }
        if(downDirection){
            y[0]+=Dots_Size;
        }
    }
    //make snake eat food
    public void checkApple(){
        if(apple_x==x[0] && apple_y==y[0]){
            Dots++;
            locateApple();
        }
    }
    //Implement controls
    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent keyEvent){
            int key = keyEvent.getKeyCode();
            if(key==KeyEvent.VK_LEFT && !rightDirection){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key==KeyEvent.VK_RIGHT && !leftDirection){
                rightDirection = true;
                downDirection = false;
                upDirection = false;
            }
            if(key==KeyEvent.VK_UP && !downDirection){
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            if(key==KeyEvent.VK_DOWN && !upDirection){
                downDirection = true;
                rightDirection= false;
                leftDirection = false;
            }
        }
    }
}
