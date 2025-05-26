import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TinyEdit extends JFrame {
    private JTabbedPane tabbedPane;

    public TinyEdit() {
        super("TinyEdit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton newTabButton = new JButton("New Tab");
        JButton closeTabButton = new JButton("Close Tab");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(newTabButton);
        buttonPanel.add(closeTabButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Add first tab
        addEditorTab("Untitled");

        openButton.addActionListener(e -> openFile());
        saveButton.addActionListener(e -> saveFile());
        newTabButton.addActionListener(e -> addEditorTab("Untitled"));
        closeTabButton.addActionListener(e -> closeCurrentTab());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addEditorTab(String title) {
        JTextArea textArea = new JTextArea(20, 60);
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.addTab(title, scrollPane);
        tabbedPane.setSelectedComponent(scrollPane);
    }

    private JTextArea getCurrentTextArea() {
        JScrollPane scrollPane = (JScrollPane) tabbedPane.getSelectedComponent();
        JViewport viewport = scrollPane.getViewport();
        return (JTextArea) viewport.getView();
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                addEditorTab(file.getName());
                JTextArea textArea = getCurrentTextArea();
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not open file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                JTextArea textArea = getCurrentTextArea();
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeCurrentTab() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            tabbedPane.removeTabAt(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TinyEdit::new);
    }
}
