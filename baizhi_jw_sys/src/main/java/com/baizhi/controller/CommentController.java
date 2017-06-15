package com.baizhi.controller;

import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import com.baizhi.vo.bigjava;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @RequestMapping("/showAllBylawerid")
    @ResponseBody
    public List<bigjava> showAllBylawerid(String id){
        ArrayList<bigjava> bglist = new ArrayList<bigjava>();

        List<Comment> comments = commentService.queryAllBylawerid(id);
        for(Comment c:comments){
            bigjava bg = new bigjava();
            bg.setUsername(c.getOrder().getUser().getName());
            bg.setUserphone(c.getOrder().getUser().getPhone());
            bg.setComcontent(c.getContent());
            bg.setComid(c.getId());
            bg.setCreatetime(c.getCreatetime());
            bg.setScore(c.getScore());
            System.out.println(bg);
            bglist.add(bg);
        }
        return bglist;
    }
}
