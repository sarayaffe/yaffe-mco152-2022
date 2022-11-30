package dictionary.webapp;

import com.google.gson.Gson;
import dictionary.ScrabbleDictionary;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WordDefinitionServlet extends HttpServlet {

    private final Gson gson = new Gson();

    public WordDefinitionServlet(){

    }
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String word = request.getParameter("word");

        ScrabbleDictionary scrabbleDictionary = new ScrabbleDictionary();

        String definition = "no definition available";
        if(scrabbleDictionary.isWord(word)) {
            definition = scrabbleDictionary.getDefinition(word);
        }

        response.setContentType("text/json");
        response.getWriter().println(gson.toJson(definition));

    }
}
