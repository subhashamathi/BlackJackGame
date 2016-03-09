import java.util.Scanner;

public class BlackJackGame
{

    private final Player[] players = new Player[2];

    public static void main(String[] args)
    {

        BlackJackGame game = new BlackJackGame();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Magic GAME Black Jack");


        System.out.println("Enter the name?");
        String userName = sc.nextLine();

        System.out.println("Hello " + userName + "! Let's play!\n");

        Player user = new User(userName);
        game.players[0] = user;
        Player dealer = new Dealer();
        game.players[1] = dealer;
        user.gameStartup();
        boolean userLoseByDefault = game.playerTurn(user, dealer);

        if(userLoseByDefault)
        {
            game.lostByDefault(sc);
        }

        dealer.gameStartup();
        boolean dealerLoseByDefault = game.playerTurn(dealer, user);

        if(dealerLoseByDefault)
        {
            game.lostByDefault(sc);
        }

        Player winner = game.whoWon(game.players, dealer);

        System.out.println(user + "'s total is: " + user.getTotal() + ".\n" +
                           dealer + "'s total is : " + dealer.getTotal() + ".\n");
        System.out.printf("%s WIN!\n\n", winner);

        if (game.goAgain(sc) == true)
        {
            main(null);
        }
    }
    
    private boolean playerTurn(Player player, Player otherPlayer)
    {
        boolean endTurn = false;
        boolean loseByDefault = false;

        while(endTurn == false)
        {
            endTurn = player.wantToStay();

            if(endTurn == false)
            {
                player.drawCard();
                System.out.println(player + "'s total is: " + player.getTotal() + "\n");
            }
        }
        if(player.getTotal() > 21)
        {
            System.out.println(player + "'s total is more than 21, " + player + " lose by default.\n" +
                               otherPlayer + " WIN!\n");
            loseByDefault = true;
        }
        return loseByDefault;
    }
  
    private Player whoWon(Player[] players, Player dealer)
    {
        Player winner = players[0];

        for(int i = 1; i < players.length; i++)
        {
            Player elem = players[i];

            if(elem.getTotal() > winner.getTotal())
            {
                winner = elem;
            }
            else if(elem.getTotal() == winner.getTotal())
            {
                winner = dealer;
            }
        }
        return winner;
    }

    private void lostByDefault(Scanner sc){
        if(goAgain(sc) == true){
            main(null);
        }
        System.exit(0);
    }

    private boolean goAgain(Scanner sc)
    {
        Boolean goAgain = null;

        while(goAgain == null)
        {
            System.out.println("Would you like to play another round? \"yes\"/\"no\": ");
            String input = sc.nextLine();

            String answer = input.toLowerCase();

            switch(answer){
                case "y":
                case "yes":
                    goAgain = true;
                    break;
                case "n":
                case "no":
                    goAgain = false;
                    break;
                default:
                    System.out.println("Invalid answer. Please answer only \"yes\" or \"no\"");
                    break;
            }
            System.out.println();
        }
        return goAgain;
    }
}