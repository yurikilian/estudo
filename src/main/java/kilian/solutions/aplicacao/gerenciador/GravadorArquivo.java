package kilian.solutions.aplicacao.gerenciador;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import kilian.solutions.aplicacao.core.GerenciadorArquivo;
import kilian.solutions.aplicacao.exception.ApplicationException;

public class GravadorArquivo extends GerenciadorArquivo {

    public GravadorArquivo(Path path) {
        super(path);
    }

    public void gravar(String conteudo) throws ApplicationException {
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write(conteudo);
        } catch (final IOException ioException) {
            throw new ApplicationException(ioException);
        }
    }

}
