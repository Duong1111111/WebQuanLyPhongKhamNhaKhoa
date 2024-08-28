package com.crud.dental.controller;

import com.crud.dental.model.HoSoKhamBenh;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IHoSoKhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hosokhambenh")
@CrossOrigin("*")
public class HoSoKhamBenhController {

    @Autowired
    private IHoSoKhamBenhService iHoSoKhamBenhService;

    @GetMapping("/list")
    public ResponseEntity<List<HoSoKhamBenh>> list() {
        List<HoSoKhamBenh> result = iHoSoKhamBenhService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody HoSoKhamBenh hoSoKhamBenh) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iHoSoKhamBenhService.save(hoSoKhamBenh);
        if (result == 1) {
            serviceResponse.setMessage("Hồ sơ khám bệnh đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu hồ sơ khám bệnh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateHoSoKhamBenh(@RequestBody HoSoKhamBenh hoSoKhamBenh) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iHoSoKhamBenhService.update(hoSoKhamBenh);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật hồ sơ khám bệnh thành công");
            } else {
                serviceResponse.setMessage("Cập nhật hồ sơ khám bệnh thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật hồ sơ khám bệnh: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iHoSoKhamBenhService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa hồ sơ khám bệnh thành công");
        } else {
            serviceResponse.setMessage("Xóa hồ sơ khám bệnh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            HoSoKhamBenh hoSoKhamBenh = iHoSoKhamBenhService.findById(id);
            if (hoSoKhamBenh != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy hồ sơ khám bệnh.");
                serviceResponse.setData(hoSoKhamBenh);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy hồ sơ khám bệnh.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
