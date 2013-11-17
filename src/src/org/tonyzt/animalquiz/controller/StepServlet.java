package org.tonyzt.animalquiz.controller;


import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.tonyzt.animalquiz.model.IAnimalQuiz;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class StepServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(StepServlet.class.getName());
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
        log.info("started");


        resp.setContentType("text/html");

        UserService userService = UserServiceFactory.getUserService();
        String thisURL = req.getRequestURI();

        if (req.getUserPrincipal()==null) {
            resp.getWriter().println("<p>Please <a href=\"" +
                    userService.createLoginURL(thisURL) +
                    "\">sign in</a>.</p>");
        } else {
            resp.getWriter().write(req.getUserPrincipal().getName());
        }

        IAnimalQuiz animalQuiz =  (IAnimalQuiz) req.getSession().getAttribute("animalQuizInstance");
        Dispatcher.getInstance().doAction(req,resp,animalQuiz);
	}
}


