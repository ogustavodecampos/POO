import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class Interface {
    private CadastraEquipe cadastraEquipe;
    private JTextArea mensagemArea;
    private JTextField codinomeField;
    private JTextField qtdField;
    private JTextField latitudeField;
    private JTextField longitudeField;

    public void criarGUI() {
        JFrame frame = new JFrame("Cadastro de Equipes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        lugarComponentes(panel);

        cadastraEquipe = new CadastraEquipe();

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void lugarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel codinomeLabel = new JLabel("Codinome:");
        codinomeLabel.setBounds(10, 20, 80, 25);
        panel.add(codinomeLabel);

        codinomeField = new JTextField(20);
        codinomeField.setBounds(100, 20, 165, 25);
        panel.add(codinomeField);

        JLabel qtdLabel = new JLabel("Quantidade:");
        qtdLabel.setBounds(10, 50, 80, 25);
        panel.add(qtdLabel);

        qtdField = new JTextField(20);
        qtdField.setBounds(100, 50, 165, 25);
        panel.add(qtdField);

        JLabel latitudeLabel = new JLabel("Latitude:");
        latitudeLabel.setBounds(10, 80, 80, 25);
        panel.add(latitudeLabel);

        latitudeField = new JTextField(20);
        latitudeField.setBounds(100, 80, 165, 25);
        panel.add(latitudeField);

        JLabel longitudeLabel = new JLabel("Longitude:");
        longitudeLabel.setBounds(10, 110, 80, 25);
        panel.add(longitudeLabel);

        longitudeField = new JTextField(20);
        longitudeField.setBounds(100, 110, 165, 25);
        panel.add(longitudeField);

        mensagemArea = new JTextArea();
        mensagemArea.setBounds(10, 140, 350, 100);
        mensagemArea.setEditable(false);
        panel.add(mensagemArea);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(10, 250, 100, 25);
        panel.add(cadastrarButton);

        JButton limparButton = new JButton("Limpar");
        limparButton.setBounds(120, 250, 100, 25);
        panel.add(limparButton);

        JButton mostrarButton = new JButton("Mostrar Equipes");
        mostrarButton.setBounds(230, 250, 150, 25);
        panel.add(mostrarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBounds(10, 280, 100, 25);
        panel.add(sairButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEquipe();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEquipes();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void cadastrarEquipe() {
        try {
            String codinome = codinomeField.getText();
            int qtd = Integer.parseInt(qtdField.getText());
            double latitude = Double.parseDouble(latitudeField.getText());
            double longitude = Double.parseDouble(longitudeField.getText());

            cadastraEquipe.cadastrarEquipe(codinome, qtd, latitude, longitude);
            mensagemArea.setText("Equipe cadastrada com sucesso.");
        } catch (NumberFormatException ex) {
            mensagemArea.setText("Erro: Certifique-se de que os campos estão preenchidos corretamente.");
        } catch (IllegalArgumentException ex) {
            mensagemArea.setText(ex.getMessage());
        }
    }

    private void limparCampos() {
        codinomeField.setText("");
        qtdField.setText("");
        latitudeField.setText("");
        longitudeField.setText("");
        mensagemArea.setText("");
    }

    private void mostrarEquipes() {
        List<Equipe> equipes = cadastraEquipe.getEquipes();
        if (equipes.isEmpty()) {
            mensagemArea.setText("Nenhuma equipe cadastrada.");
        } else {
            StringBuilder mensagem = new StringBuilder("Equipes cadastradas:\n");
            for (Equipe equipe : equipes) {
                mensagem.append("Codinome: ").append(equipe.getCodinome())
                        .append(", Quantidade: ").append(equipe.getQtd())
                        .append(", Latitude: ").append(equipe.getLatitude())
                        .append(", Longitude: ").append(equipe.getLongitude()).append("\n");
            }
            mensagemArea.setText(mensagem.toString());
        }
    }
}

