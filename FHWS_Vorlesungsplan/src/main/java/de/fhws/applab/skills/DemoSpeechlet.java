package de.fhws.applab.skills;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.SsmlOutputSpeech;

import de.fhws.applab.skills.DataStructure.Event;
import de.fhws.applab.skills.Http.HttpHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by braunpet on 02.06.17.
 */
public class DemoSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(DemoSpeechlet.class);

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
            System.out.println("Launch");
        return responseAsk("Möchtest du eine Einführung?");
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {

            log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                    session.getSessionId());

            Intent intent = request.getIntent();
            String intentName = (intent != null) ? intent.getName() : "keiner-vergeben";

        switch(intentName)
        {
            case "GetIntroduction":
                return getIntroduction();
            case "GetEventsToday":
                return getEventsTodayResponse();
            case "GetLectureDescription":
                return getLectureDescription(intent.getSlot("vorlesung").getValue());
            case "GetEventsTodayByLecturer":
                return getEventsTodayByLecturerResponse(intent.getSlot("dozent").getValue());
            case "GetEventsTodayByProgram":
                return getEventsByDateAndProgram(intent.getSlot("program").getValue());
            default:
                return responseAsk("Bitte wiederholen");
        }

    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
    }

    private SpeechletResponse responseAsk(String answer) {

        String theAnswer = "<speak>" + answer + "</speak>";

        SsmlOutputSpeech speech = new SsmlOutputSpeech();
        speech.setSsml(theAnswer);

        SsmlOutputSpeech repromtText = new SsmlOutputSpeech();
        repromtText.setSsml("<speak>Please wait.</speak>");

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromtText);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }

    private static SpeechletResponse response(String answer) {

        String theAnswer = "<speak>" + answer + "</speak>";

        SsmlOutputSpeech speech = new SsmlOutputSpeech();
        speech.setSsml(theAnswer);

        SsmlOutputSpeech repromtText = new SsmlOutputSpeech();
        repromtText.setSsml("<speak>Please wait.</speak>");

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromtText);

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

    private SpeechletResponse getIntroduction() {
        return response("Wenn du die heutigen Vorlesungen hören möchtest, sag 'Vorlesungen heute'." +
                "Wenn du die heutigen Vorlesungen bei einem bestimmten Dozenten hören möchtest, sag" +
                "'Welche Vorlesungen finden heute bei Dozentname statt.");
    }

    private SpeechletResponse getEventsTodayResponse() {
        String speechText = new String();
        Date date = DateTime.now().toDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = simpleDateFormat.format(date);

        dateString = "27.06.2017";
        RequestHandler rh = new RequestHandler();
        for (Event e : rh.requestEventListByDate(dateString)) {
            speechText += e.getName() + " " + e.getRoomsView().get(0).getRoom() + " ";
        }

        return response(speechText.replace('&', 'u'));
    }

    private SpeechletResponse getLectureDescription(String lecture) {
        String speechText = Constants.map.get(lecture);

        return response(speechText);
    }

    private SpeechletResponse getEventsTodayByLecturerResponse(String dozent) {
        System.out.println(dozent);
        String speechText = new String();
        Date date = DateTime.now().toDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = simpleDateFormat.format(date);

        dateString = "27.06.2017";
        RequestHandler rh = new RequestHandler();
        for (Event e : rh.requestEventListByDateAndLecturer(dateString, dozent)) {
            speechText += e.getName() + " ";
        }

        return response(speechText.replace('&', 'u'));
    }

    private SpeechletResponse getEventsByDateAndProgram(String program) {
        System.out.println(program);
        String speechText = new String();
        Date date = DateTime.now().toDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = simpleDateFormat.format(date);

        dateString = "27.06.2017";
        RequestHandler rh = new RequestHandler();
        for (Event e : rh.requestEventListByDateAndProgram(dateString, program)) {
            speechText += e.getName() + " ";
        }

        return response(speechText.replace('&', 'u'));
    }

}
