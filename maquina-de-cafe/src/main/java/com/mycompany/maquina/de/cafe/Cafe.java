/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina.de.cafe;

/**
 *
 * @author lab5
 */
public abstract class Cafe {
    private int doses = 30;
    private boolean acucar;
    private double preco;
    private String luzDisponibilidade;

    public Cafe(boolean acucar) {
        this.acucar = acucar;
    }

    public String getLuzDisponibilidade() {
        return luzDisponibilidade;
    }

    public void setLuzDisponibilidade(String luzDisponibilidade) {
        this.luzDisponibilidade = luzDisponibilidade;
    }
    

    public int getDoses() {
        return doses;
    }
    
    public int setDoses(int dose) {
        return doses - dose;
    }

    public boolean isAcucar() {
        return acucar;
    }

    protected void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}