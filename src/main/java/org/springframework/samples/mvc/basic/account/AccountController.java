package org.springframework.samples.mvc.basic.account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();

    /**
     * 简述如何返回参数给前台，以及前台如何获取参数
     */
    @RequestMapping(value={"getValue"})
    public String getValue(Map<String,Object> map){
        map.put("value","value");   //此时前台使用${value}即可取值
        return "test";//返回逻辑视图
    }

    @RequestMapping(value={"getModeValue"})
    public String getModeValue(Model model){
        model.addAttribute("modelValue", "value");
        return "test";//返回逻辑视图
    }

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account()); //此时前台使用${account.name}获取account对应的name值
		return "account/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "account/createForm";
		}
		this.accounts.put(account.assignId(), account);
		return UrlBasedViewResolver.REDIRECT_URL_PREFIX+"/account/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(account);
		return "account/view";
	}


    @RequestMapping(value={"test1","test2"})//可以指定多个值，此时访问account/test1,account/test2是一样的
    public String test(){
        return "test";//返回逻辑视图
    }


    /**
     * 简述如何获取javax.servlet.http.HttpServletRequest、HttpServletResponse、HttpSession
     */
    @RequestMapping("/eat")
    public String eat(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        return "test";//返回逻辑视图
    }
}
