public class Estudiante extends Usuario {

    public Estudiante(String nombreCompleto) {
        super(nombreCompleto);
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }
}
