/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina.de.cafe;

/**
 *
 * @author lab5
 */
public class Estoque {
    private int quantidadeArabico;

    public Estoque(int quantidadeArabico) {
        this.quantidadeArabico = quantidadeArabico;
    }

    public boolean verificarDisponibilidade() {
        return quantidadeArabico > 0;
    }

    public String verificarNivel() {
        if (quantidadeArabico < 15) return "VERDE";
        if (quantidadeArabico > 15) return "AMARELO";
        return "VERMELHO";
    }
}
