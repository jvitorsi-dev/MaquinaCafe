/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina.de.cafe;

/**
 *
 * @author lab5
 */
public class PreparoCafe {

    public void cappuccino() {
        System.out.println("Preparando Cappuccino...");
        adicionarLeite();
        adicionarEspuma();
    }

    public void mocaccino() {
        System.out.println("Preparando Mocaccino...");
        adicionarChocolate();
        adicionarLeite();
    }

    public void extraForte() {
        System.out.println("Preparando Café Extra Forte...");
        adicionarDoseExtra();
    }

    public void cafeClassico() {
        System.out.println("Preparando Café Clássico...");
    }

    public void achocolatado() {
        System.out.println("Preparando Achocolatado...");
        adicionarChocolate();
    }

    public void americano() {
        System.out.println("Preparando Café Americano...");
        adicionarAgua();
    }

    // 🔧 Métodos auxiliares
    private void adicionarLeite() {
        System.out.println("Adicionando leite...");
    }

    private void adicionarEspuma() {
        System.out.println("Adicionando espuma...");
    }

    private void adicionarChocolate() {
        System.out.println("Adicionando chocolate...");
    }

    private void adicionarDoseExtra() {
        System.out.println("Adicionando dose extra de café...");
    }

    private void adicionarAgua() {
        System.out.println("Adicionando água quente...");
    }
}
