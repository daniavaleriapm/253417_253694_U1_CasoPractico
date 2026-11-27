/**
 * Equipo informático del laboratorio.
 */
public class Equipo {
    private int numero;
    private boolean enUso;

    public Equipo(int numero) {
        this.numero = numero;
        this.enUso = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    @Override
    public String toString() {
        return "Equipo " + numero + " (" + (enUso ? "en uso" : "disponible") + ")";
    }
}
