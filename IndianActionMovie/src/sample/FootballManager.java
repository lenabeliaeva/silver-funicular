package sample;

interface FootballManager {
    interface Player{
        String getName();
        League getLeague();
        Team getTeam();
        void setScore(int points);
    }

    enum League{
        Premier,
    }

    enum Team{
        Barcelona,
    }

    void addPlayer(Player player);

    void removePlayer(Player player);

    Player getPlayerByName(String name);

    Player[] getAllPlayers();

    Player[] getTeamPlayers(Team team);

    Player[] getLeaguePlayers(League league);

    void addScorePoints(String name, int points);

}
