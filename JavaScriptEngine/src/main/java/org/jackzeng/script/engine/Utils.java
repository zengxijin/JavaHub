package org.jackzeng.script.engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author xijin.zeng created on 2019/5/5
 */
public final class Utils {

    private final static ScriptEngineManager MANAGER = new ScriptEngineManager();

    public static ScriptEngine getScriptEngine(String name) {
        switch (name.toLowerCase()) {
            case "js":
            case "javascript":
                return MANAGER.getEngineByName("javascript");
            case "py":
            case "python":
                return MANAGER.getEngineByName("python");
            default:
                return MANAGER.getEngineByName(name);

        }
    }

    public static ScriptEngineManager getManager() {
        return MANAGER;
    }

    public static ScriptEngine getPythonEngine() {
        return getScriptEngine("python");
    }

    public static ScriptEngine getJavaScriptEngine() {
        return getScriptEngine("javascript");
    }
}
