import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface interfaceEquipe = new Interface();
            interfaceEquipe.criarGUI();
        });
    }
}
