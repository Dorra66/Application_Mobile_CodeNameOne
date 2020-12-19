/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import Entities.Publicites;
import Services.ServicePublicite;
import java.io.IOException;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    ImageViewer imgv ;
    Image img ;
    private EncodedImage enc ;
    String url ; 
    Database db;
    boolean created = false;
    
    
    
     public Affichage() {
        
        f = new Form("List of Advertisings");
        
        
        ServicePublicite ser=new ServicePublicite();
        for (Publicites p : ser.getList2()) {
              Container con = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              con.add(addPublicite(p));
              f.add(con);
        }
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
         created= Database.exists("dorr");
        try {
            db=Database.openOrCreate("dorr");
            
            if(created ==false)
                db.execute("create table myr (id Text , rate Text);");
        } catch (IOException ex) {
          
        }
         
         
         
         
    } 
     public Container addPublicite(Publicites c) {
         
       
        Button btid = new Button(c.getTitre());
        Label titLabel = new Label(c.getTitre());
        

        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.add(titLabel);
       Container cnt2 = BorderLayout.center(cnt);
        
        cnt2.setLeadComponent(btid);
        
        btid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Boolean b=Dialog.show("Hello", "Please choose", "show", "delete");
                Container c1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Form f2=new Form("Informations of the advertising");
                Label iddLabel = new Label("id : "+String.valueOf(c.getId()));
                Label titLabel = new Label("title : "+c.getTitre());
                Label desLabel = new Label("description : "+c.getDescription());
                Label imgLabel = new Label("photo : ");
              if(b){ 
                
                  
               // Dialog.show("alert", "vous avez selectionné "+c.getId() , "ok", null);
                ////affichage des donnees dans un autre form//////////
               try {
                    enc=EncodedImage.create("/load.png").scaledEncoded(1000, 1000);
                } catch (IOException ex) {
                 }
                img=URLImage.createToStorage(enc, c.getImag(),"http://localhost/CiteCulture/web/images/"+c.getImag());
                
                imgv=new ImageViewer();
                imgv.setImage(img);
               
               Label lb = new Label();
                
                Button bt=new Button("All my adverts Rating");
               
                
                c1.add(iddLabel);
                c1.add(titLabel);
                c1.add(desLabel);
                c1.add(imgLabel);
                c1.add(imgv);
                c1.add(lb);
                 c1.add(bt);
                ////////Raiting//////////////
                
                Label lNote = new Label("Note : 5");
                Container cNote = new Container(BoxLayout.y());
                cNote.add(lNote);
                Slider starRank = new Slider();
                starRank.setIncrements(1);
                starRank.setMaxValue(10);
                starRank.setMinValue(0);
                starRank.setProgress(5);
                starRank.setEnabled(true);
                starRank.setEditable(true);
                cNote.add(starRank);

                Font fnt = Font.createSystemFont(3, 5, 7);
                Style s = new Style(0xffff33, 0, fnt, (byte)0);
                Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
                s.setOpacity(100);
                s.setFgColor(0);
                Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
                initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
                initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
                initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
                initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
                starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
                f2.add((cNote));
                
                 Button btnValider = new Button("Valider");
                f2.add(btnValider);

                starRank.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {

                    lNote.setText("Note : "+starRank.getProgress());
                    }

                });
                
                ////////////////////
                btnValider.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {

                  if(Dialog.show("Confirmation", 
                          "U have given the note : "+starRank.getProgress()+" to advertising with id : "+String.valueOf(c.getId())  ,
                          "Ok", null)){
                  lb.setText(starRank.getProgress()+" to advertising with id : "+String.valueOf(c.getId()) );
                  
                  }
                try {
                  db.execute("delete from myr where id='"+c.getId()+"'");
                   db.execute("insert into myr (id,rate) values ('" + c.getId() + "' , '" +starRank.getProgress() + "');");
                 
                  } catch (IOException ex) {
                        
                    }
              System.out.println("ok");
                   f2.show();
                    }
                });
                
                
            
                //////////
                 SpanLabel label = new SpanLabel();
                bt.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Form ff = new Form();
                        Cursor c;
                        try {
                            c = db.executeQuery("select * from myr;");
                             String message=" " ; 
                    while (c.next())
                    {
                      
                       message = message + c.getRow().getString(0) +"with rate:"+ c.getRow().getString(1)+ "\n" ;
                  
                   label.setText(message);
                   
                  //  System.out.println(message);
                 
                    }
                        } catch (IOException ex) {
                            
                        }
                        
                    
                   Label d = new Label("My rates :");
                    ff.add(d);
                    ff.add(label); 
                    ff.getToolbar().addCommandToRightBar("back", null, (ev)->{
                        f2.showBack();
                    
                    });
                   ff.show();
                    }
                    
                    
                });

            
///////////////
     /////////////table rate avec ///////////////////
                
                
                f2.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h=new Affichage();
                    h.getF().show();
                    });
                
              f2.add(c1);
                f2.show();
                
                
             }
              /////////supprimé/////////////
              else{
                ServicePublicite se=new ServicePublicite();
                se.suppPub(c);
                Form f3=new Form();
                boolean k=Dialog.show("alert", "advertising with id"+c.getId()+"has been deleted with succes !" , "ok", null);
                if(k){
                   
                    HomeForm h = new HomeForm();
                    h.getF().show();
                  ////////à revoir le null !!!///// 
                
                }
                
                
                  
              }}
        });
        return cnt2;
    }
     private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
