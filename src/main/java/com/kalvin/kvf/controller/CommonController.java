package com.kalvin.kvf.controller;

import com.kalvin.kvf.comm.constant.UploadPathEnum;
import com.kalvin.kvf.comm.utils.FileUploadUtil;
import com.kalvin.kvf.dto.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 【作用】通用控制层<br>
 * 【说明】（无）
 * @author Kalvin
 * @Date 2019/5/9 20:20
 */
@RestController
@RequestMapping(value = "comm")
public class CommonController {

    @GetMapping(value = "selUser")
    public ModelAndView selUser() {
        return new ModelAndView("sys/user_sel");
    }

    @PostMapping(value = "fileUpload")
    public R fileUpload(@RequestParam(value = "file") MultipartFile file, int type) {
        return R.ok(FileUploadUtil.uploadRelative(file, UploadPathEnum.get(type)));
    }

}