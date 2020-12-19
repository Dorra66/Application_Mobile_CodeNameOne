/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import Entities.Book;
import Entities.User;
import static GUI.Authentification.tpassword;
import static GUI.Authentification.tusername;
import Services.ServiceBook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class HomeFormBook {

    //Form f = new Form(new FlowLayout());
    Form f = new Form("Home", new BorderLayout());
    Form toolbar;
    Button btnreq;
    Button btnaffreq;
    Container c1 = new Container(BoxLayout.x());

    public HomeFormBook() throws IOException {
      //  f.setTitle("welcome " + Authentification.PERSONNECONNECTEE.getNom());
        f.getToolbar().addCommandToRightBar("Back", null, (ev) -> {
            MenuForm a = new MenuForm();
            a.getFjdida().showBack();
//            tusername.clear();
        //    tpassword.clear();
        });

        btnreq = new Button("Requests");
        btnaffreq = new Button("Requests sended");

        /**
         * ****************************** ONE IMAGE ********************
         */
        //Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
        //FontImage fi = FontImage.createMaterial(FontImage.MATERIAL_IMAGE, s);
        //  EncodedImage placeholder = EncodedImage.createFromImage(fi.scaled(fi.getWidth() * 3, fi.getHeight() * 3), false);
        //  Image i1 = URLImage.createToStorage(placeholder, "yy", "http://localhost/library/web/uploads/book/book2.jpg");
              
        //  ImageViewer img = new ImageViewer(i1);
        // c1.addAll(img);
        //f.add(c1); 
        /**
         * *************************************************
         */
        /* ***********************  DISPLAY IMAGES ************************ */
        /*
       Style ss = UIManager.getInstance().getComponentStyle("MultiList");
        FontImage pp = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, ss);
        EncodedImage placeholder = EncodedImage.createFromImage(pp.scaled(pp.getWidth() * 3, pp.getHeight() * 3), false);

        ArrayList<Map<String, Object>> data = new ArrayList<>();
        ServiceBook serviceTask = new ServiceBook();
        ArrayList<Book> lis = serviceTask.getList();
        for (Book B : lis) {
            Image i1 = URLImage.createToStorage(placeholder, "a", "http://localhost/library/web/uploads/book/"+ B.getBookImage());
            DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
            MultiList m = new MultiList(model);
           /* m.getUnselectedButton().setIconName("icon_URLImage");
            m.getSelectedButton().setIconName("icon_URLImage");
            m.getUnselectedButton().setIcon(placeholder);
            m.getSelectedButton().setIcon(placeholder);
            f.add(BorderLayout.CENTER, m);

        } 
            //f.show();
    */
        
    // int mm = Display.getInstance().convertToPixels(6);
    //EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 13, mm * 4, 0), false);
            Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
            FontImage fi = FontImage.createMaterial(FontImage.MATERIAL_IMAGE, s);
            EncodedImage placeholder = EncodedImage.createFromImage(fi.scaled(fi.getWidth() * 4, fi.getHeight() * 3), false);
    ServiceBook serviceTask = new ServiceBook();
    ArrayList<Book> lis = serviceTask.getList();
    ArrayList<Map<String, Object>> data = new ArrayList<>();
    for (Book B : lis) {
  Image i1 = URLImage.createToStorage(placeholder, B.getBookTitle(), "http://localhost/CiteCulture/web/uploads/book/"+B.getBookImage());

  data.add(createListEntry(B.getBookTitle(),B.getBookAuthor(),i1));

  DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
  f.add(BorderLayout.CENTER, ml);
    }
  f.show();
    

        /* **************************************** ************************ */
        
        
                /* ***********************  DISPLAY IMAGES ************************ */

          /*      
                int mm = Display.getInstance().convertToPixels(3);
  EncodedImage placeholderee = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
  Image i1 = URLImage.createToStorage(placeholderee, "ee", "http://localhost/library/web/uploads/book/book2.jpg");
  ArrayList<Map<String, Object>> data = new ArrayList<>();
  data.add(createListEntry("book","12/05/1996",i1));
  DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
  f.add(BorderLayout.CENTER, ml);
  f.show();
                */

        /* **************************************** ************************ */
 /*
        f.add(btnreq);
        f.add(btnaffreq);
         */
        btnreq.addActionListener((evt) -> {
            /*ReqForm aa = new ReqForm();
            aa.getRecForm().show();*/

        });
        btnaffreq.addActionListener((evt) -> {
            /* AfficheRecForm afff = new AfficheRecForm();
            afff.getAffrec().show();*/
        });

//        Container C2 = new Container(new FlowLayout(Component.CENTER));
//        Image img = Image.createImage("/show.jpg");
//        toolbar.setBgImage(img);
//        toolbar.add(C2);
        Toolbar t = f.getToolbar();
        
    }

    private Map<String, Object> createListEntry(String name ,String date ,Image icon ) {
        Map<String, Object> entry = new HashMap<>();
       entry.put("Line1", name);
       entry.put("Line2", date);
       entry.put("Line3", icon);
        return entry;
    }

  
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
