package com.mj.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mj.entity.ReportPenjualanEntity;

public class PdfHelper{
	
	
	public static ByteArrayInputStream salesReport(ReportPenjualanEntity reportEntity) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(90);
            table.setWidths(new int[]{3, 3, 3, 3, 3, 3, 3});            

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            headFont.setSize(10);
            headFont.setColor(BaseColor.MAGENTA);

            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("ID BILL", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("WAKTU", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("JENIS MENU", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);   
            
            hcell = new PdfPCell(new Phrase("NAMA MENU", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);   
            
            hcell = new PdfPCell(new Phrase("HARGA", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);   
            
            hcell = new PdfPCell(new Phrase("JUMLAH", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);   
            
            hcell = new PdfPCell(new Phrase("TOTAL", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);   
            
                        
            for(ReportPenjualanEntity.ReportPenjualan penjualanReport : reportEntity.getDataPenjualan()) {
            	PdfPCell cell;
            	
            	
				cell = new PdfPCell(new Phrase(penjualanReport.getIdBill()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(penjualanReport.getWaktuJual()));				
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(penjualanReport.getJenisMenu())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);				
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(penjualanReport.getNamaMenu())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);				
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(penjualanReport.getHarga())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);				
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(penjualanReport.getJumlah())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);				
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(String.valueOf(penjualanReport.getTotal())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setPaddingRight(2);
				table.addCell(cell);
				
            }
            
          
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}
