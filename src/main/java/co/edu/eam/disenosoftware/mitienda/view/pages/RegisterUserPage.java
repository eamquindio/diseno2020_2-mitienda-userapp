package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.view.controllers.UserRegistreController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterUserPage extends Page {
  @Override
  public void init() {

  }

  @Override
  public JComponent buildContent() {

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setLayout(null);
    scrollPane.setBackground(Color.white);

    JLabel tittle = new JLabel("<html><h2><strong>" + getString("userregisterpage.title") + "</strong></h2></html>");
    JLabel description = new JLabel(("<html><h3><font color='gray'><strong>" + getString("userregisterpage.lets") + "</strong></font></h3></html>"));

    JTextField userName = new JTextField("");
    userName.setBorder(null);
    JTextField name = new JTextField("");
    name.setBorder(null);
    JTextField emailAddress = new JTextField("");
    emailAddress.setBorder(null);
    JTextField phone = new JTextField("");
    phone.setBorder(null);
    JPasswordField password = new JPasswordField("");
    password.setBorder(null);

    TextPrompt placeUser = new TextPrompt(getString("userregisterpage.username"), userName);
    TextPrompt placePassword = new TextPrompt(getString("userregisterpage.password"), password);
    TextPrompt placePhone = new TextPrompt(getString("userregisterpage.phone"), phone);
    TextPrompt placeEmail = new TextPrompt(getString("userregisterpage.email"), emailAddress);
    TextPrompt placeName = new TextPrompt(getString("userregisterpage.name"), name);

    JSeparator line1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line2 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line3 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line4 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line5 = new JSeparator(SwingConstants.HORIZONTAL);

    JButton buttonSignIn = new JButton(getString("userregisterpage.buttonsignup"));
    buttonSignIn.setOpaque(true);
    buttonSignIn.setBorderPainted(false);
    buttonSignIn.setBackground(new Color(95, 144, 81).brighter());
    buttonSignIn.setForeground(Color.WHITE);

    scrollPane.add(tittle);
    scrollPane.add(description);
    scrollPane.add(userName);
    scrollPane.add(emailAddress);
    scrollPane.add(phone);
    scrollPane.add(password);
    scrollPane.add(name);
    scrollPane.add(line1);
    scrollPane.add(line2);
    scrollPane.add(line3);
    scrollPane.add(line4);
    scrollPane.add(line5);
    scrollPane.add(buttonSignIn);

    tittle.setLocation(22, 10);
    tittle.setSize(300, 80);

    description.setLocation(22, 40);
    description.setSize(300, 80);

    userName.setLocation(22, 130);
    userName.setSize(300, 20);

    emailAddress.setLocation(22, 200);
    emailAddress.setSize(300, 20);

    phone.setLocation(22, 270);
    phone.setSize(300, 20);

    password.setLocation(22, 340);
    password.setSize(300, 20);

    name.setLocation(22, 410);
    name.setSize(300, 20);

    line1.setLocation(22, 150);
    line1.setSize(300, 20);

    line2.setLocation(22, 220);
    line2.setSize(300, 20);

    line3.setLocation(22, 290);
    line3.setSize(300, 20);

    line4.setLocation(22, 360);
    line4.setSize(300, 20);

    line5.setLocation(22, 430);
    line5.setSize(300, 20);

    buttonSignIn.setLocation(217, 470);
    buttonSignIn.setSize(100, 40);

    buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UserRegistreController userRegistreController = new UserRegistreController();

        User user = new User(userName.getText(), phone.getText(), emailAddress.getText(), password.getText(), name.getText());

        userRegistreController.userRegister(user);

        JOptionPane.showMessageDialog(null, getString("userregisterpage.userRegistred"));

        goBack();
      }
    });

    return scrollPane;
  }

  @Override
  public JComponent buildHeader() {

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(Color.white);

    panel.setMaximumSize(new Dimension(500, 200));

    JLabel signIn = new JLabel("<html>" + getString("userloginpage.singin") + "</html>");
    JLabel signUp = new JLabel("<html><font color='green'><strong>" + getString("userloginpage.singup") + "</strong></font></html>");

    signIn.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {

        goBack();
      }
    });

    panel.add(signIn, java.awt.BorderLayout.LINE_START);
    panel.add(signUp, java.awt.BorderLayout.LINE_END);

    return panel;
  }

  @Override
  public JComponent buildFooter() {
    return null;
  }
}
