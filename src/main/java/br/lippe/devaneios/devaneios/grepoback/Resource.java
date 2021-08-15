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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public List<ResourceCity> getRc() {
        return rc;
    }


    public void setRc(List<ResourceCity> rc) {
        this.rc = rc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BuildingLevelsResources> blr = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resource", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ResourceCity> rc = new ArrayList<>();

    public List<BuildingLevelsResources> getBlr() {
        return blr;
    }


    public void setBlr(List<BuildingLevelsResources> blr) {
        this.blr = blr;
    }

    String name;

    public Resource() {
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

}
