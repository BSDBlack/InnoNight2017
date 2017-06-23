package de.fhws.applab.skills;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;

import de.fhws.applab.skills.Http.HttpHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by braunpet on 02.06.17.
 */
public class DemoSpeechlet implements Speechlet
{

	@Override
	public void onSessionStarted(final SessionStartedRequest request, final Session session)
		throws SpeechletException
	{
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
		throws SpeechletException {
		System.out.println("Launch" );
		return response( "Herzlich Willkommen" );
	}

	@Override
	public SpeechletResponse onIntent(final IntentRequest request, final Session session)
		throws SpeechletException {

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		System.out.println("Intent: " + intentName );

		SpeechletResponse theResponse = response("Hello");

		return theResponse;
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session)
		throws SpeechletException {
	}

	private static SpeechletResponse response(String answer) {

		String theAnswer = "<tell>" + answer + "</tell>";

		SsmlOutputSpeech speech = new SsmlOutputSpeech();
		speech.setSsml(theAnswer);

		SsmlOutputSpeech repromtText = new SsmlOutputSpeech();
		repromtText.setSsml( "<speak>Please wait.</speak>" );

		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech( repromtText );

		return SpeechletResponse.newTellResponse(speech);
	}



	/**
	 * Creates a {@code SpeechletResponse} for the hello intent.
	 *
	 * @return SpeechletResponse spoken and visual response for the given intent
	 */
	private static SpeechletResponse responseFinal(String answer) {
		String theAnswer = "<speak>" + answer + "</speak>";

		SsmlOutputSpeech speech = new SsmlOutputSpeech();
		speech.setSsml(theAnswer);

		return SpeechletResponse.newTellResponse(speech);
	}

}
