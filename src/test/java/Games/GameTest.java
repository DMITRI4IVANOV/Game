package Games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Player playerName1 = new Player(1, "Андрей", 110);
    Player playerName2 = new Player(2, "Женя", 160);
    Player playerName3 = new Player(3, "Людмила", 50);
    Player playerName4 = new Player(4, "Анастасия", 110);
    Player playerName5 = new Player(5, "Николай", 160);
    Player playerName6 = new Player(6, "Виталий", 150);
    Player playerName7 = new Player(7, "Вася", 15);
    Game game = new Game();

    @Test
    void registerWinPlayer2Test() {
        Collection<Player> players = new ArrayList<>();
        game.register(playerName1);
        game.register(playerName2);
        game.round("Андрей", "Женя");

        int actual = game.round("Андрей", "Женя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void registerPlayersDrawTest() {
        Collection<Player> players = new ArrayList<>();
        game.register(playerName2);
        game.register(playerName5);
        game.round("Женя", "Николай");

        int actual = game.round("Женя", "Николай");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void registerWinPlayer1Test() {
        Collection<Player> players = new ArrayList<>();
        game.register(playerName4);
        game.register(playerName3);
        game.round("Анастасия", "Людмила");

        int actual = game.round("Анастасия", "Людмила");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void registersWinPlayer1Test() {
        Collection<Player> players = new ArrayList<>();
        game.register(playerName6);
        game.register(playerName3);
        game.round("Виталий", "Людмила");

        int actual = game.round("Виталий", "Людмила");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void notRegisterTest() {
        Collection<Player> players = new ArrayList<>();
        game.register(playerName1);
        game.register(playerName7);
        game.round("Андрей", "Влас");

        int actual = game.round("Андрей", "Влас");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
}