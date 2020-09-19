package com.example.demo.Controller;

import com.example.demo.Model.PaymentRequest;
import com.example.demo.Service.BaseResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lubov on 30.08.20.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;


    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 1);
    }


    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)) {


            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();


            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);

        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }

        return response;

    }


}
