import java.time.LocalDateTime;

/**
 * Laboratorio de cómputo: 10 equipos (arreglo de objetos) y su bitácora.
 */
public class Laboratorio {
    public static final int TOTAL_EQUIPOS = 10;

    private Equipo[] equipos;
    private Bitacora bitacora;

    public Laboratorio() {
        equipos = new Equipo[TOTAL_EQUIPOS];
        for (int i = 0; i < TOTAL_EQUIPOS; i++) {
            equipos[i] = new Equipo(i + 1);
        }
        bitacora = new Bitacora();
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public Equipo buscarEquipo(int numero) {
        if (numero < 1 || numero > TOTAL_EQUIPOS) {
            return null;
        }
        return equipos[numero - 1];
    }

    /**
     * Inicia una sesión: valida el equipo, lo marca en uso y guarda el registro
     * con la fecha y hora actuales.
     * @return el registro creado, o null si el equipo no existe o está ocupado.
     */
    public RegistroUso iniciarSesion(int numeroEquipo, Usuario usuario) {
        Equipo equipo = buscarEquipo(numeroEquipo);
        if (equipo == null || equipo.isEnUso()) {
            return null;
        }
        equipo.setEnUso(true);
        RegistroUso registro = new RegistroUso(equipo, usuario, LocalDateTime.now());
        bitacora.agregar(registro);
        return registro;
    }

    /** Libera un equipo cuando termina la práctica. */
    public boolean liberarEquipo(int numeroEquipo) {
        Equipo equipo = buscarEquipo(numeroEquipo);
        if (equipo == null || !equipo.isEnUso()) {
            return false;
        }
        equipo.setEnUso(false);
        return true;
    }
}
