package operacional;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();

    // Construtor
    private Logger() {
        logs = new ArrayList<>();
    }

    // Métodos auxiliares
    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void registrarLog(String texto) {
        logs.add(texto);
    }
    public String getLogs() {
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
}
