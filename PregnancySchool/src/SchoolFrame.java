import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SchoolFrame extends JFrame{

    private JDesktopPane theDesktop;
    //private static JLabel usernamelbl, passwordlbl;
    //private static JTextField usernametxf;
    //private static JPasswordField passwordpwf;
    //private static JButton cancelbtn, loginbtn;
    private static int tkWidth, tkHeight;
    private static int dtkWidth, dtkHeight;
    //private static boolean instances = false;
    //private static int ftkWidth, ftkHeight;


    public SchoolFrame() {
        super("Pregnancy School");
        //setLayout(null);
        //getContentPane().setOpaque(false);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        theDesktop = new JDesktopPane();
        add(theDesktop);

        //The toolkit to get the screen size (height and width) of the computer on which the program runs
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());
        dtkWidth = (tkWidth - (tkWidth*30/100));
        dtkHeight = (tkHeight - (tkHeight*70/100));

        //Setting up the main menu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        //create the usersettings menu
        JMenu usersettings = new JMenu("User Settings");
        usersettings.setMnemonic('U');
        bar.add(usersettings);

        //create the menu items under the usuersettings menu
        JMenuItem adduser = new JMenuItem("Add User");
        adduser.setMnemonic('A');
        usersettings.add(adduser);

        //set up listener for add-user menu item
        adduser.addActionListener(
                new ActionListener(){  //anonymous inner class

                    //create internal frame
                    JInternalFrame adduserFrame = new JInternalFrame("Add User", false, true, false, true);

                    //display new internal window
                    public void actionPerformed(ActionEvent event){


                        if (!adduserFrame.isVisible()) {
                            AddUserPanel adduserPanel = new AddUserPanel();  //create a new panel
                            //adduserFrame.add(panel2, BorderLayout.CENTER);  //add panel
                            adduserFrame.add(adduserPanel);  //add panel
                            adduserFrame.pack(); //set internal frame to size of contents
                            //adduserFrame.setLocationRelativeTo(null);

                            theDesktop.add(adduserFrame);  //attach internal frame
                            adduserFrame.setVisible(true);  //show internal frame

                            Dimension desktopSize = theDesktop.getSize();
                            Dimension jInternalFrameSize = adduserFrame.getSize();

                            adduserFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2, (desktopSize.height- jInternalFrameSize.height)/2);

                            adduserFrame.getRootPane().setDefaultButton(adduserPanel.createbtn);

                            //adduserFrame.getContentPane().Singleton.getInstance();
                            //sclass =  new SingletonClass();
                            //adduserFrame.getContentPane().sclass.getInstance();
                            //adduserFrame.getContentPane().sclass.getInstance();
                        }

                        //JOptionPane.showMessageDialog(null, "How are you?", "Welcome Message", JOptionPane.WARNING_MESSAGE);
                    }//end method action performed
                }//end anonymous inner class
        );







        JMenuItem updateuserinfo = new JMenuItem("Update User Information");
        updateuserinfo.setMnemonic('U');
        usersettings.add(updateuserinfo);
        /*Toolkit uuitoolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) uuitoolkit.getScreenSize().getWidth());
        tkHeight = ((int) uuitoolkit.getScreenSize().getHeight());
        dtkWidth = (tkWidth - (tkWidth*30/100));
        dtkHeight = (tkHeight - (tkHeight*70/100));*/

        //set up listener for newFrame menu item
        updateuserinfo.addActionListener(
                new ActionListener(){  //anonymous inner class

                    //display new internal window
                    public void actionPerformed(ActionEvent event){
                        //create internal frame
                    /*JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);

                    MyJPanel panel = new MyJPanel();  //create a new panel
                    frame.add(panel, BorderLayout.CENTER);  //add panel
                    frame.pack(); //set internal frame to size of contents

                    theDesktop.add(frame);  //attach internal frame
                    frame.setVisible(true);  //show internal frame*/



                        //JOptionPane.showMessageDialog(null, "How are you?", "Welcome Message", JOptionPane.WARNING_MESSAGE);
                    }//end method action performed
                }//end anonymous inner class
        ); //end call to addActionListener

        JMenuItem changepassword = new JMenuItem("Change Password");
        changepassword.setMnemonic('C');
        usersettings.add(changepassword);




        JMenuItem resetpassword = new JMenuItem("Reset Password");
        resetpassword.setMnemonic('R');
        usersettings.add(resetpassword);

        //create the patientsettings menu
        JMenu clientsettings = new JMenu("Client Settings");
        clientsettings.setMnemonic('C');
        bar.add(clientsettings);

        //create the menu items under the patientsettings menu
        JMenuItem addclient = new JMenuItem("Add Client");
        addclient.setMnemonic('A');
        clientsettings.add(addclient);

        JMenuItem updateclientinfo = new JMenuItem("Update Client Information");
        updateclientinfo.setMnemonic('U');
        clientsettings.add(updateclientinfo);

        JMenuItem clientregister = new JMenuItem("Clients' Register");
        clientregister.setMnemonic('C');
        clientsettings.add(clientregister);

        JMenu reports = new JMenu("Reports");
        reports.setMnemonic('R');
        bar.add(reports);
    }


}
