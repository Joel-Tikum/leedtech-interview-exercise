package leedtech.one_time_fee_payment_backend.controller;

import leedtech.one_time_fee_payment_backend.dto.PaymentRequest;
import leedtech.one_time_fee_payment_backend.dto.PaymentResponse;
import leedtech.one_time_fee_payment_backend.service.FeePaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/one-time-fee-payment")
@CrossOrigin(origins = "http://localhost:4200") // for Angular dev server
public class OneTimeFeePaymentController {

    private final FeePaymentService feePaymentService;

    public OneTimeFeePaymentController(FeePaymentService feePaymentService) {
        this.feePaymentService = feePaymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse response = feePaymentService.processOneTimePayment(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}