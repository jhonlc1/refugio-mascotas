package model;

/**
 * Proceso de adopción: relaciona mascota, adoptante y encargado.
 */
public class Adopcion {

    private int id;
    private int mascotaId;
    private int adoptanteId;
    private int encargadoId;
    private String fecha;
    private String estado;

    public static final String SOLICITADA = "SOLICITADA";
    public static final String APROBADA = "APROBADA";
    public static final String RECHAZADA = "RECHAZADA";
    public static final String FINALIZADA = "FINALIZADA";

    public Adopcion(int id, int mascotaId, int adoptanteId, int encargadoId, String fecha, String estado) {
        this.id = id;
        this.mascotaId = mascotaId;
        this.adoptanteId = adoptanteId;
        this.encargadoId = encargadoId;
        this.fecha = fecha;
        this.estado = estado;
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

    public int getAdoptanteId() {
        return adoptanteId;
    }

    public void setAdoptanteId(int adoptanteId) {
        this.adoptanteId = adoptanteId;
    }

    public int getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(int encargadoId) {
        this.encargadoId = encargadoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Adopcion{id=" + id +
                ", mascotaId=" + mascotaId +
                ", adoptanteId=" + adoptanteId +
                ", encargadoId=" + encargadoId +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
