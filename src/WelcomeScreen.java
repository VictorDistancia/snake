
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WelcomeScreen extends JPanel {

    JLabel title;
    JButton go;
    JButton quit;

    MainWindow mw;

    public void setTitle(String t) {
        title.setText(t);
    }

    public void quitButtonActionListener() {
        final String are_you_sure = "Are you sure?";
        if (JOptionPane.showConfirmDialog(this, are_you_sure) == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    public void goButtonActionListener() {
        final String two = "Two";
        mw.showCard(two);
    }

    public WelcomeScreen(MainWindow mw) {
        this.mw = mw;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        title = new JLabel();
        add(title);
        final String new_Game = "New Game";

        //add formatting here
        go = new JButton(new_Game);
        final String quit1 = "Quit";
        quit = new JButton(quit1);
        final ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        };

        go.addActionListener(actionListener);
        final ActionListener actionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        };

        quit.addActionListener(actionListener1);

        add(go);
        add(quit);
    }

}
