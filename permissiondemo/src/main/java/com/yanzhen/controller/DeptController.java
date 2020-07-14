package com.yanzhen.controller;

import com.yanzhen.pojo.Dept;
import com.yanzhen.service.IDeptService;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private IDeptService deptService;

    /**
     * 查询所有部门信息
     */
    @RequestMapping("dept/deptAll")
    @ResponseBody
    public JsonObject queryDeptAll(){
        List<Dept> list = deptService.queryDeptAll();
        //创建返回值对象信息
        JsonObject object = new JsonObject();
        object.setCode(0);
        object.setMsg("ok");
        object.setCount((long)list.size());
        object.setData(list);
        return object;
    }

    //添加部门信息(提交)
    @RequestMapping("dept/addDeptSubmit")
    @ResponseBody
    public R addDept(Dept dept){
        //创建记录时间
        dept.setCreateTime(new Date());
        deptService.addDept(dept);
        return R.ok();
    }

    /**
     * 页面的渲染使用
     * 当我访问dept,就会去pages/dept页面,然后前端会向指定url请求数据,然后完成填充
     */
    @RequestMapping("dept")
    public String deptIndex(){
        return "pages/dept";
    }

    @RequestMapping("addDept")
    public String addDept(Integer type, Integer parentId, Model model){
        //0公司添加1部门,1部门添加2科室/小组
        model.addAttribute("type",type+1);
        model.addAttribute("parentId",parentId);

        return "pages/addDept";
    }

}
