import java.util.*;
import java.util. Scanner;
public class User implements Player  
{

    private final String user;

    private Card[] userHand = new Card[0];

	private Scanner sc;

   
    User(String name)
    {
        user = name;

        userHand = Arrays.copyOf(userHand, userHand.length + 2);
        userHand[0] = new Card();
        userHand[1] = new Card();

        System.out.println("You get a " + userHand[0].getValue() + " and a " + userHand[1].getValue() + ".");
        int total = getTotal();
        System.out.println("Your total is: " + total + "\n");
    }

   
    
    public void gameStartup()
    {
        System.out.println("Your turn!");
    }

   
    public int getTotal()
    {
        int totalValue = 0;

        for (Card c : userHand) 
        {
            int cardValue = c.getValue();
            totalValue = totalValue + cardValue;
        }

        return totalValue;
    }

    
    public void drawCard() 
    {
        userHand = Arrays.copyOf(userHand, userHand.length + 1);
        userHand[userHand.length - 1] = new Card();

        int lastCard = userHand.length - 1;
        System.out.println("You drew a " + userHand[lastCard].getValue());
    }

    
    public boolean wantToStay() {
        Boolean stay = null;

        while(stay == null){
            sc = new Scanner(System.in);

            System.out.print("Enter \"hit\" or \"stay\"? ");
            String input = sc.nextLine();

            String hitOrStay = input.toLowerCase();

            switch(hitOrStay)
            {
                case "hit":
                    stay = false;
                    break;
                case "stay":
                    stay = true;
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    break;
            }
        }
        return stay;
    }

  
    @Override
    public String toString()
    {
        return user;
    }
}