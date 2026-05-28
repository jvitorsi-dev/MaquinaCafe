/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina.de.cafe;

/**
 *
 * @author lab5
 */
public class Pedido {

    private StatusPedido status;
    private TipoAcucar tipoAcucar;
    private Pagamento pagamento;
    private String tipoCafe;

    public Pedido() {
        this.status = StatusPedido.Iniciado;
    }

    public void escolherCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public boolean verificarDisponibilidade(Estoque estoque) {
        return estoque.verificarDisponibilidade();
    }

    public void iniciarPagamento(double valor) {
        this.pagamento = new Pagamento(valor);
        this.status = StatusPedido.AguardandoPagamento;
    }

    public boolean processarPagamento(TipoPagamento tipo) {
        pagamento.escolherFormaPagamento(tipo);
        boolean aprovado = pagamento.processarPagamento();

        if (aprovado) {
            status = StatusPedido.Pago;
        } else {
            status = StatusPedido.Cancelado;
        }

        return aprovado;
    }

    public void prepararCafe(PreparoCafe preparo) {
        if (status != StatusPedido.Pago) return;

        status = StatusPedido.EmPreparo;

        switch (tipoCafe) {
            case "Cappuccino":
                preparo.cappuccino();
                break;
            case "Mocaccino":
                preparo.mocaccino();
                break;
            case "ExtraForte":
                preparo.extraForte();
                break;
            case "CafeClassico":
                preparo.cafeClassico();
                break;
            case "Achocolatado":
                preparo.achocolatado();
                break;
            case "Americano":
                preparo.americano();
                break;
        }

        status = StatusPedido.Finalizado;
    }

    public void adoçar(TipoAcucar tipo) {
        this.tipoAcucar = tipo;

        if (tipo == TipoAcucar.Acucar) {
            System.out.println("Adicionando açúcar...");
        } else if (tipo == TipoAcucar.Adocante) {
            System.out.println("Adicionando adoçante...");
        } else {
            System.out.println("Sem açúcar.");
        }
    }
}
