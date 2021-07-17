package com.ivy.controller.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WfxExceptionHandler
 *
 * @Author: ivy
 * @CreateTime: 2021-07-17
 */
public class WfxExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/500.jsp");
        return mv;
    }
}
