package model;

/**
 * Clase base para personas del sistema (adoptantes y encargados).
 * Atributos privados (encapsulamiento) y constructor completo.
 */
public class Persona {

    private int id;
    private String nombre;
    private int edad;
    private String residencia;
    private String telefono;
    private int estrato;

    public Persona(int id, String nombre, int edad, String residencia, String telefono, int estrato) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.residencia = residencia;
        this.telefono = telefono;
        this.estrato = estrato;
    }

    /** Constructor compatible con la versión inicial del proyecto. */
    public Persona(String nombre, Integer id, int edad, int estrato_economico, String residencia) {
        this(id, nombre, edad, residencia, "No registra", estrato_economico);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    /** Compatibilidad con el nombre anterior del atributo. */
    public int getEstrato_economico() {
        return estrato;
    }

    public void setEstrato_economico(int estrato_economico) {
        this.estrato = estrato_economico;
    }

    @Override
    public String toString() {
        return "Persona{id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", residencia='" + residencia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estrato=" + estrato +
                '}';
    }
}
