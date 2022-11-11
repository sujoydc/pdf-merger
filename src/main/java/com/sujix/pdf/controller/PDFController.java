package com.sujix.pdf.controller;

import com.sujix.pdf.services.PDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PDFController
 */

@Slf4j
@RestController
@RequestMapping(path = "/pdf")
public class PDFController {

    private final PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "My PDF app works!";
    }

    @GetMapping(value = "/merge")
    public String mergePDF() throws Exception {
        pdfService.merge();
        return "PDF Merge Successful!!! Yahoo";
    }

    @GetMapping(value = "/decrypt")
    public String decryptPDF() throws Exception {
        log.info("decryptPDF action called!");
        pdfService.clearPassword();
        return "PDF Decryption Successful!!! Yahoo";
    }

//    @GetMapping(value = "create")
//    public String createPDF() throws Exception {
//        log.info("Create action called!");
//        pdfService.create();
//        return "PDF Creation Successful!!! Yahoo";
//    }

}
