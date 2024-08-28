package com.crud.dental.controller;

import com.crud.dental.model.BenhNhan;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/benhnhan")
@CrossOrigin("*")
public class BenhNhanController {

    @Autowired
    private IBenhNhanService iBenhNhanService;

    @GetMapping("/list")
    public ResponseEntity<List<BenhNhan>> list(){
        List<BenhNhan> result = iBenhNhanService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody BenhNhan benhNhan){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iBenhNhanService.save(benhNhan);
        if(result == 1){
            serviceResponse.setMessage("Bệnh nhân đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu bệnh nhân thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateBenhNhan(@RequestBody BenhNhan benhNhan) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iBenhNhanService.update(benhNhan);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật bệnh nhân thành công");
            } else {
                serviceResponse.setMessage("Cập nhật bệnh nhân thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật bệnh nhân: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iBenhNhanService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Xóa bệnh nhân thành công");
        } else {
            serviceResponse.setMessage("Xóa bệnh nhân thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            BenhNhan benhNhan = iBenhNhanService.findById(id);
            if (benhNhan != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy bệnh nhân.");
                serviceResponse.setData(benhNhan);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy bệnh nhân.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }


}
