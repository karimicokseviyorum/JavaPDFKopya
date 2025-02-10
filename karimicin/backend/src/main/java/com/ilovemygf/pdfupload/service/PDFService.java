/*
 * Interface. 
 * 
 * Author: Ahmet
 * Son Guncelleme: 02.10.2025
 * TODO: hicbisiy
*/

package com.ilovemygf.pdfupload.service;

public interface PDFService { // PdfServiceImpl icin interface
    void processPdf(byte[] pdfData, String username);
}