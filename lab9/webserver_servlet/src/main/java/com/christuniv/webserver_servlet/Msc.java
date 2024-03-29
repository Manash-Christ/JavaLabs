/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.christuniv.webserver_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author lenovo
 */
public class Msc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String s1=request.getParameter("str1");
        String s2=request.getParameter("str2");
        boolean anagarm=checkAnagram(s1,s2);
        PrintWriter out=response.getWriter();
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Checking the Anagaram</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>String s1:"+s1+"</p>");
            out.println("<p>String s2:"+s2+"</p>");
            out.println("<p>Result:"+(anagarm?"Yes":"No")+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    public boolean checkAnagram(String s1,String s2)
    {
        if(s1==null|s2==null)
        {
            return false;
        }
        s1=s1.replaceAll("\\s", "").toLowerCase();
        s2=s2.replaceAll("\\s", "").toLowerCase();
        s1=sortString(s1);
        s2=sortString(s2);
        return s1.equals(s2);
    }
    public String sortString(String str)
    {
        char[]charArray=str.toCharArray();
        for(int i=0;i<charArray.length-1;i++)
        {
            for(int j=0;j<charArray.length-i-1;j++)
            {
                if(charArray[j]>charArray[j+1])
                {
                    charArray[j]^=charArray[j+1];
                    charArray[j+1]^=charArray[j];
                    charArray[j]^=charArray[j+1];
                }
            }
        }
        return new String(charArray);
    }

}