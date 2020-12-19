/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import Entities.Publicites;
import Services.ServicePublicite;

/**
 *
 * @author dorra
 */
public class Recherche {
    
    Form r;
    TextField rtitre;
    SpanLabel lb;
    public Recherche() {
        
        r = new Form("search of Advertisings");
        lb = new SpanLabel("");
        r.add(lb);
        rtitre = new TextField("","title");
        r.add(rtitre);
        
        ServicePublicite ser=new ServicePublicite();
        /*for (Publicites p : ser.Recherche(rtitre.getText())) {
              Container con = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              con.add(RechPublicite(p));
              r.add(con);
        }*/
        // lb.setText(ser.Recherche(rtitre.getText()).toString());
         lb.setText(ser.Recherche(rtitre.getText()).toString());
         r.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }
    public Container RechPublicite(Publicites c) {
         
       
       
        Label titLabel = new Label(c.getTitre());
        

        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.add(titLabel);
        return cnt;
    
    }
    
    
    
    public Form getR() {
        return r;
    }

    public void setR(Form f) {
        this.r = r;
    }
    
}

