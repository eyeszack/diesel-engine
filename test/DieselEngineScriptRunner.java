import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;
import java.io.File;
import java.io.IOException;

public class DieselEngineScriptRunner {
    
    private GroovyShell shell;
    
    public DieselEngineScriptRunner() {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.setScriptBaseClass("me.dslengine.DSLEngineScript");
        shell = new GroovyShell(configuration);
    }
    
    public Object evaluateScript(File script) throws IOException {
        return shell.evaluate(script);
    }
    
    public Object evaluateScript(String script) {
        return shell.evaluate(script);
    }
    
    public static void main(String[] args) {
        try {
            DieselEngineScriptRunner runner = new DieselEngineScriptRunner();
            runner.evaluateScript(new File(args[0]));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}