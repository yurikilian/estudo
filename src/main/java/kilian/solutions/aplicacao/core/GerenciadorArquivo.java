package kilian.solutions.aplicacao.core;

import java.nio.file.Path;

public abstract class GerenciadorArquivo {
    protected Path path;

    public GerenciadorArquivo(Path path) {
        this.path = path;
    }
}
