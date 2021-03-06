package com.kahoot.interview.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ROBOT_PART_COMPATIBLE")
@Table(name = "ROBOT_PART_COMPATIBLE")
public class RobotPartCompatible {

    @Id
    private Long id;

    @Column(name = "serialNumber", nullable = false)
    private String serialNumber;

    @Column(name = "sourceRobotPartId", nullable = false)
    private Long sourceRobotPartId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getSourceRobotPartId() {
        return sourceRobotPartId;
    }

    public void setSourceRobotPartId(Long sourceRobotPartId) {
        this.sourceRobotPartId = sourceRobotPartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RobotPartCompatible that = (RobotPartCompatible) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, that.id)
                .append(serialNumber, that.serialNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(serialNumber)
                .toHashCode();
    }
}
