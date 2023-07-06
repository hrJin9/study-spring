package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV4 {
    /**
     * @param paraMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paraMap, Map<String, Object> model);
}
