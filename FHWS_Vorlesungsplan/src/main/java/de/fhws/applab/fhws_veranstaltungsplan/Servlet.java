package de.fhws.applab.fhws_veranstaltungsplan;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "FHWS_Veranstaltungsplan", urlPatterns = { "/test" } )
public class Servlet extends javax.servlet.http.HttpServlet
{
	@Override
	protected void doPost( javax.servlet.http.HttpServletRequest request,
		javax.servlet.http.HttpServletResponse response ) throws javax.servlet.ServletException, IOException
	{}

	@Override
	protected void doGet( javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response )
		throws javax.servlet.ServletException, IOException
	{
		response.getWriter( ).print( "Hello World" );
	}
}
