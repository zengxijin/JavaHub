package org.jackzeng.script.engine;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * @author xijin.zeng created on 2019/5/5
 */
public class EngineCheck {

    public static void main(String[] args) {
        builtinCheck();
    }

    /**
     * add jython-standalone to support python running env
     */
    public static void builtinCheck() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = mgr.getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            System.out.println("ScriptEngineFactory Info");
            String engName = factory.getEngineName();
            String engVersion = factory.getEngineVersion();
            String langName = factory.getLanguageName();
            String langVersion = factory.getLanguageVersion();
            System.out.printf("\tScript Engine: %s (%s)\n", engName, engVersion);
            List<String> engNames = factory.getNames();
            for (String name : engNames) {
                System.out.printf("\tEngine Alias: %s\n", name);
            }
            System.out.printf("\tLanguage: %s (%s)\n", langName, langVersion);
        }
    }

}
