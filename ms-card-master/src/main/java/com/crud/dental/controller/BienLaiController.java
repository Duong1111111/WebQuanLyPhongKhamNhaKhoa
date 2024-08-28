package com.crud.dental.controller;

import com.crud.dental.model.BienLai;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IBienLaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bienlai")
@CrossOrigin("*")
public class BienLaiController {

    @Autowired
    private IBienLaiService iBienLaiService;

    @GetMapping("/list")
    public ResponseEntity<List<BienLai>> list() {
        List<BienLai> result = iBienLaiService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody BienLai bienLai) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iBienLaiService.save(bienLai);
        if (result == 1) {
            serviceResponse.setMessage("Biên lai đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu biên lai thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateBienLai(@RequestBody BienLai bienLai) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iBienLaiService.update(bienLai);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật biên lai thành công");
            } else {
                serviceResponse.setMessage("Cập nhật biên lai thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật biên lai: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iBienLaiService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa biên lai thành công");
        } else {
            serviceResponse.setMessage("Xóa biên lai thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            BienLai bienLai = iBienLaiService.findById(id);
            if (bienLai != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy biên lai.");
                serviceResponse.setData(bienLai);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy biên lai.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
