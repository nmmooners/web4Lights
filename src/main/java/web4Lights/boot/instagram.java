package web4Lights.boot;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/*access tokent ==== 177830241.fe4392b.ed8aa35d53154a4f81b22f1e3987379f */

//auth token for all info ====== 1704da8096ac4b8185d81427f41ed520
public class instagram{

    private String firstGot;
    private JSONObject gotJson;


    //public String getID =

    public void printJSON(JSONObject obj)
    {
        for(Object key : obj.keySet())
        {
            String keyName = (String)key;
            Object value = obj.get(keyName);
            System.out.println("key: " + keyName + " Value: " + value);

            if(value instanceof JSONObject)
            {
                printJSON((JSONObject)value);
            }
        }
    }

    public instagram() {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://api.instagram.com/v1/tags/search?q=snowy&access_token=177830241.fe4392b.ed8aa35d53154a4f81b22f1e3987379f" );
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET" );
            BufferedReader rd = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            firstGot = line;
            Gson gson = new Gson();
            JSONObject convert = gson.fromJson(line, JSONObject.class);
            gotJson = convert;

            printJSON(convert);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }


    }












}











/*

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            processRequest(req, resp);
        }

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            HttpSession session = request.getSession(true);
            String clientID =(String)session.getAttribute("client_id");
            String clientSecret =(String)session.getAttribute("client_secret");
            String redirectURI =(String)session.getAttribute("redirect_uri");
            String code = request.getParameter("code");


            JSONObject profile = getTokenContent(clientID, clientSecret, redirectURI, code);
        }

        public JSONObject getTokenContent(String clientID, String clientSecret, String redirectURI, String code){
            try {

                String httpurl = "https://api.instagram.com/oauth/access_token?"
                        + "client_id=" + clientID
                        + "&client_secret=" + clientSecret
                        + "&grant_type=authorization_code"
                        + "&redirect_uri=" + redirectURI
                        + "&code="+code;


                URL url;
                HttpURLConnection conn;
                try
                {
                    url = new URL(httpurl);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("charset", "utf-8");
                    conn.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

                    conn.setDoOutput(true);


                    DataOutputStream wr = new DataOutputStream(conn.getOutputStream ());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();

                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));

                    return getJSONFromBufferRd(in);
                }
                catch(MalformedURLException mf)
                {
                    mf.getStackTrace();
                }
                catch(IOException ioMessed)
                {
                    ioMessed.getStackTrace();
                }

                String urlParameters = "client_id=" + clientID
                        + "&client_secret=" + clientSecret
                        + "&grant_type=authorization_code"
                        + "&redirect_uri=" + redirectURI
                        + "&code="+code;


            }
        }





*/


