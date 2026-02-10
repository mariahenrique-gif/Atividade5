package AgendaMH;
import java.util.*;
import java.io.*;

public class AgendaHeloisa implements Agenda {
    private Map<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaHeloisa() {
        contatos = new HashMap<>();
        gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (contatos.containsKey(nome)) return false;
        contatos.put(nome, new Contato(nome, dia, mes));
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        List<Contato> aniversariantes = new ArrayList<>();
        for (Contato c : contatos.values()) {
            if (c.getDiaAniversario() == dia && c.getMesAniversario() == mes) {
                aniversariantes.add(c);
            }
        }
        return aniversariantes;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if (!contatos.containsKey(nome)) {
            throw new ContatoInexistenteException("Contato " + nome + " não encontrado.");
        }
        contatos.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarContatos(contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        contatos = gravador.recuperarContatos();
    }
}
