/**
 * Usuario del laboratorio (clase base). Puede ser estudiante o docente.
 */
public abstract class Usuario {
    private String nombreCompleto;

    public Usuario(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /** Devuelve "Estudiante" o "Docente". */
    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + ": " + nombreCompleto;
    }
}
