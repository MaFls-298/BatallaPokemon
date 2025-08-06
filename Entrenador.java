

public class Entrenador{
    private String nombreEntrenador;
    private int rondasGanadas;
    //private List<Pokemon> chosenPokemon; 


    public Entrenador(String nombreEntrenador){
        this.nombreEntrenador = nombreEntrenador;
        this.rondasGanadas = 0;
        //this.chosenPokemon = new ArrayList<>();
    }
    
    public String getNombreEntrenador(){
        return nombreEntrenador;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void addRondaGanada() {
        rondasGanadas++;
    
}

}