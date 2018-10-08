import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm<string> extends JFrame {
    private JPanel Panel1;
    private JLabel loginLabel;
    private JTextField tfLogin;
    private JLabel passwordLabel;
    private JPasswordField pfPassword;
    private JButton bRegister;
    private JPasswordField pfConfirm;
    private JButton cancelButton;
    private JLabel labelError;

    public RegisterForm() {

        super("Форма регистрации");
        setContentPane(Panel1);
        setSize(700, 400);
        labelError.setVisible(false);
        setVisible(true);


        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pass = pfPassword.getText();
                String confirm = pfConfirm.getText();

                if (!pass.equals(confirm)){
                    labelError.setText("Passwords do not match!");
                    labelError.setVisible(true);
                    return;
                }

                if (Launch.db == null) {
                    Launch.db = new DbStuff();
                }
                String login = tfLogin.getText();
                boolean success = Launch.db.checkLogin(login);
                if (success) {
                    labelError.setText("Login already exists!");
                    labelError.setVisible(true);
                    return;
                }
                success = Launch.db.Register(login, pass);
                if (success) {
                    dispose();
                    new RegComplete();
                } else {
                    labelError.setText("Registration failed!");
                    labelError.setVisible(true);
                    return;
                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AuthForm();
            }
        });
    }
}
