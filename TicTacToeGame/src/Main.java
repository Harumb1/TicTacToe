import java.util.Scanner;

public class Main {
    static char turnX = 'X';
    static char turnO = 'O';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Design of the table
        
        System.out.println("TIC TAC TOE GAME");
        System.out.println("Choose 'X' OR 'O':");
        System.out.println("1.'X'");
        System.out.println("2.'O'");
        System.out.println("+---+---+---+" +
                "\n| 1 | 2 | 3 |" +
                "\n|---+---+---|" +
                "\n| 4 | 5 | 6 |" +
                "\n|---+---+---|" +
                "\n| 7 | 8 | 9 |" +
                "\n+---+---+---+");

        int choose = Integer.parseInt(sc.nextLine());
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        switch (choose) {
            case 1: {
                System.out.println("You chose 'X'");
                System.out.println("The other player plays as 'O'");
                System.out.println("Choose a position from 1 to 9");

                while (!checkWinner(board)) {
                    System.out.println(turnX + "'s turn. Enter a slot number to place " + turnX + " in:");
                    int numInput;
                    numInput = sc.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Invalid input; re-enter slot number:");
                        continue;
                    }
                    if (board[numInput-1] == 'X' || board[numInput-1] == 'O') {
                        System.out.println("Slot already taken; re-enter slot number:");
                        continue;

                    }
                    board[numInput-1] = turnX;
                    if (turnX == 'X') {
                        turnX = 'O';
                    } else {
                        turnX = 'X';
                    }
                    printBoard(board);

                }

            }
            break;

            case 2: {
                System.out.println("You chose 'O'");
                System.out.println("The other player plays as 'X'");
                System.out.println("Choose a position from 1 to 9");

                while (!checkWinner(board)) {
                    System.out.println(turnO + "'s turn. Enter a slot number to place " + turnO + " in:");
                    int numInput;
                    numInput = sc.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Invalid input; re-enter slot number:");
                        continue;
                    }
                    if (board[numInput-1] == 'X' || board[numInput-1] == 'O') {
                        System.out.println("Slot already taken; re-enter slot number:");
                        continue;

                    }
                    board[numInput-1] = turnO;
                    if (turnO == 'X') {
                        turnO = 'O';
                    } else {
                        turnO = 'X';
                    }

                    printBoard(board);
                }
            }
            break;

        }
    }
    
    static void printBoard(char board[]) {
        System.out.println("+---+---+---+");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("+---+---+---+");

    }

    //All the combinations to determine whether you won or not
    
    static boolean checkWinner(char[] board) {
        char winner;
        if (board[0] == board[1] && board[1] == board[2] && board[0] != ' ') {
            winner = board[0];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[3] == board[4] && board[4] == board[5] && board[3] != ' ') {
            winner = board[3];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[6] == board[7] && board[7] == board[8] && board[6] != ' ') {
            winner = board[6];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[0] == board[4] && board[4] == board[8] && board[0] != ' ') {
            winner = board[0];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[6] == board[4] && board[4] == board[2] && board[6] != ' ') {
            winner = board[6];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[0] == board[3] && board[3] == board[6] && board[0] != ' ') {
            winner = board[0];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ') {
            winner = board[1];
            System.out.println("Winner: " + winner);
            return true;
        }
        if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ') {
            winner = board[2];
            System.out.println("Winner: " + winner);
            return true;

        }

        //Draw funtion
        //Checks trough every value in char board[] whether there is a space or not

        for(int i = 0; i < 9; i++){
            char value = board[i];
            if (value == ' '){
                return false;
            }
        }
        System.out.println("It's a draw!");
        return true;

    }

}
