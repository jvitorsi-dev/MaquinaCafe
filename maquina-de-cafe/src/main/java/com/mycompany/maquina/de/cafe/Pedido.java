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
    public Cafe cafeEscolhido;
    
    public Cafe escolherCafe(String tipoCafe, boolean acucar){
        cafeEscolhido = switch (tipoCafe) {
            case "Café clássico" -> new CafeClassico(acucar);
            case "Extra forte" -> new ExtraForte(acucar);
            case "Cappuccino" -> new Cappuccino(acucar);
            case "Achocolatado" -> new Achocolatado(acucar);
            case "Mocaccino" -> new Mocaccino(acucar);
            default -> null;
        };
        
        return cafeEscolhido;
    }
    
    public String escolherFormaPagamento(String formaPagamento){
        if(formaPagamento.equals("Pix")){
            return "Forma escolhida: Pix";
        }
        else{
            return "Forma escolhida: Cartão";
        }
    }
    
    public boolean pagar(double preco, String formaPgto){
        try{
            //Rotina de pagamento com preco e formaPgto
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean verificarDisponibilidade(Cafe cafe){        
        return cafe.getDoses() > 0;
    }
    
    public void atualizarDoses(Cafe cafeEscolhido){
        cafeEscolhido.setDoses(1);
        
        int dosesAtuais = cafeEscolhido.getDoses();
        
        if(dosesAtuais > 15){
            cafeEscolhido.setLuzDisponibilidade("Luz Verde");
        }
        else if(dosesAtuais < 15 && dosesAtuais > 0){
            cafeEscolhido.setLuzDisponibilidade("Luz Amarela");
        }
        else if(dosesAtuais == 0){
            cafeEscolhido.setLuzDisponibilidade("Luz Vermelha");
        }
    }
    
    public void prepararCafe(){
        //Rotina para preparar café
    }
}
