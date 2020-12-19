/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ReclamationM;
import Services.ServiceReclamationM;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author fares
 */
public class showMyClaims {

    Form mycs;
    public static String objj;
    
    public showMyClaims() {
        
        mycs = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        mycs.setTitle("My Claims");
        mycs.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
        });

        ServiceReclamationM ser = new ServiceReclamationM();
        ArrayList<ReclamationM> al = new ArrayList<ReclamationM>();
        al = ser.showMyClaims();
        for (ReclamationM rm : al) {

            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label lobj = new Label("" + rm.getObjetReclamation());
            //SpanLabel ldesc = new SpanLabel(""+r.getDescReclamation());
            //SpanLabel ldate = new SpanLabel(""+r.getDateReclamation());
            //  SpanLabel lreponse = new SpanLabel(""+r.getReponseReclamation());
            // SpanLabel lstatus = new SpanLabel(""+r.getStatusReclamation());

            c1.add(lobj);
            //  c1.add(ldesc);
            //  c1.add(ldate);
            // c1.add(lreponse);
            // c1.add(lstatus);

            mycs.add(c1);

            lobj.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
//                    afficheeReec aff = new afficheeReec();
//                    aff.getF().show();
                    objj = ("" + lobj.getText());
                    System.out.println("c bon " + lobj.getText());
                    Form f4 = new Form(new BoxLayout(BoxLayout.Y_AXIS));
                    f4.getToolbar().addCommandToRightBar("back", null, (ev) -> {
                        showMyClaims smc;
                        smc = new showMyClaims();
                        smc.getMycs().showBack();
                        ;
                    });
                    ServiceReclamationM ser = new ServiceReclamationM();
                    ArrayList<ReclamationM> al = new ArrayList<ReclamationM>();
                    al = ser.showMyClaims();

                   // for (ReclamationM rm : al) {
                        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Label lbbobj = new Label("Object: ");
                        SpanLabel lobj = new SpanLabel("" + rm.getObjetReclamation());
                        Label lbbdesc = new Label("Content: ");
                        SpanLabel ldesc = new SpanLabel("" + rm.getDescriptionReclamation());
                        Label lbbdate = new Label("Date: ");
                        SpanLabel ldate = new SpanLabel("" + rm.getDateReclamation());
                        Label lbreponse = new Label("Reponse : ");
                        SpanLabel lreponse = new SpanLabel("" + rm.getReponseReclamation());
                        Label lbstatus = new Label("Status: ");
                        SpanLabel lstatus = new SpanLabel("" + rm.getStatusReclamation());

                        c1.add(lbbobj);
                        c1.add(lobj);
                        c1.add(lbbdesc);
                        c1.add(ldesc);
                        c1.add(lbbdate);
                        c1.add(ldate);
                        c1.add(lbreponse);
                        c1.add(lreponse);
                        c1.add(lbstatus);
                        c1.add(lstatus);

                        f4.add(c1);
                   // }
                    f4.show();

                }
            });
        }
    }

    public Form getMycs() {
        return mycs;
    }

    public void setMycs(Form mycs) {
        this.mycs = mycs;
    }

    
    
}
