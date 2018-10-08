import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AuthForm<string> extends JFrame{

    private JPanel Panel1;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JButton bLogin;
    private JButton bRegister;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel labelError;
    private JButton exitButton;

    public AuthForm() {

        super("Форма авторизации");
        setContentPane(Panel1);
        setSize(700, 400);
        labelError.setVisible(false);
        setVisible(true);

        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbStuff db = new DbStuff();
                String pass = pfPassword.getText();
                boolean success = db.checkLogin(tfLogin.getText(),pass );
                if (success){
                    dispose();
                    new AppWindow();
                }
                else{
                    labelError.setVisible(true);
                }
            }
        });
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new RegisterForm();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}
