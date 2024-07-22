import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(username, password)) {
                    InventoryManagementForm inventoryManagementForm = new InventoryManagementForm();
                    inventoryManagementForm.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }

    private boolean authenticate(String username, String password) {
        // Replace with actual database authentication logic
        return "admin".equals(username) && "password".equals(password);
    }
}
