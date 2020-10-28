import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddUserPanel extends JPanel {
    private static JLabel fnlabel, snlabel, pnlabel, unlabel, pwdlabel, cfmpwwdlabel;
    private static JTextField fnfield, snfield, pnfield, unfield;
    private static JPasswordField password, cfmpassword;
    public static JButton createbtn;
    private static String fn, sn, pn, un, pw, cpw, slt;
    private static int pk, unlength;
    private static int tkWidth, tkHeight;
    private static int dtkWidth, dtkHeight;
    private DatabaseConnection databaseConn;

    public AddUserPanel() {

        //super("Add New User");
        setLayout(null);
        //setResizable(false);

        fnlabel = new JLabel("Firstname");
        fnlabel.setBounds(10,32,60,27);
        add(fnlabel);

        fnfield = new JTextField();
        fnfield.setBounds(70,32,200,27);
        add(fnfield);

        snlabel = new JLabel("Surname");
        snlabel.setBounds(305,32,55,27);
        add(snlabel);

        snfield = new JTextField();
        snfield.setBounds(360,32,200,27);
        add(snfield);

        pnlabel = new JLabel("Phone Number");
        pnlabel.setBounds(585,32,90,27);
        add(pnlabel);

        pnfield = new JTextField();
        pnfield.setBounds(670,32,200,27);
        add(pnfield);

        //-----------------------------------------------------------------------------------

        unlabel = new JLabel("Username");
        unlabel.setBounds(10,108,60,27);
        add(unlabel);

        unfield = new JTextField();
        unfield.setBounds(70,108,200,27);
        add(unfield);

        pwdlabel = new JLabel("Password");
        pwdlabel.setBounds(305,108,60,27);
        add(pwdlabel);

        password = new JPasswordField();
        password.setBounds(360,108,200,27);
        add(password);

        cfmpwwdlabel = new JLabel("Re-Password");
        cfmpwwdlabel.setBounds(585,108,90,27);
        add(cfmpwwdlabel);

        cfmpassword = new JPasswordField();
        cfmpassword.setBounds(670,108,200,27);
        add(cfmpassword);

        //-------------------------------------------------------------------------------------


        createbtn = new JButton("Create User");
        createbtn.setBounds(755,172,110,27);
        add(createbtn);
        createbtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    fn = fnfield.getText(); sn = snfield.getText(); pn = pnfield.getText();
                    un = unfield.getText(); pw = password.getText(); cpw = cfmpassword.getText();
                    //unlength = un.length();

                    String myPassword = pw;
                    String salt = PasswordUtils.getSalt(30);
                    String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
                    slt = salt;

                    try {
                        if ((fn.equals("")) || (sn.equals("")) || (pn.equals("")) || (un.equals("")) || (pw.equals("")) || (cpw.equals(""))) {

                            JOptionPane.showMessageDialog(null, "Please fill all fields!", "All fields Required!", JOptionPane.ERROR_MESSAGE);
                        }
                        else if (un.length() < 4) {
                            JOptionPane.showMessageDialog(null, "Please your Username should not be less than four (4) characters!", "Username too short!", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            if (!pw.equals(cpw)) {   //pw.equals(cpw)  pw == cpw
                                JOptionPane.showMessageDialog(null, "The Passwords you entered don't match!", "Passwords Mismatch!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                databaseConn = new DatabaseConnection();
                                Boolean verifyUsername = databaseConn.verifyUsername(un);
                                String verify = databaseConn.verify(un);
                                //Boolean verifyUsername = DatabaseConnection.verifyUsername(un);
                                //String verify = DatabaseConnection.verify(un);

                                //JOptionPane.showMessageDialog(null, "Results: " +verifyUsername, "Results!", JOptionPane.ERROR_MESSAGE);
                                //JOptionPane.showMessageDialog(null, "Results: " +verify, "Results!", JOptionPane.ERROR_MESSAGE);

                                if (verifyUsername) {
                                    JOptionPane.showMessageDialog(null, "Please choose a different username!", "Username already taken!", JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                    databaseConn.addUser(pk, fn, sn, pn, un, mySecurePassword, mySecurePassword, slt);
                                    //DatabaseConnection.addUser(pk, fn, sn, pn, un, mySecurePassword, mySecurePassword, slt);

                                    //JOptionPane.showMessageDialog(null, "Secure Password: " + mySecurePassword, "User Add Success", JOptionPane.INFORMATION_MESSAGE);
                                    JOptionPane.showMessageDialog(null, "Congrats! New User Successfully Added", "User Add Success", JOptionPane.INFORMATION_MESSAGE);
                                    fnfield.setText(""); snfield.setText(""); pnfield.setText("");
                                    unfield.setText(""); password.setText(""); cfmpassword.setText("");
                                }
                            }
                        }
                    }

                    catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "No Connection to Database", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        );

        /*createbtn.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyChar() == KeyEvent.VK_ENTER)
                    createbtn.doClick();
            }
        });*/

        //getRootPane().setDefaultButton(createbtn);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());
        dtkWidth = (tkWidth - (tkWidth*30/100));
        dtkHeight = (tkHeight - (tkHeight*70/100));
    }



    //return image dimensions
    public Dimension getPreferredSize() {
        return new Dimension(dtkWidth, dtkHeight);
    } //end method getPreferredSize

}
