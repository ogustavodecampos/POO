import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CadastraEquipe {
    private List<Equipe> equipes;

    public CadastraEquipe() {
        this.equipes = new ArrayList<>();
    }

    public void cadastrarEquipe(String codinome, int qtd, double latitude, double longitude)
            throws IllegalArgumentException {

        if (equipes.stream().anyMatch(equipe -> equipe.getCodinome().equals(codinome))) {
            throw new IllegalArgumentException("Erro: O codinome já existe. Tente novamente.");
        }


        if (qtd < 0 || latitude < 0 || longitude < 0) {
            throw new IllegalArgumentException("Erro: Valores inválidos. Certifique-se de que são positivos.");
        }

        Equipe novaEquipe = new Equipe(codinome, qtd, latitude, longitude);
        equipes.add(novaEquipe);


        Collections.sort(equipes, (e1, e2) -> e1.getCodinome().compareTo(e2.getCodinome()));
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }
}
