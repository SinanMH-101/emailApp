import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailApp extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> departmentCombo;
    private JTextArea outputArea;

    private final String[] departments = {"None", "Sales", "Development", "Accounting"};

    public EmailApp() {
        setTitle("Email Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Department:"));
        departmentCombo = new JComboBox<>(departments);
        inputPanel.add(departmentCombo);

        JButton generateButton = new JButton("Generate Email");
        inputPanel.add(generateButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateEmail();
            }
        });

        setVisible(true);
    }

    private void generateEmail() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        int deptCode = departmentCombo.getSelectedIndex();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both first and last names.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Email email = new Email(firstName, lastName, deptCode);
        outputArea.setText(email.showInfo());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmailApp());
    }
}
