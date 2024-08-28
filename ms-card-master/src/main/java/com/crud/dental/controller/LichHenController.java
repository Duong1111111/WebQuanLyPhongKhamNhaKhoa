package com.crud.dental.controller;

import com.crud.dental.model.LichHen;
import com.crud.dental.model.ServiceResponse;
import com.crud.dental.service.ILichHenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lichhen")
@CrossOrigin("*")
public class LichHenController {

    @Autowired
    private ILichHenService iLichHenService;

    @GetMapping("/list")
    public ResponseEntity<List<LichHen>> list() {
        List<LichHen> result = iLichHenService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody LichHen lichHen) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iLichHenService.save(lichHen);
        if (result == 1) {
            serviceResponse.setMessage("Lịch hẹn đã được lưu thành công");
        } else {
            serviceResponse.setMessage("Lưu lịch hẹn thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> updateLichHen(@RequestBody LichHen lichHen) {
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            int result = iLichHenService.update(lichHen);
            if (result == 1) {
                serviceResponse.setMessage("Cập nhật lịch hẹn thành công");
            } else {
                serviceResponse.setMessage("Cập nhật lịch hẹn thất bại");
            }
        } catch (Exception e) {
            serviceResponse.setMessage("Đã xảy ra lỗi khi cập nhật lịch hẹn: " + e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iLichHenService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Xóa lịch hẹn thành công");
        } else {
            serviceResponse.setMessage("Xóa lịch hẹn thất bại");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceResponse> findById(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            LichHen lichHen = iLichHenService.findById(id);
            if (lichHen != null) {
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage("Tìm thấy lịch hẹn.");
                serviceResponse.setData(lichHen);
            } else {
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Không tìm thấy lịch hẹn.");
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Lỗi: " + e.getMessage());
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
