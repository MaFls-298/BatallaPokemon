import java.util.ArrayList;
import java.util.List;

public class TorneoController {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private List<Pokemon> chosenPokemon1;
    private List<Pokemon> chosenPokemon2;

    public TorneoController(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        this.chosenPokemon1 = new ArrayList<>();
        this.chosenPokemon2 = new ArrayList<>();
        
    }
    public void iniciarTorneo(List<Pokemon> player1P, List<Pokemon> player2P) {
        for (int ronda = 1; ronda <= 4; ronda++) {
            Pokemon pok1 = choosePokemon(player1P, chosenPokemon1);
            Pokemon pok2 = choosePokemon(player2P, chosenPokemon2);

            Ronda combate = new Ronda(pok1, pok2);
            int resultado = combate.getRoundWinner();

            if (resultado == 1) {
                entrenador1.addRondaGanada();
            } else if (resultado == 2) {
                entrenador2.addRondaGanada();
            }

            
            chosenPokemon1.add(pok1);
            chosenPokemon2.add(pok2);
        }
    }

    private Pokemon choosePokemon(List<Pokemon> playerPokemons, List<Pokemon> unav) {
        for (Pokemon p : playerPokemons) {
            if (!unav.contains(p)) {
                return p;
            }
        }
        return null;
    }

    public Entrenador getGanadorTorneo() {
        int g1 = entrenador1.getRondasGanadas();
        int g2 = entrenador2.getRondasGanadas();
        if (g1 > g2) return entrenador1;
        else if (g2 > g1) return entrenador2;
        else return null; 
    }

    public int getPuntajeEntrenador1() {
        return entrenador1.getRondasGanadas();
    }

    public int getPuntajeEntrenador2() {
        return entrenador2.getRondasGanadas();
    }

}