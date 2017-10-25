package cz.muni.fi.pa165.soccermanager.entity;

import javax.persistence.*;
import java.util.Date;

public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //homeTeam, awayTeam, place, date, homeTeamGoalsScored, awayTeamGoalsScored

    @Temporal(TemporalType.DATE)
    private Date date;
    private String stadium; // TODO: define enum of stadiums
    private Team homeTeam;
    private Team awayTeam;
    private boolean finished;
    private int homeTeamGoals;
    private int awayTeamGoals;


    public Match() {
    }

    public Match(Date date, String stadium, Team homeTeam, Team awayTeam) {
        this.date = date;
        this.stadium = stadium;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        finished = false;
        homeTeamGoals = 0;
        awayTeamGoals = 0;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getAwayTeamGoals() { return awayTeamGoals; }

    public void setAwayTeamGoals(int awayTeamGoals) { this.awayTeamGoals = awayTeamGoals; }

    public int getHomeTeamGoals() { return homeTeamGoals; }

    public void setHomeTeamGoals(int homeTeamGoals) { this.homeTeamGoals = homeTeamGoals; }

    public Team getAwayTeam() { return awayTeam; }

    public void setAwayTeam(Team awayTeam) { this.awayTeam = awayTeam; }

    public Team getHomeTeam() { return homeTeam; }

    public void setHomeTeam(Team homeTeam) { this.homeTeam = homeTeam; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getStadium() { return stadium; }

    public void setStadium(String stadium) { this.stadium = stadium; }

    public boolean isFinished() { return finished; }

    public void setFinished(boolean finished) { this.finished = finished; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;

        Match match= (Match) o;

        if (getHomeTeam() != match.getHomeTeam()) return false;
        if (getAwayTeam() != match.getAwayTeam()) return false;
        if (getDate() != match.getDate()) return false;
        if (isFinished() != match.isFinished()) return false;
        if (getStadium() != null ? !getStadium().equals(match.getStadium()) : match.getStadium() != null) return false;
        if (getHomeTeamGoals() != match.getHomeTeamGoals()) return false;
        return (getAwayTeamGoals() != match.getAwayTeamGoals());
    }

    @Override
    public int hashCode() {
        int result = getHomeTeam() != null ? getHomeTeam().hashCode() : 0;
        result = 51 * result + (getAwayTeam() != null ? getAwayTeam().hashCode() : 0);
        result = 51 * result + (isFinished() ? 1 : 0);
        result = 51 * result + getHomeTeamGoals();
        result = 51 * result + getAwayTeamGoals();
        result = 51 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 51 * result + (getStadium() != null ? getStadium().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String string = "Match {" +
                "id=" + getId() +
                ", date=" + getDate() + '\'' +
                ", home team=" + getHomeTeam() +
                ", away team=" + getAwayTeam() +
                ", stadium=" + getStadium() + '\'';
        if (isFinished())
            string += ", result=" + getHomeTeamGoals() + ':' + getAwayTeamGoals() + " }\'";
        else
            string += ", match was not finished yet }\'";
        return string;
    }

}
