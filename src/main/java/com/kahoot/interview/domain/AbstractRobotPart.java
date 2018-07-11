package com.kahoot.interview.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractRobotPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String weight;


    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    Set<RobotPartCompatible> compatibleParts = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<RobotPartCompatible> getCompatibleParts() {
        return compatibleParts;
    }

    public void setCompatibleParts(Set<RobotPartCompatible> compatibleParts) {
        this.compatibleParts = compatibleParts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractRobotPart other = (AbstractRobotPart) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id != other.id)
            return false;
        if (serialNumber == null) {
            if (other.serialNumber != null)
                return false;
        } else if (!weight.equals(other.weight))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RobotPart [id=" + id + ", name=" + name + ", serialNumber=" + serialNumber + "]";
    }
}
