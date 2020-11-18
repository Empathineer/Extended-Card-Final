import java.util.LinkedList;
import java.util.ListIterator;

// for random card generation and a test main
public class Foothill
{
   public static void main(String[] args)
   {
      int k;
      
      Card first = new Card('A', Card.Suit.spades);
      Card second = new Card('4', Card.Suit.hearts);
      Card third = new Card('T', Card.Suit.clubs);
      System.out.println("Generated three new cards:");
      System.out.println(first.toString() + ", " + second.toString() + ", " + third.toString() 
      + "\n");
      
      System.out.println("Comparing all cards with themselves...");
      System.out.println( "should all be 0:"); 
      System.out.println( first.compareTo( first ) );
      System.out.println( second.compareTo( second ) );
      System.out.println( third.compareTo( third ) );
      
      System.out.println("\nComparing card 2 with 1, 2 with 3, and 3 with 1, respectively...");
      System.out.println( "should all be < 0:"); 
      System.out.println( second.compareTo( first ) );
      System.out.println( second.compareTo( third ) );
      System.out.println( third.compareTo( first ) );
      
      System.out.println("\nComparing card 1 with 2, 3 with 2, and 1 with 3, respectively...");
      System.out.println( "should all be > 0:"); 
      System.out.println( first.compareTo( second ) );
      System.out.println( third.compareTo( second ) );
      System.out.println( first.compareTo( third ) );
      
      //creating a LinkedList of Card type
      LinkedList<Card> myCardList = new LinkedList<Card> ();

      System.out.println( "\nInserting random cards:\n");
      for ( k = 0; k < 10; k++ )
      {
          Card randCard = generateRandomCard();
          System.out.println(randCard.toString());
          insert(myCardList, randCard);
          insert(myCardList, randCard);//inserting a duplicate
      }
      System.out.println();
      
      
      System.out.println("Printing Card list after sorting in increasing order...\n");
      for (int i = 0; i < myCardList.size(); i++)
      {
          System.out.println(myCardList.get(i) );
      }
      System.out.println("Card list size: " + myCardList.size());
      
      //remove() all traces of each of those two cards
      System.out.println("\nRemoving a single instance of cards 1, 3, and 5");
      Card cardToRemove1 = myCardList.get(1);
      Card cardToRemove3 = myCardList.get(3);
      Card cardToRemove5 = myCardList.get(5);
      
      //removing a single instance of each card
      remove(myCardList, cardToRemove1);
      remove(myCardList, cardToRemove3);
      remove(myCardList, cardToRemove5);
      
      System.out.println("Printing after removing 3 unique cards:");
      for (int i = 0; i < myCardList.size(); i++)
      {
          System.out.println(myCardList.get(i) );
      }
      System.out.println("Card list size: " + myCardList.size());
      
      System.out.println("\nRemoving all instances of the second to last card...");
      removeAll(myCardList, myCardList.get(myCardList.size()-1));
      
      System.out.println("Printing Card list for the final time:");
      for (int i = 0; i < myCardList.size(); i++)
      {
          System.out.println(myCardList.get(i) );
      }
      System.out.println("Card list size: " + myCardList.size());

   }

   static void insert(LinkedList<Card> my_List, Card x)
   {
       ListIterator<Card> iter;
       Card listCard;
       
       for (iter = my_List.listIterator(); iter.hasNext(); )
       {
         listCard = iter.next();
         
         if (x.compareTo(listCard) <= 0)
         {
            iter.previous(); // back up one
            break;
         }
       }
       iter.add(x);
   }

   static boolean remove(LinkedList<Card> my_List, Card x)
   {
       if (my_List == null) {System.out.println("There is nothing here."); return false;}
           
       ListIterator<Card> iter;
       
       for (iter = my_List.listIterator(); iter.hasNext(); )
          if (x.compareTo(iter.next()) == 0)
          {
             iter.remove();
             return true;   // we found, we removed, we return
          }
       return false;
   }
   
   static boolean removeAll(LinkedList<Card> my_List, Card x)
   {
       if (!remove(my_List, x)) {return false;}

       while (remove(my_List, x))
       {
           continue;
       }
       return true;
   }
   
   // "global" static Foothill methods 
   static Card generateRandomCard()
   {
      // if firstTime = true, use clock to seed, else fixed seed for debugging
      Card.Suit suit;
      char val;

      int suitSelector, valSelector;

      // get random suit and value
      suitSelector = (int) (Math.random() * 4);
      valSelector = (int) (Math.random() * 13);

      // pick suit
      suit = turnIntIntoSuit(suitSelector);
      val = turnIntIntoVal(valSelector);

      return new Card(val, suit);
   }

   // note:  this method not needed if we use int for suits instead of enum
   static Card.Suit turnIntIntoSuit(int k)
   {
      return Card.Suit.values()[k];  // 
   }

   static char turnIntIntoVal(int k)
   {
      String legalVals = "23456789TJQKA";
      
      if (k < 0 | k >= legalVals.length())
         return '?';
      return legalVals.charAt(k);
   }
}

class Card
{   
   // type and constants
   public enum Suit { clubs, diamonds, hearts, spades }
   
   static char DEFAULT_VAL = 'A';
   static Suit DEFAULT_SUIT = Suit.spades;

   // private data
   private char value;
   private Suit suit;
   private boolean errorFlag;

   // 4 overloaded constructors
   public Card(char value, Suit suit)
   {   // because mutator sets errorFlag, we don't have to test
      set(value, suit);
   }

   public Card(char value)
   {
      this(value, DEFAULT_SUIT);
   }
   
   public Card()
   {
      this(DEFAULT_VAL, DEFAULT_SUIT);
   }
   
   // copy constructor
   public Card(Card card)
   {
      this(card.value, card.suit);
   }

   // mutators
   public boolean set(char value, Suit suit)
   {
      char upVal;            // for upcasing char

      // convert to uppercase to simplify
      upVal = Character.toUpperCase(value);

      if ( !isValid(upVal, suit))
      {
         errorFlag = true;
         return false;
      }
      
      // else implied
      errorFlag = false;
      this.value = upVal;
      this.suit = suit;
      return true;
   }

   // accessors
   public char getVal()
   {
      return value;
   }

   public Suit getSuit()
   {
      return suit;
   }

   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   // stringizer
   public String toString()
   {
      String retVal;

      if (errorFlag)
         return "** illegal **";

      // else implied
      retVal =  String.valueOf(value);
      retVal += " of ";
      retVal += String.valueOf(suit);

      return retVal;
   }

   // helper
   private static boolean isValid(char value, Suit suit)
   {
      // don't need to test suit (enum), but leave in for clarity
      char upVal;  // string to hold the 1-char value
      String legalVals = "23456789TJQKA";
      
      // convert to uppercase to simplify (need #include <cctype>)
      upVal = Character.toUpperCase(value);

      // check for validity
      if ( legalVals.indexOf(upVal) >= 0 )
         return true;
      else
         return false;
   }
   
   public boolean equals(Card card)
   {
      if (this.value != card.value)
         return false;
      if (this.suit != card.suit)
         return false;
      if (this.errorFlag != card.errorFlag)
         return false;
      return true;
   }
   // to existing members, add:

   // for sort  
   protected static char[] valueRanks = { '2', '3', '4', '5', '6', '7', '8', '9', 
      'T', 'J', 'Q', 'K', 'A'};
   protected static Suit[] suitRanks = {Suit.clubs, Suit.diamonds, Suit.hearts, 
      Suit.spades};
   protected static final int NUM_VALS = 13; 

   // sort member methods
   public int compareTo(Card other)
   {
      if (this.value == other.value)
         return ( getSuitRank(this.suit) - getSuitRank(other.suit) );

      return ( 
            getValueRank(this.value) 
            - getValueRank(other.value) 
            );
   }

   public static int getSuitRank(Suit st)
   {
      int k;

      for (k = 0; k < 4; k++) 
         if (suitRanks[k] == st)
            return k;

      // should not happen
      return 0;
   }

   public  static int getValueRank(char val)
   {
      int k;

      for (k = 0; k < NUM_VALS; k++) 
         if (valueRanks[k] == val)
            return k;

      // should not happen
      return 0;
   }
   
}

/******************************OUTPUT**************************************/
/*
Generated three new cards:
A of spades, 4 of hearts, T of clubs

Comparing all cards with themselves...
should all be 0:
0
0
0

Comparing card 2 with 1, 2 with 3, and 3 with 1, respectively...
should all be < 0:
-10
-6
-4

Comparing card 1 with 2, 3 with 2, and 1 with 3, respectively...
should all be > 0:
10
6
4

Inserting random cards:

4 of spades
8 of clubs
Q of clubs
T of diamonds
6 of diamonds
9 of hearts
J of clubs
2 of diamonds
6 of spades
K of hearts

Printing Card list after sorting in increasing order...

2 of diamonds
2 of diamonds
4 of spades
4 of spades
6 of diamonds
6 of diamonds
6 of spades
6 of spades
8 of clubs
8 of clubs
9 of hearts
9 of hearts
T of diamonds
T of diamonds
J of clubs
J of clubs
Q of clubs
Q of clubs
K of hearts
K of hearts
Card list size: 20

Removing a single instance of cards 1, 3, and 5
Printing after removing 3 unique cards:
2 of diamonds
4 of spades
6 of diamonds
6 of spades
6 of spades
8 of clubs
8 of clubs
9 of hearts
9 of hearts
T of diamonds
T of diamonds
J of clubs
J of clubs
Q of clubs
Q of clubs
K of hearts
K of hearts
Card list size: 17

Removing all instances of the second to last card...
Printing Card list for the final time:
2 of diamonds
4 of spades
6 of diamonds
6 of spades
6 of spades
8 of clubs
8 of clubs
9 of hearts
9 of hearts
T of diamonds
T of diamonds
J of clubs
J of clubs
Q of clubs
Q of clubs
Card list size: 15


*/