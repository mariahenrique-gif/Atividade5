package AgendaMH;
import java.util.Collection;

public class AgendaHeloisaTest {

    public static void main(String[] args) {
        try {
            Agenda agenda = new AgendaHeloisa();

            //CADASTRO
            System.out.println(">>> Cadastro de contatos:");
            agenda.cadastraContato("Maria", 9, 2);
            agenda.cadastraContato("João", 10, 2);
            agenda.cadastraContato("Ana", 9, 2);
            System.out.println("Contatos cadastrados com sucesso!\n");

            //PESQUISA
            System.out.println(">>> Pesquisa de aniversariantes em 9/2:");
            Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(9, 2);
            for (Contato c : aniversariantes) {
                System.out.println(c);
            }
            System.out.println();

            //REMOÇÃO
            System.out.println(">>> Remoção de contato:");
            agenda.removeContato("João");
            System.out.println("Contato João removido com sucesso!\n");

            // PERSISTÊNCIA
            System.out.println(">>> Salvando dados...");
            agenda.salvarDados();

            System.out.println(">>> Recuperando dados...");
            agenda.recuperarDados();

            // Verifica se João foi realmente removido
            System.out.println(">>> Contatos após recuperação:");
            for (Contato c : agenda.pesquisaAniversariantes(9, 2)) {
                System.out.println(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
