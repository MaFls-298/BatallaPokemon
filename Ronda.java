public class Ronda{
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private int roundWin;

    public Ronda(Pokemon pokemon1, Pokemon pokemon2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.roundWin = 0;

    }

    private int getPokemonElementEff(String atacante, String defensor) {

        if (atacante.equals("fuego") && defensor.equals("planta")) return 20;
        if (atacante.equals("planta") && defensor.equals("agua")) return 20;
        if (atacante.equals("agua") && defensor.equals("fuego")) return 20;
        if (atacante.equals("eléctrico") && defensor.equals("agua")) return 20;

        if (atacante.equals("fuego") && defensor.equals("agua")) return -10;
        if (atacante.equals("agua") && defensor.equals("planta")) return -10;
        if (atacante.equals("planta") && defensor.equals("fuego")) return -10;

        return 0; 
    }

    public int getRoundWinner() {
        return roundWin;
    }

}