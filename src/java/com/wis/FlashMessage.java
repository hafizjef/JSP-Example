package com.wis;

import javax.servlet.http.HttpSession;

public final class FlashMessage {
    
    public static void createAlertMessage(HttpSession session, String messageKey, String caption) {
        session.setAttribute("alertMessage", messageKey);
        session.setAttribute("alertCaption", caption);
    }

    public static void createInfoMessage(HttpSession session, String messageKey, String caption) {
        session.setAttribute("infoMessage", messageKey);
        session.setAttribute("infoCaption", caption);        
    }

    public static void createWarnMessage(HttpSession session, String messageKey, String caption) {
        session.setAttribute("warnMessage", messageKey);
        session.setAttribute("warnCaption", caption);
    }

    public static void createSuccessMessage(HttpSession session, String messageKey, String caption) {
        session.setAttribute("successMessage", messageKey);
        session.setAttribute("successCaption", caption);
    }
}
