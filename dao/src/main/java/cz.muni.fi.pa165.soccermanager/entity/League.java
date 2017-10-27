package cz.muni.fi.pa165.soccermanager.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

public class League {

    public static class LeagueBuilder {


        private  String name;
        private  String country;
        private Set<Match> matches;


        public LeagueBuilder(String name, String country,Set<Match> matches) {
            this.name = name;
            this.country = country;
            this.matches=matches;
        }

        public LeagueBuilder players(Set<Match> matches) {
            this.matches = matches;
            return this;
        }

        public LeagueBuilder name(String name) {
            this.name = name;
            return this;
        }

        public LeagueBuilder country(String country){
            this.country = country;
            return this;
        }

        public League build() {
            return new League(this);
        }

    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String country;


    @OneToMany
    @JoinTable(name = "LEAGUE_MATCHES",
            joinColumns = @JoinColumn(name = "LEAGUE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MATCH_ID"))
    private Set<Match> matches;


    public League() {
    }

    private League(LeagueBuilder builder){
        name = builder.name;
        country = builder.country;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Match> getMatches() {
                return Collections.unmodifiableSet(matches);
            }

    public void setMatches(Set<Match> matches) {
                this.matches = matches;
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;

        League league = (League) o;


        if (matches != null ? !matches.equals(league.matches) : league.matches != null) return false;
        if (getName() != null ? !getName().equals(league.getName()) : league.getName() != null) return false;
        return getCountry() != null ? getCountry().equals(league.getCountry()) : league.getCountry() == null;
    }




    @Override
    public int hashCode() {
        int result = matches != null ? matches.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "league {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
