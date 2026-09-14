package model;

/**
 * Representa una mascota del refugio.
 * Aplica encapsulamiento con atributos privados y constructor completo.
 */
public class Mascota {

    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String sexo;
    private String estado;

    public static final String DISPONIBLE = "DISPONIBLE";
    public static final String EN_PROCESO = "EN_PROCESO";
    public static final String ADOPTADA = "ADOPTADA";

    public Mascota(int id, String nombre, String especie, String raza, int edad, String sexo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.estado = estado;
    }

    /** Constructor simplificado: por defecto DISPONIBLE. */
    public Mascota(int id, String nombre, String especie, String raza, int edad, String sexo) {
        this(id, nombre, especie, raza, edad, sexo, DISPONIBLE);
    }

    /** Constructor compatible con la versión inicial del proyecto. */
    public Mascota(String nombre, Integer id, int edad, String raza) {
        this(id, nombre, "Perro", raza, edad, "No registra", DISPONIBLE);
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" +
                "  MASCOTA [ID: " + id + "]\n" +
                "-----------------------------------\n" +
                " Nombre  : " + nombre + "\n" +
                " Especie : " + especie + "\n" +
                " Raza    : " + raza + "\n" +
                " Edad    : " + edad + " anios\n" +
                " Sexo    : " + sexo + "\n" +
                " Estado  : " + estado + "\n" +
                "-----------------------------------";
    }
}
