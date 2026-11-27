import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Una línea de la bitácora: equipo asignado, usuario y fecha/hora de inicio.
 */
public class RegistroUso {
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Equipo equipo;
    private Usuario usuario;
    private LocalDateTime inicio;

    public RegistroUso(Equipo equipo, Usuario usuario, LocalDateTime inicio) {
        this.equipo = equipo;
        this.usuario = usuario;
        this.inicio = inicio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    @Override
    public String toString() {
        return String.format("Equipo %-2d | %-10s | %-30s | %s",
                equipo.getNumero(), usuario.getTipo(),
                usuario.getNombreCompleto(), inicio.format(FORMATO));
    }
}
