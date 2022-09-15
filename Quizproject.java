 import java.awt.event.*;
import javax.swing.*;
class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Review");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Review")) {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Mark for Review" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: When was JAVA developed?");
            jb[0].setText("1900");
            jb[1].setText("1938");
            jb[2].setText("2000");
            jb[3].setText("1995");
        }
        if (current == 1) {
            l.setText("Que2: Which class is available to all the class automatically?");
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Object");
            jb[3].setText("ActionEvent");
        }
        if (current == 2) {
            l.setText("Que3: Array in java are?");
            jb[0].setText("Object references");
            jb[1].setText("objects");
            jb[2].setText("Primitive data types");
            jb[3].setText("None");
        }
        if (current == 3) {
            l.setText("Que4: When is object created with new keyword?");
            jb[0].setText("At run time");
            jb[1].setText("At compile time");
            jb[2].setText("Depends on code");
            jb[3].setText("None");
        }
        if (current == 4) {
            l.setText("Que5: Output of Math.floor(3.6)?");
            jb[0].setText("3");
            jb[1].setText("3.0");
            jb[2].setText("4");
            jb[3].setText("4.0");
        }
        if (current == 5) {
            l.setText("Que6: Which one among these is not a keyword?");
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("Que7: compareTo() returns? ");
            jb[0].setText("True");
            jb[1].setText("False");
            jb[2].setText("An int value");
            jb[3].setText("None");
        }
        if (current == 7) {
            l.setText("Que8: which one among these is not a function of Object class?");
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");
            jb[3].setText("getDocumentBase");
        }
        if (current == 8) {
            l.setText("Que9: To which of following does class string belongs to?");
            jb[0].setText("java.lang");
            jb[1].setText("java.awt");
            jb[2].setText("java.applet");
            jb[3].setText("java.string");
        }
        if (current == 9) {
            l.setText("Que10: Total constructor string class have?");
            jb[0].setText("3");
            jb[1].setText("7");
            jb[2].setText("13");
            jb[3].setText("20");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[3].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[2].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[3].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[2].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[0].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {

        new OnlineTest("SILIGURI INSTITUTE OF TECHNOLOGY: QUIZ PORTAL");
    }
}