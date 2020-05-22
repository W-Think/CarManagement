package com.wthink.car_producer2.config;

import com.wthink.car_producer2.pojo.TbCarUser;
import com.wthink.car_producer2.utils.StaticFlag;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @描述:登录拦截器
 * @作者:wangshuai
 * @时间:2020/5/13 19:39
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入方法之前");
        /*从 session获取user的信息， 如果有user的信息，则认为他是已经登陆过的，
        如果没有user的数据，则认为他是非法访问，
        让他回登陆页面*/
        try {
            HttpSession session = request.getSession();
            TbCarUser tbCarUser = (TbCarUser) session.getAttribute(StaticFlag.USERINFO);
            if(null == tbCarUser){
                response.sendRedirect("/");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入方法处理业务之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(">>>LoginIncerceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
