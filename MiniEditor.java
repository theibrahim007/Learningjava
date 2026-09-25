import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MiniEditor {

    JFrame frame;
    JTextArea textArea;

    public void go() {
        // 1. Create the window
        frame = new JFrame("Mini Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // 2. Create the text area (where you type)
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Wrap it in a scroll pane so it scrolls when text gets long
        JScrollPane scroller = new JScrollPane(textArea);
        frame.getContentPane().add(BorderLayout.CENTER, scroller);

        // 3. Build the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // 4. Hook up the menu items to actions
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // 5. Show it
        frame.setVisible(true);
    }

    // ---- OPEN a file ----
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Couldn't read file: " + ex.getMessage());
            }
        }
    }

    // ---- SAVE a file ----
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Couldn't save file: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Run GUI on the Event Dispatch Thread (the proper way in Swing)
        SwingUtilities.invokeLater(() -> new MiniEditor().go());
    }
}