package cz.muni.fi.pa165.soccermanager.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Jan Novak
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date born;
    private int position;
    private String nationality;
    private int number;

    public Player() {
    }

    public Player(String name, Date born, int position, String nationality, int number) {
        this.name = name;
        this.born = born;
        this.position = position;
        this.nationality = nationality;
        this.number = number;
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

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (getPosition() != player.getPosition()) return false;
        if (getNumber() != player.getNumber()) return false;
        if (getId() != null ? !getId().equals(player.getId()) : player.getId() != null) return false;
        if (getName() != null ? !getName().equals(player.getName()) : player.getName() != null) return false;
        if (getBorn() != null ? !getBorn().equals(player.getBorn()) : player.getBorn() != null) return false;
        return getNationality() != null ? getNationality().equals(player.getNationality()) : player.getNationality() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getBorn() != null ? getBorn().hashCode() : 0);
        result = 31 * result + getPosition();
        result = 31 * result + (getNationality() != null ? getNationality().hashCode() : 0);
        result = 31 * result + getNumber();
        return result;
    }

    @Override
    public String toString() {
        return "Player {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", born=" + born +
                ", position=" + position +
                ", nationality='" + nationality + '\'' +
                ", number=" + number +
                '}';
    }
}
