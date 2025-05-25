import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TinyEdit extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton openButton, saveButton;

    public TinyEdit() {
        super("TinyEdit");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        openButton.addActionListener(this);
        saveButton.addActionListener(this);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "File could not be opened: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == saveButton) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(writer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "File could not be saved: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TinyEdit::new);
    }
}