import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class SchoolTest {
    private static int tkWidth;
    private static int tkHeight;
    public static SchoolFrame schoolFrame;

    public static void main(String[] args) {

//        try{
//            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
//                if("Nimbus".equals(info.getName())){
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        }
//        catch(Exception exception){
//            exception.printStackTrace();
//        }
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        // /*  */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        tkWidth = ((int) toolkit.getScreenSize().getWidth());
        tkHeight = ((int) toolkit.getScreenSize().getHeight());

        schoolFrame = new SchoolFrame();
        schoolFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //schoolFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        schoolFrame.addWindowListener(new WindowAdapter() {
            //@Override

            public void windowClosing(WindowEvent windowEvent) {
                int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);
                if(dialogButton == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                else{
                    //JOptionPane.showMessageDialog(null, "The Username and Password do not match! \n Please check and try again!", "Username & Password Mismatch", JOptionPane.ERROR_MESSAGE);
                    //dispose();
                    //JDialog.remove(dialogButton);
                }
            }
        });


        schoolFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //schoolFrame.setLocationRelativeTo(null);
        schoolFrame.setSize(tkWidth, tkHeight);
        schoolFrame.setVisible(true);
        //schoolFrame.setEnabled(false);



        LoginDialog loginDlg = new LoginDialog(schoolFrame);
        loginDlg.setVisible(true);
        //loginDlg.setDefaultCloseOperation(System.exit(0));
        loginDlg.setSize(300,100);
        loginDlg.setLayout(new FlowLayout());
    }
}
