/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;


import java.io.File;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class GmailFetch {

    public static void main(String[] args) throws Exception {

        Session session = Session.getDefaultInstance(new Properties());
        Store store = session.getStore("imaps");
        store.connect("mail.seatelgroup.com", 993, "vengleab.so@seatelgroup.com", "client123");
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Fetch unseen messages from inbox folder
        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        System.out.print(messages.length);

        for (Message message : messages) {
            String contentType = message.getContentType();
            System.out.println("sendDate: " + message.getSentDate() + " subject:" + message.getSubject());
            if (contentType.contains("multipart")) {
                
                MimeMultipart multiPart = (MimeMultipart) message.getContent();
                int count = multiPart.getCount();
                for (int i = 0; i < count; i++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                    if (part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                        String fileName=MimeUtility.decodeText(part.getFileName());
                        part.saveFile("C:/temp/"+ File.separator + fileName);
                    }
                }
            }
        }
    }
}
