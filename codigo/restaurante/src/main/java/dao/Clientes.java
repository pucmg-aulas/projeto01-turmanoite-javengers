package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.model.Cliente;

public class Clientes extends AbstractDao implements Serializable {

    private List<Cliente> clientes;
    private static Clientes instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Clientes.dat";

    private Clientes() {
        this.clientes = new ArrayList<>();
        carregaClientes();
    }

    public static Clientes getInstance() {
        if (instance == null)
            instance = new Clientes();
        return instance;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        grava();
    }

    private void carregaClientes() {
        this.clientes = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, clientes);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
        grava();
    }

    public Optional<Cliente> buscarClientePorNome(String nome) {
        return clientes.stream()
                       .filter(cliente -> cliente.getNome().equals(nome)) 
                       .findFirst();
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf) {
        return clientes.stream()
                       .filter(cliente -> cliente.getCpf().equals(cpf)) 
                       .findFirst(); 
    }

    public boolean altera(Cliente clienteExistente, String nomeAnterior) {
        try {
            clientes = clientes.stream()
                               .map(cliente -> cliente.getNome().equals(nomeAnterior) ? clienteExistente : cliente) // substitui o cliente de nome anterior por um existente
                               .collect(Collectors.toList());
            grava();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}