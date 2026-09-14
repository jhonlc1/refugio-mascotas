package repository;

import java.util.ArrayList;
import model.Mascota;

/**
 * Capa repository: gestiona la persistencia en memoria con ArrayList.
 * Operaciones CRUD básicas: Create (guardar) y Read (listar/buscar).
 */
public class MascotaRepository {

    private ArrayList<Mascota> mascotas;

    public MascotaRepository() {
        this.mascotas = new ArrayList<>();
    }

    public boolean guardar(Mascota mascota) {
        if (buscarPorId(mascota.getId()) != null) {
            return false;
        }
        mascotas.add(mascota);
        return true;
    }

    public ArrayList<Mascota> listar() {
        return new ArrayList<>(mascotas);
    }

    public Mascota buscarPorId(int id) {
        for (Mascota m : mascotas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public int contar() {
        return mascotas.size();
    }
}
