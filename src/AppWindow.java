import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow<string> extends JFrame{
    private JPanel Panel1;
    private JButton exitButton;

    public AppWindow() {
        super("Форма приложения");
        setContentPane(Panel1);
        setSize(700, 400);
        setVisible(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AuthForm();
            }
        });
    }
}
