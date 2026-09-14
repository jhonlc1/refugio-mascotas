package model;

public class Persona {

    private Integer id;
    private String nombre;
    private int edad;
    private String residencia;
    private int estrato_economico;

    public Persona(String nombre, Integer id, int edad, int estrato_economico, String residencia) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.estrato_economico = estrato_economico;
        this.residencia = residencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getEstrato_economico() {
        return estrato_economico;
    }

    public void setEstrato_economico(int estrato_economico) {
        this.estrato_economico = estrato_economico;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", residencia='" + residencia + '\'' +
                ", estrato_economico=" + estrato_economico +
                '}';
    }
}
