import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegComplete<string> extends JFrame{
    private JButton logInButton;
    private JPanel Panel1;

    public RegComplete() {
        super("Форма успешной регистрации");
        setContentPane(Panel1);
        setSize(700, 400);
        setVisible(true);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AuthForm();
            }
        });
    }
}
