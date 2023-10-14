import javax.swing.*;

public class SnakeGame extends JFrame {
    Board board ;
    SnakeGame(){
        board = new Board();
        add(board);//thid=s will add the board into the frame
        pack();//this will pack the frame size as the given Board size i.e, B_Height and B_Width
        setResizable(false);//after pack we use it and make it false so that user cannot resize it
        setVisible(true);

    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
    }
}