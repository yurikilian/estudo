package kilian.solutions.aplicacao;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import kilian.solutions.aplicacao.entidade.Resumo;
import kilian.solutions.aplicacao.exception.ApplicationException;
import kilian.solutions.aplicacao.gerenciador.GravadorArquivo;
import kilian.solutions.aplicacao.gerenciador.LeitorArquivo;
import kilian.solutions.aplicacao.resumo.GeradorResumoVendas;

public class Aplicacao {
    private static final String EXTENSOES_PERMITIDAS = "*.{dat}";
    private static final String SUFIXO_ARQUIVO_PROCESSADO = ".proc";
    private static final String DIRETORIO_ENTRADA = "dados//in";
    private static final String DIRETORIO_SAIDA = "dados//out//";


    public static void main(String[] args) {
        try (final DirectoryStream<Path> directoryStream =
                Files.newDirectoryStream(Paths.get(DIRETORIO_ENTRADA), EXTENSOES_PERMITIDAS)) {
            directoryStream.forEach(arquivoEntrada -> {
                try {
                    final LeitorArquivo leitorArquivo = new LeitorArquivo(arquivoEntrada);

                    Files.createDirectories(Paths.get(DIRETORIO_SAIDA));
                    final GravadorArquivo gravadorArquivo = new GravadorArquivo(Paths
                            .get(DIRETORIO_SAIDA + "//" + arquivoEntrada.getFileName() + SUFIXO_ARQUIVO_PROCESSADO));
                    final Resumo resumoVendas = new GeradorResumoVendas(leitorArquivo.ler()).gerar();
                    gravadorArquivo.gravar(resumoVendas.toString());
                } catch (final ApplicationException e) {
                    throw new ApplicationException(e);
                } catch (final IOException e) {
                    throw new ApplicationException(e);
                }
            });
        } catch (final IOException ioException) {
            throw new ApplicationException(ioException);
        }
    }

}
