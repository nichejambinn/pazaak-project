package ca.sheridancollege.project;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class PazaakGameTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(PazaakGame.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void play() {
    }

    @org.junit.Test
    public void declareWinner() {
    }

    @org.junit.Test
    public void rematch() {
    }

    @org.junit.Test
    public void dealCard() {
    }

    @org.junit.Test
    public void roundWinner() {
    }

    @org.junit.Test
    public void buildDeck() {
    }

    @org.junit.Test
    public void assignSideDeck() {
    }

    @org.junit.Test
    public void takeWager() {
    }

    @org.junit.Test
    public void changeTurn() {
    }

    @org.junit.Test
    public void startTurn() {
    }

    @org.junit.Test
    public void checkTotal() {
    }

    @org.junit.Test
    public void showBoard() {
    }
}
