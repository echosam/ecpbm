package com.ecpbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecpbm.pojo.Type;
import com.ecpbm.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/getType/{flag}")
	@ResponseBody
	public List<Type> getType(@PathVariable("flag") Integer flag) {
		List<Type> typeList = typeService.getAll();
		if (flag == 1) {
			Type t = new Type();
			t.setId(0);
			t.setName("请选择...");
			typeList.add(0, t);
		}
		return typeList;
	}
	
}
