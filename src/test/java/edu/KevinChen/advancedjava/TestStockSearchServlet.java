package edu.KevinChen.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.

public class AppTest 
    extends TestCase
{
    MyServlet servlet = new MyServlet();
    HttpServletRequest mockRequest = mock(HttpServletRequest.class);
    HttpServletResponse mockResponse = mock(HttpServletResponse.class);

    StringWriter out = new StringWriter();
    PrintWriter printOut = new PrintWriter(out);
    when(mockResponse.getWriter()).thenReturn(printOut);

StockSearchServlet.doGet(mockRequest, mockResponse);

    verify(mockResponse).setStatus(200);
    assertEquals("my content", out.toString());
}

 */
