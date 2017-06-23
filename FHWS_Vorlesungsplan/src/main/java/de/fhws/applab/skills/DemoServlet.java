package de.fhws.applab.skills;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by braunpet on 02.06.17.
 */
@WebServlet( name = "Speechlet", urlPatterns = { "/service" })
public class DemoServlet extends SpeechletServlet
{
	public DemoServlet( )
	{
		this.setSpeechlet( new DemoSpeechlet() );
	}
}
