import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Atendimento> filaDeEspera = new ArrayList<>();
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();
    private ArrayList<Alimento> cardapio = new ArrayList<>();

    public Restaurante() {
    }

    public Restaurante(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Restaurante(ArrayList<Mesa> mesas, ArrayList<Alimento> cardapio) {
        this.mesas = mesas;
        this.cardapio = cardapio;
    }

    public Restaurante(ArrayList<Mesa> mesas, ArrayList<Atendimento> filaDeEspera,
            ArrayList<Atendimento> atendimentos) {
        this.mesas = mesas;
        this.filaDeEspera = filaDeEspera;
        this.atendimentos = atendimentos;
    }

    public ArrayList<Atendimento> getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(ArrayList<Atendimento> filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void adicionaFilaDeEspera(Atendimento atendimento) {
        filaDeEspera.add(atendimento);
    }

    public void removeFilaDeEspera(Atendimento atendimento) {
        filaDeEspera.remove(atendimento);
    }


    public ArrayList<Alimento> getCardapio() {
        return cardapio;
    }

    public void removeReserva(Atendimento atendimento) {
        System.out.println("\nHora de entrada: " + atendimento.getDataHoraEntrada().getHour() + ":"
                + atendimento.getDataHoraEntrada().getMinute());
        System.out.println("Hora de saída: " + atendimento.getDataHoraSaida().getHour() + ":"
                + atendimento.getDataHoraSaida().getMinute());
        atendimento.getMesa().setOcupada(false);
        atendimentos.remove(atendimento);
        verificaFilaDeEspera();
    }

    public int quantidadeAtendimentos() {
        return atendimentos.size();
    }

    public int quantidadeFilaDeEspera() {
        return filaDeEspera.size();
    }

    public boolean verificaFilaDeEspera() {
        for (Atendimento atendimento : filaDeEspera) {
            if (fazReservaDeMesa(atendimento)) {
                System.out.println("\nFila de espera andou! Atendimento do cliente "
                        + atendimento.getCliente().getNome() + " foi realizado!");
                return true;
            }
        }
        return false;
    }

    public boolean fazReservaDeMesa(Atendimento atendimento) {
        for (Mesa mesa : this.mesas) {
            if (!mesa.isOcupada()) {
                if (mesa.getQuantCadeiras() >= atendimento.getQuantPessoas()) {
                    atendimentos.add(atendimento);
                    atendimento.setMesa(mesa);
                    mesa.setOcupada(true);
                    removeFilaDeEspera(atendimento);
                    return true;
                }
            }
        }
        return false;
    }

    public void exibeMesasDisponiveis() {
        int indice = 1;

        System.out.println("Mesas disponíveis: \n");

        for (Mesa mesa : this.mesas) {
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + indice + " com " + mesa.getQuantCadeiras() + " cadeiras");
                indice++;
            }
        }
        System.out.println();
    }

    public void exibeAtendimentos() {
        int indice = 1;

        if (atendimentos.size() == 0) {
            System.out.println("Não há clientes no momento.");
            return;
        }

        System.out.println("Clientes: \n");

        for (Atendimento atendimento : atendimentos) {
            System.out.println(indice + ": " + atendimento.getCliente().getNome() + " com "
                    + atendimento.getQuantPessoas() + " pessoas.");
            indice++;
        }
        System.out.println();
    }

    public void exibeFilaDeEspera() {
        int indice = 1;

        if (filaDeEspera.size() == 0) {
            System.out.println("Não há clientes na fila de espera no momento.");
            return;
        }

        System.out.println("Clientes na fila de espera: \n");

        for (Atendimento atendimento : filaDeEspera) {
            System.out.println(indice + ": " + atendimento.getCliente().getNome() + " com "
                    + atendimento.getQuantPessoas() + " pessoas.");
            indice++;
        }
        System.out.println();
    }

    public void exibeCardapio() {
        int indice = 1;

        System.out.println("Cardápio: \n");

        for (Alimento alimento : cardapio) {
            System.out.println(indice + ": " + alimento.toString());
            indice++;
        }
    }

}
