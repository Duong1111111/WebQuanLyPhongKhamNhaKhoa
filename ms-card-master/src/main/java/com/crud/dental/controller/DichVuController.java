package com.crud.dental.controller;

import com.crud.dental.model.DichVu;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dichvu")
@CrossOrigin("*")
public class DichVuController {

    @Autowired
    private IDichVuService iDichVuService;

    @GetMapping("/list")
    public ResponseEntity<List<DichVu>> list() {
        List<DichVu> result = iDichVuService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody DichVu dichVu) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iDichVuService.save(dichVu);
        if (result == 1) {
            serviceResponse.setMessage("Dịch vụ đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu dịch vụ thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody DichVu dichVu) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iDichVuService.update(dichVu);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật dịch vụ thành công");
            } else {
                serviceResponse.setMessage("Cập nhật dịch vụ thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật dịch vụ: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iDichVuService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa dịch vụ thành công");
        } else {
            serviceResponse.setMessage("Xóa dịch vụ thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            DichVu dichVu = iDichVuService.findById(id);
            if (dichVu != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy dịch vụ.");
                serviceResponse.setData(dichVu);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy dịch vụ.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
