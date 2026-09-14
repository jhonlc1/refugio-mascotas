package model;

public class Mascota {

     private Integer id;
     private String nombre;
     private int edad;
     private String raza;

    public Mascota(String nombre, Integer id, int edad, String raza) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.raza = raza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" +
                "  MASCOTA [ID: " + id + "]\n" +
                "-----------------------------------\n" +
                " Nombre : " + nombre + "\n" +
                " Edad   : " + edad + " años\n" +
                " Raza   : " + raza + "\n" +
                "-----------------------------------";
    }



}
