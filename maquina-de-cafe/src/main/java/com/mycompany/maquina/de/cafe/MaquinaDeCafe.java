/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maquina.de.cafe;
import javax.swing.JOptionPane;
/**
 *
 * @author lab5
 */
public class MaquinaDeCafe {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        Cafe cafeEscolhido;
        boolean acucar;
        String tipoCafe;
        String[] opcoesCafe = {
            "Café clássico",
            "Extra forte",
            "Cappuccino",
            "Achocolatado",
            "Mocaccino"
        };
        String[] comAcucar = {
            "Com",
            "Sem"
        };
        String[] formasPagamento = {
            "Pix",
            "Cartão"
        };
        boolean sucessoPgto;
        
        
        int escolhaCafe = JOptionPane.showOptionDialog(
                null,
                "Escolha seu café:",
                "Cafeteria",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesCafe,
                opcoesCafe[0]
        );
        
        tipoCafe = opcoesCafe[escolhaCafe];
        
        int escolhaAcucar = JOptionPane.showOptionDialog(
                null,
                "Com ou sem açucar:",
                "Cafeteria",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                comAcucar,
                comAcucar[0]
        );
        
        String escolhidoAcucar = comAcucar[escolhaAcucar];
        
        acucar = escolhidoAcucar.equals("Com");
        
        cafeEscolhido = pedido.escolherCafe(tipoCafe, acucar);
        
        if(pedido.verificarDisponibilidade(cafeEscolhido)){
            int escolhaPgto = JOptionPane.showOptionDialog(
                null,
                "Escolha o pagamento:",
                "Cafeteria",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                formasPagamento,
                formasPagamento[0]
            );

            String pgtoEscolhido = formasPagamento[escolhaPgto];

            pgtoEscolhido = pedido.escolherFormaPagamento(pgtoEscolhido);

            sucessoPgto = pedido.pagar(cafeEscolhido.getPreco(), pgtoEscolhido);

            if(!sucessoPgto){
                JOptionPane.showMessageDialog(null,"Houve um erro com o seu pagamento!");
            }
            else{
                pedido.prepararCafe();
                pedido.atualizarDoses(cafeEscolhido);
                JOptionPane.showMessageDialog(null,"Seu café está sendo preparado!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Café não disponível");
        }       
        
    }
}
