package com.origami.teach.servlet;


import service.StockService;
import service.StockServiceException;
import service.StockServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Example servlet from the apache tomcat distribution
 */
public class StockSearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request Information Example</h3>");
        out.println("Method: " + request.getMethod());
        out.println("Request URI: " + request.getRequestURI());
        out.println("Protocol: " + request.getProtocol());
        out.println("PathInfo: " + request.getPathInfo());
        out.println("Remote Address: " + request.getRemoteAddr());
        out.println("</body>");
        out.println("</html>");

        StockService stockService = StockServiceFactory.getInstance();

        // Retrieve the value of the query parameter "username" (from text field)
        String symbol = request.getParameter("symbol");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (symbol == null
                || (symbol = (symbol.trim())).length() == 0) {
            out.println("<p>Name: MISSING</p>");
        } else {
            out.println("<p>Symbol: " + symbol + "</p>");
        }



        // Retrieve the value of the query parameter "username" (from text field)
        String startDate = request.getParameter("startDate");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (startDate == null
                || (startDate = (startDate.trim())).length() == 0) {
            out.println("<p>Start date: MISSING</p>");
        } else {
            out.println("<p>/Start date: " + startDate + "</p>");
        }

        Calendar start = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            start.setTime(sdf.parse(startDate));// all done
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Retrieve the value of the query parameter "username" (from text field)
        String endDate = request.getParameter("enddate");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (endDate == null
                || (endDate = (endDate.trim())).length() == 0) {
            out.println("<p>End date: MISSING</p>");
        } else {
            out.println("<p>/End date: " + startDate + "</p>");
        }

        Calendar end = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            end.setTime(sdf2.parse(endDate));// all done
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // Retrieve the value of the query parameter "username" (from text field)
        String interval = request.getParameter("intervalenum");
        // Get null if the parameter is missing from query string.
        // Get empty string or string of white spaces if user did not fill in
        if (interval == null
                || (interval = (interval.trim())).length() == 0) {
            out.println("<p>Interval Enum: MISSING</p>");
        } else {
            out.println("<p>/Interval Enum: " + startDate + "</p>");
        }

        try {
            stockService.getQuote(symbol, start, end);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

    }

    /**
     * We are going to perform the same operations for POST requests
     * as for GET methods, so this method just sends the request to
     * the doGet method.
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}