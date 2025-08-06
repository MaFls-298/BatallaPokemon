public class Ronda{
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private int roundWin;

    public Ronda(Pokemon pokemon1, Pokemon pokemon2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        
        iniciarCombate(accion1, accion2);

    }

    private void iniciarCombate(String accion1, String accion2) {
        if (accion1.equals("habilidad")) pokemon1.useHabilidad();
        if (accion2.equals("habilidad")) pokemon2.useHabilidad();

        int ataqueP1 = pokemon1.getAtaqueTotal() - pokemon2.getRivDebuff();
        int ataqueP2 = pokemon2.getAtaqueTotal() - pokemon1.getRivDebuff();

        if (accion1.equals("defender")) ataqueP2 -= pokemon1.getDefensaTotal();
        if (accion2.equals("defender")) ataqueP1 -= pokemon2.getDefensaTotal();

        ataqueP1 += getPokemonElementEff(pokemon1.getElementoPokemon(), pokemon2.getElementoPokemon());
        ataqueP2 += getPokemonElementEff(pokemon2.getElementoPokemon(), pokemon1.getElementoPokemon());

        ataqueP1 = Math.max(0, ataqueP1);
        ataqueP2 = Math.max(0, ataqueP2);

        pokemon2.recibirDanio(ataqueP1);
        pokemon1.recibirDanio(ataqueP2);

        if (pokemon1.getHitpoints() == 0 && pokemon2.getHitpoints() > 0) {
            roundWin = 2;
        } else if (pokemon2.getHitpoints() == 0 && pokemon1.getHitpoints() > 0) {
            roundWin = 1;
        } else if (ataqueP1 > ataqueP2) {
            roundWin = 1;
        } else if (ataqueP2 > ataqueP1) {
            roundWin = 2;
        } else {
            roundWin = 0;
        }

        pokemon1.resetBuffs();
        pokemon2.resetBuffs();
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