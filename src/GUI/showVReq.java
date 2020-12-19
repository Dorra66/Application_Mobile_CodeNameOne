/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.demandeVisite;
import static GUI.showMyClaims.objj;
import Services.ServiceDemandeVisite;
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
public class showVReq {

    Form myvr;
    public static String dateV;
    public static String hourV;
    
    public showVReq() {
        myvr = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        myvr.setTitle("My Visit Requests");
        myvr.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
        });

        ServiceDemandeVisite ser = new ServiceDemandeVisite();
        ArrayList<demandeVisite> al = new ArrayList<demandeVisite>();
        al = ser.showMyVR();
        for (demandeVisite dv : al) {

            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label dateVR = new Label("" + dv.getDateVisiteD());
            Label hourVR = new Label("" + dv.getHeureVisiteD());

            c1.add(dateVR);
            c1.add(hourVR);

            myvr.add(c1);

            dateVR.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    objj = ("" + dateVR.getText());
                    System.out.println("c bon " + dateVR.getText());
                    Form f4 = new Form(new BoxLayout(BoxLayout.Y_AXIS));
                    f4.setTitle(dateVR.getText());
                    f4.getToolbar().addCommandToRightBar("back", null, (ev) -> {
                        showVReq smvr;
                        smvr = new showVReq();
                        smvr.getMyvr().showBack();
                        ;
                    });
                    ServiceDemandeVisite ser = new ServiceDemandeVisite();
                    ArrayList<demandeVisite> al = new ArrayList<demandeVisite>();
                    al = ser.showMyVR();

                   // for (ReclamationM rm : al) {
                        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Label lbOrg = new Label("Oraganization Name: ");
                        SpanLabel slOrg = new SpanLabel("" + dv.getNomOrganismeD());
                        Label lbResp = new Label("Organizer Name: ");
                        SpanLabel slResp = new SpanLabel("" + dv.getNomResponsableD());
                        Label lbTel = new Label("TEL. Number: ");
                        SpanLabel slTel = new SpanLabel("" + dv.getNumTelD());
                        Label lbMail = new Label("E-mail: ");
                        SpanLabel slMail = new SpanLabel("" + dv.getMailD());
                        Label lbAdd = new Label("Address: ");
                        SpanLabel slAdd = new SpanLabel("" + dv.getAddPostaleD());
                        Label lbDate = new Label("Date: ");
                        SpanLabel slDate = new SpanLabel("" + dv.getDateVisiteD());
                        Label lbHour = new Label("Hour: ");
                        SpanLabel slHour = new SpanLabel("" + dv.getHeureVisiteD());
                        Label lbNbre = new Label("Visitors Number: ");
                        SpanLabel slNbre = new SpanLabel("" + dv.getNbreVisiteursD());
                        Label lbstatus = new Label("Status: ");
                        SpanLabel lstatus = new SpanLabel("" + dv.getEtatDV());

                        c1.add(lbOrg);
                        c1.add(slOrg);
                        c1.add(lbResp);
                        c1.add(slResp);
                        c1.add(lbTel);
                        c1.add(slTel);
                        c1.add(lbMail);
                        c1.add(slMail);
                        c1.add(lbAdd);
                        c1.add(slAdd);
                        c1.add(lbDate);
                        c1.add(slDate);
                        c1.add(lbHour);
                        c1.add(slHour);
                        c1.add(lbNbre);
                        c1.add(slNbre);
                        c1.add(lbstatus);
                        c1.add(lstatus);

                        f4.add(c1);
                   // }
                    f4.show();

                }
            });
        }
    }

    public Form getMyvr() {
        return myvr;
    }

    public void setMyvr(Form myvr) {
        this.myvr = myvr;
    }
    
    
}
