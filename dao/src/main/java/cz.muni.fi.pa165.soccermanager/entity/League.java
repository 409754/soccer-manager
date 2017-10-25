package cz.muni.fi.pa165.soccermanager.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;


    //List<Match> matches;

    ArrayList<Match> matches = new ArrayList<Match>();



    public League() {
    }

    public League(String name, String country) {
        this.name = name;
        this.country = country;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;

        League league = (League) o;

      //  if (getCountry() != league.getCountry()) return false;
        if (getId() != null ? !getId().equals(league.getId()) : league.getId() != null) return false;
        if (getName() != null ? !getName().equals(league.getName()) : league.getName() != null) return false;
        return getCountry() != null ? getCountry().equals(league.getCountry()) : league.getCountry() == null;
    }




    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
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
