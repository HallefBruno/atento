
package com.olhonoponto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author halle
 */
@Controller("/")
public class IndexController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView pageIndex() {
        return new ModelAndView("Index");
    }
    
}
