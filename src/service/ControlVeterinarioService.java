package service;

import java.util.ArrayList;
import model.ControlVeterinario;
import repository.ControlVeterinarioRepository;
import repository.MascotaRepository;

public class ControlVeterinarioService {

    private ControlVeterinarioRepository controlRepository;
    private MascotaRepository mascotaRepository;

    public ControlVeterinarioService(ControlVeterinarioRepository controlRepository, MascotaRepository mascotaRepository) {
        this.controlRepository = controlRepository;
        this.mascotaRepository = mascotaRepository;
    }

    public String registrarControl(int id, int mascotaId, String fecha, String tipo, String descripcion, String veterinario) {
        if (controlRepository.buscarPorId(id) != null) {
            return "Error: ya existe un control con ID " + id;
        }
        if (mascotaRepository.buscarPorId(mascotaId) == null) {
            return "Error: no existe la mascota con ID " + mascotaId;
        }
        ControlVeterinario control = new ControlVeterinario(id, mascotaId, fecha, tipo, descripcion, veterinario);
        controlRepository.guardar(control);
        return "Control veterinario registrado correctamente.";
    }

    public ArrayList<ControlVeterinario> historialPorMascota(int mascotaId) {
        return controlRepository.listarPorMascota(mascotaId);
    }

    public ArrayList<ControlVeterinario> listarControles() {
        return controlRepository.listar();
    }
}
