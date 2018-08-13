import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ScriptException, IOException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        try {
            engine.eval(new FileReader("src/script.js"));

            Invocable invocable = (Invocable) engine;

            Object result = invocable.invokeFunction("getMessage", "World!");

            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
