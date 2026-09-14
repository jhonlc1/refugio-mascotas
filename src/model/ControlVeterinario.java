package model;

/**
 * Control veterinario realizado a una mascota.
 */
public class ControlVeterinario {

    private int id;
    private int mascotaId;
    private String fecha;
    private String tipo;
    private String descripcion;
    private String veterinario;

    public ControlVeterinario(int id, int mascotaId, String fecha, String tipo, String descripcion, String veterinario) {
        this.id = id;
        this.mascotaId = mascotaId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.veterinario = veterinario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "ControlVeterinario{id=" + id +
                ", mascotaId=" + mascotaId +
                ", fecha='" + fecha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", veterinario='" + veterinario + '\'' +
                '}';
    }
}
