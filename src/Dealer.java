import java.util.*;

public class Dealer implements Player  
{

    private final String dealer = "Dealer";

    Card[] dealerHand = new Card[0];

    Dealer(){
        dealerHand = Arrays.copyOf(dealerHand, dealerHand.length + 2);
        dealerHand[0] = new Card();
        dealerHand[1] = new Card();

        System.out.println("The dealer has a " + dealerHand[0].getValue() + " showing, and a hidden card.");
        System.out.println("Her total is hidden too.\n");
    }

    
    public void gameStartup()
    {
        System.out.println("Okay, Dealer's turn!\n");

        int total = getTotal();
        System.out.println("Her hidden card was a " + dealerHand[1].getValue() + "\n" +
                            "Her total was " + total + ".\n");
    }

   

    public void drawCard() 
    {
        dealerHand = Arrays.copyOf(dealerHand, dealerHand.length + 1);
        dealerHand[dealerHand.length - 1] = new Card();

        int lastCard = dealerHand.length - 1;
        System.out.println("Dealer drew a " + dealerHand[lastCard].getValue());
    }

   
    public boolean wantToStay() 
    {
        boolean stay = false;
        int total = getTotal();

        if(total > 16){
            stay = true;
            System.out.println("Dealer stays.\n");
        }
        else{
            System.out.println("Dealer hits.");
        }
        return stay;
    }

  
    public int getTotal() 
    {
        int totalValue = 0;

        for (Card c : dealerHand) 
        {
            int cardValue = c.getValue();
            totalValue = totalValue + cardValue;
        }

        return totalValue;
    }

    
  
    public String toString()
    {
        return dealer;
    } 
}