/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Monument;
import Services.ServiceMonument;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fares
 */
public class showMonuments {

    Form MForm;
    Button Next, Previous;
    ImageViewer MViewer;
    Label Nom, Description, lnom, ldesc;
    EncodedImage enc;
    URLImage img;

    public showMonuments() {

        MForm = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        MForm.setTitle("Our Monuments");
        MForm.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
        });

        ServiceMonument ser = new ServiceMonument();
        ArrayList<Monument> al = new ArrayList<Monument>();
        al = ser.showMonuments();
        
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        for (Monument M : al) {
            try {
        
                MViewer = new ImageViewer();
                enc = EncodedImage.create("/Loading.png").scaledEncoded(1000, 1000);

                img = URLImage.createToStorage(enc, M.getImageM(), "http://localhost/CiteCulture/web/uploads/images/"+M.getImageM());//5d8a7dc51f27c2c9ff01e4d8306037b7
                MViewer.setImage(img);

                Nom = new Label();
                Nom.setText("Nom: " + M.getNomM());

                Description = new Label();
                Description.setText("Description: " + M.getDescriptionM());

                c.add(MViewer);
                c.add(Nom);
                c.add(Description);
                
            } catch (IOException ex) {
            }
   
        }
        MForm.add(c);
    }

    public Form getMForm() {
        return MForm;
    }

    public void setMForm(Form MForm) {
        this.MForm = MForm;
    }

}
