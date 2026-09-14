package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Adopcion;
import model.Adoptante;
import model.ControlVeterinario;
import model.Encargado;
import model.Mascota;
import repository.AdopcionRepository;
import repository.AdoptanteRepository;
import repository.ControlVeterinarioRepository;
import repository.EncargadoRepository;
import repository.MascotaRepository;
import service.AdopcionService;
import service.AdoptanteService;
import service.ControlVeterinarioService;
import service.EncargadoService;
import service.MascotaService;

/**
 * Capa main: punto de entrada y menú de consola.
 * Delega la lógica a la capa service.
 */
public class Main {

    private Scanner sc;
    private MascotaService mascotaService;
    private AdoptanteService adoptanteService;
    private EncargadoService encargadoService;
    private AdopcionService adopcionService;
    private ControlVeterinarioService controlService;

    public Main() {
        sc = new Scanner(System.in);

        MascotaRepository mascotaRepo = new MascotaRepository();
        AdoptanteRepository adoptanteRepo = new AdoptanteRepository();
        EncargadoRepository encargadoRepo = new EncargadoRepository();
        AdopcionRepository adopcionRepo = new AdopcionRepository();
        ControlVeterinarioRepository controlRepo = new ControlVeterinarioRepository();

        mascotaService = new MascotaService(mascotaRepo);
        adoptanteService = new AdoptanteService(adoptanteRepo);
        encargadoService = new EncargadoService(encargadoRepo);
        adopcionService = new AdopcionService(adopcionRepo, mascotaRepo, adoptanteRepo, encargadoRepo);
        controlService = new ControlVeterinarioService(controlRepo, mascotaRepo);

        cargarDatosEjemplo();
        menu();
    }

    private void cargarDatosEjemplo() {
        mascotaService.registrarMascota(1, "Max", "Perro", "Labrador", 3, "Macho");
        mascotaService.registrarMascota(2, "Michi", "Gato", "Criollo", 2, "Hembra");
        adoptanteService.registrarAdoptante(101, "Ana Perez", 30, "Calle 10 #5-20", "3001112233", 3, "2026-09-01");
        encargadoService.registrarEncargado(201, "Carlos Ruiz", 35, "Carrera 15 #8-10", "3104445566", 3, "Coordinador de adopciones");
    }

    private void menu() {
        String opcion = "";
        while (!opcion.equals("0")) {
            System.out.println("\n==== REFUGIO DE MASCOTAS ====");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Registrar persona interesada en adoptar");
            System.out.println("3. Registrar encargado de adopcion");
            System.out.println("4. Gestionar proceso de adopcion");
            System.out.println("5. Registrar control veterinario");
            System.out.println("6. Consultar historial veterinario de una mascota");
            System.out.println("7. Listar toda la informacion");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            if (!sc.hasNextLine()) {
                break;
            }
            opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": registrarMascota(); break;
                case "2": registrarAdoptante(); break;
                case "3": registrarEncargado(); break;
                case "4": gestionarAdopcion(); break;
                case "5": registrarControl(); break;
                case "6": consultarHistorial(); break;
                case "7": listarTodo(); break;
                case "0": System.out.println("Gracias por usar el sistema. ¡Hasta pronto!"); break;
                default: System.out.println("Opcion no valida.");
            }
        }
    }

    private void registrarMascota() {
        System.out.println("\n-- Registrar mascota --");
        int id = leerNumero("ID de la mascota: ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Especie (Perro/Gato/Otro): ");
        String especie = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        int edad = leerNumero("Edad: ");
        System.out.print("Sexo: ");
        String sexo = sc.nextLine();
        System.out.println(mascotaService.registrarMascota(id, nombre, especie, raza, edad, sexo));
    }

    private void registrarAdoptante() {
        System.out.println("\n-- Registrar persona interesada --");
        int id = leerNumero("ID de la persona: ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        int edad = leerNumero("Edad: ");
        System.out.print("Residencia/direccion: ");
        String residencia = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        int estrato = leerNumero("Estrato economico: ");
        System.out.print("Fecha de registro (AAAA-MM-DD): ");
        String fecha = sc.nextLine();
        System.out.println(adoptanteService.registrarAdoptante(id, nombre, edad, residencia, telefono, estrato, fecha));
    }

    private void registrarEncargado() {
        System.out.println("\n-- Registrar encargado --");
        int id = leerNumero("ID del encargado: ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        int edad = leerNumero("Edad: ");
        System.out.print("Residencia/direccion: ");
        String residencia = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        int estrato = leerNumero("Estrato: ");
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.println(encargadoService.registrarEncargado(id, nombre, edad, residencia, telefono, estrato, cargo));
    }

    private void gestionarAdopcion() {
        System.out.println("\n-- Gestionar proceso de adopcion --");
        System.out.println("a. Crear solicitud  b. Cambiar estado  c. Listar procesos");
        System.out.print("Elija (a/b/c): ");
        String sub = sc.nextLine().trim().toLowerCase();
        if (sub.equals("a")) {
            int id = leerNumero("ID del proceso: ");
            int mascotaId = leerNumero("ID de la mascota: ");
            int adoptanteId = leerNumero("ID del adoptante: ");
            int encargadoId = leerNumero("ID del encargado: ");
            System.out.print("Fecha (AAAA-MM-DD): ");
            String fecha = sc.nextLine();
            System.out.println(adopcionService.crearSolicitud(id, mascotaId, adoptanteId, encargadoId, fecha));
        } else if (sub.equals("b")) {
            int id = leerNumero("ID del proceso: ");
            System.out.print("Nuevo estado (SOLICITADA/APROBADA/RECHAZADA/FINALIZADA): ");
            String estado = sc.nextLine().trim().toUpperCase();
            System.out.println(adopcionService.cambiarEstado(id, estado));
        } else {
            ArrayList<Adopcion> lista = adopcionService.listarAdopciones();
            if (lista.isEmpty()) {
                System.out.println("No hay procesos registrados.");
            } else {
                for (Adopcion a : lista) {
                    System.out.println(a);
                }
            }
        }
    }

    private void registrarControl() {
        System.out.println("\n-- Registrar control veterinario --");
        int id = leerNumero("ID del control: ");
        int mascotaId = leerNumero("ID de la mascota: ");
        System.out.print("Fecha (AAAA-MM-DD): ");
        String fecha = sc.nextLine();
        System.out.print("Tipo (Vacunacion/Desparasitacion/Chequeo/Cirugia/Otro): ");
        String tipo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Veterinario/encargado: ");
        String veterinario = sc.nextLine();
        System.out.println(controlService.registrarControl(id, mascotaId, fecha, tipo, descripcion, veterinario));
    }

    private void consultarHistorial() {
        System.out.println("\n-- Historial veterinario --");
        int mascotaId = leerNumero("ID de la mascota: ");
        Mascota mascota = mascotaService.buscarMascota(mascotaId);
        if (mascota == null) {
            System.out.println("No existe la mascota con ID " + mascotaId);
            return;
        }
        System.out.println(mascota);
        ArrayList<ControlVeterinario> historial = controlService.historialPorMascota(mascotaId);
        if (historial.isEmpty()) {
            System.out.println("La mascota no tiene controles registrados.");
        } else {
            System.out.println("Historial (" + historial.size() + " controles):");
            for (ControlVeterinario c : historial) {
                System.out.println(c);
            }
        }
    }

    private void listarTodo() {
        System.out.println("\n-- MASCOTAS --");
        for (Mascota m : mascotaService.listarMascotas()) {
            System.out.println(m);
        }
        System.out.println("\n-- ADOPTANTES --");
        for (Adoptante a : adoptanteService.listarAdoptantes()) {
            System.out.println(a);
        }
        System.out.println("\n-- ENCARGADOS --");
        for (Encargado e : encargadoService.listarEncargados()) {
            System.out.println(e);
        }
        System.out.println("\n-- ADOPCIONES --");
        for (Adopcion a : adopcionService.listarAdopciones()) {
            System.out.println(a);
        }
        System.out.println("\n-- CONTROLES VETERINARIOS --");
        for (ControlVeterinario c : controlService.listarControles()) {
            System.out.println(c);
        }
    }

    private int leerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
