package com.bharath.restws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

@Path("/fileService")
@Service
public class FileService {

	//This is path where file will be uploaded.
	private static final String FILE_PATH = "/Users/bansal/Desktop/Study Material/Workspace/Spring_REST_WEB_Service_Eclipse_Code/Udemy_Lec7_RESTfullWS_RestAttachments/Uploaded/uploaded.jpg";
	
	/****
	 * This 'Attachment' class from Apache CXF.
	 * So CXF will grab the any no of incoming files and it will create an attachment per file and put them into a list
	 * and handed over the this 'upload' method. 
	 * If you using JERSEY, there might be different class name and package instead of org.apache.cxf.jaxrs.ext.multipart.Attachment
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Path("/upload")
	@POST
	public void upload(List<Attachment> attachments) throws FileNotFoundException, IOException {
		for(Attachment attachment : attachments) {
			/****
			 * getDataHandler() gives us to handler to handle the incoming files
			 * getInputStream() because our CopyFile() method accepts the InputStream.
			 */
			copyFile(attachment.getDataHandler().getInputStream());
		}

	}
	
	/****
	 * We are using this method to download the file which we have uploaded.
	 * @return
	 */
	@Path("/download")
	@GET
	public Response download() {
		//We are reading the file form this given path.
		File file = new File(FILE_PATH);
		//Writing below line so that client take the response back as file.
		ResponseBuilder responseBuilder = Response.ok(file);
		/****We need to add header so that browser knows that there is attachment.
		 * file name would be downloaded.JPG after downloading the file.
		 */
		responseBuilder.header("Content-Disposition", "attachement;filename=downloaded.JPG");
		return responseBuilder.build();
		
	}
	
	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

}