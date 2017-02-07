package kilian.solutions.aplicacao.entidade;

public class Resumo {

    private int quantidadeClientes;
    private int quantidadeVendedores;
    private String idVendaMaisCara;
    private String nomeVendedorPoucasVendas;

    @Override
    public String toString() {
        return new StringBuilder().append("1. Quantidade de Clientes: ").append(this.quantidadeClientes).append("\n")
                .append("2. Quantidade de Vendedores: ").append(this.quantidadeVendedores).append("\n")
                .append("3. ID da Venda de valor mais alto:").append(this.idVendaMaisCara).append("\n")
                .append("4. Nome do Vendedor que menos vendeu:").append(this.nomeVendedorPoucasVendas).append("\n")
                .toString();
    }

    public void setQuantidadeClientes(int quantidadeClientes) {
        this.quantidadeClientes = quantidadeClientes;
    }

    public void setQuantidadeVendedores(int quantidadeVendedores) {
        this.quantidadeVendedores = quantidadeVendedores;
    }

    public void setIdVendaMaisCara(String idVendaMaisCara) {
        this.idVendaMaisCara = idVendaMaisCara;
    }

    public void setNomeVendedorPoucasVendas(String nomeVendedorPoucasVendas) {
        this.nomeVendedorPoucasVendas = nomeVendedorPoucasVendas;
    }

}
