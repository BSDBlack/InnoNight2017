package de.fhws.applab.skills;

import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import de.fhws.applab.skills.dataStructure.VPSessionBean;

import javax.servlet.Servlet;
import javax.servlet.ServletResponse;

/**
 * Created by Sebastian Kreuzer on 6/24/17.
 */
public class FHWS_VorlesungsplanAPI {
    public static SpeechletResponse doLaunch(LaunchRequest request, Session session)
    {
        VPSessionBean vpSessionBean = new VPSessionBean();
        SpeechletResponse speechletResponse = null;
        vpSessionBean.setUserId(session.getUser().getUserId());
        return speechletResponse;
    }

}
