import model.Mascota;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Logica {

    private ArrayList<Mascota> listademascotas;

    private Scanner sc = new Scanner(System.in);

    public Logica(){
        //instanciar o crear objeto o lista de mascotas
        listademascotas = new ArrayList<Mascota>();
        System.out.println("Bienvenido al sistema de adopcion");
        menu();



    }

    private void registrar() {
        System.out.println(" Registrar mascota");


        System.out.println("Ingrese el id de la mascota:" );
        int id =   leernumero();


        System.out.println("Ingrese el nombre de la mascota:" );
        String nombre =   leertexto();



        System.out.println("Ingrese la edad de la mascota:" );
        int edad =  leernumero();



        System.out.println("Ingrese la raza de la mascota:" );
        String raza =   leertexto();


        for(Mascota m : listademascotas){
            if(id == m.getId()){
                menu();
                System.err.println("Esa mascota ya existe ");
            }

        }


        Mascota mascotanueva = new Mascota(nombre,id,edad,raza);

        listademascotas.add(mascotanueva);

        listarmascotas();



      //  System.out.println(mascotanueva.toString());

        menu();


    }

    private void listarmascotas() {

        for (Mascota m : listademascotas){
            System.out.println(m.toString());
        }
    }


    public void menu(){
        String menu = " 1.Registrar mascota \n 2.Registro de interesados \n 3.Iniciar proceso \n 4.Controles veterinarios \n 5.ver historial veterinario";
        System.out.println(menu);

        //RECIBE TEXTO DEL TECLADO
        String opcion = sc.nextLine();

        System.out.println("Usted escogio la opcion " + opcion );


        if(opcion.equals("1")){

            registrar();

        } else if (opcion.equals("2")) {

        }else if (opcion.equals("3")) {

        }else if (opcion.equals("4")) {

        }else if (opcion.equals("5")) {

        }

    }

    public int leernumero() {
        int numero = sc.nextInt();
        sc.nextLine(); // Consume el salto de línea pendiente
        return numero;
    }

    public String leertexto(){
        return sc.nextLine();
    }
}
