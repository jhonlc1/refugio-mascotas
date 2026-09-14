package model;

/**
 * Persona interesada en adoptar. Hereda de Persona.
 */
public class Adoptante extends Persona {

    private String fechaRegistro;

    public Adoptante(int id, String nombre, int edad, String residencia, String telefono, int estrato, String fechaRegistro) {
        super(id, nombre, edad, residencia, telefono, estrato);
        this.fechaRegistro = fechaRegistro;
    }

    /** Constructor compatible con la versión inicial del proyecto. */
    public Adoptante(String nombre, Integer id, int edad, int estrato_economico, String residencia) {
        super(nombre, id, edad, estrato_economico, residencia);
        this.fechaRegistro = "No registra";
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Adoptante{id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", residencia='" + getResidencia() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", estrato=" + getEstrato() +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }
}
