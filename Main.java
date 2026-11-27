import java.util.Scanner;

/**
 * Menú de consola para el encargado del laboratorio.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Laboratorio lab = new Laboratorio();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== CONTROL DEL LABORATORIO DE CÓMPUTO =====");
            System.out.println("1. Registrar inicio de práctica");
            System.out.println("2. Liberar equipo (fin de práctica)");
            System.out.println("3. Ver estado de los equipos");
            System.out.println("4. Historial de uso por equipo");
            System.out.println("5. Historial de uso por usuario");
            System.out.println("6. Ver bitácora completa");
            System.out.println("0. Salir");
            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1: registrarInicio(); break;
                case 2: liberar(); break;
                case 3: verEstado(); break;
                case 4: historialEquipo(); break;
                case 5: historialUsuario(); break;
                case 6: bitacoraCompleta(); break;
                case 0: System.out.println("Hasta luego."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void registrarInicio() {
        int numero = leerEntero("Número de equipo (1-" + Laboratorio.TOTAL_EQUIPOS + "): ");
        Equipo equipo = lab.buscarEquipo(numero);
        if (equipo == null) {
            System.out.println("Ese equipo no existe.");
            return;
        }
        if (equipo.isEnUso()) {
            System.out.println("El equipo " + numero + " ya está en uso.");
            return;
        }
        System.out.print("Nombre completo del usuario: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        System.out.print("Tipo de usuario (1 = Estudiante, 2 = Docente): ");
        String tipo = sc.nextLine().trim();
        Usuario usuario = tipo.equals("2") ? new Docente(nombre) : new Estudiante(nombre);

        RegistroUso registro = lab.iniciarSesion(numero, usuario);
        System.out.println("Registro guardado:\n" + registro);
    }

    private static void liberar() {
        int numero = leerEntero("Número de equipo a liberar: ");
        if (lab.liberarEquipo(numero)) {
            System.out.println("Equipo " + numero + " liberado.");
        } else {
            System.out.println("El equipo no existe o ya estaba disponible.");
        }
    }

    private static void verEstado() {
        System.out.println();
        for (Equipo e : lab.getEquipos()) {
            System.out.println(e);
        }
    }

    private static void historialEquipo() {
        int numero = leerEntero("Número de equipo: ");
        if (lab.buscarEquipo(numero) == null) {
            System.out.println("Ese equipo no existe.");
            return;
        }
        imprimir(lab.getBitacora().historialPorEquipo(numero),
                "El equipo " + numero + " no tiene registros.");
    }

    private static void historialUsuario() {
        System.out.print("Nombre completo del usuario: ");
        String nombre = sc.nextLine().trim();
        imprimir(lab.getBitacora().historialPorUsuario(nombre),
                "No hay registros para ese usuario.");
    }

    private static void bitacoraCompleta() {
        Bitacora b = lab.getBitacora();
        if (b.getTotal() == 0) {
            System.out.println("La bitácora está vacía.");
            return;
        }
        for (int i = 0; i < b.getTotal(); i++) {
            System.out.println((i + 1) + ". " + b.get(i));
        }
    }

    private static void imprimir(RegistroUso[] lista, String mensajeVacio) {
        if (lista.length == 0) {
            System.out.println(mensajeVacio);
            return;
        }
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ". " + lista[i]);
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Escribe un número válido.");
            }
        }
    }
}
