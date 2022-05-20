package com.example.springbootapiassignment.entity;

import javax.persistence.*;

//Partee Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "parts") //This is for the actual name of the database table we are mapping to the class.
public class Part {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "part_name") //This will map the partName field to the column named part_name in the table.
    private String partName;

    @Column(name = "part_origin") //This will map the partOrigin field to the column named part_origin in the table.
    private String partOrigin;

    @Column(name = "part_qty") //This will map the partQty field to the column named part_qty in the table.
    private int partQty;

    //default constructor
    public Part() {
    }

    //para constructor
    public Part(int id, String partName, String partOrigin, int partQty) {
        this.id = id;
        this.partName = partName;
        this.partOrigin = partOrigin;
        this.partQty = partQty;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartOrigin() {
        return partOrigin;
    }

    public void setPartOrigin(String partOrigin) {
        this.partOrigin = partOrigin;
    }

    public int getPartQty() {
        return partQty;
    }

    public void setPartQty(int partQty) {
        this.partQty = partQty;
    }

    //ToString Method
    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partOrigin='" + partOrigin + '\'' +
                ", partQty=" + partQty +
                '}';
    }

}
