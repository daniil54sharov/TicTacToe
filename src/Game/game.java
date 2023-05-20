package Game;
import java.util.Scanner;
public class game {
    Scanner sc = new Scanner(System.in);
    //game board [~, ~, ~], [~, ~, ~][~, ~, ~], []
    char[][] board = new char[3][3];
    boolean win = false;
    char x = 'X', o = 'O';
    int num, a, b, moves;
    game() {
        introduce();
        setBoard();
        showBoard();
        setMove();
        while(!win) {
            setMove();
        }
    }
    // all cords equal '~'
    public void setBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '~';
            }
        }
    }
    public void showBoard() {
            /*
           -------------
           | ~ | ~ | ~ |
           | ~ | ~ | ~ |
           | ~ | ~ | ~ |
           -------------
           */
        System.out.print(" ");
        for(int i = 1; i < 4; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
        System.out.print("  ");
        System.out.println("-------------");
        for(int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for(int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|  ");
        }
        System.out.println("  -------------\n");
    }
    public void setMove() {
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                    System.out.println(" player " + i + " ");
                    System.out.print(" Set ur move " + j + " -> ");
                    num = sc.nextInt();
                System.out.println();
                    while(num >3 || num < 1) {
                        System.out.println(num + " is incorrect cords");
                        System.out.println(" player " + i + " ");
                        System.out.print(" Set ur move " + j + " -> ");
                        num = sc.nextInt();
                        System.out.println();
                    }
                    if (j == 1) {
                        b = num - 1;
                    } else {
                        a = num - 1;
                    }
                }
                System.out.println();
                if (i == 1) {
                    if (board[a][b] == o) {
                        System.out.println(":( this cord is busy, try again\n");
                        setMove();
                    } else if (board[a][b] == x) {
                        System.out.println(":( you already set this cords\n");
                        setMove();
                    } else {
                        board[a][b] = x;
                        moves++;
                    }
                }
                if (i == 2) {
                    if (board[a][b] == x) {
                        System.out.println(":( this cord is busy, try again\n");
                        setMove();
                    } else if (board[a][b] == o) {
                        System.out.println(":( you already set this cords\n");
                        setMove();
                    } else {
                        board[a][b] = o;
//                        moveFlag = false;
                        moves++;
                        System.out.println(moves);
                    }
                }
            showBoard();
            win();
            }
        }
    //introduce developer and game rules
    public void introduce() {
        String info = "\n =============RULES=============\n  first number vertically cords\n second number horizontally cords\n      ' :( ' means error\n =====Created by Sharik ;D======\n";
        System.out.println(info);
    }
    public void win() {
        //- - - x
        // тут я посмотрел в интернете про System.exit()
        if(board[0][0] == x && board[0][1] == x && board[0][2] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[1][0] == x && board[1][1] == x && board[1][2] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[2][0] == x && board[2][1] == x && board[2][2] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;// | | | x
        } else if(board[0][0] == x && board[1][0] == x && board[2][0] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][1] == x && board[1][1] == x && board[2][1] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][2] == x && board[1][2] == x && board[2][2] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        }
        // / x
        else if(board[0][0] == x && board[1][1] == x && board[2][2] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        }
        // \ x
        else if(board[1][2] == x && board[1][1] == x && board[2][1] == x) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if (moves == 9) {
            System.out.println("!!! DRAW !!!");
            System.exit(0);
        }
        //- - - o
        if(board[0][0] == o && board[0][1] == o && board[0][2] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[1][0] == o && board[1][1] == o && board[1][2] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[2][0] == o && board[2][1] == o && board[2][2] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
            // | | | o
        } else if(board[0][0] == o && board[1][0] == o && board[2][0] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][1] == o && board[1][1] == o && board[2][1] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][2] == o && board[1][2] == o && board[2][2] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        }
        // / o
        else if(board[0][0] == o && board[1][1] == o && board[2][2] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        }
        // \ o
        else if(board[1][2] == o && board[1][1] == o && board[2][1] == o) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if (moves == 9) {
            System.out.println("!!! DRAW !!!");
            System.exit(0);
        }
    }
}