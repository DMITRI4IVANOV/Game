package Games;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }


    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int findByStrength(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player.getStrength();
            }
        }
        return 0;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок : " + playerName1 + " not register");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок : " + playerName2 + " not register");
        } else if (findByStrength(playerName1) > findByStrength(playerName2)) {
            return 1;
        } else if (findByStrength(playerName1) < findByStrength(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}