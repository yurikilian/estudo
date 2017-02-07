package kilian.solutions.aplicacao.processador;

import kilian.solutions.aplicacao.core.Entidade;
import kilian.solutions.aplicacao.core.Processador;
import kilian.solutions.aplicacao.entidade.Cliente;

public class ProcessadorCliente implements Processador {

    @Override
    public Entidade processar(String[] colunas) {
        final String cnpj = colunas[1];
        final String nome = colunas[2];
        final String ramoAtividade = colunas[3];
        return new Cliente(cnpj, nome, ramoAtividade);
    }

}
