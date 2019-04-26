package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.DonateBook;
import com.gxy.vbook.service.DonateBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book/donate")
public class DonateBookController {

    @Autowired
    private DonateBookService donateBookService;



    @RequestMapping("save")
    public ServerResponse save(@RequestBody DonateBook book){

        int result = donateBookService.insert(book);
        if (result != 1) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }
    @RequestMapping("list")
    public ServerResponse list(){
        List<DonateBook> list = donateBookService.selectAllList();
        return ServerResponse.createBySuccess(list);
    }
}
