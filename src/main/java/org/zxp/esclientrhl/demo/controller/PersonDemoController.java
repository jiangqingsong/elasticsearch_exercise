package org.zxp.esclientrhl.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zxp.esclientrhl.demo.domain.test.Person;
import org.zxp.esclientrhl.demo.repository.PersonDemoRepository;

/**
 * @program: esclientrhlDemo
 * @description:
 * @author: X-Pacific zhang
 * @create: 2021-03-10 15:56
 **/
@RestController
@RequestMapping("/person")
public class PersonDemoController {
    @Autowired
    private PersonDemoRepository personDemoRepository;
    //http://127.0.0.1:8888/demo/add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody String param) throws Exception {
        JSONObject object = JSON.parseObject(param);
        String name = object.getString("name");
        Long id = object.getLong("id");
        Integer gender = object.getInteger("gender");
        Integer age = object.getInteger("age");
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setGender(gender);
        person.setAge(age);
        personDemoRepository.save(person);
        return "新增成功\n" + person.toString();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public String search(@RequestParam String id) throws Exception {

        return personDemoRepository.getById(Long.valueOf(id)).toString();
    }
}
