package Semana_2.Observer_6;

public class SlackStrategy implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[SLACK] Enviando: " + message);
    }
}
