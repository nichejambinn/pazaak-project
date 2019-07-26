/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards = new ArrayList <Card>();
    private int size;//the size of the grouping
    private int count = cards.size();
    
    public GroupOfCards(int size)
    {
        this.size = size;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards; ///////// this probably does not display as we want it to
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }


	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		if(count < size) {
                    cards.add(card);
                    count++;
                }
                else {
                    System.out.println("This group already has " + size + " cards");
                }
	}

	/**
	 * 
	 * @param card
	 */
	public void removeCard(Card card) {
            if(count > 0) {
                    cards.remove(card);
                    count--;
                }
            else {
                    System.out.println("This group has no cards left");
            }
	}

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
    
}//end class
