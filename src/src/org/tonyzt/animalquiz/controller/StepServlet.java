package org.tonyzt.animalquiz.controller;


import org.tonyzt.animalquiz.model.IAnimalQuiz;


//import com.google.appengine.api.datastore.DatastoreService;
//import com.google.appengine.api.datastore.DatastoreServiceFactory;
//import com.google.appengine.api.datastore.Entity;
//import com.google.appengine.api.datastore.Key;
//import com.google.appengine.api.datastore.KeyFactory;
//import com.google.appengine.api.users.User;
//import com.google.appengine.api.users.UserService;
//import com.google.appengine.api.users.UserServiceFactory;


import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class StepServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(StepServlet.class.getName());
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
        log.info("started");
        resp.setContentType("text/html");
        IAnimalQuiz animalQuiz =  (IAnimalQuiz) req.getSession().getAttribute("animalQuizInstance");
        Dispatcher.getInstance().doAction(req,resp,animalQuiz);
	}
}


