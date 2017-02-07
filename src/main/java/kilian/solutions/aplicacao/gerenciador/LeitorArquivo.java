package kilian.solutions.aplicacao.gerenciador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import kilian.solutions.aplicacao.core.Entidade;
import kilian.solutions.aplicacao.core.GerenciadorArquivo;
import kilian.solutions.aplicacao.exception.ApplicationException;
import kilian.solutions.aplicacao.factory.ProcessadorFactory;

public class LeitorArquivo extends GerenciadorArquivo {
    private static final String SEPARATOR = ";";
    private List<Entidade> entidadesProcessadas;

    public LeitorArquivo(Path path) {
        super(path);
        entidadesProcessadas = new ArrayList<Entidade>(0);
    }

    public List<Entidade> ler() throws ApplicationException {
        try (final Stream<String> linhas = Files.lines(path)) {
            linhas.forEach(linha -> {
                final String[] colunas = linha.split(SEPARATOR);
                try {
                    entidadesProcessadas.add(ProcessadorFactory.get(colunas[0]).processar(colunas));
                } catch (final ApplicationException e) {
                    e.printStackTrace();
                }
            });
        } catch (final IOException ioException) {
            throw new ApplicationException(ioException);
        }

        return this.entidadesProcessadas;
    }

}
