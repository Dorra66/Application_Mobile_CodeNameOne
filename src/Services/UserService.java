/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class UserService {
    
    User gUser = new User();

    public User parseUserJson(String json) {
        User u = null;
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
            if (!user.isEmpty()) {
                u = new User();
                List<String> rolesUser = new ArrayList();
                float id = Float.parseFloat(user.get("id").toString());
                u.setId((int) id);
                List<String> roles = (List<String>) user.get("roles");
                for (String role : roles) {
                    rolesUser.add(role);
                }
                u.setRoles(rolesUser);
                u.setUsername(user.get("username").toString());
                u.setEmail(user.get("email").toString());
                u.setEnabled(Boolean.parseBoolean(user.get("enabled").toString()));
                if (user.get("nom") != null) {
                    String nom = (user.get("nom").toString());
                    u.setNom(nom);
                }
                u.setPrenom(user.get("prenom").toString());
//                u.setCin(Integer.parseInt(user.get("cin").toString()));
            }
        } catch (IOException ex) {

        }
        return u;

    }
    
    public User login(String username, String password) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/CiteCulture/web/app_dev.php/museum/login?username=" + username + "&password=" + password);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                UserService ser = new UserService();
                gUser = ser.parseUserJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return gUser;
    }


    
}
