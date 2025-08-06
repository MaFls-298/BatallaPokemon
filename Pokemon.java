
public class Pokemon{
    private String nombrePokemon;
    private String elementoPokemon;
    private int ataqueBase;
    private int defensaBase;
    private int hitpoints;
    private HabilidadEsp habilidadPokemon;

    private int buffAtaque = 0;
    private int buffDefensa = 0;
    private int debuffRival = 0;

    public Pokemon(String nombre, String elementoPokemon, int ataque, int defensa, int hitpoints, HabilidadEsp habilidadPokemon){
        this.nombrePokemon = nombre;
        this.elementoPokemon = elementoPokemon;
        this.ataqueBase = ataque;
        this.defensaBase = defensa;
        this.hitpoints = hitpoints;
        this.habilidadPokemon = habilidadPokemon;
    }

    public String getElementoPokemon(){
        return elementoPokemon;
    }

    public HabilidadEsp getHabilidadPokemon(){
        return habilidadPokemon;
    }

    public int getAtaqueTotal(){
        return ataqueBase + buffAtaque;

    }

    public int getDefensaTotal(){
        return  defensaBase + buffDefensa;
    }

    public int getRivDebuff(){
        return debuffRival;
    } 

    public int getHitpoints(){
        return hitpoints;
    }
    
    public String getNombre() {
        return nombrePokemon;
    }

    public void recibirDanio(int dmgReceived) {
        hitpoints -= dmgReceived;
        if (hitpoints < 0) hitpoints = 0;
    }

    public void useHabilidad() {
        if (habilidadPokemon.tryActivar()) {
            String stat = habilidadPokemon.getStatAfect();
            int valor = habilidadPokemon.getValorHab();

            switch (stat) {
                case "ataque":
                    buffAtaque += valor;
                    break;
                case "defensa":
                    buffDefensa += valor;
                    break;
                case "daño":
                    debuffRival += valor;
                    break;
            }
        }
    }

    public void resetBuffs() {
        buffAtaque = 0;
        buffDefensa = 0;
        debuffRival = 0;
    }

}