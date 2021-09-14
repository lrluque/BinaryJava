import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;


public class Binary extends JFrame implements ActionListener {

    JButton button1;
    JButton reverseButton;
    JTextField textField;
    JTextField textField2;
    boolean reversed = false;

    Binary() {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Submit");
        button1.addActionListener(this);

        reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(this);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 40));


        this.add(button1);
        this.add(reverseButton);
        this.add(textField);
        this.add(textField2);
        textField2.setEditable(false);
        this.pack();
        this.setVisible(true);
        this.setTitle("Decimal to Binary");

    }


    public void actionPerformed(ActionEvent e) {
        Pattern p = Pattern.compile(".*[^01]"); //si la string(.*)todos los char. contiene cualquier carácter que no sea 0 o 1
        if (e.getSource() == button1 && !reversed) { //decimal-binario
            String number = textField.getText();
            int n = Integer.parseInt(number);
            textField2.setText(Integer.toBinaryString(n));

        } 
        if (e.getSource() == button1 && reversed) { //binario-decimal
            String number = textField.getText();
            boolean isNotBinary = p.matcher(number).matches();
            if (isNotBinary) {
                textField2.setForeground(Color.RED);
                textField2.setText("ERROR. NÚMERO NO BINARIO.");
            }
            int num = Integer.parseInt(number, 2);
            System.out.println(num);
            textField2.setForeground(Color.BLACK);
            textField2.setText(Integer.toString(num));

        }

        if (e.getSource() == reverseButton) {
            reversed = !reversed;
            if (!reversed) {
                this.setTitle("Decimal to Binary");
            } else {
                this.setTitle("Binary to Decimal");
            }
        }
    }


    public static void main(String[] args) {
        Binary frame = new Binary();


    }

}


