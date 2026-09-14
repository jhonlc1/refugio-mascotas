package repository;

import java.util.ArrayList;
import model.Adoptante;

public class AdoptanteRepository {

    private ArrayList<Adoptante> adoptantes;

    public AdoptanteRepository() {
        this.adoptantes = new ArrayList<>();
    }

    public boolean guardar(Adoptante adoptante) {
        if (buscarPorId(adoptante.getId()) != null) {
            return false;
        }
        adoptantes.add(adoptante);
        return true;
    }

    public ArrayList<Adoptante> listar() {
        return new ArrayList<>(adoptantes);
    }

    public Adoptante buscarPorId(int id) {
        for (Adoptante a : adoptantes) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public int contar() {
        return adoptantes.size();
    }
}
