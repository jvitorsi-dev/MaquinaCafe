/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maquina.de.cafe;
import javax.swing.JOptionPane;

public class MaquinaDeCafe {
    public static void main(String[] args) {

        Pedido pedido = new Pedido();
        Estoque estoque = new Estoque(20);
        PreparoCafe preparo = new PreparoCafe();

        // Escolher café
        String[] cafes = {
                "Cappuccino",
                "Mocaccino",
                "ExtraForte",
                "CafeClassico",
                "Achocolatado",
                "Americano"
        };

        String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Escolha seu café:",
                "Máquina de Café",
                JOptionPane.QUESTION_MESSAGE,
                null,
                cafes,
                cafes[0]
        );

        if (escolha == null) return;

        pedido.escolherCafe(escolha);

        //  Disponibilidade
        if (!pedido.verificarDisponibilidade(estoque)) {
            JOptionPane.showMessageDialog(null, "Produto indisponível.");
            return;
        }

        // Pagamento
        pedido.iniciarPagamento(10.0); // valor fixo simples

        String[] pagamentos = {"PIX", "Cartão"};
        int escolhaPagamento = JOptionPane.showOptionDialog(
                null,
                "Forma de pagamento:",
                "Pagamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                pagamentos,
                pagamentos[0]
        );

        TipoPagamento tipoPagamento =
                (escolhaPagamento == 0) ? TipoPagamento.Pix : TipoPagamento.Cartao;

        if (!pedido.processarPagamento(tipoPagamento)) {
            JOptionPane.showMessageDialog(null, "Erro no pagamento.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Pagamento aprovado!");

        //  Açúcar
        String[] acucar = {"Açúcar", "Adoçante", "Nenhum"};
        int escolhaAcucar = JOptionPane.showOptionDialog(
                null,
                "Deseja açúcar?",
                "Açúcar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                acucar,
                acucar[0]
        );

        pedido.adoçar(TipoAcucar.values()[escolhaAcucar]);

        // Preparar
        pedido.prepararCafe(preparo);

        JOptionPane.showMessageDialog(null, "Seu café está pronto ☕");
    }
}
