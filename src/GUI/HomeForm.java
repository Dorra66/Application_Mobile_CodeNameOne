/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import Entities.Publicites;
import Services.ServicePublicite;

 


/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField ttitre;
    TextField tdescription;
    TextField timag ;
    Button btnajout,btnaff,btnrech;
    TextField rtitre;
    SpanLabel lb;

    public HomeForm() {
        f = new Form("Advertisings");
        ttitre = new TextField("","title");
        tdescription = new TextField("","description");
        timag = new TextField("","photo");
        btnajout = new Button("add     ");
        btnaff=new Button("show list");
        btnrech=new Button("Search");
        
        
         f= new Form("search of Advertisings");
        lb = new SpanLabel("");
        f.add(ttitre);
        f.add(tdescription);
        f.add(timag);
        f.add(btnajout);
        f.add(btnaff);
        f.add(btnrech);
        
        
       
        rtitre = new TextField("","title");
        f.add(rtitre);
        f.add(lb);
        
        btnajout.addActionListener((e) -> {
            ServicePublicite ser = new ServicePublicite();
            if(ttitre.getText().equalsIgnoreCase("") || tdescription.getText().equalsIgnoreCase("") || timag.getText().equalsIgnoreCase("")){
            //
            
             Dialog.show("alert","Please, try to fill all text fields !!", "ok", null);
                 ;}
                         else{
            
            
            
            Publicites t = new Publicites(0, ttitre.getText(), tdescription.getText(), timag.getText());
            ser.ajoutPub(t);
            Dialog.show("alert","advertising has been added with success ! ", "ok", null);
            }

        });
        
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
        
        ////recherche/////////
        btnrech.addActionListener((e)->{
        //Recherche r=new Recherche();
        //r.getR().show();
        if(rtitre.getText().equalsIgnoreCase("") ){
            //
            
             Dialog.show("alert","Please, try to fill the text field title !!", "ok", null);
                 ;}
                         else{
        ServicePublicite ser=new ServicePublicite();
        lb.setText(ser.Recherche(rtitre.getText()).toString());
        }});
        f.getToolbar().addCommandToRightBar("back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    MenuForm mf = new MenuForm();
                    mf.getFjdida().show();
            }
        });
        
     
    } 

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    

}

