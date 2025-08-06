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

}