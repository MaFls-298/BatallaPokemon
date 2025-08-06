import java.util.Random;

public class HabilidadEsp{
    private String nombreHabilidad;
    private String statAfect; // stat aque va a  aplicar el buff
    private int valorHab;
    private int randChance;

    public HabilidadEsp(String nombreHabilidad, String statAfect, int valorHab, int randChance){
    
    this.nombreHabilidad = nombreHabilidad;
    this.statAfect = stat;
    this.valorHab = valor;
    this.probabilidad = randChance;
    }
    

    public boolean tryActivar(){
        int randomNum = (int)(Math.random() * 101);
        return randomNum <= randChance;
    }

    public String getNombreHab(){
        return nombreHabilidad;
    }

    public String getStatAfect(){
        return stat;
    }
    
    public int getValorHab(){
        return valor;
    }
    
    public int getRandChance(){
        return randChance;
    }

}