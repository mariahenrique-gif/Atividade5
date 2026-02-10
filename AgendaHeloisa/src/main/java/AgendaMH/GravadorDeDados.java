package AgendaMH;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String ARQUIVO_CONTATOS = "contatos.dat";

    public void salvarContatos(Map<String, Contato> contatos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))) {
            out.writeObject(contatos);
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Contato> recuperarContatos() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))) {
            return (HashMap<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao ler os contatos.", e);
        }
    }
}
