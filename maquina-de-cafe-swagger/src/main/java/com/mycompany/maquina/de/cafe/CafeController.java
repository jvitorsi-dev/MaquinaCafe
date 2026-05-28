package com.mycompany.maquina.de.cafe;

import com.mycompany.maquina.de.cafe.*;
import com.mycompany.maquina.de.cafe.CafeRequest;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafes")
public class CafeController {

    @PostMapping("/preparar")
    @Operation(summary = "Preparar um café")
    public String prepararCafe(@RequestBody CafeRequest request) {

        Pedido pedido = new Pedido();
        Estoque estoque = new Estoque(20);
        PreparoCafe preparo = new PreparoCafe();

        // Escolher café
        pedido.escolherCafe(request.getCafe());

        // Verificar estoque
        if (!pedido.verificarDisponibilidade(estoque)) {
            return "Produto indisponível";
        }

        // Iniciar pagamento
        pedido.iniciarPagamento(10.0);

        TipoPagamento tipoPagamento =
                request.getPagamento().equalsIgnoreCase("PIX")
                        ? TipoPagamento.Pix
                        : TipoPagamento.Cartao;

        // Processar pagamento
        if (!pedido.processarPagamento(tipoPagamento)) {
            return "Erro no pagamento";
        }

        // Açúcar
        pedido.adoçar(
                TipoAcucar.valueOf(request.getAcucar())
        );

        // Preparar café
        pedido.prepararCafe(preparo);

        return "Seu café está pronto ☕";
    }
}