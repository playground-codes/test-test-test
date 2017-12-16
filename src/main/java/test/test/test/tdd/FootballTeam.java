package test.test.test.tdd;

public class FootballTeam implements Comparable<FootballTeam> {

  private int gamesWon;

  public FootballTeam(int gamesWon) {
    if (gamesWon < 0) {
      throw new IllegalArgumentException("Games number must be equal or greater than zero.");
    }
    this.gamesWon = gamesWon;
  }

  public int getGamesWon() {
    return gamesWon;
  }

  @Override public int compareTo(FootballTeam otherTeam) {
    return gamesWon - otherTeam.gamesWon;
  }
}
