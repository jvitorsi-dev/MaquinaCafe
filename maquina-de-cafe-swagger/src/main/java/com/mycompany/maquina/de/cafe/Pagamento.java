/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina.de.cafe;

/**
 *
 * @author lab5
 */
public class Pagamento {
    private double valor;
    private StatusPagamento status;
    private TipoPagamento tipo;

    public Pagamento(double valor) {
        this.valor = valor;
        this.status = StatusPagamento.Pendente;
    }

    public void escolherFormaPagamento(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public boolean processarPagamento() {
        // Simulação simples
        if (tipo != null) {
            status = StatusPagamento.Aprovado;
            return true;
        } else {
            status = StatusPagamento.Recusado;
            return false;
        }
    }

    public StatusPagamento getStatus() {
        return status;
    }
}
