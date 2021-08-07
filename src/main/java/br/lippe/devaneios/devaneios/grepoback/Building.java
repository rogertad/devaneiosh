package br.lippe.devaneios.devaneios.grepoback;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    private Long level;

    @Override
    public String toString() {
        return " :-)   Building [city=" + city.getName() + ", id=" + id + ", level=" + level + "]";
    }
    

/*     @OneToMany (
        fetch = FetchType.LAZY, 
        mappedBy = "city",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Building> buildings;
 */



 
}