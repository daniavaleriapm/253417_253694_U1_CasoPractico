public class Docente extends Usuario {

    public Docente(String nombreCompleto) {
        super(nombreCompleto);
    }

    @Override
    public String getTipo() {
        return "Docente";
    }
}
