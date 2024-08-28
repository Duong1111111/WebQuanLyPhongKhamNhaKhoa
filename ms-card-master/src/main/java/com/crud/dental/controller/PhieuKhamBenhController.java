package com.crud.dental.controller;

import com.crud.dental.model.PhieuKhamBenh;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IPhieuKhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/phieukhambenh")
@CrossOrigin("*")
public class PhieuKhamBenhController {

    @Autowired
    private IPhieuKhamBenhService iPhieuKhamBenhService;

    @GetMapping("/list")
    public ResponseEntity<List<PhieuKhamBenh>> list() {
        List<PhieuKhamBenh> result = iPhieuKhamBenhService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody PhieuKhamBenh phieuKhamBenh) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iPhieuKhamBenhService.save(phieuKhamBenh);
        if (result == 1) {
            serviceResponse.setMessage("Phiếu khám bệnh đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu phiếu khám bệnh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updatePhieuKhamBenh(@RequestBody PhieuKhamBenh phieuKhamBenh) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iPhieuKhamBenhService.update(phieuKhamBenh);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật phiếu khám bệnh thành công");
            } else {
                serviceResponse.setMessage("Cập nhật phiếu khám bệnh thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật phiếu khám bệnh: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iPhieuKhamBenhService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa phiếu khám bệnh thành công");
        } else {
            serviceResponse.setMessage("Xóa phiếu khám bệnh thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            PhieuKhamBenh phieuKhamBenh = iPhieuKhamBenhService.findById(id);
            if (phieuKhamBenh != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy phiếu khám bệnh.");
                serviceResponse.setData(phieuKhamBenh);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy phiếu khám bệnh.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
