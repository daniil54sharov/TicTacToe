package Game;
public class Main {
    public static void main(String[] args) {
        game TicTac = new game();
        TicTac.introduce();
        TicTac.setPlayers();
        TicTac.setBoard();
        TicTac.showBoard();
        TicTac.setMove();

        boolean finish = TicTac.win;
        while(!finish) {
            TicTac.setMove();
        }
    }
}