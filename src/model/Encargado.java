package model;

/**
 * Encargado del proceso de adopción (personal del refugio).
 */
public class Encargado extends Persona {

    private String cargo;

    public Encargado(int id, String nombre, int edad, String residencia, String telefono, int estrato, String cargo) {
        super(id, nombre, edad, residencia, telefono, estrato);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Encargado{id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", residencia='" + getResidencia() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
