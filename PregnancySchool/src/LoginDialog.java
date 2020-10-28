import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {

    private JTextField usernametxf;
    private JPasswordField passwordpwf;
    private String un, pwd;
    private JLabel usernamelbl, passwordlbl;
    private JButton cancelbtn, loginbtn;
    private DatabaseConnection databaseConn;
    private String firstname, username, securePassword, saltValue;

    public LoginDialog(Frame parent) {
        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        usernamelbl = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(usernamelbl, cs);

        usernametxf = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(usernametxf, cs);

        passwordlbl = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(passwordlbl, cs);

        passwordpwf = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(passwordpwf, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        cancelbtn = new JButton("Cancel");
        cancelbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        loginbtn = new JButton("Login");
        loginbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                un = usernametxf.getText(); pwd = passwordpwf.getText();

                if ((un.equals("")) || (pwd.equals(""))){
                    JOptionPane.showMessageDialog(null, "Please fill all fields!", "All fields Required!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try {
                        databaseConn = new DatabaseConnection();
                        String[] resultValue = DatabaseConnection.userLogin(un, pwd);
                        firstname = resultValue[0];
                        username = resultValue[1];
                        securePassword = resultValue[2];
                        saltValue = resultValue[3];
                    }
                    catch(Exception exception){
                        JOptionPane.showMessageDialog(null, "Your Username or Password is not correct! \n Please check and try again.", "Username & Password Mismatch", JOptionPane.ERROR_MESSAGE);
                    }
                    //String[] resultValue = databaseConn.userLogin(un, pwd);
                    //DatabaseConnection.userLogin(un, pwd);

                    //String securePassword = resultValue[1];
                    //String saltValue = resultValue[2];

                    Boolean myVerifiedPassword = PasswordUtils.verifyUserPassword(pwd, securePassword, saltValue);

                    if (myVerifiedPassword == true){

                        dispose();

                        //JOptionPane.showMessageDialog(null, "Result: " + myVerifiedPassword, "Login Outcome", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Hi " + firstname + "!" + "\n" + "Welcome to the Antenatal App", "Login Success", JOptionPane.INFORMATION_MESSAGE);

                        //AncAppTest.realAppFrame.setEnabled(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "The Username and Password do not match! \n Please check and try again!", "Username & Password Mismatch", JOptionPane.ERROR_MESSAGE);
                    }
                    //}
                }
            }
        });

        JPanel bp = new JPanel();
        bp.add(cancelbtn);
        bp.add(loginbtn);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        //setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE );
        getRootPane().setDefaultButton(loginbtn);  //The positon matters. It doesn't take effect if it's at the top

    }

}
