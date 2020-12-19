/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import Entities.User;
import Entities.UserRequest;
import Services.ServiceUserRequest;
import com.mycompany.util.SMSAPI;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class UserRequestForm {


    TextField booktitle;
    TextField membermobile;
    TextField issuedate;
    TextField issueperiod;
    Picker picker;

    Label lbbooktitle;
    Label lbmembermobile;
    Label lbissuedate;
    Label lbissueperiod;
    Button Envoyer;
    Button Reset;

    SimpleDateFormat sdf;
    SimpleDateFormat sdf2;
    Date date;
    Date finalDate;
    String strDate;
    String mydate;
    Form f;
    public UserRequestForm() {
        f = new Form("Send",new FlowLayout(CENTER, CENTER));
        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            HomeFormBook hf;
            try {
                hf = new HomeFormBook();
                hf.getF().showBack();
            } catch (IOException ex) {

            }
            ;
        });
        Container c = new Container();
        Container c1 = new Container();
        Container c2 = new Container();
        Container c3 = new Container();
        Container c4 = new Container();
        



        booktitle = new TextField("", "booktitle ");
        membermobile = new TextField("", "membermobile ");
        issuedate = new TextField("", "isseudate ");
        issueperiod = new TextField("", "isssueperiod ");
        picker = new Picker();

        Envoyer = new Button("Envoyer");
        Reset = new Button("Reset");
        lbbooktitle = new Label("book title:");
        lbmembermobile = new Label("member mobile:");
        lbissuedate = new Label("issue date:");
        lbissueperiod = new Label("issue period:");
        c1.addAll(lbbooktitle, booktitle);
        c2.addAll(lbmembermobile, membermobile);
        c3.addAll(lbissuedate, picker);
        c4.addAll(lbissueperiod, issueperiod);
        SpanLabel lb = new SpanLabel("                    ");
        f.addAll(c1,c2,c4,c3,lb,Envoyer,Reset);
   
     
        Envoyer.addActionListener((ActionEvent evt) -> {
            if (!(booktitle.getText().equals("")) && !(membermobile.getText().equals(""))) {
                ServiceUserRequest sr = new ServiceUserRequest();
                UserRequest userrequest = new UserRequest();
                System.out.println(Authentification.PERSONNECONNECTEE.getId());
                userrequest.setMemberId(Authentification.PERSONNECONNECTEE.getId());
                userrequest.setBookTitle(booktitle.getText());
                userrequest.setMemberName(Authentification.PERSONNECONNECTEE.getNom());
                userrequest.setMemberLastName(Authentification.PERSONNECONNECTEE.getPrenom());
                userrequest.setMemberMobile(Integer.parseInt(membermobile.getText()));
                userrequest.setMemberMail(Authentification.PERSONNECONNECTEE.getEmail());
                userrequest.setIssuePeriod(Integer.parseInt(issueperiod.getText()));
                
                
               SMSAPI sms = new SMSAPI("Hey i want to isse  "+booktitle.getText()+"  please  ", "+21623181323");
                
                
                ////////////////////////////// DATE TO STRING CONVERSION ///////////////////  
                date = picker.getDate();
                //sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                //sdf = new SimpleDateFormat("EEE-MMM-dd-HH:mm:ss-z-yyyy");
                sdf = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat dateFormat = sdf;
                strDate = dateFormat.format(date);
                userrequest.setIssueDate(strDate);
                ////////////////////////////////////////////////////////////////////////////                
                sr.addUserRequest(userrequest);     
                System.out.println("send UserRequest (Form) : Succes");
                HomeFormBook hf;
                try {
                    hf = new HomeFormBook();
                    hf.getF().show();
                } catch (IOException ex) {
                }
            } else {
                Dialog.show("Attention", "Veuillez remplir tous les champs", "Ok", null);
            }

            ////////////////////////////// STRING TO DATE CONVERSION ///////////////////
            /*    try {
                    finalDate=new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2019");  
                    System.out.println("date apres formattage : "+finalDate);
                                    } catch (ParseException ex) {
                }*/
            //   mydate = strDate.substring(0,3)+"-"+strDate.substring(4,7)+"-"+strDate.subSequence(30,34);                 
            //   System.out.println("nouveau date  : "+mydate);
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        });
        Reset.addActionListener((evt) -> {
            UserRequestForm urf = new UserRequestForm();
            booktitle.clear();
            membermobile.clear();
            issueperiod.clear();
            //descRec.clearClientProperties();
            urf.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
