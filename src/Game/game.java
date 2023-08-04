package Game;
import java.util.Scanner;
public class game {
    Scanner scan = new Scanner(System.in);
    //game board [~, ~, ~], [~, ~, ~][~, ~, ~], []
    String player1, player2;
    char[][] board = new char[3][3];
    boolean win = false;
    char playerX = 'X', playerO = 'O';
    int move, a, b, movesCounter;
    game() {
    }
    public void setPlayers() {
        System.out.print("Player1 enter your name -> ");
        player1 = scan.nextLine();
        System.out.print("Player2 enter your name -> ");
        player2 = scan.nextLine();
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
                if(i == 1) {
                    System.out.print(player1 + " set your move vertical -> ");
                } else if (i == 2) {
                    System.out.print(player2 + " set your move hirizontal -> ");
                }
                    move = scan.nextInt();
                System.out.println();
                    while(move > 3 || move < 1 ) {
                        System.out.println(move + " is incorrect cords");
                        if(i == 1) {
                            System.out.print(player1 + " set your move " + j + " again -> ");
                        } else if (i == 2) {
                            System.out.print(player2 + " set your move " + j + " again -> ");
                        }
                        move = scan.nextInt();
                        System.out.println();
                    }
                    if (j == 1) {
                        b = move - 1;
                    } else {
                        a = move - 1;
                    }
                }
                System.out.println();
                if (i == 1) {
                    if (board[a][b] == playerO) {
                        System.out.println(":( this cord is busy, try again\n");
                        setMove();
                    } else if (board[a][b] == playerX) {
                        System.out.println(":( you already set this cords\n");
                        setMove();
                    } else {
                        board[a][b] = playerX;
                        movesCounter++;
                    }
                }
                if (i == 2) {
                    if (board[a][b] == playerX) {
                        System.out.println(":( this cord is busy, try again\n");
                        setMove();
                    } else if (board[a][b] == playerO) {
                        System.out.println(":( you already set this cords\n");
                        setMove();
                    } else {
                        board[a][b] = playerO;
                        movesCounter++;
                        System.out.println(movesCounter);
                    }
                }
            showBoard();
            checkWin();
            }
        }
    //introduce developer and game rules
    public void introduce() {
        String info = "\n =============RULES=============\n  first number vertically cords\n second number horizontally cords\n      ' :( ' means error\n =====Created by Sharik ;D======\n";
        System.out.println(info);
    }
    public void checkWin() {
        //- - - x
        // тут я посмотрел в интернете про System.exit()
        if(board[0][0] == playerX && board[0][1] == playerX && board[0][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[1][0] == playerX && board[1][1] == playerX && board[1][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[2][0] == playerX && board[2][1] == playerX && board[2][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;// | | | x
        } else if(board[0][0] == playerX && board[1][0] == playerX && board[2][0] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][1] == playerX && board[1][1] == playerX && board[2][1] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][2] == playerX && board[1][2] == playerX && board[2][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        }
        // \ x
        else if(board[0][0] == playerX && board[1][1] == playerX && board[2][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        }
        // / x
        else if(board[2][0] == playerX && board[1][1] == playerX && board[0][2] == playerX) {
            System.out.println("!!! X WON!!!");
            System.exit(0);
            win = true;
        } else if (movesCounter == 9) {
            System.out.println("!!! DRAW !!!");
            System.exit(0);
        }
        //- - - o
        if(board[0][0] == playerO && board[0][1] == playerO && board[0][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[1][0] == playerO && board[1][1] == playerO && board[1][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[2][0] == playerO && board[2][1] == playerO && board[2][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
            // | | | o
        } else if(board[0][0] == playerO && board[1][0] == playerO && board[2][0] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][1] == playerO && board[1][1] == playerO && board[2][1] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if(board[0][2] == playerO && board[1][2] == playerO && board[2][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        }
        // / o
        else if(board[0][0] == playerO && board[1][1] == playerO && board[2][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        }
        // \ o
        else if(board[2][0] == playerO && board[1][1] == playerO && board[0][2] == playerO) {
            System.out.println("!!! O WON!!!");
            System.exit(0);
            win = true;
        } else if (movesCounter == 9) {
            System.out.println("!!! DRAW !!!");
            System.exit(0);
        }
    }
}