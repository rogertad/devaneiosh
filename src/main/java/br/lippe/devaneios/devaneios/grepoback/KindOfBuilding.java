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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "kindofbuilding")
public class KindOfBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kob", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Building> buildings = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kob", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BuildingLevelsResources> buildingLevelsResources = new ArrayList<>();

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<BuildingLevelsResources> getBuildingLevelsResources() {
        return buildingLevelsResources;
    }

    public void setBuildingLevelsResources(List<BuildingLevelsResources> buildingLevelsResources) {
        this.buildingLevelsResources = buildingLevelsResources;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    
}