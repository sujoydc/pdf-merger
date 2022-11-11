package com.sujix.pdf.services.impl;

import com.sujix.pdf.services.PDFService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 * PDFServiceImpl
 */
@Slf4j
@Service
public class PDFServiceImpl implements PDFService {

    @Override
    public void merge() throws Exception {
        PDFMergerUtility ut = new PDFMergerUtility();

        ut.addSource(ResourceUtils.getFile("classpath:data/One.pdf"));
        ut.addSource(ResourceUtils.getFile("classpath:data/Two.pdf"));

        ut.setDestinationFileName("Merged.pdf");
        ut.mergeDocuments(null);
    }

    @Override
    @SneakyThrows
    public void clearPassword() {
        log.info("clearPassword called.");
        PDDocument pd = PDDocument.load(ResourceUtils.getFile("classpath:data/2020_1098T.pdf"), "07194861");

        pd.setAllSecurityToBeRemoved(true);
        pd.save("2020_1098T_NoPass.pdf");
        log.info("The document is now decrypted by Sujoy...");
        log.info("clearPassword returned...");
        log.info("clearPassword returned...");
    }

//    @Override
//    public void create() throws Exception {
//        log.info("Creating a PDF from image file.");
//        File       file     = ResourceUtils.getFile("classpath:data/Dhira-DL-2023.jpg");
//
//        PDFParser parser = new PDFParser(file);
//        parser.parse();
//
//        log.info("Image file created.");
//        PDDocument document = PDDocument.load();
//        log.info("Image file byte array created.");
//        document.save("test123.pdf");
//        log.info("PDF document saved!");
//    }
}
