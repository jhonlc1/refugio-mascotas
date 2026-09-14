package model;

public class Adoptante  extends  Persona{

    private int identrega;
    private Mascota mascota;


    public Adoptante(String nombre, Integer id, int edad, int estrato_economico, String residencia) {
        super(nombre, id, edad, estrato_economico, residencia);
    }

    public Adoptante(String nombre, Integer id, int edad, int estrato_economico, String residencia,int identrega , Mascota mascota) {
        super(nombre, id, edad, estrato_economico, residencia);
    }

    public int getIdentrega() {
        return identrega;
    }

    public void setIdentrega(int identrega) {
        this.identrega = identrega;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
