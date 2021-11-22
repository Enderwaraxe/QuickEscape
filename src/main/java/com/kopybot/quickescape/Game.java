package com.kopybot.quickescape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private int numDecks;
    private Player winner;
    private Player loser;

    public Game(List<Player> players, int numDecks) {
        this.players = players;
        this.numDecks = numDecks;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNumDecks() {
        return numDecks;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }
    private List<Card> shuffle() {
        List<Card> result = new ArrayList<>(numDecks*54);
        for (int k = 0; k<numDecks; k++) {
            for (int i = 3; i <= 15; i++) {
                for (Suite suite : Suite.values()) {
                    if (suite == Suite.BigJoker || suite == Suite.SmallJoker){
                        continue;
                    }
                    Card card = new Card(suite, i);
                    result.add(card);
                }
            }
            result.add(new Card(Suite.SmallJoker, 16));
            result.add(new Card(Suite.BigJoker, 17));
        }
        for (int i = 0; i< 54*numDecks; i++) {
            int rand = (int) (Math.random()*(54*numDecks));
            Card temp = result.get(rand);
            result.set(rand, result.get(i));
            result.set(i, temp);
        }
        return result;
    }

    private void distribute(List<Card> cards) {
        int current = 0;
        for (Card card: cards) {
            Player player = players.get(current);
            player.takeCard(card);
            current++;
            current = current%players.size();
        }
    }
    private void start() {
        distribute(shuffle());
        for (Player player: players) {
            System.out.println(player);
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", numDecks=" + numDecks +
                ", winner=" + winner +
                ", loser=" + loser +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a list of names: ");
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            if (name.equals("")){
                break;
            }
            playerList.add(new Player(name));
        }
        System.out.print("Enter the number of decks you want to use: ");
        int numDecks = sc.nextInt();
        Game game = new Game(playerList,numDecks);
        game.start();
    }
}
