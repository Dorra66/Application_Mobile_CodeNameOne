/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Avis;
import Entities.Event;
import Services.AvisService;
import Services.ParticipationService;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MyFeeds {
    Form f;
    List<Avis> lse = new ArrayList();

    public MyFeeds() {
        
        f = new Form("My Feed_Backs", BoxLayout.y());
        Toolbar tb = f.getToolbar();
        tb.addCommandToLeftBar("<back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MenuForm a =new MenuForm();
                a.getFjdida().show();
            }
        });
        
        lse = new AvisService().getListAvis();
        for (int i = 0; i < lse.size(); i++) {
            //int id = lse.get(i).getIdParticipation();
            addItemAvis(lse.get(i));
    }
    
    }   
        
        
        
        public void addItemAvis(Avis avis) {
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Label descrip = new Label("Description: "+avis.getDescriptionavis());
             c1.add(descrip);
             f.add(c1);
              f.refreshTheme();
             
        }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
