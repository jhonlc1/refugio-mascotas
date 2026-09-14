package service;

import java.util.ArrayList;
import model.Adopcion;
import model.Mascota;
import repository.AdopcionRepository;
import repository.AdoptanteRepository;
import repository.EncargadoRepository;
import repository.MascotaRepository;

public class AdopcionService {

    private AdopcionRepository adopcionRepository;
    private MascotaRepository mascotaRepository;
    private AdoptanteRepository adoptanteRepository;
    private EncargadoRepository encargadoRepository;

    public AdopcionService(AdopcionRepository adopcionRepository, MascotaRepository mascotaRepository,
                           AdoptanteRepository adoptanteRepository, EncargadoRepository encargadoRepository) {
        this.adopcionRepository = adopcionRepository;
        this.mascotaRepository = mascotaRepository;
        this.adoptanteRepository = adoptanteRepository;
        this.encargadoRepository = encargadoRepository;
    }

    public String crearSolicitud(int id, int mascotaId, int adoptanteId, int encargadoId, String fecha) {
        if (adopcionRepository.buscarPorId(id) != null) {
            return "Error: ya existe un proceso con ID " + id;
        }
        Mascota mascota = mascotaRepository.buscarPorId(mascotaId);
        if (mascota == null) {
            return "Error: no existe la mascota con ID " + mascotaId;
        }
        if (adoptanteRepository.buscarPorId(adoptanteId) == null) {
            return "Error: no existe el adoptante con ID " + adoptanteId;
        }
        if (encargadoRepository.buscarPorId(encargadoId) == null) {
            return "Error: no existe el encargado con ID " + encargadoId;
        }
        if (mascota.getEstado().equals(Mascota.ADOPTADA)) {
            return "Error: la mascota ya fue adoptada.";
        }
        Adopcion adopcion = new Adopcion(id, mascotaId, adoptanteId, encargadoId, fecha, Adopcion.SOLICITADA);
        adopcionRepository.guardar(adopcion);
        mascota.setEstado(Mascota.EN_PROCESO);
        return "Proceso de adopción creado (SOLICITADA).";
    }

    public String cambiarEstado(int adopcionId, String nuevoEstado) {
        Adopcion adopcion = adopcionRepository.buscarPorId(adopcionId);
        if (adopcion == null) {
            return "Error: no existe el proceso con ID " + adopcionId;
        }
        adopcion.setEstado(nuevoEstado);
        Mascota mascota = mascotaRepository.buscarPorId(adopcion.getMascotaId());
        if (mascota != null) {
            if (nuevoEstado.equals(Adopcion.FINALIZADA) || nuevoEstado.equals(Adopcion.APROBADA)) {
                mascota.setEstado(Mascota.ADOPTADA);
            } else if (nuevoEstado.equals(Adopcion.RECHAZADA)) {
                mascota.setEstado(Mascota.DISPONIBLE);
            }
        }
        return "Proceso " + adopcionId + " actualizado a " + nuevoEstado + ".";
    }

    public ArrayList<Adopcion> listarAdopciones() {
        return adopcionRepository.listar();
    }

    public Adopcion buscarAdopcion(int id) {
        return adopcionRepository.buscarPorId(id);
    }
}
