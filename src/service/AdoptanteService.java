package service;

import java.util.ArrayList;
import model.Adoptante;
import repository.AdoptanteRepository;

public class AdoptanteService {

    private AdoptanteRepository repository;

    public AdoptanteService(AdoptanteRepository repository) {
        this.repository = repository;
    }

    public String registrarAdoptante(int id, String nombre, int edad, String residencia, String telefono, int estrato, String fechaRegistro) {
        if (repository.buscarPorId(id) != null) {
            return "Error: ya existe un adoptante con ID " + id;
        }
        Adoptante adoptante = new Adoptante(id, nombre, edad, residencia, telefono, estrato, fechaRegistro);
        repository.guardar(adoptante);
        return "Persona interesada registrada correctamente.";
    }

    public ArrayList<Adoptante> listarAdoptantes() {
        return repository.listar();
    }

    public Adoptante buscarAdoptante(int id) {
        return repository.buscarPorId(id);
    }
}
