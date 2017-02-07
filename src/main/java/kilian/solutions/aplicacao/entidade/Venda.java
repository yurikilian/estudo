package kilian.solutions.aplicacao.entidade;

import kilian.solutions.aplicacao.core.Entidade;

public class Venda implements Entidade {
    private String id;
    private Item item;
    private int quantidade;
    private String nomeVendedor;

    public Venda(String id, Item item, int quantidade, String nomeVendedor) {
        super();
        this.id = id;
        this.item = item;
        this.quantidade = quantidade;
        this.nomeVendedor = nomeVendedor;
    }

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

}
