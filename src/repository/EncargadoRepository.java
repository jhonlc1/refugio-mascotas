package repository;

import java.util.ArrayList;
import model.Encargado;

public class EncargadoRepository {

    private ArrayList<Encargado> encargados;

    public EncargadoRepository() {
        this.encargados = new ArrayList<>();
    }

    public boolean guardar(Encargado encargado) {
        if (buscarPorId(encargado.getId()) != null) {
            return false;
        }
        encargados.add(encargado);
        return true;
    }

    public ArrayList<Encargado> listar() {
        return new ArrayList<>(encargados);
    }

    public Encargado buscarPorId(int id) {
        for (Encargado e : encargados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int contar() {
        return encargados.size();
    }
}
