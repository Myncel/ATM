import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panel1;
    private JPanel machine;
    private JButton a7Button;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a0Button;
    private JTextArea screenInt;
    private JTextArea screenString;
    private JButton ACCBALButton;
    private JButton OUTButton;
    private JButton INButton;
    private JButton CANCELButton1;
    private JButton CLEARButton;
    private JButton ENTERButton;
    private JButton SETACCButton;

    int tmp,tmpChoose;
    private int account;

    public Main() {

        screenString.setText("Ustaw swój stan konta\n");
        screenString.append("Wprowadź wartość, a następnie wciśnij SET");

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               screenInt.append("1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("9");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.append("0");
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            //Czyszczenie wszystkiego
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.setText(null);
                screenString.setText(null);
                tmp = 0;
                tmpChoose = 0;
            }
        });
        CANCELButton1.addActionListener(new ActionListener() {
            //Wyłączenie aplikacji, symulacja przerwania transakcji
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp = screenInt.getText();
                int tmpInt = Integer.parseInt(tmp);
                    System.out.println(tmpInt);
                    //Opcja do wpłaty pieniędzy
                    if(tmpChoose == 1){
                       account+=tmpInt;
                       screenInt.setText("");
                       screenString.setText("Wpłaciłeś pieniądze");
                    }
                    //Opcja do wypłaty pieniędzy
                    else if(tmpChoose == 2){
                        if(tmpInt>account){
                            screenString.setText("Nie masz wystarczającej ilości pięniędzy");
                        }
                        else if(tmpInt<=account) {
                            account -= tmpInt;
                            screenInt.setText("");
                            screenString.setText("Wypłaciłeś pieniądze");
                        }
                    }
                    else {
                        screenInt.setText(null);
                        screenString.setText("Nie wybrano operacji");
                    }
            }
        });
        ACCBALButton.addActionListener(new ActionListener() {
            //Sprawdzanie stanu konta
            @Override
            public void actionPerformed(ActionEvent e) {
                screenInt.setText(String.valueOf(account));
                screenString.setText("Wartość konta");
            }
        });
        INButton.addActionListener(new ActionListener() {
            //Wpłacanie pieniędzy
            @Override
            public void actionPerformed(ActionEvent e) {
                screenString.setText("Wpłata\n");
                screenString.append("Wprowadź kwote");
                screenInt.setText(null);
                tmpChoose = 1;
                System.out.println(tmpChoose);
            }
        });
        OUTButton.addActionListener(new ActionListener() {
            //Wypłacanie pieniędzy
            @Override
            public void actionPerformed(ActionEvent e) {
                screenString.setText("Wypłata\n");
                screenString.append("Wprowadź kwote");
                screenInt.setText(null);
                tmpChoose = 2;
                System.out.println(tmpChoose);
            }
        });
        SETACCButton.addActionListener(new ActionListener() {
            //Ustawianie stanu konta na którym prowadzimy operacje
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp = screenInt.getText();
                int tmpInt = Integer.parseInt(tmp);
                account = tmpInt;
                screenString.setText("Stan konta ustawiony\n");
                screenString.append("Wybierz opcje Wpłać/Wypłać");
                System.out.println(account);
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("BANKOMAT");
        frame.setContentPane(new Main().panel1);
        frame.setLocation(400,200);
        frame.setSize(550,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
