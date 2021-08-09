/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs_gui.models;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Document {
	public enum DocumentType {
		PASSPORT, CERTIFICATE, VISA
	}
	
	private DocumentType documentType;
	private LocalDate expiryDate;
	private String image; // filename of the image
	
	
	/**
	 * Constructor for Document
	 * @param documentType Type of document
	 * @param expiryDate Expiry date if available
	 * @param image Document image, (as file name)
	 */
	public Document(DocumentType documentType, LocalDate expiryDate, String image) {
		setDocumentType(documentType);
		setExpiryDate(expiryDate);
		setImage(image);
	}
	
	/**
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the expiryDate
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		if (getExpiryDate() != null)
			return getDocumentType() + " expired on " +
				getExpiryDate() + ", image: " + getImage();
		else
			return getDocumentType() + ", image: " + getImage(); 
	}
}

