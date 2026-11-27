import java.util.Arrays;

/**
 * Bitácora del laboratorio. Guarda los registros en un ARREGLO de objetos
 * (RegistroUso[]) que crece automáticamente cuando se llena.
 */
public class Bitacora {
    private RegistroUso[] registros;
    private int total;

    public Bitacora() {
        registros = new RegistroUso[10];
        total = 0;
    }

    public void agregar(RegistroUso registro) {
        if (total == registros.length) {
            registros = Arrays.copyOf(registros, registros.length * 2);
        }
        registros[total++] = registro;
    }

    public int getTotal() {
        return total;
    }

    public RegistroUso get(int indice) {
        return registros[indice];
    }

    /** Historial detallado de un equipo (arreglo del tamaño exacto). */
    public RegistroUso[] historialPorEquipo(int numeroEquipo) {
        int cuenta = 0;
        for (int i = 0; i < total; i++) {
            if (registros[i].getEquipo().getNumero() == numeroEquipo) {
                cuenta++;
            }
        }
        RegistroUso[] resultado = new RegistroUso[cuenta];
        int j = 0;
        for (int i = 0; i < total; i++) {
            if (registros[i].getEquipo().getNumero() == numeroEquipo) {
                resultado[j++] = registros[i];
            }
        }
        return resultado;
    }

    /** Historial de un usuario buscando por nombre (sin distinguir mayúsculas). */
    public RegistroUso[] historialPorUsuario(String nombre) {
        int cuenta = 0;
        for (int i = 0; i < total; i++) {
            if (registros[i].getUsuario().getNombreCompleto().equalsIgnoreCase(nombre)) {
                cuenta++;
            }
        }
        RegistroUso[] resultado = new RegistroUso[cuenta];
        int j = 0;
        for (int i = 0; i < total; i++) {
            if (registros[i].getUsuario().getNombreCompleto().equalsIgnoreCase(nombre)) {
                resultado[j++] = registros[i];
            }
        }
        return resultado;
    }
}
