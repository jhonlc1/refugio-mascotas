package service;

import java.util.ArrayList;
import model.Encargado;
import repository.EncargadoRepository;

public class EncargadoService {

    private EncargadoRepository repository;

    public EncargadoService(EncargadoRepository repository) {
        this.repository = repository;
    }

    public String registrarEncargado(int id, String nombre, int edad, String residencia, String telefono, int estrato, String cargo) {
        if (repository.buscarPorId(id) != null) {
            return "Error: ya existe un encargado con ID " + id;
        }
        Encargado encargado = new Encargado(id, nombre, edad, residencia, telefono, estrato, cargo);
        repository.guardar(encargado);
        return "Encargado registrado correctamente.";
    }

    public ArrayList<Encargado> listarEncargados() {
        return repository.listar();
    }

    public Encargado buscarEncargado(int id) {
        return repository.buscarPorId(id);
    }
}
