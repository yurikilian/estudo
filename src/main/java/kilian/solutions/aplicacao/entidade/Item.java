package kilian.solutions.aplicacao.entidade;

import kilian.solutions.aplicacao.core.Entidade;

public class Item implements Entidade {
    private String id;
    private double preco;

    public Item(String id, double preco) {
        super();
        this.id = id;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

}
