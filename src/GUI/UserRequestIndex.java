/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import Entities.User;
import Entities.UserRequest;
import static GUI.Authentification.tpassword;
import static GUI.Authentification.tusername;
import Services.ServiceUserRequest;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author LENOVO
 */
public class UserRequestIndex {

    Form f;

    SpanLabel memberid;
    SpanLabel bookid;
    SpanLabel booktitle;
    SpanLabel membername;
    SpanLabel memberlastname;
    SpanLabel membermobile;
    SpanLabel membermail;
    SpanLabel issuedate;
    SpanLabel issueperiod;
    SpanLabel myspan;
    SpanLabel myspan2;

    Label lbbooktitle;
    Label lbissuedate;
    Label lbissueperiod;
    //Container c = new Container (BoxLayout.x());
    public UserRequestIndex() {
        f = new Form("Your Requests",new BoxLayout(BoxLayout.Y_AXIS));
           f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            HomeFormBook a;
            try {
                a = new HomeFormBook();
                            a.getF().show();
            } catch (IOException ex) {
            }

//            tusername.clear();
 //           tpassword.clear();
        });
        ServiceUserRequest ser = new ServiceUserRequest();
        ArrayList<UserRequest> al = new ArrayList<UserRequest>();
        al = ser.getList();
/*
        for (UserRequest r : al) {
            Container c0 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            lbbooktitle = new Label("book title : ");
            lbissuedate = new Label("issue date : ");
            lbissueperiod = new Label("issue period : ");

            myspan = new SpanLabel("" + "***  Book Request  ****");
            memberid = new SpanLabel("" + r.getMemberId());
            bookid = new SpanLabel("" + r.getBookId());
            booktitle = new SpanLabel("" + r.getBookTitle());
            membername = new SpanLabel("" + r.getMemberName());
            memberlastname = new SpanLabel("" + r.getMemberLastName());
            membermobile = new SpanLabel("" + r.getMemberMobile());
            membermail = new SpanLabel("" + r.getMemberMail());
            issuedate = new SpanLabel("" + r.getIssueDate());
            issueperiod = new SpanLabel("" + r.getIssuePeriod());
            myspan2 = new SpanLabel("" + "******************");
            c0.add(myspan);
            c1.addAll(lbbooktitle, booktitle);
            c2.addAll(lbissuedate, issuedate);
            c3.addAll(lbissueperiod, issueperiod);
            c4.add(myspan2);
            f.add(c0);
            f.add(c1);
            f.add(c2);
            f.add(c3);
            f.add(c4);


        }*/

 for (UserRequest ur : al){
     if (ur.getMemberId() == Authentification.PERSONNECONNECTEE.getId()) {
         String str = Integer.toString(ur.getIssuePeriod());
         f.add(ComponentGroup.enclose(new Label("Book Title :" + ur.getBookTitle()), new Label("Issue Date : " + ur.getIssueDate()),
                 new Label("Issue Period :" + ur.getIssuePeriod()), new Label("RESPONSE  : " + ur.getRequestState())));
         Button b = new Button("Delete");
         f.add(b);
         b.addActionListener((e) -> {
               ServiceUserRequest sr = new ServiceUserRequest();
               ser.deleteUserRequest(ur.getIdRequest());
                HomeFormBook hf;
             try {
                 hf = new HomeFormBook();
                 hf.getF().show();
             } catch (IOException ex) {
             }
              
         });
     }
    }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
