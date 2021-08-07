package br.lippe.devaneios.devaneios.grepoback;

import java.util.ArrayList;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (
        fetch = FetchType.EAGER, 
        mappedBy = "city",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Building> buildings = new ArrayList<>();

    //Logger logger = LoggerFactory.getLogger(City.class);

    public List<Building> getBuildings() {
        return buildings;
    }


    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    private String name;
    private Long stone;
    private Long wood;
    private Long silver;


    public Long getStone() {
        return stone;
    }


    public void setStone(Long stone) {
        this.stone = stone;
    }


    public Long getWood() {
        return wood;
    }


    public void setWood(Long wood) {
        this.wood = wood;
    }


    public Long getSilver() {
        return silver;
    }


    public void setSilver(Long silver) {
        this.silver = silver;
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


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public City() {
    
        
    }


    @Override
    public String toString() {

        StringBuilder sss = new StringBuilder();
        

        for (Building b : buildings) {
            sss.append(b.toString());
            
        }

        return "City [buildings=" + sss + ", id=" + id + ", name=" + name + ", silver=" + silver + ", stone="
                + stone + ", user=" + user + ", wood=" + wood + "]";
    }

    
}

