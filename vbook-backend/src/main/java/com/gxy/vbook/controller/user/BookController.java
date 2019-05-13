package com.gxy.vbook.controller.user;

import com.gxy.vbook.common.Const;
import com.gxy.vbook.common.PageResponse;
import com.gxy.vbook.common.ServerResponse;
import com.gxy.vbook.pojo.Book;
import com.gxy.vbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 二手书接口
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private BookService bookService;

    /**
     * 添加新书
     *
     * @param book
     * @return
     */
    @RequestMapping("add")
    public ServerResponse add(@RequestBody Book book) {
        return bookService.save(book);
    }

    /**
     * 获取所有的二手书列表
     *
     * @param name
     * @return
     */
    @GetMapping("list")
    public PageResponse findList(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return bookService.findList(name);
    }

    /**
     * 添加购物车的时候判断是否是自己的二手书
     * 如果是自己的二手书就无法添加到购物车中
     *
     * @param id
     * @return
     */
    @RequestMapping("isMine")
    public ServerResponse isMine(@RequestParam("id") Integer id) {
        Integer userId = Integer.parseInt(redisTemplate.opsForValue().get(Const.CURRENT_USER));
        return bookService.isMine(id, userId);
    }

    /**
     * 二手书推荐列表
     *
     * @return
     */
    @GetMapping("recommended")
    public PageResponse recommendedList() {
        return bookService.recommendedList();
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ServerResponse saveImg(@RequestParam("images") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File uploadFile = new File("C:\\home\\school\\code\\vbook\\vbook-fe\\static\\image");
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            //获取文件后缀名
            String suffix = "jpg";
            String name = UUID.randomUUID().toString();
            String diskFileName = name + "." + suffix;
            String pathName = uploadFile.getPath() + "/" + diskFileName;
            file.transferTo(new File(pathName));
            // 先创建一个对象用来保存图片名
            Book book = new Book();
            book.setImgName(diskFileName);
            return bookService.saveBookImage(book);
        }
        return ServerResponse.createByError();
    }

    /**
     * restful 接口
     *
     * @param id
     * @return
     */
    @RequestMapping("{id}")
    public ServerResponse getBook(@PathVariable("id") Integer id) {
        return bookService.getBook(id);
    }

    /**
     * 卖书记录
     *
     * @return
     */
    @RequestMapping("record/sell")
    public ServerResponse bookSellRecordList() {
        return bookService.bookSellRecord();
    }

    /**
     * 捐赠记录
     *
     * @return
     */
    @RequestMapping("record/donate")
    public ServerResponse bookDonateRecordList() {
        return bookService.bookDonateRecord();
    }
}
