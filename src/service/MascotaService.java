package service;

import java.util.ArrayList;
import model.Mascota;
import repository.MascotaRepository;

/**
 * Capa service: reglas de negocio para mascotas.
 */
public class MascotaService {

    private MascotaRepository repository;

    public MascotaService(MascotaRepository repository) {
        this.repository = repository;
    }

    public String registrarMascota(int id, String nombre, String especie, String raza, int edad, String sexo) {
        if (repository.buscarPorId(id) != null) {
            return "Error: ya existe una mascota con ID " + id;
        }
        Mascota mascota = new Mascota(id, nombre, especie, raza, edad, sexo, Mascota.DISPONIBLE);
        repository.guardar(mascota);
        return "Mascota registrada correctamente.";
    }

    public ArrayList<Mascota> listarMascotas() {
        return repository.listar();
    }

    public Mascota buscarMascota(int id) {
        return repository.buscarPorId(id);
    }

    public boolean actualizarEstado(int id, String nuevoEstado) {
        Mascota m = repository.buscarPorId(id);
        if (m == null) {
            return false;
        }
        m.setEstado(nuevoEstado);
        return true;
    }
}
