package ui.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.DierDB;
import domain.model.Dier;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private DierDB db = new DierDB();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = "home";
        // in web.xml: welcome-file = Controller zonder parameter, dus command == null
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overview":
                destination = overview(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        Dier meestHongerigeDier = db.getMeestHongerigeDier();
        request.setAttribute("meestHongerige", meestHongerigeDier);
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("dieren", db.getAlle());
        return "overview.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        // lijst klaarzetten om foutboodschappen op te slaan
        ArrayList<String> errors = new ArrayList<String>();

        // leeg object aanmaken
        Dier dier = new Dier();
        // parameters één voor één toevoegen aan object
        // eventuele fouten wegschrijven naar errors
        setNaam(dier, request, errors);
        setSoort(dier, request, errors);
        setVoedsel(dier, request, errors);

        if (errors.size() == 0) {
            // parameters zijn foutloos toegevoegd aan Dier-object
            try {
                db.voegToe(dier);
                return overview(request, response);
            } catch (IllegalArgumentException exc) {
                // er liep iets fout bij voegToe, boodschap wordt opgevangen en toegevoegd aanlijst
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "add.jsp";
 	    }

    /**
     * Leest naam uit gegeven request-object en kent die toe aan gegeven dier-object
     * Vangt fouten van setter op en schrijft die weg naar gegeven errors-object
     * @param dier: moet meegegeven worden als parameter want is lokale veranderlijke in methode processRequest()
     * @param request: bevat invoer van formulier
     * @param errors: lijst waar fouten naar geschreven kunnen worden; moet meegegeven
     *              worden als parameter want is lokale veranderlijke in methode processRequest()
     */
    private void setNaam(Dier dier, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("naam");
        try {
            dier.setNaam(naam);
            // bewaar (correcte) gebruikersinvoer in request-object zodat het eventueel opgeroepen kan worden in add.jsp
            request.setAttribute("naamPreviousValue", naam);
        } catch (IllegalArgumentException exc) {
            // setNaam() wierp een fout op
            errors.add(exc.getMessage());
        }
    }

    private void setSoort(Dier dier, HttpServletRequest request, ArrayList<String> errors) {
        String soort = request.getParameter("soort");
        try {
            dier.setSoort(soort);
            request.setAttribute("soortPreviousValue", soort);
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setVoedsel(Dier dier, HttpServletRequest request, ArrayList<String> errors) {
        String voedsel = request.getParameter("voedsel");
        try {
            dier.setVoedsel(Integer.parseInt(voedsel));
            request.setAttribute("voedselPreviousValue", voedsel);
        } catch (NumberFormatException exc) {
            errors.add("Vul een nummer in voor voedsel.");
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

}
