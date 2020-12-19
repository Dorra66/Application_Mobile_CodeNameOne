/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.demandeVisite;
import Services.ServiceDemandeVisite;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author fares
 */
public class sendVReq {

    Form reqForm;
    Label lbOrgType, lbTel, lbMail, lbAdd, lbDate, lbNbrV;
    TextField tfTel, tfMail, tfAdd, tfNbrV;
    Button Send, Reset;

    public sendVReq() {

        reqForm = new Form(new BoxLayout(BoxLayout.Y_AXIS));

        reqForm.setTitle("Send Visit Request");
        reqForm.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            MenuForm mf = new MenuForm();
            mf.getFjdida().show();
            ;
        });
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container cx1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbOrgType = new Label("Organization       :");
        cx1.add(lbOrgType);
        Picker OrgTypePicker = new Picker();
        OrgTypePicker.setStrings("Association", "Kindergarten", "Primary school", "High school", "University", "Group of tourist", "Individual visit");
        OrgTypePicker.setSelectedString("Association");
        cx1.add(OrgTypePicker);
        c.add(cx1);
        Container cx2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbTel = new Label("Tel. Number        :");
        cx2.add(lbTel);
        tfTel = new TextField();
        cx2.add(tfTel);
        c.add(cx2);
        Container cx3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbMail = new Label("E-mail                   :");
        cx3.add(lbMail);
        tfMail = new TextField();
        cx3.add(tfMail);
        c.add(cx3);
        Container cx4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbAdd = new Label("Postal address  :");
        cx4.add(lbAdd);
        tfAdd = new TextField();
        cx4.add(tfAdd);
        c.add(cx4);
        Container cx5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbDate = new Label("Date of visit        :");
        cx5.add(lbDate);
        Picker datePicker = new Picker();
        cx5.add(datePicker);
        c.add(cx5);
        Container cx6 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbDate = new Label("Hour of visit       :");
        cx6.add(lbDate);
        Picker HourPicker = new Picker();
        HourPicker.setStrings("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14;00", "15:00", "16:00", "17:00");
        HourPicker.setSelectedString("08:00");
        cx6.add(HourPicker);
        c.add(cx6);
        Container cx7 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        lbNbrV = new Label("Visitors number:");
        cx7.add(lbNbrV);
        tfNbrV = new TextField();
        cx7.add(tfNbrV);
        c.add(cx7);
        reqForm.add(c);
        Send = new Button("Send");
        Reset = new Button("Reset");
        reqForm.add(Send);
        reqForm.add(Reset);

        Send.addActionListener((evt) -> {
            ServiceDemandeVisite sdv = new ServiceDemandeVisite();
            demandeVisite dv = new demandeVisite();

            dv.setNomOrganismeD(OrgTypePicker.getSelectedString());
            dv.setNumTelD(Integer.parseInt(tfTel.getText()));
            dv.setMailD(tfMail.getText());
            dv.setAddPostaleD(tfAdd.getText());
            dv.setDateVisiteD(datePicker.getDate());//java.sql.Date.valueOf(selectDate.getValue())
            dv.setHeureVisiteD(HourPicker.getSelectedString());
            dv.setNbreVisiteursD(Integer.parseInt(tfNbrV.getText()));

            //Controle numero tel
            String tel = tfTel.getText();
            int tel1 = Integer.parseInt(tel);
            if (String.valueOf(tel1).length() != 8) {
                Dialog.show("Alert", "Please, enter a telephone of 8 digits !!", "OK", null);
                return;
            }

            // Controle nombre visiteurs
            if (Integer.parseInt(tfNbrV.getText()) > 50  || Integer.parseInt(tfNbrV.getText()) < 0) {
                Dialog.show("Alert", "The number of visitors should be positive and less than 50 !!", "OK", null);
                return;
            }

            //Controle date de visite
//            if( (datePicker.getDate().before(LocalDate.now()))){//.isBefore(LocalDate.now())
//                Dialog.show("Alert", "Please, enter a date after the date of today !!", "OK",null);
//                return;
//            }

            //Controle saisie sur les textfield vide s'ils sont vides
            if (tfTel.getText().equalsIgnoreCase("")
                    || tfMail.getText().equalsIgnoreCase("")
                    || tfAdd.getText().equalsIgnoreCase("")
                    || tfNbrV.getText().equalsIgnoreCase("")) {
                Dialog.show("Alert", "Please, try to fill all text fields !!", "OK", null);
                return;
            } else {
                sdv.sendVR(dv);
                showVReq VR = new showVReq();//Afficher mes réclamation
                Dialog.show("Alert", "Request has been sucessfully sended", "OK", null);
                VR.getMyvr().show();
            }

//            Message msg = new Message("Votre demande a été bien enovoyé, un mail vous sera transmis ultérieurement lors de traitement de votre demande. Merci.");
//            msg.sendMessageViaCloudSync("Codename One", dv.getMailD() , dv.getSource(),"Info", msg.toString());
        });
        Reset.addActionListener((evt) -> {
            sendVReq SVR = new sendVReq();
            OrgTypePicker.clearClientProperties();
            tfTel.clear();
            tfMail.clear();
            tfAdd.clear();
            datePicker.clearClientProperties();
            HourPicker.clearClientProperties();
            tfNbrV.clear();
            SVR.getReqForm().show();
        });
    }

    public Form getReqForm() {
        return reqForm;
    }

    public void setReqForm(Form reqForm) {
        this.reqForm = reqForm;
    }

}
