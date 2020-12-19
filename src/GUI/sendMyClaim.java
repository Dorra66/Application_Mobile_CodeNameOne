/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ReclamationM;
import Services.ServiceReclamationM;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author fares
 */
public class sendMyClaim {

    TextField objetRec;
    Label lbobj;
    Label lbdesc;
    TextArea descRec;
    Form recForm;
    Button Envoyer;
    Button Reset;
    
    public sendMyClaim() {
        recForm = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        recForm.setTitle("Send Claim");
        recForm.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
           
        });
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        objetRec = new TextField("", "claim object...");
        // destRec = new TextField("", "destination Reclamation");
        descRec = new TextArea("");
        Envoyer = new Button("Send");
        Reset = new Button("Reset");
        lbobj = new Label("Object:");
        lbdesc = new Label("Content:");
        
        c.add(lbobj);
        c.add(objetRec);
        c1.add(lbdesc);

        c1.add(descRec);
        recForm.add(c);
        recForm.add(c1);
        recForm.add(Envoyer);
        recForm.add(Reset);

        Envoyer.addActionListener((evt) -> {
            if (!(objetRec.getText().equals(""))&& !(descRec.getText().equals(""))){
                ServiceReclamationM serRec = new ServiceReclamationM();
            ReclamationM reclamation = new ReclamationM();
            
            reclamation.setObjetReclamation(objetRec.getText());
            reclamation.setDescriptionReclamation(descRec.getText());
            
            serRec.sendClaim(reclamation);
            System.out.println("test");
            Dialog.show("Alert", "Claim has been sucessfully sended", "OK", null);
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
            
            }
            else {
                Dialog.show("Warning", "Please fill in all fields", "Ok", null);
            }

        });
        Reset.addActionListener((evt) -> {
            sendMyClaim send = new sendMyClaim();
            objetRec.clear();
            descRec.clearClientProperties();
            send.getRecForm().show();
        });
    }

    public Form getRecForm() {
        return recForm;
    }

    public void setRecForm(Form recForm) {
        this.recForm = recForm;
    }

    
}
