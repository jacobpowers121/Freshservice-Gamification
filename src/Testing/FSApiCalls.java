package Testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Base64;

public class FSApiCalls {

    public static void main(String[] args) {
        try {
            getHttpResponse("http://msoe.freshservice.com/helpdesk/tickets/38816", "powersjd@msoe.edu", "20050649");
        }catch(Exception e){

        }
    }

    public static String getHttpResponse(String address, String username, String password) throws Exception {
        URL url = new URL(address);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(30000); // 30 seconds time out

        if (username != null && password != null){
            String user_pass = username + ":" + password;
            String encoded = Base64.encodeBase64String(user_pass.getBytes());
            conn.setRequestProperty("Authorization", "Basic " + encoded);
        }

        String line = "";
        StringBuffer sb = new StringBuffer();
        BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()) );
        while((line = input.readLine()) != null)
            sb.append(line);
        input.close();
        return sb.toString();
    }
}
