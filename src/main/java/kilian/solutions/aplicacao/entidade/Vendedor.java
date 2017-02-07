package kilian.solutions.aplicacao.entidade;

import kilian.solutions.aplicacao.core.Entidade;

public class Vendedor implements Entidade {
    private String cpf;
    private String nome;
    private double salario;

    public Vendedor(String cpf, String nome, double salario) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}
