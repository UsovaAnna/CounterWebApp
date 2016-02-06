package ru.academ_it_school.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.academ_it_school.beans.ClientBean;
import ru.academ_it_school.beans.FormBean;
import ru.academ_it_school.factory.ClientFactory;
import ru.academ_it_school.factory.FormFactory;
import ru.academ_it_school.factory.impl.ClientFactoryImpl;
import ru.academ_it_school.factory.impl.FormFactoryImpl;

@Controller
@RequestMapping("/api")
public class ApiController {

    private static final String FAIL_JSON = "{\"result:\" = \"FAIL\"}";
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";

	//@Autowired
    private ClientFactory clientFactory = new ClientFactoryImpl();
    private FormFactory formFactory = new FormFactoryImpl();

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