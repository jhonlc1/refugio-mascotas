package repository;

import java.util.ArrayList;
import model.ControlVeterinario;

public class ControlVeterinarioRepository {

    private ArrayList<ControlVeterinario> controles;

    public ControlVeterinarioRepository() {
        this.controles = new ArrayList<>();
    }

    public boolean guardar(ControlVeterinario control) {
        if (buscarPorId(control.getId()) != null) {
            return false;
        }
        controles.add(control);
        return true;
    }

    public ArrayList<ControlVeterinario> listar() {
        return new ArrayList<>(controles);
    }

    public ControlVeterinario buscarPorId(int id) {
        for (ControlVeterinario c : controles) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /** Read filtrado: historial veterinario de una mascota. */
    public ArrayList<ControlVeterinario> listarPorMascota(int mascotaId) {
        ArrayList<ControlVeterinario> resultado = new ArrayList<>();
        for (ControlVeterinario c : controles) {
            if (c.getMascotaId() == mascotaId) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public int contar() {
        return controles.size();
    }
}
