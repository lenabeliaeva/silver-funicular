package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Person implements FootballManager, FootballManager.Player {
    private String name;
    private League league;
    private Team team;
    private int score;

    Person(String name, League league, Team team){
        this.name = name;
        this.league = league;
        this.team = team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public League getLeague() {
        return league;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    private HashMap<String, Player> players = new HashMap<>();

    @Override
    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player.getName());
    }

    @Override
    public Player getPlayerByName(String name) {
        return players.get(name);
    }

    @Override
    public Player[] getAllPlayers() {
        Player[] allPlayers = new Player[players.size()];
        int i = 0;
        for (Player iter: players.values()){
            allPlayers[i] = iter;
            i++;
        }
        return allPlayers;
    }

    public void add(Player[] players, Player target){
        Player[] anotherArray = new Player[players.length + 1];
        for (int i = 0; i < anotherArray.length - 1; ++i)
            anotherArray[i] = players[i];   //заполняем новый массив старыми значениями
        anotherArray[anotherArray.length - 1] = target; //и на последнее место добавляем новый элемент
        players = anotherArray;
    }

    @Override
    public Player[] getLeaguePlayers(League league) {
        Player[] leaguePlayers = new Player[0];
        for (Player player: players.values()){
            if (player.getLeague().equals(league))
                add(leaguePlayers, player);
        }
        return leaguePlayers;
    }

    @Override
    public Player[] getTeamPlayers(Team team) {
        Player[] teamPlayers = new Player[0];
        for (Player player: players.values()){
            if (player.getTeam().equals(team))
                add(teamPlayers, player);
        }
        return teamPlayers;
    }

    @Override
    public void addScorePoints(String name, int points) {
        players.get(name).setScore(points);
    }
}
