package repository;

import java.util.ArrayList;
import model.Adopcion;

public class AdopcionRepository {

    private ArrayList<Adopcion> adopciones;

    public AdopcionRepository() {
        this.adopciones = new ArrayList<>();
    }

    public boolean guardar(Adopcion adopcion) {
        if (buscarPorId(adopcion.getId()) != null) {
            return false;
        }
        adopciones.add(adopcion);
        return true;
    }

    public ArrayList<Adopcion> listar() {
        return new ArrayList<>(adopciones);
    }

    public Adopcion buscarPorId(int id) {
        for (Adopcion a : adopciones) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public int contar() {
        return adopciones.size();
    }
}
