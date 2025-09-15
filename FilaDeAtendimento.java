import java.util.LinkedList;

public class FilaDeAtendimento {
    private LinkedList<Paciente> fila = new LinkedList<>();

    public void adicionarPaciente(Paciente p) {
        fila.addLast(p);
    }

    public Paciente atenderPaciente() {
        return fila.removeFirst();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public void mostrarFila() {
        if (estaVazia()) {
            System.out.println("A fila de atendimento está vazia.");
            return;
        }
        System.out.println("--- Pacientes na Fila ---");
        for (Paciente paciente : fila) {
            System.out.println(paciente.exibirInfo());
        }
    }
}
