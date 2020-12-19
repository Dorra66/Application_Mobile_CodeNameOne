/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Event;


import Entities.User;
import Services.AvisService;
import Services.EventService;
import Services.ParticipationService;
import com.codename1.components.ImageViewer;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
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
public class AfficheEvent {
    
    Form f;
    ImageViewer ip;
    List<Event> lse = new ArrayList();
   
    

    public AfficheEvent() {

        f = new Form("Event List", BoxLayout.y());
        
        Toolbar tb = f.getToolbar();
        tb.addCommandToLeftBar("<back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MenuForm a =new MenuForm();
                a.getFjdida().show();
            }
        });
        lse = new EventService().getListEvenements();
        for (int i = 0; i < lse.size(); i++) {
            int id = lse.get(i).getIdevent();
            addItem(lse.get(i));
            String nomevent=lse.get(i).getNomevent().toString();
            String dateevent = lse.get(i).getDateevent().toString();
            String heureevent = lse.get(i).getHeureevent().toString();
            Button participer = new Button("Participate");
            f.add(participer);
            TextField comment=new TextField(null,"add feed_back");
            f.add(comment);
            Button addfeed = new Button("Add Feed_Back");
            f.add(addfeed);
            participer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    //User p = new User(1,"Hnana", "Alaeddine", 12345678);
                    ParticipationService es = new ParticipationService();
                   // float id = Float.parseFloat(lse.get(i).getIdevent());
                    
                   es.ajouterPartEvenement(id, Authentification.PERSONNECONNECTEE.getId());
                   
                   
                            
                    
                }
            });
            
            addfeed.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    AvisService as = new AvisService();
                    as.ajouterAvisEvenement(id, Authentification.PERSONNECONNECTEE.getId(), comment.getText());
                }
            });
        }
        
        /*tb.addCommandToLeftBar("< Retour", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                precedent.show();
            }
        });*/
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
            
            //Label id1 = new Label(""+e.getIdevent());
            //Button participer = new Button("Participate");
            
            
              
            /*l1.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    DetailEvenement de = new DetailEvenement(user, e, f);
                    de.getF().show();
                }
            });*/
            c1.add(ip);
            //c2.add(id1);
            c2.add(l1);
            c2.add(l2);
            c2.add(l);
            c2.add(l3);
            //c2.add(participer);
            
            //c2.add(participer);
           /* id1.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Accueil a = new Accueil();
                    a.getAcc().show();
                               }
            });*/
            
             /*participer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Accueil a = new Accueil();
                    a.getAcc().show();
//                        
            }
        });*/
           // c2.add(l4);
            c1.add(c2);
            c1.setLeadComponent(l1);
            f.add(c1);
           f.refreshTheme();
           /*participer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    User p = new User(1,"Hnana", "Alaeddine", 12345678);
                    ParticipationService es = new ParticipationService();
                    es.ajouterPartEvenement(e,p);
                    
                }
            });*/
           
            
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
