/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;
import Entities.Participation;
import Services.EventService;
import Services.ParticipationService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MyParticipations {
    Form f;
    //ImageViewer ip;
    List<Event> lse = new ArrayList();
    ImageViewer ip;

    public MyParticipations() {
         f = new Form("My Participations", BoxLayout.y());
        
        Toolbar tb = f.getToolbar();
        tb.addCommandToLeftBar("<back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MenuForm a =new MenuForm();
                a.getFjdida().show();
            }
        });
        lse = new ParticipationService().getListPart();
        for (int i = 0; i < lse.size(); i++) {
            //int id = lse.get(i).getIdParticipation();
            addItem(lse.get(i));
            int id = lse.get(i).getIdevent();
            Button remove = new Button("Remove");
            f.add(remove);
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(Dialog.show("You like to remove this participation!!!!", "", "YES", "NO")){
                        ParticipationService ps = new ParticipationService();
                    ps.deletePartEvenement(id, Authentification.PERSONNECONNECTEE.getId());
                    }
                    
                    
                }
            });
        }
        
        
    }

    

    public void addItem(Event e) {

      
        Image imgs;
        String url = "http://localhost/CiteCulture/web/Uploads/Images/" + e.getAffiche();
        //System.out.println(url);
        try {
            EncodedImage enc = EncodedImage.create("/load.png");
            imgs = URLImage.createToStorage(enc, e.getAffiche(), url).scaled(400, 350);
            ip = new ImageViewer(imgs);
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Label l1 = new Label("Name:"+e.getNomevent());
            Label l2 = new Label("Gategory:"+e.getCategorieevent());
            Label l = new Label("Date:" +e.getDateevent());
            Label l3 = new Label("At:" +e.getHeureevent());
            
            
            c1.add(ip);
            
            c2.add(l1);
            c2.add(l2);
            c2.add(l);
            c2.add(l3);
            
            c1.add(c2);
            c1.setLeadComponent(l1);
            f.add(c1);
           f.refreshTheme();
           
           
            
        } catch (IOException ex) {
        }  
        
       
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
    
    
}
