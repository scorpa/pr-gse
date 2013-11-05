package demo;

import java.io.File;
import java.io.IOException;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.data.TransferSyntax;
import org.dcm4che2.io.DicomInputStream;

public class Headerdaten
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("sample_images/1.2.840.113619.2.5.1762583153.215519.978957063.79/1.2.840.113619.2.5.1762583153.215519.978957063.80.dcm");
		DicomInputStream input = new DicomInputStream(file);
		DicomObject dcm = input.readDicomObject();
		System.out.println(dcm);
		
		
		System.out.println("Patient id: " + dcm.getString(Tag.PatientID));
		System.out.println("Patientenname: " + dcm.getString(Tag.PatientBirthName));
		System.out.println("Aufnahmedatum: " + dcm.getDate(Tag.AcquisitionDate));
		System.out.println("Transfersyntax: " + dcm.getString(Tag.TransferSyntaxUID));
		
		TransferSyntax ts = TransferSyntax.valueOf(dcm.getString(Tag.TransferSyntaxUID));
		
		System.out.println(ts.bigEndian());
		System.out.println(ts.deflated());
		System.out.println(ts.encapsulated());
		System.out.println(ts.explicitVR());
		System.out.println(ts.uncompressed());

	}

}
