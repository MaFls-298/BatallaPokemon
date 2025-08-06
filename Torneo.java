import java.util.*;

public class Torneo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("• • TORNEO POKEMON • • ");
        System.out.print("• bIENVENIDOS, ENTRENADORES •");
        System.out.print("Nombre del Entrenador 1: ");
        Entrenador entrenador1 = new Entrenador(scanner.nextLine());

        System.out.print("Nombre del Entrenador 2: ");
        Entrenador entrenador2 = new Entrenador(scanner.nextLine());

        List<Pokemon> catalogo = getPokemonesDisp();

        List<Pokemon> equipo1 = selectPokemon(scanner, entrenador1.getNombreEntrenador(), catalogo);
        List<Pokemon> equipo2 = selectPokemon(scanner, entrenador2.getNombreEntrenador(), catalogo);

        TorneoController torneo = new TorneoController(entrenador1, entrenador2);
        torneo.iniciarTorneo(equipo1, equipo2);

        System.out.println("Puntaje final:");
        System.out.println(entrenador1.getNombreEntrenador() + ": " + torneo.getPuntajeEntrenador1());
        System.out.println(entrenador2.getNombreEntrenador() + ": " + torneo.getPuntajeEntrenador2());

        Entrenador ganador = torneo.getGanadorTorneo();
        if (ganador != null) {
            System.out.println("GANADOR DEL TORNEO: " + ganador.getNombreEntrenador());
        } else {
            System.out.println("Empate");
        }

        scanner.close();
    }

    private static List<Pokemon> getPokemonesDisp() {
        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon("Charmander", "Fuego", 50, 30, 100, new HabilidadEsp("Llama Final", "ataque", 15, 30)));
        lista.add(new Pokemon("Bulbasaur", "Planta", 45, 35, 100, new HabilidadEsp("Escudo Natural", "defensa", 20, 25)));
        lista.add(new Pokemon("Squirtle", "Agua", 40, 40, 100, new HabilidadEsp("Chorro Rápido", "daño", 10, 40)));
        lista.add(new Pokemon("Pikachu", "Eléctrico", 55, 25, 100, new HabilidadEsp("Impacto Relámpago", "daño", 10, 35)));
        lista.add(new Pokemon("Growlithe", "Fuego", 48, 28, 100, new HabilidadEsp("Colmillo Ígneo", "ataque", 10, 30)));
        lista.add(new Pokemon("Oddish", "Planta", 43, 37, 100,  new HabilidadEsp("Raíces Vivas", "defensa", 15, 20)));
        return lista;
    }
    private static List<Pokemon> selectPokemon(Scanner scanner, String nombreEntrenador, List<Pokemon> catalogo) {
        List<Pokemon> equipo = new ArrayList<>();
        List<Pokemon> disponibles = new ArrayList<>(catalogo);

        System.out.println("\n" + nombreEntrenador + ", selecciona 4 Pokemon:");

        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < disponibles.size(); j++) {
                Pokemon pok = disponibles.get(j);
                System.out.println((j + 1) + ". " + pok.getNombre() + " (" + pok.getElementoPokemon() + ")");
            }

            int opcion = -1;
            while (opcion < 1 || opcion > disponibles.size()) {
                System.out.print("Elige el nuumero del Pokemon " + i + ": ");
                opcion = Integer.parseInt(scanner.nextLine());
            }

            Pokemon elegido = disponibles.remove(opcion - 1);
            equipo.add(elegido);
        }

        return equipo;
    }
}