package kilian.solutions.aplicacao.entidade;

import kilian.solutions.aplicacao.core.Entidade;

public class Cliente implements Entidade {
    private String cnpj;
    private String nome;
    private String ramoAtividade;

    public Cliente(String cnpj, String nome, String ramoAtividade) {
        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.ramoAtividade = ramoAtividade;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

}
