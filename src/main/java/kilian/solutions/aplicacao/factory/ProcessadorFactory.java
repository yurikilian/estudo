package kilian.solutions.aplicacao.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import kilian.solutions.aplicacao.core.Processador;
import kilian.solutions.aplicacao.exception.ApplicationException;
import kilian.solutions.aplicacao.exception.FactoryNotFoundException;
import kilian.solutions.aplicacao.processador.ProcessadorCliente;
import kilian.solutions.aplicacao.processador.ProcessadorVenda;
import kilian.solutions.aplicacao.processador.ProcessadorVendedor;

public class ProcessadorFactory {
    private static final Map<String, Class<?>> dicionario =
            Collections.unmodifiableMap(new HashMap<String, Class<?>>() {
                private static final long serialVersionUID = 1L;
                {
                    put("001", ProcessadorVendedor.class);
                    put("002", ProcessadorCliente.class);
                    put("003", ProcessadorVenda.class);
                }
            });

    public static Processador get(String tipo) throws ApplicationException {
        final Optional<?> optional = Optional.ofNullable(dicionario.get(tipo));
        final Class<?> clazz = (Class<?>) optional.get();
        Processador processador;
        try {
            processador = (Processador) clazz.newInstance();
        } catch (final Exception ex) {
            throw new FactoryNotFoundException(tipo);
        }
        return processador;
    }

}
