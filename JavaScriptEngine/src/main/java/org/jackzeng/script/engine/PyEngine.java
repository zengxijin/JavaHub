package org.jackzeng.script.engine;

import javax.script.*;

import static javax.script.ScriptContext.ENGINE_SCOPE;
import static javax.script.ScriptContext.GLOBAL_SCOPE;

/**
 * @author xijin.zeng created on 2019/5/5
 */
public class PyEngine {
    // quick test
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = Utils.getManager();

        // (1) simple
        ScriptEngine engine = Utils.getPythonEngine();
        engine.put("a", 42);
        engine.eval("print a");

        // (2) CompiledScript and Invocable
        Compilable compilableEngine = (Compilable)engine;
        // explicit return key word to return value
        String script = "def f(a,b):return a+b";

        // need to compiled(x) and eval() first
        // then to use Invocable to invoke function
        CompiledScript compiledFunc= compilableEngine.compile(script);
        compiledFunc.eval();
        Invocable invocableFunc = (Invocable)compiledFunc.getEngine();
        Integer val = (Integer)invocableFunc.invokeFunction("f", 1, 2);
        System.out.println(val);

        // (3) three-way to set params values
        String testStr = "print x\n" +
                "print y\n" +
                "print z\n";

        manager.put("x", "1");
        engine.put("y", "2");
        engine.put("z", "3");
        engine.eval(testStr);

        Bindings bindings = engine.createBindings();
        bindings.put("x", "11");
        bindings.put("y", "22");
        bindings.put("z", "33");
        engine.eval(testStr, bindings);

        ScriptContext ctx = new SimpleScriptContext();
        Bindings ctxGlobalBindings = engine.createBindings();
        ctx.setBindings(ctxGlobalBindings, GLOBAL_SCOPE);
        ctx.setAttribute("x", "111", GLOBAL_SCOPE);
        ctx.setAttribute("y", "222", ENGINE_SCOPE);
        ctx.setAttribute("z", "333", ENGINE_SCOPE);
        engine.eval(testStr, ctx);

        engine.eval(testStr);

    }
}
