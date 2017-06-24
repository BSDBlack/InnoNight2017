package de.fhws.applab.skills;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.SsmlOutputSpeech;

import de.fhws.applab.skills.DataStructure.Event;
import de.fhws.applab.skills.Http.HttpHandler;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by braunpet on 02.06.17.
 */
public class DemoSpeechlet implements Speechlet
{
	private static final Logger log = LoggerFactory.getLogger(DemoSpeechlet.class);

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
		/*throws SpeechletException {

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		System.out.println("Intent: " + intentName );

		SpeechletResponse theResponse = response("Hello");

		return theResponse;*/
			throws SpeechletException {
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
				session.getSessionId());

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		if ("GetEventsToday".equals(intentName)) {
			return getEventsTodayResponse();
		} else {
			throw new SpeechletException("Invalid Intent");
		}
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session)
		throws SpeechletException {
	}

	private static SpeechletResponse response(String answer) {

		String theAnswer = "<speak>" + answer + "</speak>";

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

	private SpeechletResponse getEventsTodayResponse() {
		String speechText = new String();

		RequestHandler rh = new RequestHandler();
		for (Event e: rh.requestEventListByDate("24.06.2017")
		) {
			speechText += e.getName() +" " + e.getRoomsView().get(0).getRoom() + " ";
		}


		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle("HelloWorld");
		card.setContent(speechText);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		// Create reprompt
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(speech);

		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

}
