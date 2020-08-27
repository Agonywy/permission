package com.yanzhen.controller;

import com.yanzhen.pojo.Dept;
import com.yanzhen.pojo.Node;
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
//    @ResponseBody注解表示该方法的返回的结果直接写入 HTTP 响应正文中,一般在异步获取数据时使用；
//    在使用@RequestMapping后,返回值通常解析为跳转路径,加上@Responsebody后返回结果不会被解析为跳转路径,
//    而是直接写入HTTP 响应正文中.例如,异步获取json数据,加上@Responsebody注解后,就会直接返回json数据.
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

    /**
     * 部门树结构的渲染工作
     */
    @RequestMapping("queryDeptTree")
    @ResponseBody
    public Object queryDeptTree(){
        List<Node> nodes = deptService.queryDeptTree();
        return nodes;
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

    //更改部门信息
    @ResponseBody
    @RequestMapping("dept/updateDeptSubmit")
    public R updateDept(Dept dept){
        deptService.updateDept(dept);
        return R.ok();
    }
    //根据id删除部门信息

    @RequestMapping("dept/deleteDeptByID")
    @ResponseBody
    public R deleteDeptById(Integer id){
        deptService.deleteDeptById(id);
        return R.ok();
    }

    /**
     * 页面的渲染使用
     * 当我访问dept,就会去pages/dept页面,然后前端会向指定url请求数据,然后完成填充
     */
    @RequestMapping("/dept")
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
