/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author emna
 */
public class DetaillersForm {
     Form detailleForm = new Form("Detailles", BoxLayout.y());
   
   // Button btnValider = new Button("Add to my Basket");
      

  public  DetaillersForm (){
     
         
               //detailleForm.add(btnValider);
          //btnValider.addActionListener((e) -> {
            // Dialog.show("confirm", "product added succefully", "OK", "Cancel");
      
    // });
          
         
          
          detailleForm.getToolbar().addCommandToRightBar("back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           CatalogueEcommerceForm  catalogueForm=new CatalogueEcommerceForm();
          catalogueForm.getCatalogueForm().showBack();
            }
        }); 

         
          
          }
    public Form getDetailleForm() {
        return detailleForm;
    }
  
}