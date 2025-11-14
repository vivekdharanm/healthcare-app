package com.healthcare_application.HealthCare.prescription.pdf;

import java.io.FileOutputStream;
import org.springframework.stereotype.Component;
import com.healthcare_application.HealthCare.prescription.entity.Prescription;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

    public void generatePdf(Prescription prescription) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(
                "prescription_" + prescription.getId() + ".pdf"
            ));
            document.open();
            document.add(new Paragraph("Prescription ID: " + prescription.getId()));
            document.add(new Paragraph("Diagnosis: " + prescription.getDiagnosis()));
            document.add(new Paragraph("Medications: " + prescription.getMedications()));
            document.add(new Paragraph("Date: " + prescription.getDate()));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
