package com.ashokit.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.ashokit.entity.EligibliltyDetails;
import com.ashokit.repository.EligiblityDetailsRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PDFService {
	public  String createAPPdf(EligibliltyDetails eligibliltyDetails ) throws FileNotFoundException, DocumentException {
		Document document= new Document(PageSize.A4,50,50,50,50);
		String fileName="document"+eligibliltyDetails.getCaseNum()+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileName));
		document.addAuthor("vishal");
		document.addSubject("IES Approvied NOTIES");
		document.addTitle("SNAP NOTIES");
		document.addCreationDate();
		document.open();
		Paragraph p= new Paragraph();
		p.add("Approved Plan Details");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		PdfPTable table= new PdfPTable(2);
		table.addCell(new PdfPCell(new Paragraph("Case Number")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getCaseNum())));
		
		table.addCell(new PdfPCell(new Paragraph("Plan Name")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanName())));
		
		table.addCell(new PdfPCell(new Paragraph("Plan Status")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanStatus())));
		
		table.addCell(new PdfPCell(new Paragraph("Start date")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanStartDate())));
		
		table.addCell(new PdfPCell(new Paragraph("End date")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanEndDate())));
		
		document.add(table);
		document.close();
		return fileName;
	}
	
	public  String createDNPdf(EligibliltyDetails eligibliltyDetails ) throws FileNotFoundException, DocumentException {
		Document document= new Document(PageSize.A4,50,50,50,50);
		String fileName="document"+eligibliltyDetails.getCaseNum()+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(fileName));
		document.addAuthor("vishal");
		document.addSubject("IES Denied NOTIES");
		document.addTitle("SNAP NOTIES");
		document.addCreationDate();
		document.open();
		Paragraph p= new Paragraph();
		p.add("Denied Plan Details");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		PdfPTable table= new PdfPTable(2);
		table.addCell(new PdfPCell(new Paragraph("Case Number")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getCaseNum())));
		
		table.addCell(new PdfPCell(new Paragraph("Plan Name")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanName())));
		
		table.addCell(new PdfPCell(new Paragraph("Plan Status")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getPlanStatus())));
		
		table.addCell(new PdfPCell(new Paragraph("Denail Reason")));
		table.addCell(new PdfPCell(new Paragraph(eligibliltyDetails.getDenailReason())));
		
		document.add(table);
		document.close();
		return fileName;
	}
}
