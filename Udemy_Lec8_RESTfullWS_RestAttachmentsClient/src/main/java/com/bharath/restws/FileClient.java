package com.bharath.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	/****
	 * We will achieve the same thing which is done by fileUpload.html, when we upload the file and hit the submit button 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		//Need to write WS URL.
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		//fileName should be exactly same what we are uploading, so our file name is 'MAVEN.JPG'
		ContentDisposition cd = new ContentDisposition("attachement;filename=MAVEN.JPG");

		//Give the exact file 'MAVEN.JPG' path
		Attachment attachement = new Attachment("root",
				new FileInputStream(new File("/Users/bansal/Desktop/Study Material/Workspace/Spring_REST_WEB_Service_Eclipse_Code/Udemy_Lec7_RESTfullWS_RestAttachments/MAVEN.JPG")), cd);

		client.post(attachement);

	}

}
