package kilian.solutions.aplicacao.processador;

import kilian.solutions.aplicacao.core.Entidade;
import kilian.solutions.aplicacao.core.Processador;
import kilian.solutions.aplicacao.entidade.Item;
import kilian.solutions.aplicacao.entidade.Venda;

public class ProcessadorVenda implements Processador {

    @Override
    public Entidade processar(String[] colunas) {
        final String id = colunas[1];

        final String idItem = colunas[2];
        final double valorItem = Double.parseDouble(colunas[4]);
        final Item item = new Item(idItem, valorItem);
        final String nomeVendedor = colunas[5];

        final int quantidadeItens = Integer.parseInt(colunas[3]);
        return new Venda(id, item, quantidadeItens, nomeVendedor);
    }

}
