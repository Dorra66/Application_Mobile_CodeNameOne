/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import Services.UserService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Authentification {
        Form hi = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        public static TextField tusername;
    public static TextField tpassword;
        public static User PERSONNECONNECTEE ;
    public Authentification() {
        
        hi.setTitle("Culture City");
        
            try {
                ImageViewer IV = new ImageViewer(Image.createImage("/m7.jpg"));
//                IV.Fares
                hi.getAllStyles().setBgImage(IV.getImage());
                
            } catch (IOException ex) {
            }
            
        
        
        Button btConnecter = new Button("Login");
        
        Label lu = new Label("Username:");
        TextField tfUsername = new TextField(null, "username...");
        Label lp = new Label("Password:");
        TextField tfPassword = new TextField(null, "password", 0, TextField.PASSWORD);
        
        hi.add(lu);
        hi.add(tfUsername);
        hi.add(lp);
        hi.add(tfPassword);
        hi.add(btConnecter);
        hi.show();
        
        btConnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                UserService us = new UserService();
                User u = us.login(tfUsername.getText(), tfPassword.getText());
               if (u == null) {
                    
                   Dialog.show("Alerte", "Username Or Password Are Invalid ! ", "OK", null);
                
               } else {
                    
                   GUI.MenuForm mf = new GUI.MenuForm();
                    mf.getFjdida().show();
              }
                PERSONNECONNECTEE = u ;
                System.out.println("personne co "+PERSONNECONNECTEE);
            }
        });

    }

    public Form getHi() {
        return hi;
    }

    public void setHi(Form hi) {
        this.hi = hi;
    }
    
    
    
}
