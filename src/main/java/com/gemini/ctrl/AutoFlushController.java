package com.gemini.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 定义直接渲染的路径接口, 就毋须在Ctrl中为每一url定义个资源
 * @author KingDom
 */

@Controller
public class AutoFlushController {

    private static final String PREFIX = "front";
    private static final String DEFAULT_FRONT_TYPE = "404";
    private static final String PATH_SEP = "/";
    private static final String PAGE_PREFIX = "index";

    @RequestMapping("/front/{frontType}/index")
    public ModelAndView jspMapping(HttpServletRequest request,
            @PathVariable("frontType") String frontType, ModelMap modelmap,
            @RequestParam(value = "message", required = false) String message) {
        String viewName = this.getViewName(frontType);
        modelmap.put("message", message);
        ModelAndView view = new ModelAndView();
        view.setViewName(viewName);
        return view;
    }

    private String getViewName(String frontType) {
        String ft = StringUtils.isEmpty(frontType) ? DEFAULT_FRONT_TYPE
                : frontType;
        StringBuffer sb = new StringBuffer();
        sb.append(PREFIX);
        sb.append(PATH_SEP);
        sb.append(ft);
        sb.append(PATH_SEP);
        sb.append(PAGE_PREFIX);
        return sb.toString();
    }
}
