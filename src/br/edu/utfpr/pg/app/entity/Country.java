/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pg.app.entity;

/**
 *
 * @author Vinicius
 */
public class Country {

    private int id;
    private String name;
    private String acronym;
    private int phoneDigits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public int getPhoneDigits() {
        return phoneDigits;
    }

    public void setPhoneDigits(int phoneDigits) {
        this.phoneDigits = phoneDigits;
    }
}
