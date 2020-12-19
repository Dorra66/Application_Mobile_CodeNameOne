/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Entity.User;
//import static GUI.LoginUser.tpassword;
//import static GUI.LoginUser.tusername;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;


/**
 *
 * @author fares
 */
public class MenuForm {

    Form fjdida = new Form(new FlowLayout());
    Form toolbar;
    URLImage img;
    EncodedImage enc ;
    

    public MenuForm(){
        fjdida.setTitle("WELCOME" );//+ User.membre.getUsername
        

        Toolbar t = fjdida.getToolbar();
        
        t.addCommandToOverflowMenu("Logout",null, e->{
            Authentification auth = new Authentification();
            auth.getHi().show();
        });
        
        t.addMaterialCommandToSideMenu("Some Monuments", FontImage.MATERIAL_PHOTO, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showMonuments sm = new showMonuments();
                sm.getMForm().show();
            }
        });
        
        t.addMaterialCommandToSideMenu("Send Visit Request", FontImage.MATERIAL_SEND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendVReq SVReq;
                SVReq = new sendVReq();
                SVReq.getReqForm().show();
            }
        });
        
        t.addMaterialCommandToSideMenu("My Visit Request", FontImage.MATERIAL_VIEW_LIST, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showVReq ShVReq;
                ShVReq = new showVReq();
                ShVReq.getMyvr().show();
            }
        });
        
        t.addMaterialCommandToSideMenu("Send Claim", FontImage.MATERIAL_SEND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendMyClaim SC;
                SC = new sendMyClaim();
                SC.getRecForm().show();
            }
        });
        t.addMaterialCommandToSideMenu("Claims Sent", FontImage.MATERIAL_FEEDBACK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showMyClaims ShC;
                ShC = new showMyClaims();
                ShC.getMycs().show();
            }
        });
        t.addMaterialCommandToSideMenu("Advertising", FontImage.MATERIAL_PUBLISH, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm hf = new HomeForm();
                hf.getF().show();
            }
        });
        t.addMaterialCommandToSideMenu("Catalogue", FontImage.MATERIAL_MONEY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CatalogueEcommerceForm ce = new CatalogueEcommerceForm();
                ce.getCatalogueForm().show();
            }
        });
        t.addMaterialCommandToSideMenu("My basket", FontImage.MATERIAL_MONEY_OFF, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                PanierAddForm p = new PanierAddForm();
                p.getPanierForm().show();
            }
        });
        t.addMaterialCommandToSideMenu("My basket", FontImage.MATERIAL_MONEY_OFF, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                PanierAddForm p = new PanierAddForm();
                p.getPanierForm().show();
            }
        });
        t.addMaterialCommandToSideMenu("Books", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeFormBook hfb;
                try {
                    hfb = new HomeFormBook();
                    hfb.getF().show();
                } catch (IOException ex) {
                   
                }
                
                     
            }
        });
         t.addMaterialCommandToSideMenu("Send Book Request", FontImage.MATERIAL_SEND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                UserRequestForm us = new UserRequestForm();
                us.getF().show();
            }
        });
          t.addMaterialCommandToSideMenu("Show Requests", FontImage.MATERIAL_SEND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               UserRequestIndex ui = new UserRequestIndex();
               ui.getF().show();
            }
        });
        
          t.addMaterialCommandToSideMenu("Event List", FontImage.MATERIAL_EVENT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               AfficheEvent ae= new AfficheEvent();
               ae.getF().show();
            }
        });
          t.addMaterialCommandToSideMenu("My Participations", FontImage.MATERIAL_EVENT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               MyParticipations mypart=new MyParticipations();
               mypart.getF().show();
            }
        });
          t.addMaterialCommandToSideMenu("My Feed_Backs", FontImage.MATERIAL_EVENT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               MyFeeds myf=new MyFeeds();
               myf.getF().show();
            }
        });

    }

    public Form getFjdida() {
        return fjdida;
    }

    public void setFjdida(Form fjdida) {
        this.fjdida = fjdida;
    }

}
