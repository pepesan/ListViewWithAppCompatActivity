package com.cursosdedesarrollo.listviewwithappcompatactivity;

import java.io.Serializable;

/**
 * Created by pepesan on 16/10/15.
 */
public class Chorbi implements Serializable {


    private Integer id;
    private String name;
    private String tlf;

    public Chorbi(Integer id, String name, String tlf) {
        this.id = id;
        this.name = name;
        this.tlf = tlf;
    }

    public Chorbi() {
        this.id = 0;
        this.name = "";
        this.tlf = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return "Chorbi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tlf='" + tlf + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chorbi chorbi = (Chorbi) o;

        if (id != null ? !id.equals(chorbi.id) : chorbi.id != null) return false;
        if (name != null ? !name.equals(chorbi.name) : chorbi.name != null) return false;
        return !(tlf != null ? !tlf.equals(chorbi.tlf) : chorbi.tlf != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tlf != null ? tlf.hashCode() : 0);
        return result;
    }
}
