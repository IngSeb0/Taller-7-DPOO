package uniandes.dpoo.taller7.modelo;

public interface Playable {
    void reiniciar();
    void salvar_tablero();
    void desordenar(int dificultad);
    int darJugadas();
    boolean[][] darTablero();
    void jugar(int fila, int columna);
    boolean tableroIluminado();
    int calcularPuntaje();
}
