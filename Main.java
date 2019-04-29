
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diksha
 */
@WebServlet(urlPatterns = {"/Main"})
public class Main extends HttpServlet implements javax.servlet.Servlet {

    String response_string;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
                String usercode = request.getParameter("usercode");
            
                String result_string = "Authentication is successful!", error_string;
                
                if(valid(username, password, usercode)){
                    DBHelper dBHelper = new DBHelper();
                    if(dBHelper.validAuthentication(username, password, usercode)){
                        
                        result_string =  result_string+" for user "+username;
                    }
                    else{
                    result_string =  "Authentication failed for user "+username;
                    }    
                }else{
                    
                }
                response_string = "<h1 align=\"center\"> <b>Authentication</b> </h1>\n"+    
                "<h4 align=\"center\">" + result_string + "</h4>\n";
                showResult(response);
              
	}
    
    public void showResult(HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>\n" +
            "<head><title> Result </title></head>\n" +
            "<body bgcolor=\"#fff5e6\">\n" +response_string+
             "</body></html>");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private boolean valid(String username, String password, String usercode) {
        boolean isValid = false;
        
        if(!username.isEmpty() && !username.isEmpty() && !username.isEmpty() ){
            isValid = true;
        }
        return isValid;
    }
}

