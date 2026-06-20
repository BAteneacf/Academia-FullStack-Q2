package Semana_3.Ejercicio_6;

public record PageResult(String url, int statusCode, String title, long responseTimeMs) {
    @Override
    public String toString() {
        return String.format("[%d] %s (%dms)", statusCode, title, responseTimeMs);
    }
}