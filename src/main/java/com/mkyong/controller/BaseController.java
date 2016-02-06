package com.mkyong.controller;

import beans.ClientBean;
import beans.FormBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory.ClientFactory;
import factory.FormFactory;
import factory.impl.ClientFactoryImpl;
import factory.impl.FormFactoryImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class BaseController {

    private static final String FAIL_JSON = "{\"result:\" = \"FAIL\"}";
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	//@Autowired
    private ClientFactory clientFactory = new ClientFactoryImpl();
    private FormFactory formFactory = new FormFactoryImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter sdada : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/getClient", method = RequestMethod.GET)
    public
    @ResponseBody
    String getClient() {
        ClientBean clientBean = clientFactory.createClientBean();
        return convert(clientBean);
    }

    @RequestMapping(value = "/getForm", method = RequestMethod.GET)
    public
    @ResponseBody
    String getForm() {
        FormBean formBean = formFactory.createFormBean();
        return convert(formBean);
    }

    private String convert(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return FAIL_JSON;
        }
    }

}