package kilian.solutions.aplicacao.resumo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import kilian.solutions.aplicacao.core.Entidade;
import kilian.solutions.aplicacao.entidade.Cliente;
import kilian.solutions.aplicacao.entidade.Resumo;
import kilian.solutions.aplicacao.entidade.Venda;
import kilian.solutions.aplicacao.entidade.Vendedor;

public class GeradorResumoVendas {

    private List<Entidade> clientes;
    private List<Entidade> vendedores;
    private List<Venda> vendas;

    public GeradorResumoVendas(List<Entidade> entidades) {
        clientes =
                entidades.stream().filter(e -> e instanceof Cliente).map(e -> (Cliente) e).collect(Collectors.toList());
        vendedores = entidades.stream().filter(e -> e instanceof Vendedor).map(e -> (Vendedor) e)
                .collect(Collectors.toList());
        vendas = entidades.stream().filter(e -> e instanceof Venda).map(e -> (Venda) e).collect(Collectors.toList());
    }

    public Resumo gerar() {
        final Resumo resumo = new Resumo();

        resumo.setQuantidadeClientes(clientes.size());
        resumo.setQuantidadeVendedores(vendedores.size());
        resumo.setNomeVendedorPoucasVendas(this.calcularMenorQuantidadeVendas());
        final Optional<Venda> maiorVenda = calcularVendaMaiorValor();
        resumo.setIdVendaMaisCara(maiorVenda.isPresent() ? maiorVenda.get().getId() : "");

        return resumo;
    }


    public String calcularMenorQuantidadeVendas() {
        final Map<String, Integer> vendasAgrupadasPorNome = vendas.stream()
                .collect(Collectors.groupingBy(Venda::getNomeVendedor, Collectors.summingInt(Venda::getQuantidade)));
        final Optional<Entry<String, Integer>> menorVendedor =
                vendasAgrupadasPorNome.entrySet().stream().min(Map.Entry.comparingByValue());
        final Entry<String, Integer> entry = menorVendedor.get();
        return entry.getKey();
    }

    public Optional<Venda> calcularVendaMaiorValor() {
        return this.vendas.stream().collect(Collectors.maxBy(new Comparator<Venda>() {
            @Override
            public int compare(Venda o1, Venda o2) {
                if (o1.getQuantidade() * o1.getItem().getPreco() > o2.getQuantidade() * o1.getItem().getPreco()) {
                    return 1;
                } else if (o1.getQuantidade() * o1.getItem().getPreco() < o2.getQuantidade()
                        * o1.getItem().getPreco()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }));
    }
}
