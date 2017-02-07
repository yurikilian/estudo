package kilian.solutions.aplicacao.processador;

import kilian.solutions.aplicacao.core.Entidade;
import kilian.solutions.aplicacao.core.Processador;
import kilian.solutions.aplicacao.entidade.Vendedor;

public class ProcessadorVendedor implements Processador {

    @Override
    public Entidade processar(String[] colunas) {
        final String cpf = colunas[1];
        final String nome = colunas[2];
        final Double salario = Double.valueOf(colunas[3]);
        return new Vendedor(cpf, nome, salario);
    }

}
