package graalvm.x.python;

import org.graalvm.polyglot.HostAccess;

/**
 * @author zengxijin created on 2019-11-26
 */
public class JavaBean {

    private String name;

    public JavaBean(String name) {
        this.name = name;
    }

    /**
     * host语言导出可供gust语言访问的方法
     * @return String
     */
    @HostAccess.Export
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
