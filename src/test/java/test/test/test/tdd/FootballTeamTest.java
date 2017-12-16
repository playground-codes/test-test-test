package test.test.test.tdd;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

  @Test
  @Parameters({"0", "3", "5", "9"})
  public void constructorShouldSetGamesWon(int gamesWon) {
    FootballTeam footballTeam = new FootballTeam(gamesWon);
    assertEquals(
        gamesWon
            + " games passed to constructor, but "
            + footballTeam.getGamesWon()
            + " were returned.", gamesWon,
        footballTeam.getGamesWon());
  }

  @Test(expected = IllegalArgumentException.class)
  @Parameters({"-10", "-1"})
  public void constructorShouldThrowExceptionForIllegalGamesWonNumber(int illegalGamesWon) {
    new FootballTeam(illegalGamesWon);
  }

  @Test
  @Parameters({"123"})
  public void shouldBePossibleToCompareTeams(int anyNumber) {
    FootballTeam footballTeam = new FootballTeam(anyNumber);

    assertTrue("FootballTeam should implement Comparable", footballTeam instanceof Comparable);
  }

  @Test
  public void teamsWithMoreMatchesWonShouldBeGreater() {
    final FootballTeam TEAM2 = new FootballTeam(2);
    final FootballTeam TEAM3 = new FootballTeam(3);

    assertTrue("Team with "
            + TEAM3.getGamesWon()
            + " games won should be ranked before the team with"
            + TEAM2.getGamesWon()
            + " games won.",
        TEAM3.compareTo(TEAM2) > 0);
  }

  @Test
  public void teamsWithLessMatchesWonShouldBeLesser() {
    final FootballTeam TEAM2 = new FootballTeam(2);
    final FootballTeam TEAM3 = new FootballTeam(3);

    assertTrue("Team with "
            + TEAM2.getGamesWon()
            + " games won should be ranked after the team with"
            + TEAM3.getGamesWon()
            + " games won.",
        TEAM2.compareTo(TEAM3) < 0);
  }

  @Test
  public void teamsWithEqualMatchesWonShouldBeEqual() {
    final FootballTeam TEAMA = new FootballTeam(2);
    final FootballTeam TEAMB = new FootballTeam(2);

    assertTrue("Team with "
            + TEAMA.getGamesWon()
            + " games won should be ranked equal to team with"
            + TEAMB.getGamesWon()
            + " games won.",
        TEAMA.compareTo(TEAMB) == 0);
  }
}